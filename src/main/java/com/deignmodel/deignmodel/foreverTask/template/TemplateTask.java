package com.deignmodel.deignmodel.foreverTask.template;

import com.deignmodel.deignmodel.foreverTask.util.TaskProcessUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.testcontainers.shaded.com.google.common.collect.Lists;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;

@Slf4j
public abstract class TemplateTask<T> {
    private int POOL_SIZE = 5; // 默认线程池大小
    private int SPLIT_SIZE = 5; // 默认数据拆分大小

    // 接收jvm关闭信号，实现优雅停机
    protected volatile boolean terminal = false;

    public void setPOOL_SIZE(int POOL_SIZE) {
        this.POOL_SIZE = Math.min(10, POOL_SIZE);
    }
    public void setSPLIT_SIZE(int SPLIT_SIZE) {
        this.SPLIT_SIZE = Math.min(10, SPLIT_SIZE);
    }
    // 获取数据
    public abstract List<T> queryData();
    //业务逻辑处理
    public abstract void execute(T data);
    //设置执行间隔
    public abstract int inter();
    //多久执行一次
    public abstract String serviceName();
    // 程序执行入口
    public void doExecute() {
        int i = 0;
        try {
            while (true) {
                log.info("{}任务第{}次执行",serviceName(),i);
                // 获取数据
                List<T> datas = queryData();
                // 处理数据
                taskExecute(datas);
                log.info("{}任务第{}次执行结束",serviceName(),i);
                if (terminal) {
                    // 只有应用关闭，才会走到这里，用于实现优雅的下线
                    break;
                }
                // 设置线程的休息时间
                if (inter() > 0){
                    Thread.sleep(inter());
                }
                i++;
            }
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            // 回收线程池资源
            TaskProcessUtil.releaseExecutors(serviceName());
        }
    }
    // 优雅停机
    public void terminal() {
        // 关机
        terminal = true;
        log.info("{} shut down",serviceName());
    }
    // 处理数据
    private void doProcessData(List<T> datas, CountDownLatch latch) {
        try {
            for (T cat : datas) {
                execute(cat);
            }
        } catch (Exception e) {
            log.error(Arrays.toString(e.getStackTrace()));
        } finally {
            if (latch != null) {
                latch.countDown();
            }
        }
    }
    // 处理单个任务数据
    private void taskExecute(List<T> sourceDatas) {
        if (CollectionUtils.isEmpty(sourceDatas)) {
            return;
        }
        SPLIT_SIZE = Math.min(this.SPLIT_SIZE, sourceDatas.size());
        // 拆分数据
        List<List<T>> splitDatas = Lists.partition(sourceDatas, SPLIT_SIZE);
        // 子线程同步锁声明
        final CountDownLatch latch = new CountDownLatch(splitDatas.size());

        // 并发处理拆分的数据，共用一个线程池
        for (final List<T> datas : splitDatas) {
            ExecutorService executorService = TaskProcessUtil.getOrInitExecutors(serviceName(), POOL_SIZE);
            executorService.submit(() -> { doProcessData(datas, latch); });
            try {
                latch.await();
            } catch (Exception e) {
                log.error(Arrays.toString(e.getStackTrace()));
            }
        }
    }
}
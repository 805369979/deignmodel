package com.deignmodel.deignmodel.foreverTask;

import com.deignmodel.deignmodel.foreverTask.template.TemplateTask;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Optional;

@Component
public class TaskConfig implements InitializingBean {
    @Autowired
    List<TemplateTask> templateList;

    // 初始化任务
    public void initTasks() {
        for (final TemplateTask childTask : templateList) {
            new Thread(childTask::doExecute).start();
        }
    }
    // 关闭任务
    public void shutdownTasks() {
        if (!CollectionUtils.isEmpty(templateList)) {
            for (TemplateTask childTask : templateList) {
                childTask.terminal();
            }
        }
    }
    // 通过任务名字关闭任务
    public void shutdownTaskByName(String serviceName) {
        Optional<TemplateTask> first = templateList.stream().filter(service -> service.serviceName().equals(serviceName)).findFirst();
        first.ifPresent(TemplateTask::terminal);
    }

    // Springboot容器启动时默认开启任务
    @Override
    public void afterPropertiesSet() throws Exception {
        initTasks();
    }

}

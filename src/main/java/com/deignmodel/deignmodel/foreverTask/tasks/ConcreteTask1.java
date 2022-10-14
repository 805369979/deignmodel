package com.deignmodel.deignmodel.foreverTask.tasks;


import com.deignmodel.deignmodel.foreverTask.Entity.Message;
import com.deignmodel.deignmodel.foreverTask.template.TemplateTask;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class ConcreteTask1 extends TemplateTask<Message> {
    @Override
    public List<Message> queryData() {
        Message message = new Message();
        message.setOrderId("0001");
        List<Message> messages = Arrays.asList(message);
        return messages;
    }
    @Override
    public void execute(Message data) {
        System.out.println("每条信息的处理"+data.getOrderId());
    }
    @Override
    public int inter() {
        return 1000;
    }
    @Override
    public String serviceName() {
        return "ConcreteTask1";
    }
}

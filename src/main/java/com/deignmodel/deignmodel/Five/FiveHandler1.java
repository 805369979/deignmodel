package com.deignmodel.deignmodel.Five;

import org.springframework.stereotype.Service;

@Service(value = "FiveHandler1")
public class FiveHandler1 extends AbstractFiveHandler {
    @Override
    public void handle() {
        System.out.println("FiveHandler1执行完成");
    }

    @Override
    public boolean isAccept(String type) {
        return "FiveHandler1".equals(type);
    }
}
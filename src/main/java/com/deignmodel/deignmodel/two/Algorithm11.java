package com.deignmodel.deignmodel.two;

import org.springframework.stereotype.Service;

@Service("Handler1")
public class Algorithm11 extends  AbstractHandler {

    @Override
    public void execute() {
        System.out.println("执行算法1");
    }

    @Override
    public boolean accept(String s) {
        return "Handler1".equals(s);
    }
}

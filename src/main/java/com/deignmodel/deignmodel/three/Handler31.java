package com.deignmodel.deignmodel.three;

import org.springframework.stereotype.Service;

@Service("Handler31")
public class Handler31 implements ThirdHandler {
    @Override
    public void handle() {
        System.out.println("Handler1处理完成");;
    }

    public boolean accept(String type) {
        return "Handler31".equals(type);
    }
}

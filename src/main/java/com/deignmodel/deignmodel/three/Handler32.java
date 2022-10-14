package com.deignmodel.deignmodel.three;

import org.springframework.stereotype.Service;

@Service("Handler32")
public class Handler32 implements ThirdHandler {
    @Override
    public void handle() {
        System.out.println("Handler2处理完成");;
    }

    public boolean accept(String type) {
        return "Handler32".equals(type);
    }
}

package com.deignmodel.deignmodel.Four;

import org.springframework.stereotype.Service;

@Service
public class Handler11 implements FourthHandler {
    @Override
    public void handle() {
        System.out.println("外部定义的处理完成");;
    }

    public boolean accept(String type) {
        return "Handler1".equals(type);
    }
}

package com.deignmodel.deignmodel.one;


import org.springframework.stereotype.Service;

@HandlerType(type = "Algorithm2")
@Service
public class Algorithm2 implements Handler{
    @Override
    public void algorithm() {
        System.out.println("我是算法2");
    }
}

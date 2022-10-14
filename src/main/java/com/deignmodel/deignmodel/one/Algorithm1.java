package com.deignmodel.deignmodel.one;


import org.springframework.stereotype.Service;

@HandlerType(type = "Algorithm1")
@Service
public class Algorithm1 implements Handler{
    @Override
    public void algorithm() {
        System.out.println("我是算法1");
    }
}

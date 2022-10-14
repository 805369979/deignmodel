package com.deignmodel.deignmodel.two;


import com.deignmodel.deignmodel.one.HandlerType;
import org.springframework.stereotype.Service;

@Service(value = "Handler2")
public class Algorithm22 extends AbstractHandler {

    @Override
    public void execute() {
        System.out.println("执行算法2");
    }

    @Override
    public boolean accept(String s) {
        return "Handler2".equals(s);
    }
}

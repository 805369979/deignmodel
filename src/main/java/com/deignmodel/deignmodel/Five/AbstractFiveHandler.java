package com.deignmodel.deignmodel.Five;

import org.springframework.beans.factory.InitializingBean;

import javax.annotation.Resource;

public abstract class AbstractFiveHandler implements InitializingBean {
    @Resource
    private FiveHandlerContext fiveHandlerContext;
    @Override
    public void afterPropertiesSet() throws Exception {
        fiveHandlerContext.register(this);
    }

    public abstract void handle();
    public abstract boolean isAccept(String type);

}

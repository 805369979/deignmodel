package com.deignmodel.deignmodel.one;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class HandlerContext implements BeanFactoryPostProcessor {

    private static Map<String, Handler> handlerMap = new HashMap<>();;

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        Map<String, Object> handlerBeans = beanFactory.getBeansWithAnnotation(HandlerType.class);
        Optional.ofNullable(handlerBeans).orElse(Collections.emptyMap())
                .forEach((name, bean) -> {
                    Class<?> clazz = bean.getClass();
                    HandlerType handlerType = clazz.getAnnotation(HandlerType.class);
                    handlerMap.put(handlerType.type(), (Handler)bean);
                });
    }
    public static Handler getInstance(String type) {
        Handler clazz = handlerMap.get(type);
        if (clazz == null) {
            throw new RuntimeException("can not find handler");
        }
        return clazz;
    }
}


package com.deignmodel.deignmodel.two;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SelectorContext implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof AlgorithmAbstractSelector && bean.getClass().isAnnotationPresent(AlgorithmSelector.class)) {
            Class<?> clazz = bean.getClass();
            AlgorithmSelector selector = clazz.getAnnotation(AlgorithmSelector.class);
            String[] handlerNames = selector.value();
            if (handlerNames != null && handlerNames.length>0) {
                List<AbstractHandler> handlers = Arrays.stream(handlerNames)
                        .map(handlerName -> {
                            AbstractHandler handler = (AbstractHandler)ApplicationUtil.getBean(handlerName);
                            return handler;
                        }).collect(Collectors.toList());
                ((AlgorithmAbstractSelector) bean).setHandlers(handlers);
            }
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}

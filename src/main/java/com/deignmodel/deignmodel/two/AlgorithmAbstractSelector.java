package com.deignmodel.deignmodel.two;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service
public abstract class AlgorithmAbstractSelector {

    private List<AbstractHandler> handlers;

    public void setHandlers(List<AbstractHandler> handlers) {
        this.handlers = handlers;
    }

    public void execute(String request) {

        AbstractHandler handler = selectOne(request);
        if (handler == null) {
            throw new RuntimeException("can not find handler");
        }
        handler.execute();
    }

    private AbstractHandler selectOne(String request) {
        if (CollectionUtils.isEmpty(handlers)) {
            return null;
        }
        return handlers.stream().filter(handler -> handler.accept(request))
                .findFirst().orElse(null);
    }
}
package com.deignmodel.deignmodel.three;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ThirdContext {
    @Autowired
    private List<ThirdHandler> handlerList;
    public void handle(String type) {
        ThirdHandler handler = Optional.ofNullable(handlerList).orElse(null)
                .stream().filter(h -> h.accept(type))
                .findFirst().orElse(null);
        if (handler == null) {
            throw new RuntimeException("can not find handler");
        }
     handler.handle();
    }
}

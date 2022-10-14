package com.deignmodel.deignmodel.Five;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service(value = "FiveHandlerContext")
public class FiveHandlerContext {
    private List<AbstractFiveHandler> fiveHandlerList = new ArrayList<>();

    public void register(AbstractFiveHandler fiveHandler) {
        fiveHandlerList.add(fiveHandler);
    }

    public AbstractFiveHandler selectOne(String type) {
        AbstractFiveHandler fiveHandler = fiveHandlerList.stream()
                .filter(handler -> handler.isAccept(type))
                .findFirst().orElse(null);
        if (fiveHandler == null) {
            throw new RuntimeException("can not find handler");
        }
        return fiveHandler;
    }
}

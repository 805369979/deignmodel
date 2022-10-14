package com.deignmodel.deignmodel.Four;

import com.deignmodel.deignmodel.two.ApplicationUtil;
import org.springframework.util.StringUtils;

public enum FourthHandlerEnum {

    Handler1("Handler1") {
        @Override
        public void handle (){
            FourthHandler bean = ApplicationUtil.getBean(FourthHandler.class);
            bean.handle();
        }
    },

    Handler2("Handler2") {
        @Override
        public void handle (){
            System.out.println("handle2执行");
        }
    },

    Handler3("Handler3") {
        @Override
        public void handle (){
            System.out.println("handle3执行");
        }
    };
    private String type;

    FourthHandlerEnum(String type) {
        this.type = type;
    }

    public abstract void handle();

    public String getType() {
        return type;
    }

    public static FourthHandlerEnum getByType(String type) {
        if (StringUtils.isEmpty(type)) {
            return null;
        }
        for (FourthHandlerEnum fourHandlerEnum : values()) {
            if (fourHandlerEnum.type.equals(type)) {
                return fourHandlerEnum;
            }
        }
        return null;
    }
}

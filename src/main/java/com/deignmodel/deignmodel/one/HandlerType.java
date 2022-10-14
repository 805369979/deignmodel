package com.deignmodel.deignmodel.one;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface HandlerType {
    String type();
}

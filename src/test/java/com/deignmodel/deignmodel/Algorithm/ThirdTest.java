package com.deignmodel.deignmodel.Algorithm;

import com.deignmodel.deignmodel.one.Handler;
import com.deignmodel.deignmodel.one.HandlerContext;
import com.deignmodel.deignmodel.three.ThirdContext;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ThirdTest {

    @Autowired
    ThirdContext context;

    @Test
    void contextLoads() {
        context.handle("Handler31");
    }
}

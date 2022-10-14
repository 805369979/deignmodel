package com.deignmodel.deignmodel.Algorithm;

import com.deignmodel.deignmodel.two.ExcuteHandlerContext;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TwoTest {
    @Autowired
    ExcuteHandlerContext context;
    @Test
    void contextLoads() {
        context.execute("Handler2");
    }
}

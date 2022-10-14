package com.deignmodel.deignmodel.Algorithm;


import com.deignmodel.deignmodel.one.Handler;
import com.deignmodel.deignmodel.one.HandlerContext;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class OneTest {

    @Test
    void contextLoads() {
        Handler algorithm1 = HandlerContext.getInstance("Algorithm1");
        algorithm1.algorithm();
    }
}

package com.deignmodel.deignmodel;

import com.deignmodel.deignmodel.foreverTask.TaskConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class FoeverTask {
    @Autowired
    TaskConfig config;
    @Test
    void contextLoads() {
        config.initTasks();
    }
}

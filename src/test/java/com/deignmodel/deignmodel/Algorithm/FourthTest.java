package com.deignmodel.deignmodel.Algorithm;

import com.deignmodel.deignmodel.Four.FourthHandlerEnum;
import com.deignmodel.deignmodel.three.ThirdContext;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class FourthTest {

    @Test
    void contextLoads() {
        FourthHandlerEnum byType = FourthHandlerEnum.getByType("Handler1");
        byType.handle();
    }
}

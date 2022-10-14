package com.deignmodel.deignmodel.Algorithm;

import com.deignmodel.deignmodel.Five.AbstractFiveHandler;
import com.deignmodel.deignmodel.Five.FiveHandlerContext;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class FiveTest {

    @Autowired
    FiveHandlerContext context;

    @Test
    public void testMentod(){
        AbstractFiveHandler fiveHandler1 = context.selectOne("FiveHandler1");
        fiveHandler1.handle();
    }
}

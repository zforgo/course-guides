package io.github.zforgo.guides.aop;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(TestInterceptor.class)
public class InterceptedTest {
    Integer integer;

    @Test
    void run() {
        assertTrue(true);
    }

    @Test
    void npex() {
//        integer += 1;
        assertEquals(0, integer);
    }
}

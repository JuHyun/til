package com.aop.practice.concert;

import com.aop.practice.concert.service.Performance;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DancePerformanceTest {

    @Autowired
    private Performance performance;

    // TODO: 실제 테스트 내용이 없기 때문에 테스트 내용이 있어야 함.
    @Test
    public void aopTest() {
        performance.perform();
    }
}

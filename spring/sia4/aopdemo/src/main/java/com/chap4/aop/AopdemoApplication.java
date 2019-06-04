package com.chap4.aop;

import com.chap4.aop.concert.ConcertConfig;
import com.chap4.aop.concert.Performance;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class AopDemoApplication {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(ConcertConfig.class);

        Performance performance =
                (Performance) applicationContext.getBean("performance");
        performance.perform();
    }
}

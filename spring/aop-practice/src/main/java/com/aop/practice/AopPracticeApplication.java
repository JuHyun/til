package com.aop.practice;

import com.aop.practice.concert.ConcertConfig;
import com.aop.practice.concert.service.Performance;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class AopPracticeApplication {

    public static void main(String[] args) {
        SpringApplication.run(AopPracticeApplication.class, args);

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(ConcertConfig.class);
        context.refresh();
        Performance performance = context.getBean(Performance.class);
        performance.perform();
    }
}

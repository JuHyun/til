package com.aop.practice.concert;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

import org.springframework.stereotype.Component;

@Component
@Aspect
public class Audience {

    @Pointcut("execution(** com.aop.practice.concert.service.Performance.perform(..))")
    public void performace() {
    }

    @Around("performace()")
    public void watchPerformance(ProceedingJoinPoint joinPoint) {
        try {
            System.out.println("Around::Sliencing cell phones");
            System.out.println("Around::Taking seats");

            joinPoint.proceed();

            System.out.println("Around::Taking seats");
        } catch (Throwable throwable) {
            System.out.println("Around::Demanding a refund");
        }
    }
}

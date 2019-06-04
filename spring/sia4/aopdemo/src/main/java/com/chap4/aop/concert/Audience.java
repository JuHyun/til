package com.chap4.aop.concert;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * Created by seoungjuhyun on 3/16/16.
 */
@Aspect
public class Audience {

    @Pointcut("execution(** com.chap4.aop.concert.Performance.perform(..))")
    public void performance() {
    }

    @Before("performance()")
    public void turnOffCellPhones() {
        System.out.println("Turn off the cell phones");
    }

    @Before("performance()")
    public void takeSeats() {
        System.out.println("Taking seats");
    }

    @Around("performance()")
    public void watchPerformance(ProceedingJoinPoint joinPoint) {
        try {
            System.out.println("Silencing cell phones");
            System.out.println("Please taking seats");

            joinPoint.proceed();

            System.out.println("Loud applause");
        } catch (Throwable throwable) {
            System.out.println("WTF WTF WTF");
        }
    }

    @AfterReturning("performance()")
    public void applause() {
        System.out.println("CLAP CLAP CLAP!!!");
    }

    @AfterThrowing("performance()")
    public void demandRefund() {
        System.out.println("Demanding a refund");
    }
}

package com.aop.practice.concert;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import org.springframework.stereotype.Component;

@Component
@Aspect
public class Audience {

    @Pointcut("execution(** com.aop.practice.concert.service.Performance.perform(..))")
    public void performace() {
    }

    @Before("performace()")
    public void silenceCellPhones() {
        System.out.println("Sliencing cell phones");
    }

    @Before("performace()")
    public void takeSeats() {
        System.out.println("Taking seats");
    }

    @AfterReturning("performace()")
    public void applause() {
        System.out.println("CLAP CLAP");
    }

    @AfterThrowing("performace()")
    public void demandRefund() {
        System.out.println("Demanding a refund");
    }
}

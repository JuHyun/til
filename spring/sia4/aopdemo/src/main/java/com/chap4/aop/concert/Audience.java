package com.chap4.aop.concert;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * Created by seoungjuhyun on 3/16/16.
 */
@Aspect
public class Audience {

    @Before("execution(** com.chap4.aop.concert.Performance.perform(..))")
    public void turnOffCellPhones() {
        System.out.println("turnOffCellPhones");
    }
}

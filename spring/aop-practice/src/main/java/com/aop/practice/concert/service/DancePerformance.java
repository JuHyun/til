package com.aop.practice.concert.service;

import org.springframework.stereotype.Service;

@Service
public class DancePerformance implements Performance {

    @Override
    public void perform() {
        System.out.println("I'm dancing...");
    }
}

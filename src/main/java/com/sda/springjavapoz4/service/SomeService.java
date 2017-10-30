package com.sda.springjavapoz4.service;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class SomeService {

    private int value;

    public SomeService() {
        Random random = new Random();
        this.value = random.nextInt(100);
    }

    public void someAction() {
        System.out.println("Hello World " + value);
    }
}

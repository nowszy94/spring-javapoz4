package com.sda.springjavapoz4.service;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Component
@Scope(value = "myCustomScope", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class IncrementalNumberGeneratorService implements NumberGenerator {

    private int counter;

    public IncrementalNumberGeneratorService() {
        System.out.println("Hello From Constructor");
    }

    @Override
    public int generateNumber() {
        return counter++;
    }
}

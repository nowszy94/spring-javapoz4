package com.sda.springjavapoz4.service;

import org.springframework.stereotype.Component;

import java.util.Random;

//@Component
public class RandomNumbersGeneratorService {

    private int bound;

    private int offset;

    private Random random;

    public RandomNumbersGeneratorService(int bound, int offset) {
        this.random = new Random();
        this.bound = bound;
        this.offset = offset;
    }

    public RandomNumbersGeneratorService(int bound) {
        this(bound, 0);
    }

    public RandomNumbersGeneratorService() {
        this(100, 0);
    }

    public int generateNumber() {
        return random.nextInt(bound) + offset;
    }

    public void setBound(int bound) {
        this.bound = bound;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }
}


//Chcemy efektywnie dostać 2 beany - smallNumbersGenerator i bigNumbersGenerator
//pierwszy ma zwracać liczby z zakresu 0-50
//drugi z zakresu 1000-10000
//Wstrzykujemy je do controllerow, pierwszy do UsersController drugi do HomeController
//Używamy ich odpowiednio w metodach @GetMapping
//Używamy Qualifier
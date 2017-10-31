package com.sda.springjavapoz4.config;

import com.sda.springjavapoz4.service.RandomNumbersGeneratorService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;


@Configuration
public class NumberGeneratorServiceConfiguration {

    @Profile("dev")
    @Bean
    public RandomNumbersGeneratorService smallNumbersGenerator() {
        return new RandomNumbersGeneratorService(50, 0);
    }

    @Profile("prod")
    @Bean
    public RandomNumbersGeneratorService bigNumbersGenerator() {
        RandomNumbersGeneratorService randomNumbersGeneratorService = new RandomNumbersGeneratorService();
        randomNumbersGeneratorService.setBound(9000);
        randomNumbersGeneratorService.setOffset(1000);
        return randomNumbersGeneratorService;
    }
}

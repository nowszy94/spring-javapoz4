package com.sda.springjavapoz4.config;

import com.sda.springjavapoz4.service.CalcService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class CalcServiceConfiguration {

    @Profile("dev")
    @Bean
    public CalcService devCalcService() {
        return new CalcService("This is dev bean");
    }

    @Profile("!dev")
    @Bean
    public CalcService prodCalcService() {
        return new CalcService("This is prod bean");
    }
}

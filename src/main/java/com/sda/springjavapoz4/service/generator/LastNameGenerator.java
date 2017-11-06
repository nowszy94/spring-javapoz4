package com.sda.springjavapoz4.service.generator;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

@Component
public class LastNameGenerator {

    public String getRandomLastName() {
        String randomName = RandomStringUtils.randomAlphabetic(8);
        return StringUtils.capitalize(randomName);
    }
}

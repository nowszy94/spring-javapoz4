package com.sda.springjavapoz4.service.generator;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class FirstNameGenerator {

    private List<String> names;

    public FirstNameGenerator() {
        names = new ArrayList<>();
        names.add("Jan");
        names.add("Andrzej");
        names.add("Karolina");
        names.add("Anna");
    }

    public String getRandomFirstName() {
        Random random = new Random();
        int randomIndex = random.nextInt(names.size());
        return names.get(randomIndex);
    }
}

//1. Zaimplementowac obie klasy (oraz PhoneNumberGenerator(bean))*
//2. Zarejestrowac je w kontekscie springa
//3. wstrzyknac je do UsersService i je tam wykorzystać (getExampleUser)
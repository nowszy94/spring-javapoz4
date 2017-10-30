package com.sda.springjavapoz4;

import com.sda.springjavapoz4.service.RandomNumbersGeneratorService;
import com.sda.springjavapoz4.service.SomeService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class MySpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(MySpringApplication.class, args);
	}
}

//Chcemy efektywnie dostać 2 beany - smallNumbersGenerator i bigNumbersGenerator
//pierwszy ma zwracać liczby z zakresu 0-50
//drugi z zakresu 1000-10000
//Wstrzykujemy je do controllerow, pierwszy do UsersController drugi do HomeController
//Używamy ich odpowiednio w metodach @GetMapping
//Używamy Qualifier
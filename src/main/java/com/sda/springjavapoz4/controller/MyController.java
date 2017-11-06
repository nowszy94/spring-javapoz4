package com.sda.springjavapoz4.controller;

import com.sda.springjavapoz4.service.RandomNumbersGeneratorService;
import com.sda.springjavapoz4.service.SomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyController {

//    @Qualifier("bigNumbersGenerator")
    @Autowired
    private RandomNumbersGeneratorService randomNumbersGeneratorService;

    @Autowired
    private SomeService someService;

    @GetMapping("/users")
    public ModelAndView users() {
        System.out.println("blabla");
        someService.someAction();
        return new ModelAndView("home");
    }

    @GetMapping("contact-us")
    public ModelAndView contactUs() {
        System.out.println(randomNumbersGeneratorService.generateNumber());
        System.out.println(randomNumbersGeneratorService.generateNumber());
        System.out.println(randomNumbersGeneratorService.generateNumber());
        System.out.println(randomNumbersGeneratorService.generateNumber());
        System.out.println(randomNumbersGeneratorService.generateNumber());
        System.out.println(randomNumbersGeneratorService.generateNumber());
        return new ModelAndView("home");
    }
}

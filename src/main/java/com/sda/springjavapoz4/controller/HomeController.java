package com.sda.springjavapoz4.controller;

import com.sda.springjavapoz4.service.RandomNumbersGeneratorService;
import com.sda.springjavapoz4.service.SomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @Autowired
    private SomeService someService;

    @Qualifier("aboutService")
    @Autowired
    private SomeService myService;

    @Qualifier("smallNumbersGenerator")
    @Autowired
    private RandomNumbersGeneratorService randomNumbersGeneratorService;

    public HomeController() {
//        this.someService = new SomeService();
    }

    @GetMapping("/")
    public ModelAndView home() {
        System.out.println(randomNumbersGeneratorService.generateNumber());
        System.out.println(randomNumbersGeneratorService.generateNumber());
        System.out.println(randomNumbersGeneratorService.generateNumber());
        System.out.println(randomNumbersGeneratorService.generateNumber());
        System.out.println(randomNumbersGeneratorService.generateNumber());
        System.out.println(randomNumbersGeneratorService.generateNumber());
        someService.someAction();
        return new ModelAndView("home");
    }

    @GetMapping("/about")
    public ModelAndView about() {
        System.out.println(randomNumbersGeneratorService.generateNumber());
        myService.someAction();
        return new ModelAndView("home");
    }
}

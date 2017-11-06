package com.sda.springjavapoz4.controller;

import com.sda.springjavapoz4.service.CalcService;
import com.sda.springjavapoz4.service.IncrementalNumberGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestController {

    @Autowired
    private IncrementalNumberGeneratorService numberGenerator;

    @Autowired
    private CalcService calcService;


    @GetMapping("/calc/test")
    public ModelAndView sum() {
        int firstValue = numberGenerator.generateNumber();
        int secondValue = numberGenerator.generateNumber();
        System.out.println(firstValue + " + " + secondValue + " = " + calcService.sum(firstValue, secondValue));
        return new ModelAndView("home");
    }
}

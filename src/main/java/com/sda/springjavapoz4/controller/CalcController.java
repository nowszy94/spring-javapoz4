package com.sda.springjavapoz4.controller;

import com.sda.springjavapoz4.service.CalcService;
import com.sda.springjavapoz4.service.RandomNumbersGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CalcController {

    @Autowired
    private CalcService calcService;

    @Autowired
    private RandomNumbersGeneratorService smallNumbersGenerator;

    @GetMapping("/calc/sum")
    public ModelAndView sum() {
        int firstValue = smallNumbersGenerator.generateNumber();
        int secondValue = smallNumbersGenerator.generateNumber();
        System.out.println(firstValue + " + " + secondValue + " = " + calcService.sum(firstValue, secondValue));
        return new ModelAndView("home");
    }

    @GetMapping("/calc/multiply")
    public ModelAndView multiply() {
        int firstValue = smallNumbersGenerator.generateNumber();
        int secondValue = smallNumbersGenerator.generateNumber();
        System.out.println(firstValue + " * " + secondValue + " = " + calcService.multiply(firstValue, secondValue));
        return new ModelAndView("home");
    }
}

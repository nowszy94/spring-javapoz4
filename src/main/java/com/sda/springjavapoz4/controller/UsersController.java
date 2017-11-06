package com.sda.springjavapoz4.controller;

import com.sda.springjavapoz4.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private UsersService usersService;

    @GetMapping("/example")
    public ModelAndView getExampleUser() {
        System.out.println(usersService.getExampleUser());
        return new ModelAndView("users");
    }

}

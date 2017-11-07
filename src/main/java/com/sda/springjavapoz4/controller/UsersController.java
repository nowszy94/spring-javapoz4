package com.sda.springjavapoz4.controller;

import com.sda.springjavapoz4.model.User;
import com.sda.springjavapoz4.service.UsersService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * PathVariable - do wyciagania wartosci ze sciezki
 * RequestParam - do wyciagania wartosci z queryParametrów (/users?firstName=blabla
 * ModelAttribute - do wyciagania danych wyslanych w formularzu (content-type:x-www-form-urlencoded
 * RequestBody - do wyciagania dancyh wyslanych w body (np. content-type: application-json)
 */
@Controller
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private UsersService usersService;

    @PostMapping
    public String saveUser(@ModelAttribute User user) {
        usersService.addUser(user);
        return "redirect:/users";
    }

    @PostMapping(consumes = "application/json")
    public String saveUserJson(@RequestBody User user) {
        usersService.addUser(user);
        return "redirect:/users";
    }

    @GetMapping
    public ModelAndView getAllUsers() {
        ModelAndView modelAndView = new ModelAndView("users");
        modelAndView.addObject("users", usersService.getAllUsers());
        return modelAndView;
    }

    @GetMapping("/{id}")
    public ModelAndView getUser(@PathVariable("id") int id) {
        ModelAndView modelAndView = new ModelAndView("user");
        User user = usersService.getUser(id);
        modelAndView.addObject("user", user);
        return modelAndView;
    }

    @GetMapping(params = {"lastName"})
    public ModelAndView getUsersByLastName(@RequestParam("lastName") String lastName) {
        ModelAndView modelAndView = new ModelAndView("users");
        modelAndView.addObject("lastName", lastName);
        return modelAndView;
    }

    @GetMapping(params = {"firstName"})
    public ModelAndView getUsersByFirstName(@RequestParam("firstName") String firstName) {
        ModelAndView modelAndView = new ModelAndView("users");
        modelAndView.addObject("users", usersService.getUsersByFirstName(firstName));
        return modelAndView;
    }

    @GetMapping("/example")
    public ModelAndView getExampleUser() {
        System.out.println(usersService.getExampleUser());
        return new ModelAndView("users");
    }

}

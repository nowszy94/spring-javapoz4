package com.sda.springjavapoz4.controller;

import com.sda.springjavapoz4.model.News;
import com.sda.springjavapoz4.model.User;
import com.sda.springjavapoz4.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/news")
public class NewsController {

    @Autowired
    private NewsService newsService;

    @PostMapping
    public String saveNews(@ModelAttribute News news) {
        int index = newsService.saveNewsWithRandomUser(news);
        return "redirect:/news/" + index;
    }

    @GetMapping
    public ModelAndView getAllNews() {
        ModelAndView modelAndView = new ModelAndView("allNews");
        modelAndView.addObject("allNews", newsService.getAllNews());
        modelAndView.addObject("test", new User());
        return modelAndView;
    }

    @GetMapping(value = "/{id}")
    public ModelAndView getNews(@PathVariable("id") int id) {
        ModelAndView modelAndView = new ModelAndView("news");
        modelAndView.addObject("news", newsService.getNews(id));
        return modelAndView;
    }
}

//1. formularz - allNews.html
//2. post danych do backendu (/news) - nie postujemy usera
//3. zapisujemy news w serwisie - dodajemy istniejacego usera z usersService do authora
//4. redirect na /news/{id}
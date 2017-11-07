package com.sda.springjavapoz4.controller;

import com.sda.springjavapoz4.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/news")
public class NewsController {

    @Autowired
    private NewsService newsService;

    @GetMapping
    public ModelAndView getAllNews() {
        ModelAndView modelAndView = new ModelAndView("allNews");
        modelAndView.addObject("allNews", newsService.getAllNews());
        return modelAndView;
    }

    @GetMapping("/{id}")
    public ModelAndView getNews(@PathVariable("id") int id) {
        ModelAndView modelAndView = new ModelAndView("news");
        modelAndView.addObject("news", newsService.getNews(id));
        return modelAndView;
    }
}

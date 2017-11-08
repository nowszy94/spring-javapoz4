package com.sda.springjavapoz4.service;

import com.sda.springjavapoz4.model.News;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class NewsService {

    @Autowired
    private UsersService usersService;

    private List<News> newsList;

    public List<News> getAllNews() {
        return newsList;
    }

    public News getNews(int id) {
        return newsList.get(id);
    }

    @PostConstruct
    public void init() {
        this.newsList = new ArrayList<>();
        this.newsList.add(getExampleNews());
        this.newsList.add(getExampleNews());
        this.newsList.add(getExampleNews());
        this.newsList.add(getExampleNews());
    }

    private News getExampleNews() {
        News news = new News();
        news.setId(1);
        news.setTitle("Lorem ipsum");
        news.setDescription("Lorem ipsum dolor sit amet, consectetur adipisicing elit. A eaque eveniet necessitatibus quas ullam. Possimus.");
        news.setAuthor(usersService.getExampleUser());
        news.setDate(LocalDate.now());
        return news;
    }

    public int saveNewsWithRandomUser(News news) {
        news.setAuthor(usersService.getRandomUser());
        newsList.add(news);
        return newsList.size() - 1;
    }
}

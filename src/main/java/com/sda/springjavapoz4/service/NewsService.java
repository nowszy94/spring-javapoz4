package com.sda.springjavapoz4.service;

import com.sda.springjavapoz4.model.News;
import com.sda.springjavapoz4.repository.NewsRepository;
import com.sda.springjavapoz4.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Component
public class NewsService {

    @Autowired
    private UsersService usersService;

    @Autowired
    private NewsRepository newsRepository;

    @Autowired
    private UsersRepository usersRepository;

    public List<News> getAllNews() {
        return StreamSupport.stream(newsRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    public News getNews(int id) {
        return newsRepository.findOne((long)id);
    }

    @PostConstruct
    public void init() {
        newsRepository.save(getExampleNews());
        newsRepository.save(getExampleNews());
        newsRepository.save(getExampleNews());
        newsRepository.save(getExampleNews());
    }

    private News getExampleNews() {
        News news = new News();
        news.setTitle("Lorem ipsum");
        news.setDescription("Lorem ipsum dolor sit amet, consectetur adipisicing elit. A eaque eveniet necessitatibus quas ullam. Possimus.");
        news.setAuthor(usersRepository.findOne(1l));
        news.setDate(LocalDate.now());
        return news;
    }

    public int saveNews(News news) {
        return (int) newsRepository.save(news).getId();
    }

    public int saveNewsWithRandomUser(News news) {
//        news.setAuthor(usersService.getRandomUser());
//        newsList.add(news);
//        return newsList.size() - 1;
        return 1;
    }
}

package com.sda.springjavapoz4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MySpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(MySpringApplication.class, args);
    }
}

//1. klasa News - id(long), title, description, date, smallImgPath, bigImgPath, author(User)
//2. NewsService - getAllNews(), getNews(id)
//3. NewsController - getAllNews() oraz getNews(id)
//4. allNews.html, news.html (bootstrap)*
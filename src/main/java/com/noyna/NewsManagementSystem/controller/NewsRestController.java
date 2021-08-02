package com.noyna.NewsManagementSystem.controller;

import com.noyna.NewsManagementSystem.entity.News;
import com.noyna.NewsManagementSystem.servisce.NewsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;;


@RestController
@RequestMapping(path = "/news")
public class NewsRestController {

    private final NewsService newsService;

    public NewsRestController(NewsService newsService) {
        this.newsService = newsService;
    }


    @PostMapping
    public void addNews(@RequestBody News news){
        newsService.addNews(news);
    }

    @GetMapping(path = "/{id}")
    public Optional<News> getNewsById(@PathVariable(name = "id") Long id){

        return newsService.getNewsById(id);

    }

    @GetMapping(path = "/show")
    public News grtNewsByTitle(@RequestBody String title){
        return newsService.loadNewsByTitle(title);
    }

    @GetMapping
    public List<News> getAllNews(){
        return newsService.getAllNews();
    }
}

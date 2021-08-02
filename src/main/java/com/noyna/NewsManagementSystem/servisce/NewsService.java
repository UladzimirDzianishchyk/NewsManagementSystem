package com.noyna.NewsManagementSystem.servisce;

import com.noyna.NewsManagementSystem.entity.News;
import com.noyna.NewsManagementSystem.repository.NewsRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NewsService {


    private final NewsRepository newsRepository;


    public NewsService(NewsRepository newsRepository) {
        this.newsRepository = newsRepository;
    }

    public void addNews(News news){
        newsRepository.save(news);
    }

    public Optional getNewsById(Long id){
        return newsRepository.findById(id);
    }

    public News loadNewsById(Long id){
        return newsRepository.getById(id);
    }

    public List<News> getAllNews(){
        return newsRepository.findAll();
    }

    public News loadNewsByTitle(String title){
        return newsRepository.getByTitle(title);
    }
}



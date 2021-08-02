package com.noyna.NewsManagementSystem.repository;

import com.noyna.NewsManagementSystem.entity.News;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NewsRepository extends JpaRepository<News, Long> {

    News getById(Long id);
    News getByTitle(String title);
}

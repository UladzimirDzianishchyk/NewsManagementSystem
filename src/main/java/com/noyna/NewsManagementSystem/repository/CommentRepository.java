package com.noyna.NewsManagementSystem.repository;

import com.noyna.NewsManagementSystem.entity.Comment;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

    List<Comment> findCommentByNews_Id(Long newsId);

}

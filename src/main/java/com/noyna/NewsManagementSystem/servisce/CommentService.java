package com.noyna.NewsManagementSystem.servisce;

import com.noyna.NewsManagementSystem.entity.Comment;
import com.noyna.NewsManagementSystem.entity.News;
import com.noyna.NewsManagementSystem.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    private final CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public void addComment(Comment comment){
        commentRepository.save(comment);
    }

    public void deleteComment(Long commentId){
        commentRepository.deleteById(commentId);
    }

    public List<Comment> viewCommentByNewsId(Long newsId){
        return commentRepository.findCommentByNews_Id(newsId);
    }
}

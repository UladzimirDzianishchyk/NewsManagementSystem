package com.noyna.NewsManagementSystem.controller;

import com.noyna.NewsManagementSystem.entity.Comment;
import com.noyna.NewsManagementSystem.entity.News;
import com.noyna.NewsManagementSystem.servisce.CommentService;
import com.noyna.NewsManagementSystem.servisce.NewsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(path = "/comment")
public class CommentRestController {

    private final CommentService commentService;
    private final NewsService newsService;

    public CommentRestController(CommentService commentService, NewsService newsService) {
        this.commentService = commentService;
        this.newsService = newsService;
    }



    @PostMapping(path = "/{newsId}")
    public void addCommend(@PathVariable(name = "newsId") Long newsId, @RequestBody Comment comment){
        comment.setNews(newsService.loadNewsById(newsId));
        commentService.addComment(comment);
    }

    @GetMapping(path = "/{newsId}")
    public List<Comment> viewCommentForNews(@PathVariable(name = "newsId") Long newsId){
        return commentService.viewCommentByNewsId(newsId);
    }

    @DeleteMapping(path = "/{commentId}")
    public void deleteComent(@PathVariable(name = "commentId") Long commentId){
        commentService.deleteComment(commentId);
    }
}

package com.technews.controller;

import com.technews.model.Comment;
import com.technews.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
public class CommentController {

    @Autowired
    CommentRepository repository;

    @GetMapping("/api/comments")
    public List<Comment> getAllComments(int postId) {
        return repository.findAllCommentsByPostId(postId);
    }

    @GetMapping("/api/comments/{id}")
    public Comment getComment(@PathVariable int id) {
        return repository.findCommentById(id);
    }

    @PostMapping("/api/comments")
    @ResponseStatus(HttpStatus.CREATED)
    public Comment createComment(@RequestBody Comment comment) {
        return repository.saveComment(comment);
    }

    @PutMapping("/api/updateComment")
    public Comment updateComment(@RequestBody Comment comment) {
        return repository.saveComment(comment);
    }

    @DeleteMapping("/api/comments/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteComment(@PathVariable int id) {
        repository.deleteComment(id);
    }
}

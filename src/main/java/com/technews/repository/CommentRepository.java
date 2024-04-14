package com.technews.repository;

import com.technews.model.Comment;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository {
    List<Comment> findAllCommentsByPostId(int postId);
    Comment findCommentById(int commentId);
    Comment saveComment(Comment comment);
    Comment updateComment(Comment comment);
    void deleteComment(int commentId);
}

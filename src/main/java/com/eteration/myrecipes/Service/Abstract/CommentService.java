package com.eteration.myrecipes.Service.Abstract;

import com.eteration.myrecipes.Entity.Comment;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CommentService {

    List<Comment> getAllComments();

    Comment createComment(Comment comment);

    Comment updateComment(Integer commentId, Comment comment);

    void deleteComment(Integer commentId);

    Comment getCommentById(Integer commentId);


}

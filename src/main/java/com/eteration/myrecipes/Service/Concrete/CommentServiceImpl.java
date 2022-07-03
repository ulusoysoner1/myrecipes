package com.eteration.myrecipes.Service.Concrete;

import com.eteration.myrecipes.Entity.Comment;
import com.eteration.myrecipes.Exception.CommentNotFoundException;
import com.eteration.myrecipes.Repository.CommentRepository;
import com.eteration.myrecipes.Service.Abstract.CommentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {


    private final CommentRepository commentRepository;

    public CommentServiceImpl(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @Override
    public List<Comment> getAllComments() {
        return commentRepository.findAll();
    }

    @Override
    public Comment createComment(Comment comment) {
        return commentRepository.save(comment);
    }

    @Override
    public Comment updateComment(Integer commentId, Comment commentRequest) {
        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(() -> new CommentNotFoundException(commentId));
        comment.setTitle(commentRequest.getTitle());
        comment.setText(commentRequest.getText());
        comment.setRecipe(commentRequest.getRecipe());
        comment.setUser(commentRequest.getUser());
        return commentRepository.save(comment);
    }


    @Override
    public void deleteComment(Integer commentId) {
        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(() -> new CommentNotFoundException(commentId));
        commentRepository.delete(comment);

    }


    /// ****
    @Override
    public Comment getCommentById(Integer commentId) {
        return commentRepository.findById(commentId)
                .orElseThrow(() -> new CommentNotFoundException(commentId));
    }
}

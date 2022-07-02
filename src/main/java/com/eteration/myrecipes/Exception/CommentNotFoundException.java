package com.eteration.myrecipes.Exception;


import org.springframework.web.bind.annotation.ExceptionHandler;

public class CommentNotFoundException extends RuntimeException {
    public CommentNotFoundException(Integer id) {
        super("Could not find employee " + id);
    }
}


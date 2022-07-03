package com.eteration.myrecipes.Exception;


public class CommentNotFoundException extends RuntimeException {
    public CommentNotFoundException(Integer id) {
        super("Could not find employee " + id);
    }
}


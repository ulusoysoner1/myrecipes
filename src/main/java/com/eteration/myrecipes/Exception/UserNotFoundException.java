package com.eteration.myrecipes.Exception;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(Integer userId) {
        super("Could not find employee " + userId);
    }
}


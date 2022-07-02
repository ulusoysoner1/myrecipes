package com.eteration.myrecipes.Exception;

public class IngredientNotFoundException extends RuntimeException {

    public IngredientNotFoundException(Integer id) {
        super("Could not find ingredient " + id);
    }
}

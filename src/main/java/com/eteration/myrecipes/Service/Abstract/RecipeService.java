package com.eteration.myrecipes.Service.Abstract;

import com.eteration.myrecipes.Entity.Recipe;
import org.springframework.stereotype.Service;

import java.util.List;

public interface RecipeService {

    List<Recipe> getAllRecipes();

    Recipe createRecipe(Recipe recipe);

    Recipe updateRecipe(Integer recipeId, Recipe recipe);

    void deleteRecipe(Integer recipeId);

    Recipe getRecipeById(Integer recipeId);

}
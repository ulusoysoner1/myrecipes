package com.eteration.myrecipes.Service.Concrete;

import com.eteration.myrecipes.Entity.Recipe;
import com.eteration.myrecipes.Exception.RecipeNotFoundException;
import com.eteration.myrecipes.Repository.RecipeRepository;
import com.eteration.myrecipes.Service.Abstract.RecipeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecipeServiceImpl implements RecipeService {
    private final RecipeRepository recipeRepository;

    public RecipeServiceImpl(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }


    public List<Recipe> getAllRecipes() {
        return recipeRepository.findAll();
    }


    public Recipe createRecipe(Recipe recipe) {
        return recipeRepository.save(recipe);
    }


    public Recipe updateRecipe(Integer recipeId, Recipe recipeRequest) {
        Recipe recipe = recipeRepository.findById(recipeId)
                .orElseThrow(() -> new RecipeNotFoundException(recipeId));

        recipe.setTitle(recipeRequest.getTitle());
        recipe.setCategory(recipeRequest.getCategory());
        recipe.setNop(recipeRequest.getNop());
        recipe.setCookingTime(recipeRequest.getCookingTime());
        recipe.setCookingDegree(recipeRequest.getCookingDegree());
        recipe.setImage(recipeRequest.getImage());
        recipe.setUser(recipeRequest.getUser());
        return recipeRepository.save(recipe);
    }

    public void deleteRecipe(Integer recipeId) {
        Recipe recipe = recipeRepository.findById(recipeId)
                .orElseThrow(() -> new RecipeNotFoundException(recipeId));
        recipeRepository.delete(recipe);
    }

    public Recipe getRecipeById(Integer recipeId) {
        Recipe recipe = recipeRepository.findById(recipeId)
                .orElseThrow(() -> new RecipeNotFoundException(recipeId));
        return recipe;
    }

}

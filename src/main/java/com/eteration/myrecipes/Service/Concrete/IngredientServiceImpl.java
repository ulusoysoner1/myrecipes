package com.eteration.myrecipes.Service.Concrete;

import com.eteration.myrecipes.Entity.Ingredient;
import com.eteration.myrecipes.Exception.IngredientNotFoundException;
import com.eteration.myrecipes.Repository.IngredientRepository;
import com.eteration.myrecipes.Service.Abstract.IngredientService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IngredientServiceImpl implements IngredientService {

    private final IngredientRepository ingredientRepository;

    public IngredientServiceImpl(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    @Override
    public List<Ingredient> getAllIngredient() {
        return ingredientRepository.findAll();
    }

    @Override
    public Ingredient createIngredient(Ingredient ingredient) {
        return ingredientRepository.save(ingredient);
    }

    @Override
    public Ingredient updateIngredient(Integer ingId, Ingredient ingredientRequest) {
        Ingredient ingredient = ingredientRepository.findById(ingId)
                .orElseThrow(() -> new IngredientNotFoundException(ingId));
        ingredient.setDescription(ingredientRequest.getDescription());
        ingredient.setRecipe(ingredientRequest.getRecipe());
        return ingredientRepository.save(ingredient);
    }

    @Override
    public void deleteIngredient(Integer ingId) {
        Ingredient ingredient = ingredientRepository.findById(ingId)
                .orElseThrow(() -> new IngredientNotFoundException(ingId));
        ingredientRepository.delete(ingredient);
    }

    @Override
    public Ingredient getIngredientById(Integer ingId) {
        return ingredientRepository.findById(ingId)
                .orElseThrow(() -> new IngredientNotFoundException(ingId));

    }
}

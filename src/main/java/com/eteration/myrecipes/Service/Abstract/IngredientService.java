package com.eteration.myrecipes.Service.Abstract;

import com.eteration.myrecipes.Entity.Ingredient;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IngredientService {

    List<Ingredient> getAllIngredient();

    Ingredient createIngredient(Ingredient ingredient);

    Ingredient updateIngredient(Integer ingId, Ingredient ingredient);

    void deleteIngredient(Integer ingId);

    Ingredient getIngredientById(Integer ingId);
}

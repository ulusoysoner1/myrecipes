package com.eteration.myrecipes.Repository;

import com.eteration.myrecipes.Entity.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredient, Integer> {

    List<Ingredient> findAllByRecipeId(Integer recipeId);

}

package com.eteration.myrecipes.Controller;

import com.eteration.myrecipes.Dto.RecipeDto;
import com.eteration.myrecipes.Entity.Recipe;
import com.eteration.myrecipes.Service.Abstract.RecipeService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/recipes")
public class RecipeController {

    private final ModelMapper modelMapper;

    private final RecipeService recipeService;

    public RecipeController(ModelMapper modelMapper, RecipeService recipeService) {
        this.modelMapper = modelMapper;
        this.recipeService = recipeService;
    }

    @GetMapping
    public List<RecipeDto> getAllRecipes() {
        return recipeService.getAllRecipes().stream().map(recipe -> modelMapper.map(recipe, RecipeDto.class))
                .collect(Collectors.toList());
    }

    @GetMapping("/{recipeId}")
    public ResponseEntity<RecipeDto> getRecipeById(@PathVariable Integer recipeId) {
        Recipe recipe = recipeService.getRecipeById(recipeId);
        RecipeDto recipeResponse = modelMapper.map(recipe, RecipeDto.class);

        return ResponseEntity.ok().body(recipeResponse);
    }

    @PostMapping
    public ResponseEntity<RecipeDto> createRecipe(@RequestBody RecipeDto recipeDto) {

        Recipe recipeRequest = modelMapper.map(recipeDto, Recipe.class);
        Recipe recipe = recipeService.createRecipe(recipeRequest);

        RecipeDto recipeResponse = modelMapper.map(recipe, RecipeDto.class);

        return new ResponseEntity<>(recipeResponse, HttpStatus.CREATED);
    }

    @PutMapping("/{recipeId}")
    public ResponseEntity<RecipeDto> updateRecipe(@PathVariable Integer recipeId, @RequestBody RecipeDto recipeDto) {

        Recipe recipeRequest = modelMapper.map(recipeDto, Recipe.class);

        Recipe recipe = recipeService.updateRecipe(recipeId, recipeRequest);

        // entity to DTO
        RecipeDto recipeResponse = modelMapper.map(recipe, RecipeDto.class);

        return ResponseEntity.ok().body(recipeResponse);
    }

    @DeleteMapping("/{recipeId}")
    public ResponseEntity<Integer> deleteRecipe(@PathVariable Integer recipeId) {
        return ResponseEntity.ok(recipeId);
    }
}




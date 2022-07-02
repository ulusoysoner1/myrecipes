package com.eteration.myrecipes.Controller;

import com.eteration.myrecipes.Dto.UserDto;
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
    public List<UserDto> getAllUsers() {
        return recipeService.getAllRecipes().stream().map(recipe -> modelMapper.map(recipe, UserDto.class))
                .collect(Collectors.toList());
    }

    @GetMapping("/{recipeId")
    public ResponseEntity<UserDto> getUserById(Integer recipeId) {
        Recipe recipe = recipeService.getRecipeById(recipeId);
        UserDto recipeResponse = modelMapper.map(recipe, UserDto.class);

        return ResponseEntity.ok().body(recipeResponse);
    }

    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto recipeDto) {

        Recipe recipeRequest = modelMapper.map(recipeDto, Recipe.class);
        Recipe recipe = recipeService.createRecipe(recipeRequest);

        UserDto recipeResponse = modelMapper.map(recipe, UserDto.class);

        return new ResponseEntity<UserDto>(recipeResponse, HttpStatus.CREATED);
    }

    @PutMapping("/{recipeId}")
    public ResponseEntity<UserDto> updateUser(@PathVariable Integer recipeId, @RequestBody UserDto recipeDto) {

        Recipe recipeRequest = modelMapper.map(recipeDto, Recipe.class);

        Recipe recipe = recipeService.updateRecipe(recipeId, recipeRequest);

        // entity to DTO
        UserDto recipeResponse = modelMapper.map(recipe, UserDto.class);

        return ResponseEntity.ok().body(recipeResponse);
    }

    @DeleteMapping("/{recipeId}")
    public ResponseEntity<Integer> deleteRecipe(Integer recipeId) {
        return ResponseEntity.ok(recipeId);
    }
}




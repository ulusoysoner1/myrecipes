package com.eteration.myrecipes.Controller;


import com.eteration.myrecipes.Dto.IngredientDto;
import com.eteration.myrecipes.Entity.Ingredient;
import com.eteration.myrecipes.Service.Abstract.IngredientService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/ingredients")
public class IngredientController {
    private final ModelMapper modelMapper;

    private final IngredientService ingredientService;

    public IngredientController(ModelMapper modelMapper, IngredientService ingredientService) {
        this.modelMapper = modelMapper;
        this.ingredientService = ingredientService;
    }

    @GetMapping
    public List<IngredientDto> getAllUsers() {
        return ingredientService.getAllIngredient().stream().map(ingredient -> modelMapper.map(ingredient, IngredientDto.class))
                .collect(Collectors.toList());
    }

    @GetMapping("/{ingId")
    public ResponseEntity<IngredientDto> getUserById(Integer ingId) {
        Ingredient ingredient = ingredientService.getIngredientById(ingId);
        IngredientDto ingredientResponse = modelMapper.map(ingredient, IngredientDto.class);

        return ResponseEntity.ok().body(ingredientResponse);
    }

    @PostMapping
    public ResponseEntity<IngredientDto> createUser(@RequestBody IngredientDto ingredientDto) {

        Ingredient ingredientRequest = modelMapper.map(ingredientDto, Ingredient.class);
        Ingredient ingredient = ingredientService.createIngredient(ingredientRequest);

        IngredientDto ingredientResponse = modelMapper.map(ingredient, IngredientDto.class);

        return new ResponseEntity<IngredientDto>(ingredientResponse, HttpStatus.CREATED);
    }

    @PutMapping("/{ingId}")
    public ResponseEntity<IngredientDto> updateUser(@PathVariable Integer ingId, @RequestBody IngredientDto ingredientDto) {

        Ingredient ingredientRequest = modelMapper.map(ingredientDto, Ingredient.class);

        Ingredient ingredient = ingredientService.updateIngredient(ingId, ingredientRequest);

        // entity to DTO
        IngredientDto ingredientResponse = modelMapper.map(ingredient, IngredientDto.class);

        return ResponseEntity.ok().body(ingredientResponse);
    }
}

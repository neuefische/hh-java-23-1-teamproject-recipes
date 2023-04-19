package com.example.backend.controller;

import com.example.backend.model.Recipe;
import com.example.backend.service.RecipeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/recipes")

public class RecipeController {

    private final RecipeService recipeService;

    @GetMapping
    List<Recipe> getAllRecipes() {
        return recipeService.getAllRecipes();
    }

    @GetMapping("/{id}")
    Recipe getRecipeById(@PathVariable String id) {
        return recipeService.getRecipeById(id);
    }

    @PostMapping
    Recipe addRecipe(@RequestBody @Valid Recipe recipe) {
        return recipeService.addRecipe(recipe);
    }

    @PutMapping("/{id}")
    Recipe updateRecipe(@PathVariable String id, @RequestBody Recipe recipe) {
        if (!recipe.id().equals(id)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The id in the url does not match the request body's id");
            }
        return recipeService.updateRecipe(recipe);
    }


    @DeleteMapping("{id}")
    void delete(@PathVariable String id) {
        recipeService.delete(id);
    }
}

package com.example.backend.controller;


import com.example.backend.model.Recipe;
import com.example.backend.service.RecipeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/recipes")
/*@CrossOrigin(origins = "http://localhost:3000")*/

public class RecipeController {

    private final RecipeService recipeService;

    @GetMapping
    List<Recipe> getAllRecipes() {
        return recipeService.getAllRecipes();
    }

    @PostMapping
    Recipe addRecipe(@RequestBody Recipe recipe) {
        return recipeService.addRecipe(recipe);
    }


}

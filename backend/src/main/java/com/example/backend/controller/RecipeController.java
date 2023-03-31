package com.example.backend.controller;


import com.example.backend.model.Recipe;
import com.example.backend.service.RecipeService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api")

public class RecipeController {

    private final RecipeService recipeService;

    @GetMapping("/recipes")
    List<Recipe> getAllRecipes() {
        return recipeService.getAllRecipes();
    }

    @GetMapping("/test")
    public String testMethode() {
        return "Teststring";
    }

}

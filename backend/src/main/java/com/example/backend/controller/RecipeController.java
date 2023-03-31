package com.example.backend.controller;


import com.example.backend.model.Recipe;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RecipeController {
    @GetMapping
    List<Recipe> getAllRecipes() {
        return null;
    }

    
}

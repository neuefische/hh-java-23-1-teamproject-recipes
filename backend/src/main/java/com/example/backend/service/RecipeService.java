package com.example.backend.service;

import com.example.backend.model.Recipe;
import com.example.backend.repo.RecipeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class RecipeService {

    private final RecipeRepository recipeRepository;

    //Encapsulation: Wir rufen die Methode aus Repository in Serviceklasse auf
    public List<Recipe> getAllRecipes() {
        return recipeRepository.getAllRecipes();
    }
}

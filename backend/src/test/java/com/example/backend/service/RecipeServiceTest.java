package com.example.backend.service;

import com.example.backend.model.Recipe;
import com.example.backend.repo.RecipeRepository;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class RecipeServiceTest {

    RecipeRepository recipeRepository = mock(RecipeRepository.class);
    RecipeService recipeService = new RecipeService(recipeRepository);

    @Test
    void getAllRecipes() {
        // GIVEN
        List<Recipe> expected = Collections.emptyList();
        // WHEN
        when(recipeRepository.getAllRecipes()).thenReturn(Collections.emptyList());
        List<Recipe> actual = recipeService.getAllRecipes();
        // THEN
        verify(recipeRepository).getAllRecipes();
        assertEquals(expected, actual);
    }
}

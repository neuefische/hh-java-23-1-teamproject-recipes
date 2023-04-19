package com.example.backend.service;

import com.example.backend.model.Category;
import com.example.backend.model.MongoUser;
import com.example.backend.model.Recipe;
import com.example.backend.repo.MongoUserRepository;
import com.example.backend.repo.RecipeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class RecipeServiceTest {

    RecipeRepository recipeRepository = mock(RecipeRepository.class);
    MongoUserRepository mongoUserRepository = mock(MongoUserRepository.class);
    RecipeService recipeService = new RecipeService(recipeRepository);
    MongoUserDetailsService mongoUserDetailsService = new MongoUserDetailsService(mongoUserRepository);


    @Test
    void getAllRecipesReturnEmptyList() {

        List<Recipe> expected = Collections.emptyList();

        when(recipeRepository.findAll()).thenReturn(Collections.emptyList());
        List<Recipe> actual = recipeService.getAllRecipes();

        verify(recipeRepository).findAll();
        assertEquals(expected, actual);
    }

    @Test
    void getMongoUserByName() {

        String username = "testUser";
        String password = "1234";

        MongoUser expected = new MongoUser(
                "test1",
                username, password
        );

        when(mongoUserRepository.findMongoUserByUsername(username)).thenReturn(Optional.of(expected));
        UserDetails actual = mongoUserDetailsService.loadUserByUsername(username);

        verify(mongoUserRepository).findMongoUserByUsername(username);
        assertEquals(expected.username(), actual.getUsername());
    }

    @Test
    void addRecipe() {

        Recipe recipe = new Recipe("Gurke", Category.ASIAN);

        when(recipeRepository.save(recipe)).thenReturn(recipe);
        Recipe actual = recipeService.addRecipe(recipe);

        verify(recipeRepository).save(recipe);
        assertEquals(recipe, actual);
    }

    @Test
    void getRecipeById() {

        String id = "642ee1f918543010b981f729";
        Recipe expected = new Recipe(
                "642ee1f918543010b981f729",
                "Tofu",
                Category.ASIAN
        );

        when(recipeRepository.findById(id)).thenReturn(Optional.of(expected));
        Recipe actual = recipeService.getRecipeById(id);

        verify(recipeRepository).findById(id);
        assertEquals(expected, actual);
    }

    @Test
    void getRecipeById_whenRecipeNotExist_thenReturnException() {

        String id = "123567";

        when(recipeRepository.findById(id)).thenThrow(new NoSuchElementException());

        assertThrows(NoSuchElementException.class, () -> recipeService.getRecipeById(id));
    }

    @Test
    void upRecipeById() {
        String id = "123567";
        Recipe recipe = new Recipe("Gurke", Category.MEDITERRANEAN);

        when(recipeRepository.findById(id)).thenReturn(Optional.of(recipe));
        recipeService.updateRecipe(recipe);

        verify(recipeRepository).save(recipe);
    }


}

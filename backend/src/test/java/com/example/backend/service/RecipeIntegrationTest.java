package com.example.backend.service;

import com.example.backend.model.Category;
import com.example.backend.model.Recipe;
import com.example.backend.repo.RecipeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
class RecipeIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    RecipeRepository recipeRepository;

    @BeforeEach
    void addRecipeToRepo() {
        recipeRepository.save(new Recipe("123", "Test", Category.ASIAN));
    }

    @Test
    void getAllRecipesReturnAllRecipes() throws Exception {
        mockMvc.perform(get("/api/recipes"))
                .andExpect(status().isOk())
                .andExpect(content().json("""
                        [
                        {
                            "id": "123",
                            "name": "Test",
                            "category": "ASIAN"
                        }
                        ]
                         """));
    }

    @DirtiesContext
    @Test
    void getRecipeById() throws Exception {
        mockMvc.perform(get("/api/recipes/123"))
                .andExpect(status().isOk())
                .andExpect(content().json("""
                        {
                            "id": "123",
                            "name": "Test",
                            "category": "ASIAN"
                        }
                         """));
    }

    @DirtiesContext
    @Test
    void addRecipe_ExpectRecipe() throws Exception {
        mockMvc.perform(post("/api/recipes")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                                {
                                    "id": "some title",
                                    "name": "some name",
                                    "category": "ASIAN"
                                }
                                """))
                .andExpect(status().isOk());
    }


}
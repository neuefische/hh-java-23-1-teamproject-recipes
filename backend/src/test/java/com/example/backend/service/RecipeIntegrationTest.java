package com.example.backend.service;

import com.example.backend.model.Category;
import com.example.backend.model.Recipe;
import com.example.backend.repo.RecipeRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
class RecipeIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    RecipeRepository recipeRepository;

    @Autowired
    ObjectMapper objectMapper;


    @BeforeEach
    void addRecipeToRepo() {
        recipeRepository.save(new Recipe("123", "Test", Category.ASIAN));
    }


    @Test
    @WithMockUser
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
    @WithMockUser
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
    @WithMockUser
    void addRecipe_ExpectRecipe() throws Exception {
        mockMvc.perform(post("/api/recipes")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                                {
                                    "id": "some title",
                                    "name": "some name",
                                    "category": "ASIAN"
                                }
                                """)
                        .with(csrf())
                )
                .andExpect(status().isOk());
    }

    @DirtiesContext
    @Test
    @WithMockUser(username = "testbenutzer")
    void getUsernameWhenLoggedIn() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/users/me"))
                .andExpect(status().isOk())
                .andExpect(content().string("testbenutzer"));
    }

    @DirtiesContext
    @Test
    void getAnonymousUserWhenNotLoggedIn() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/users/me"))
                .andExpect(status().isOk())
                .andExpect(content().string("anonymousUser"));
    }

    @DirtiesContext
    @Test
    @WithMockUser
    void expectSuccessfulDelete() throws Exception {

        mockMvc.perform(delete("/api/recipes/123")
                        .with(csrf()))
                .andExpect(status().isOk());

        mockMvc.perform(get("/api/recipes"))
                .andExpect(status().isOk())
                .andExpect(content().json("""
                        []
                        """));
    }
}
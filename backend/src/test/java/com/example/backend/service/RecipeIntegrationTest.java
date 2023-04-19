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
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


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

    @Test
    @DirtiesContext
    @WithMockUser
    void updateRecipeById_Successfully() throws Exception {
        mockMvc.perform(put("/api/recipes/123").
                        contentType(MediaType.APPLICATION_JSON).
                        content("""
                                {
                                "id": "123",
                                "name": "Test",
                                "category": "ASIAN"
                                 }
                                       """).with(csrf())).
                andExpect(status().isOk());
    }
    @Test
    @DirtiesContext
    @WithMockUser
    void updateRecipeById_failed() throws Exception {
        mockMvc.perform(put("/api/recipes/abcdef").
                        contentType(MediaType.APPLICATION_JSON).
                        content("""
                                {
                                "id": "123",
                                "name": "Test",
                                "category": "ASIAN"
                                 }
                                       """).with(csrf())).
                andExpect(status().isBadRequest());
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

    @DirtiesContext
    @Test
    @WithMockUser
    void catchesExceptionWhenRecipeNotFoundWithSpecificResponse() throws Exception {

        mockMvc.perform(get("/api/recipes/999")
                        .contentType(MediaType.APPLICATION_JSON)
                        .with(csrf()))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("message").value("No value present"));
    }
}






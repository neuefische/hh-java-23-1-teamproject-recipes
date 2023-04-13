package com.example.backend.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record Recipe(
        String id,
        @NotBlank
        @Size(min = 3,  max = 32)
        String name,
        Category category)
{

    public Recipe(String name, Category category) {
        this(null, name, category);
    }

    public Recipe withId(String id) {
        return new Recipe(id, name, category);
    }

}

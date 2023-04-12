package com.example.backend.model;

public record Recipe(String id, String name, Category category) {

    public Recipe(String name, Category category) {
        this(null, name, category);
    }

    public Recipe withId(String id) {
        return new Recipe(id, name, category);
    }

}

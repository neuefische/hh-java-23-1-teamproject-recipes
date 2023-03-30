package com.example.backend.model;


public record Recipe(
        String id,
        String name,
        String image,
        String ingredients,
        String preparation,
        String portion,

        Categories categories
) {

}

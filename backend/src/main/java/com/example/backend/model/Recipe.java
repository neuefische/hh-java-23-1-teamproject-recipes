package com.example.backend.model;


import java.util.List;

public record Recipe(
        String id,
        String name,
        String image,
        List<String> ingredients,
        String preparation,
        String portion,

        Categories categories
) {

}

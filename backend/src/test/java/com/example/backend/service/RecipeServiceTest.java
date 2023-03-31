package com.example.backend.service;

import com.example.backend.repo.RecipeRepository;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class RecipeServiceTest {
    /*
    MockMVC ist ein Test-Framework in der Spring-Entwicklung, das verwendet wird, um den Controller-Layer einer
    Anwendung zu testen. Es ermöglicht das Schreiben von Integrationstests, bei denen ein Anfrage- und Antwortzyklus
    simuliert wird, als ob er von einem echten Client gesendet und empfangen würde. Die MockMVC-Umgebung bietet eine
    Vielzahl von Tools und Methoden, um den Spring MVC-Controller zu testen, einschließlich der Möglichkeit, HTTP-Anfragen
    zu senden, die Antwortstatuscodes zu validieren und die empfangenen Daten zu prüfen. Die Verwendung von MockMVC ermöglicht
    es Entwicklern, ihre REST-Endpoints zu testen, die korrekte Verarbeitung von Anfragen sicherzustellen und sicherzustellen,
    dass der vom Endpunkt zurückgegebene Inhalt korrekt ist.

     */
    //Eingenschaft von Recipeservice-Test-Klasse
    private RecipeRepository recipeRepository = mock(RecipeRepository.class);
    private RecipeService recipeService = new RecipeService(recipeRepository);

    //Unit Test
   /* @Test
    void getAllRecipes() {
        //GIVEN

        //WHEN

        //THEN
    }*/
}
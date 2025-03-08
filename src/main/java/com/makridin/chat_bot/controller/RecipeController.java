package com.makridin.chat_bot.controller;

import com.makridin.chat_bot.model.Answer;
import com.makridin.chat_bot.model.Question;
import com.makridin.chat_bot.service.RecipeGenerator;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/recipe")
public class RecipeController {

    private final RecipeGenerator recipeGenerator;

    public RecipeController(RecipeGenerator recipeGenerator) {
        this.recipeGenerator = recipeGenerator;
    }

    @PostMapping("/generate")
    public Answer chat(@RequestBody String message) {
        return recipeGenerator.generateRecipe(new Question(message));
    }
}

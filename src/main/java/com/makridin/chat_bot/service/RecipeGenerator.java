package com.makridin.chat_bot.service;

import com.makridin.chat_bot.model.Answer;
import com.makridin.chat_bot.model.Question;

public interface RecipeGenerator {

    Answer generateRecipe(Question question);
}

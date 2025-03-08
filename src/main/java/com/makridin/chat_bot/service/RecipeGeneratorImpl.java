package com.makridin.chat_bot.service;

import com.makridin.chat_bot.model.Answer;
import com.makridin.chat_bot.model.Question;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.stereotype.Service;

@Service
public class RecipeGeneratorImpl implements RecipeGenerator{
    private final ChatClient chatClient;

    public RecipeGeneratorImpl(ChatClient chatClient) {
        this.chatClient = chatClient;
    }

    @Override
    public Answer generateRecipe(Question question) {
        return new Answer(
                getMessage(question.getQuestion())
                        .getResult()
                        .getOutput()
                        .getContent()
        );
    }

    private ChatResponse getMessage(String message) {
        return chatClient.prompt()
                .user(message)
                .call()
                .chatResponse();
    }
}

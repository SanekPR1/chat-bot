package com.makridin.chat_bot.service;

import com.makridin.chat_bot.model.Answer;
import com.makridin.chat_bot.model.Question;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.stereotype.Service;

@Service
public class RecipeGeneratorImpl implements RecipeGenerator{
    private final ChatClient chatClient;
    private final String questionTemplate = """
            Answer for {question} for {foodName}""";

    public RecipeGeneratorImpl(ChatClient chatClient) {
        this.chatClient = chatClient;
    }

    @Override
    public Answer generateRecipe(Question question) {
        return new Answer(
                getMessage(question)
                        .getResult()
                        .getOutput()
                        .getContent()
        );
    }

    private ChatResponse getMessage(Question question) {
        return chatClient.prompt()
                .user(userSpec -> userSpec.text(questionTemplate)
                        .param("question", question.getQuestion())
                        .param("foodName", question.getFoodName())
                )
                .call()
                .chatResponse();
    }
}

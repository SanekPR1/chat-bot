package com.makridin.chat_bot.service.impl;

import com.makridin.chat_bot.model.Answer;
import com.makridin.chat_bot.service.MovieService;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

@Service
public class MovieServiceImpl implements MovieService {
    private final ChatClient chatClient;

    @Value("classpath:prompts/movie.st")
    private Resource movieResource;

    public MovieServiceImpl(ChatClient client) {
        this.chatClient = client;
    }

    public Answer movieInfo(String movieName) {
        return new Answer(
                getMessage(movieName)
                        .getResult()
                        .getOutput()
                        .getContent()
        );
    }

    private ChatResponse getMessage(String movieName) {
        return chatClient.prompt()
                .user(userSpec -> userSpec.text(movieResource)
                        .param("movieName", movieName)
                )
                .call()
                .chatResponse();
    }
}

package com.makridin.chat_bot.configuration;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

@Configuration
public class ApplicationConfiguration {

    @Value("classpath:roleExplanation.txt")
    Resource resource;

    @Bean
    public ChatClient chatClient(ChatClient.Builder builder) {
        return builder
                .defaultSystem(resource)
                .build();
    }
}

package com.makridin.chat_bot.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.stereotype.Service;

@Service
public class ChatBotService {
    private static final String DEFAULT_PROMPT_MESSAGE = "Please give me a simple joke";

    private final ChatClient chatClient;

    public ChatBotService(ChatClient chatClient) {
        this.chatClient = chatClient;
    }

    public String generateChatResponse(String message) {
        return chatClient.prompt()
                .user(StringUtils.isEmpty(message) ? DEFAULT_PROMPT_MESSAGE : message)
                .call()
                .content();
    }
}

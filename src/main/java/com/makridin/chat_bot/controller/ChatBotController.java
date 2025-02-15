package com.makridin.chat_bot.controller;

import com.makridin.chat_bot.service.ChatBotService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/chat")
public class ChatBotController {

    private ChatBotService chatBotService;

    public ChatBotController(ChatBotService service) {
        this.chatBotService = service;
    }

    @PostMapping("/ask")
    public String chat(@RequestBody String message) {
        return chatBotService.generateChatResponse(message);
    }
}

package com.makridin.chat_bot.service;

import com.makridin.chat_bot.model.Answer;

public interface MovieService {
    Answer movieInfo(String movieName);
}

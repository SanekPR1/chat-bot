package com.makridin.chat_bot.controller;

import com.makridin.chat_bot.model.Answer;
import com.makridin.chat_bot.model.Question;
import com.makridin.chat_bot.service.MovieService;
import com.makridin.chat_bot.service.RecipeGenerator;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/movie")
public class MovieChatController {
    private final MovieService movieService;

    public MovieChatController(MovieService movieService) {
        this.movieService = movieService;
    }

    @PostMapping("/{movieName}")
    public Answer chat(@PathVariable String movieName) {
        return movieService.movieInfo(movieName);
    }


}

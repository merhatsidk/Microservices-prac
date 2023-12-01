package com.merha.movieinfoservice.controller;

import com.merha.movieinfoservice.model.MovieInfo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/movieInfo")
public class MovieInfoController {

    @GetMapping("/{movieId}")
    public static MovieInfo getMovieInfo(@PathVariable("movieId") String movieId){
        return new MovieInfo(movieId, "this is a movie about an african kid's life.");
    }
}

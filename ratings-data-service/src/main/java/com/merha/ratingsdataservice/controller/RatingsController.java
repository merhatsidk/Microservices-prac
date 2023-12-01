package com.merha.ratingsdataservice.controller;

import com.merha.ratingsdataservice.model.Rating;
import com.merha.ratingsdataservice.model.UserRating;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/rating")
public class RatingsController {

    @GetMapping("/{movieId}")
    public Rating getRating(@PathVariable("movieId") String movieId){
        return new Rating(movieId, 5);
    }

    @GetMapping("/users/{userId}")
    public UserRating getUserRating(@PathVariable("userId") String userId){


       List<Rating> ratings =  Arrays.asList(
               new Rating(userId,4),
               new Rating("Abc",5)
       );
        UserRating userRating = new UserRating();
         userRating.setUserRatings(ratings);
        return userRating;
    }
}

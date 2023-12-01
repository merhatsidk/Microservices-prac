package com.merha.moviecatalogservice.controller;

import com.merha.moviecatalogservice.model.CatalogItem;
import com.merha.moviecatalogservice.model.MovieInfo;
import com.merha.moviecatalogservice.model.Rating;
import com.merha.moviecatalogservice.model.UserRating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/catalog")
public class MovieCatalogController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private WebClient.Builder webClientBuilder;


    @GetMapping("/{userId}")
    public  List<CatalogItem> getCatalog(@PathVariable("userId") String userId) {


         UserRating ratings = restTemplate.getForObject("http://rating-service/api/rating/users/" + userId, UserRating.class);

        // for each movie UD, call movie info service and get details.
      return ratings.getUserRatings().stream().map(rating -> {
          /**
           * this code below is a webclient way of performing an api calls.
           */
        /*  MovieInfo movieInfo = webClientBuilder.build()
                  .get()
                  .uri("http://localhost:8082/api/movieInfo/" + rating.getMovieId())
                  .retrieve()
                  .bodyToMono(MovieInfo.class)
                  .block();
        */

          /**
           * And this is RestTemplate way of performing an api call. N:B probably deprecated.
           */

          MovieInfo movieInfo =  restTemplate.getForObject("http://movie-info-service/api/movieInfo/" + rating.getMovieId(), MovieInfo.class);
          return new CatalogItem(movieInfo.getName(),"desc",rating.getRating());
       }).toList();

    }

}

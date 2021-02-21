package io.practice.moviecatalogservice.Controller;

import io.practice.moviecatalogservice.Model.MovieCatalog;
import io.practice.moviecatalogservice.Model.MovieInformation;
import io.practice.moviecatalogservice.Model.Rating;
import io.practice.moviecatalogservice.Model.UserRatings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogController {

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping("/{userId}")
    public List<MovieCatalog> getMovieCatalog(@PathVariable("userId") String userId){

        //send userId and fetch Ratings data
        UserRatings userRatings = restTemplate.getForObject("http://RATING-INFO-SERVICE/ratings/"+userId,
                UserRatings.class);

        MovieInformation movieInformation = null;
        List<MovieCatalog> mc = new ArrayList<MovieCatalog>();
        //User movieId from Ratings data and send it to movie info
        for(Rating rating : userRatings.getUserRating()){
            movieInformation = restTemplate.getForObject("http://MOVIE-INFO-SERVICE/movieInfo/"+rating
                          .getMovieId(), MovieInformation.class);
          mc.add(new MovieCatalog(movieInformation.getMovieName(),movieInformation.getMovieDesc(),rating.getRating()));
        }

        //process and put them together and return
        return mc;
    }
}

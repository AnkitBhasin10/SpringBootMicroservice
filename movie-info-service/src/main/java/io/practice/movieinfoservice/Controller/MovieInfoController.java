package io.practice.movieinfoservice.Controller;

import io.practice.movieinfoservice.Model.MovieInformation;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/movieInfo")
public class MovieInfoController {

    @RequestMapping("/{movieId}")
    public MovieInformation getMovieInformation(@PathVariable("movieId") String movieId){
        return new MovieInformation("Avengers2", "desc");
    }
}

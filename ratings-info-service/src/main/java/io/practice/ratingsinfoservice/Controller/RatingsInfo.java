package io.practice.ratingsinfoservice.Controller;

import io.practice.ratingsinfoservice.Model.Rating;
import io.practice.ratingsinfoservice.Model.UserRatings;
import org.apache.catalina.User;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/ratings")
public class RatingsInfo {

    @RequestMapping("/{userId}")
    public UserRatings getRating(@PathVariable("userId") String userId){

        List<Rating> rating = Arrays.asList(
          new Rating("1234", 4),
          new Rating("5678", 3)
        );

        UserRatings userRatings = new UserRatings();
        userRatings.setUserRating(rating);
        return userRatings;
    }
}

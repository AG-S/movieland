package com.ag.movieland.controller;

import com.ag.movieland.dao.common.*;
import com.ag.movieland.entity.Movie;
import com.ag.movieland.service.IMovieService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MovieController {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    private IMovieService movieService;

    @GetMapping(path = "/movies", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    List<Movie> findAll(@RequestParam(value = "rating", required = false) SortingDirection ratingOrdering,
                        @RequestParam(value = "price", required = false) SortingDirection priceOrdering) {
        logger.info("find All Movies");
        RequestParameters requestParameters = new RequestParameters();
        requestParameters.addSortingParameters(ratingOrdering, priceOrdering);
        List<Movie> movies = movieService.findAll(requestParameters);
        return movies;
    }

    @GetMapping(path = "/movies/random", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    List<Movie> getRandom() {
        logger.info("get Random Movies");
        List<Movie> movies = movieService.getRandom();
        return movies;
    }

    @GetMapping(path = "/movies/genre/{genreId}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    List<Movie> findByGenreId(@PathVariable int genreId,
                              @RequestParam(value = "rating", required = false) SortingDirection ratingOrdering,
                              @RequestParam(value = "price", required = false) SortingDirection priceOrdering) {
        logger.info("find Movies by Genre ID");
        RequestParameters requestParameters = new RequestParameters();
        requestParameters.addSortingParameters(ratingOrdering, priceOrdering);
        List<Movie> movies = movieService.findByGenreId(genreId, requestParameters);
        return movies;
    }

    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        dataBinder.registerCustomEditor(SortingDirection.class, new SortingDirectionConverter());
    }

    @Autowired
    public void setMovieService(IMovieService movieService) {
        this.movieService = movieService;
    }

}

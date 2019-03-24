package com.ag.movieland.controller;

import com.ag.movieland.entity.Movie;
import com.ag.movieland.service.impl.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MovieController {

    private MovieService movieService;

    @RequestMapping(method = RequestMethod.GET, path = "/movies", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    List<Movie>  findAll()  {
        List<Movie> movies = movieService.findAll();
        return  movies;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/movies/random", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    List<Movie>  getRandom()  {
        List<Movie> movies = movieService.getRandom();
        return  movies;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/movies/genre/{genreId}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    List<Movie>  findByGenreId(@PathVariable int genreId)  {
        List<Movie> movies = movieService.findByGenreId(genreId);
        return  movies;
    }

    @Autowired
    public void setMovieService(MovieService movieService) {
        this.movieService = movieService;
    }

}

package com.ag.movieland.service;

import com.ag.movieland.entity.Movie;

import java.util.List;

public interface IMovieService {
    List<Movie> findAll();
    List<Movie> getRandom();
    List<Movie> findByGenreId(int id);
}

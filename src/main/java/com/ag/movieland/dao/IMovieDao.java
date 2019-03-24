package com.ag.movieland.dao;

import com.ag.movieland.entity.Movie;

import java.util.List;

public interface IMovieDao {
    List<Movie> findAll();
    List<Movie> getRandom();
    List<Movie> findByGenreId(int id);

}

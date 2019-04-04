package com.ag.movieland.service;

import com.ag.movieland.dao.common.SortingParameters;
import com.ag.movieland.entity.Movie;

import java.util.List;

public interface IMovieService {
    List<Movie> findAll(SortingParameters sortingParameters);
    List<Movie> getRandom();
    List<Movie> findByGenreId(int id, SortingParameters sortingParameters);
}

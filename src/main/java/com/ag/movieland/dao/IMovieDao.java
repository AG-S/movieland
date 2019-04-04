package com.ag.movieland.dao;

import com.ag.movieland.dao.common.SortingParameters;
import com.ag.movieland.entity.Movie;

import java.util.List;

public interface IMovieDao {
    List<Movie> findAll(SortingParameters sortingParameters);
    List<Movie> getRandom();
    List<Movie> findByGenreId(int id, SortingParameters sortingParameters);

}

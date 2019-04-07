package com.ag.movieland.service;

import com.ag.movieland.dao.common.RequestParameters;
import com.ag.movieland.entity.Movie;

import java.util.List;

public interface IMovieService {
    List<Movie> findAll(RequestParameters requestParameters);
    List<Movie> getRandom();
    List<Movie> findByGenreId(int id, RequestParameters requestParameters);
}

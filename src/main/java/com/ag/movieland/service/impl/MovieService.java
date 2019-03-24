package com.ag.movieland.service.impl;

import com.ag.movieland.dao.jdbc.MovieDao;
import com.ag.movieland.entity.Movie;
import com.ag.movieland.service.IMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService implements IMovieService {

    private MovieDao movieDao;

    @Autowired
    public MovieService(MovieDao movieDao) {
        this.movieDao = movieDao;
    }

    @Override
    public List<Movie> findAll() {
       List<Movie> movies = movieDao.findAll();
       return movies;
    }

    @Override
    public List<Movie> getRandom() {
        List<Movie> movies = movieDao.getRandom();
        return movies;
    }

    @Override
    public List<Movie> findByGenreId(int id) {
        List<Movie> movies = movieDao.findByGenreId(id);
        return movies;
    }
}

package com.ag.movieland.service.impl;

import com.ag.movieland.dao.IMovieDao;
import com.ag.movieland.dao.common.RequestParameters;
import com.ag.movieland.entity.Movie;
import com.ag.movieland.service.IMovieService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService implements IMovieService {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    private IMovieDao movieDao;

    @Autowired
    public MovieService(IMovieDao movieDao) {
        this.movieDao = movieDao;
    }

    @Override
    public List<Movie> findAll(RequestParameters requestParameters) {
        logger.info("find All Movies");
        List<Movie> movies = movieDao.findAll(requestParameters);
        return movies;
    }

    @Override
    public List<Movie> getRandom() {
        logger.info("get Random Movies");
        List<Movie> movies = movieDao.getRandom();
        return movies;
    }

    @Override
    public List<Movie> findByGenreId(int id, RequestParameters requestParameters) {
        logger.info("find Movies by Genre ID");
        List<Movie> movies = movieDao.findByGenreId(id, requestParameters);
        return movies;
    }
}

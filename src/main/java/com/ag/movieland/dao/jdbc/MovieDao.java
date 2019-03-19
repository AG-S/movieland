package com.ag.movieland.dao.jdbc;

import com.ag.movieland.dao.IMovieDao;
import com.ag.movieland.dao.jdbc.mapper.MovieRowMapper;
import com.ag.movieland.entity.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MovieDao implements IMovieDao {

    private static final MovieRowMapper MOVIE_ROW_MAPPER = new MovieRowMapper();

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private String findAllMovies;

    public List<Movie> findAll() {
        List<Movie> movies = jdbcTemplate.query(findAllMovies,MOVIE_ROW_MAPPER) ;
        return movies;
    }
}


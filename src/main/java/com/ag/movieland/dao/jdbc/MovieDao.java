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

    private JdbcTemplate jdbcTemplate;
    private String findAllMovies;
    private String findRandomMovies;

    public List<Movie> findAll() {
        List<Movie> movies = jdbcTemplate.query(findAllMovies, MOVIE_ROW_MAPPER);
        return movies;
    }

    @Override
    public List<Movie> getRandom() {
        List<Movie> movies = jdbcTemplate.query(findRandomMovies, MOVIE_ROW_MAPPER);
        return movies;
    }

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Autowired
    public void setFindAllMovies(String findAllMovies) {
        this.findAllMovies = findAllMovies;
    }

    @Autowired
    public void setFindRandomMovies(String findRandomMovies) {
        this.findRandomMovies = findRandomMovies;
    }

}


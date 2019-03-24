package com.ag.movieland.dao.jdbc;

import com.ag.movieland.dao.IMovieDao;
import com.ag.movieland.dao.jdbc.mapper.MovieRowMapper;
import com.ag.movieland.entity.Movie;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private String findMoviesByGenreId;

    private final Logger logger = LoggerFactory.getLogger(getClass());

    public List<Movie> findAll() {
        logger.info("find All Movies");
        long startTime = System.currentTimeMillis();
        List<Movie> movies = jdbcTemplate.query(findAllMovies, MOVIE_ROW_MAPPER);
        logger.debug("Query took:{} ms", System.currentTimeMillis() - startTime);
        return movies;
    }

    @Override
    public List<Movie> getRandom() {
        logger.info("get Random Movies");
        long startTime = System.currentTimeMillis();
        List<Movie> movies = jdbcTemplate.query(findRandomMovies, MOVIE_ROW_MAPPER);
        logger.debug("Query took:{} ms", System.currentTimeMillis() - startTime);
        return movies;
    }

    @Override
    public List<Movie> findByGenreId(int id) {
        logger.info("find Movies by Genre Id");
        long startTime = System.currentTimeMillis();
        List<Movie> movies = jdbcTemplate.query(findMoviesByGenreId, MOVIE_ROW_MAPPER, id);
        logger.debug("Query took:{} ms", System.currentTimeMillis() - startTime);
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

    @Autowired
    public void setFindMoviesByGenreId(String findMoviesByGenreId) {
        this.findMoviesByGenreId = findMoviesByGenreId;
    }

}


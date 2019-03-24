package com.ag.movieland.dao.jdbc;

import com.ag.movieland.dao.IGenreDao;
import com.ag.movieland.dao.jdbc.mapper.GenreRowMapper;
import com.ag.movieland.entity.Genre;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class GenreDao implements IGenreDao {

    private static final GenreRowMapper GENRE_ROW_MAPPER = new GenreRowMapper();
    private final Logger logger = LoggerFactory.getLogger(getClass());

    private JdbcTemplate jdbcTemplate;
    private String findAllGenres;

    @Override
    public List<Genre> findAll() {
        logger.info("find All Genres");
        long startTime = System.currentTimeMillis();
        List<Genre> genres = jdbcTemplate.query(findAllGenres, GENRE_ROW_MAPPER);
        logger.debug("Query took:{} ms", System.currentTimeMillis() - startTime);
        return genres;
    }

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Autowired
    public void setFindAllGenres(String findAllGenres) {
        this.findAllGenres = findAllGenres;
    }

}

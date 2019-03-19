package com.ag.movieland.dao.jdbc.mapper;

import com.ag.movieland.entity.Movie;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class MovieRowMapper implements RowMapper<Movie> {

    @Override
    public Movie mapRow(ResultSet resultSet, int i) throws SQLException {
        Movie movie = new Movie();
        movie.setId(resultSet.getInt("id"));
        movie.setNameNative(resultSet.getString("namenative"));
        movie.setNameRussian(resultSet.getString("namerussian"));
        movie.setYearOfRelease(resultSet.getInt("yearofrelease"));
        movie.setPrice(resultSet.getDouble("price"));
        movie.setRating(resultSet.getDouble("rating"));
        movie.setPicturePath(resultSet.getString("picturepath"));
        return movie;
    }

}


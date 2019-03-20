package com.ag.movieland.dao.mapper;

import com.ag.movieland.dao.jdbc.mapper.MovieRowMapper;
import com.ag.movieland.entity.Movie;
import org.junit.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MovieRowMapperTest {

    @Test
    public void mapRowTest() throws SQLException {
        MovieRowMapper movieRowMapper = new MovieRowMapper();
        ResultSet resultSet = mock(ResultSet.class);

        when(resultSet.getInt("id")).thenReturn(23);
        when(resultSet.getDouble("rating")).thenReturn(7.6);
        when(resultSet.getDouble("price")).thenReturn(100.0);
        when(resultSet.getInt("yearofrelease")).thenReturn(1976);
        when(resultSet.getString("namerussian")).thenReturn("Блеф");
        when(resultSet.getString("namenative")).thenReturn("Bluff storia di truffe e di imbroglioni");
        when(resultSet.getString("picturepath")).thenReturn("https://images-na.ssl-images-amazon.com/images/M/MV5BMjk5YmMxMjMtMTlkNi00YTI5LThhYTMtOTk2NmNiNzQwMzI0XkEyXkFqcGdeQXVyMTQ3Njg3MQ@@._V1._SX140_CR0,0,140,209_.jpg");

        Movie mockMovie = movieRowMapper.mapRow(resultSet, 0);

        assertEquals(23, mockMovie.getId());
        assertEquals(7.6, mockMovie.getRating(), 0.1);
        assertEquals(100.0, mockMovie.getPrice(), 0.1);
        assertEquals(1976, mockMovie.getYearOfRelease());
        assertEquals("Блеф", mockMovie.getNameRussian());
        assertEquals("Bluff storia di truffe e di imbroglioni", mockMovie.getNameNative());
        assertEquals("https://images-na.ssl-images-amazon.com/images/M/MV5BMjk5YmMxMjMtMTlkNi00YTI5LThhYTMtOTk2NmNiNzQwMzI0XkEyXkFqcGdeQXVyMTQ3Njg3MQ@@._V1._SX140_CR0,0,140,209_.jpg", mockMovie.getPicturePath());

    }
}

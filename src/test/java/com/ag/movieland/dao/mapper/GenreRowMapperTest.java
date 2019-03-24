package com.ag.movieland.dao.mapper;

import com.ag.movieland.dao.jdbc.mapper.GenreRowMapper;

import com.ag.movieland.entity.Genre;
import org.junit.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class GenreRowMapperTest {

    @Test
    public void mapRowTest() throws SQLException {
        GenreRowMapper genreRowMapper = new GenreRowMapper();
        ResultSet resultSet = mock(ResultSet.class);
        when(resultSet.getInt("id")).thenReturn(0);
        when(resultSet.getString("name")).thenReturn("Комедия");
        Genre mockGenre = genreRowMapper.mapRow(resultSet, 0);

        assertEquals(0, mockGenre.getId());
        assertEquals("Комедия", mockGenre.getName());
    }
}

package com.ag.movieland.service.impl;

import com.ag.movieland.dao.jdbc.GenreDao;
import com.ag.movieland.entity.Genre;
import com.ag.movieland.entity.Movie;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class GenreServiceTest {

    @Test
    public void findAllGenre(){
        GenreDao genreDao = mock(GenreDao.class);
        List<Genre> expectedGenreList = new ArrayList<>();
        Genre genreFirst = new Genre(1,"комедия");
        expectedGenreList.add(genreFirst);
        Genre genreSecond = new Genre(2,"фантастика");
        expectedGenreList.add(genreSecond);

        GenreService genreService = new GenreService(genreDao);

        when(genreDao.findAll()).thenReturn(expectedGenreList);

        List<Genre> actualGenreList = genreService.findAll();

        assertEquals(2, actualGenreList.size());

        for (Genre actualGenre : actualGenreList) {
            assertTrue(expectedGenreList.contains(actualGenre));
        }

    }
}

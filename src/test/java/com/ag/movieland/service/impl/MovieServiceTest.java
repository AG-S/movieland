package com.ag.movieland.service.impl;

import com.ag.movieland.dao.jdbc.MovieDao;
import com.ag.movieland.entity.Movie;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MovieServiceTest {
    @Test
    public void getAllMovies() {
        MovieDao movieDao = mock(MovieDao.class);

        List<Movie> expectedMovieList = new ArrayList<Movie>();

        Movie movieFirst = new Movie();
        movieFirst.setId(5);
        movieFirst.setNameRussian("1+1");
        movieFirst.setNameNative("Intouchables");
        movieFirst.setYearOfRelease(2011);
        movieFirst.setRating(8.3);
        movieFirst.setPrice(120);
        movieFirst.setPicturePath("https://images-na.ssl-images-amazon.com/images/M/MV5BMTYxNDA3MDQwNl5BMl5BanBnXkFtZTcwNTU4Mzc1Nw@@._V1._SY209_CR0,0,140,209_.jpg");
        expectedMovieList.add(movieFirst);

        Movie movieSecond = new Movie();
        movieSecond.setId(9);
        movieSecond.setNameRussian("Звёздные войны: Эпизод 4 – Новая надежда");
        movieSecond.setNameNative("Star Wars");
        movieSecond.setYearOfRelease(1977);
        movieSecond.setRating(8.1);
        movieSecond.setPrice(198.98);
        movieSecond.setPicturePath("https://images-na.ssl-images-amazon.com/images/M/MV5BYTUwNTdiMzMtNThmNS00ODUzLThlMDMtMTM5Y2JkNWJjOGQ2XkEyXkFqcGdeQXVyNzQ1ODk3MTQ@._V1._SX140_CR0,0,140,209_.jpg");
        expectedMovieList.add(movieSecond);

        MovieService movieService = new MovieService(movieDao);

        when(movieDao.findAll()).thenReturn(expectedMovieList);

        List<Movie> actualMovieList = movieService.findAll();

        assertEquals(2, actualMovieList.size());

        for (Movie actualMovie : actualMovieList) {
            assertTrue(expectedMovieList.contains(actualMovie));
        }
    }
}

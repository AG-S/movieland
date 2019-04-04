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

        when(movieDao.findAll(null)).thenReturn(expectedMovieList);

        List<Movie> actualMovieList = movieService.findAll(null);

        assertEquals(2, actualMovieList.size());

        for (Movie actualMovie : actualMovieList) {
            assertTrue(expectedMovieList.contains(actualMovie));
        }
    }
    @Test
    public void testGetRandomMovies() {

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

        Movie movieThird = new Movie();
        movieThird.setId(22);
        movieThird.setNameRussian("Укрощение строптивого");
        movieThird.setNameNative("Il bisbetico domato");
        movieThird.setYearOfRelease(1980);
        movieThird.setRating(7.7);
        movieThird.setPrice(120.0);
        movieThird.setPicturePath("https://images-na.ssl-images-amazon.com/images/M/MV5BMTc5NTM5OTY0Nl5BMl5BanBnXkFtZTcwNjg1MjcyMQ@@._V1._SY209_CR3,0,140,209_.jpg");
        expectedMovieList.add(movieThird);

        Movie movieFourth = new Movie();
        movieFourth.setId(23);
        movieFourth.setNameRussian("Блеф");
        movieFourth.setNameNative("Bluff storia di truffe e di imbroglioni");
        movieFourth.setYearOfRelease(1976);
        movieFourth.setRating(7.6);
        movieFourth.setPrice(100.0);
        movieFourth.setPicturePath("https://images-na.ssl-images-amazon.com/images/M/MV5BMjk5YmMxMjMtMTlkNi00YTI5LThhYTMtOTk2NmNiNzQwMzI0XkEyXkFqcGdeQXVyMTQ3Njg3MQ@@._V1._SX140_CR0,0,140,209_.jpg");
        expectedMovieList.add(movieFourth);

        MovieService movieService = new MovieService(movieDao);

        when(movieDao.findAll(null)).thenReturn(expectedMovieList);

        List<Movie> actualMovieList = movieService.getRandom();

        for (Movie actualMovie : actualMovieList) {
            assertTrue(expectedMovieList.contains(actualMovie));
        }

    }

    @Test
    public void testGetMoviesByGenre() throws Exception {

        MovieDao movieDao = mock(MovieDao.class);

        List<Movie> expectedMovieList = new ArrayList<>();

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
        movieSecond.setId(22);
        movieSecond.setNameRussian("Укрощение строптивого");
        movieSecond.setNameNative("Il bisbetico domato");
        movieSecond.setYearOfRelease(1980);
        movieSecond.setRating(7.7);
        movieSecond.setPrice(120.0);
        movieSecond.setPicturePath("https://images-na.ssl-images-amazon.com/images/M/MV5BMTc5NTM5OTY0Nl5BMl5BanBnXkFtZTcwNjg1MjcyMQ@@._V1._SY209_CR3,0,140,209_.jpg");
        expectedMovieList.add(movieSecond);

        Movie movieThird = new Movie();
        movieThird.setId(23);
        movieThird.setNameRussian("Блеф");
        movieThird.setNameNative("Bluff storia di truffe e di imbroglioni");
        movieThird.setYearOfRelease(1976);
        movieThird.setRating(7.6);
        movieThird.setPrice(100.0);
        movieThird.setPicturePath("https://images-na.ssl-images-amazon.com/images/M/MV5BMjk5YmMxMjMtMTlkNi00YTI5LThhYTMtOTk2NmNiNzQwMzI0XkEyXkFqcGdeQXVyMTQ3Njg3MQ@@._V1._SX140_CR0,0,140,209_.jpg");
        expectedMovieList.add(movieThird);

        MovieService movieService = new MovieService(movieDao);

        when(movieDao.findByGenreId(1, null)).thenReturn(expectedMovieList);

        List<Movie> actualMovieList = movieService.findByGenreId(1, null);

        for (Movie actualMovie : actualMovieList) {
            assertTrue(expectedMovieList.indexOf(actualMovie) > -1);
        }

        assertEquals(3, expectedMovieList.size());
    }

}

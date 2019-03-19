package com.ag.movieland.entity;

import org.junit.Test;
import static org.junit.Assert.assertEquals;


public class MovieTest {

    private Movie movie;

    public MovieTest(){
        movie = new Movie();
    }

    @Test
    public void testSetterAndGetter() {
        movie.setRating(7.7);
        movie.setPrice(120.00);
        movie.setYearOfRelease(1980);
        movie.setNameRussian("Укрощение строптивого");
        movie.setNameNative("Il bisbetico domato");
        movie.setPicturePath("https://images-na.ssl-images-amazon.com/images/M/MV5BMTc5NTM5OTY0Nl5BMl5BanBnXkFtZTcwNjg1MjcyMQ@@._V1._SY209_CR3,0,140,209_.jpg");
        movie.setId(22);
        assertEquals("Укрощение строптивого",movie.getNameRussian());
        assertEquals("Il bisbetico domato",movie.getNameNative());
        assertEquals(22,movie.getId());
        assertEquals(1980,movie.getYearOfRelease());
        assertEquals(120.00,movie.getPrice(),0.01);
        assertEquals(7.7,movie.getRating(),0.1);
        assertEquals("https://images-na.ssl-images-amazon.com/images/M/MV5BMTc5NTM5OTY0Nl5BMl5BanBnXkFtZTcwNjg1MjcyMQ@@._V1._SY209_CR3,0,140,209_.jpg",movie.getPicturePath());
    }
}

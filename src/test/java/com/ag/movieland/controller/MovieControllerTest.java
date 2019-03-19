package com.ag.movieland.controller;

import com.ag.movieland.entity.Movie;
import com.ag.movieland.service.impl.MovieService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.Arrays;
import java.util.Collections;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/movieland-context.xml", "file:src/main/webapp/WEB-INF/movielandServlet-servlet.xml", "classpath:/test-context.xml"})
@WebAppConfiguration
public class MovieControllerTest {
    private MockMvc mockMvc;
    @Autowired
    private WebApplicationContext webApplicationContext;
    @Autowired
    private MovieService movieService;
    @Before
    public void setUp() {
        Mockito.reset(movieService);
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }
    @Test
    public void testGetAllMovies() throws Exception {
        Movie movieFirst = new Movie();
        movieFirst.setId(22);
        movieFirst.setNameRussian("Укрощение строптивого");
        movieFirst.setNameNative("Il bisbetico domato");
        movieFirst.setYearOfRelease(1980);
        movieFirst.setRating(7.7);
        movieFirst.setPrice(120.0);
        movieFirst.setPicturePath("https://images-na.ssl-images-amazon.com/images/M/MV5BNDE4OTMxMTctNmRhYy00NWE2LTg3YzItYTk3M2UwOTU5Njg4XkEyXkFqcGdeQXVyNjU0OTQ0OTY@._V1._SX140_CR0,0,140,209_.jpg");
        Movie movieSecond = new Movie();
        movieSecond.setId(23);
        movieSecond.setNameRussian("Блеф");
        movieSecond.setNameNative("Bluff storia di truffe e di imbroglioni");
        movieSecond.setYearOfRelease(1979);
        movieSecond.setRating(7.6);
        movieSecond.setPrice(100.0);
        movieSecond.setPicturePath("https://images-na.ssl-images-amazon.com/images/M/MV5BMjk5YmMxMjMtMTlkNi00YTI5LThhYTMtOTk2NmNiNzQwMzI0XkEyXkFqcGdeQXVyMTQ3Njg3MQ@@._V1._SX140_CR0,0,140,209_.jpg");

        when(movieService.findAll()).thenReturn(Arrays.asList(movieFirst, movieSecond));

        mockMvc.perform(get("/movies"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].id", equalTo(22)))
                .andExpect(jsonPath("$[0].nameRussian", equalTo("Укрощение строптивого")))
                .andExpect(jsonPath("$[0].nameNative", equalTo("Il bisbetico domato")))
                .andExpect(jsonPath("$[0].yearOfRelease", equalTo(1980)))
                .andExpect(jsonPath("$[0].rating", equalTo(7.7)))
                .andExpect(jsonPath("$[0].price", equalTo(120.0)))
                .andExpect(jsonPath("$[0].picturePath", equalTo("https://images-na.ssl-images-amazon.com/images/M/MV5BNDE4OTMxMTctNmRhYy00NWE2LTg3YzItYTk3M2UwOTU5Njg4XkEyXkFqcGdeQXVyNjU0OTQ0OTY@._V1._SX140_CR0,0,140,209_.jpg")))
                .andExpect(jsonPath("$[1].id", equalTo(23)))
                .andExpect(jsonPath("$[1].nameRussian", equalTo("Блеф")))
                .andExpect(jsonPath("$[1].nameNative", equalTo("Bluff storia di truffe e di imbroglioni")))
                .andExpect(jsonPath("$[1].yearOfRelease", equalTo(1979)))
                .andExpect(jsonPath("$[1].rating", equalTo(7.6)))
                .andExpect(jsonPath("$[1].price", equalTo(100.0)))
                .andExpect(jsonPath("$[1].picturePath", equalTo("https://images-na.ssl-images-amazon.com/images/M/MV5BMjk5YmMxMjMtMTlkNi00YTI5LThhYTMtOTk2NmNiNzQwMzI0XkEyXkFqcGdeQXVyMTQ3Njg3MQ@@._V1._SX140_CR0,0,140,209_.jpg")));
    }
}

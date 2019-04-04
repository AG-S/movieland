package com.ag.movieland.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
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

    @Value("${sql.limitrandommovies}")
    private int limitRows;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }
    @Test
    public void testGetAllMovies() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/movies"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$", hasSize(4)))
                .andExpect(jsonPath("$[0].id", equalTo(5)))
                .andExpect(jsonPath("$[0].nameRussian", equalTo("1+1")))
                .andExpect(jsonPath("$[0].nameNative", equalTo("Intouchables")))
                .andExpect(jsonPath("$[0].yearOfRelease", equalTo(2011)))
                .andExpect(jsonPath("$[0].rating", equalTo(8.3)))
                .andExpect(jsonPath("$[0].price", equalTo(120.0)))
                .andExpect(jsonPath("$[0].picturePath", equalTo("https://images-na.ssl-images-amazon.com/images/M/MV5BMTYxNDA3MDQwNl5BMl5BanBnXkFtZTcwNTU4Mzc1Nw@@._V1._SY209_CR0,0,140,209_.jpg")))
                .andExpect(jsonPath("$[1].id", equalTo(9)))
                .andExpect(jsonPath("$[1].nameRussian", equalTo("Звёздные войны: Эпизод 4 – Новая надежда")))
                .andExpect(jsonPath("$[1].nameNative", equalTo("Star Wars")))
                .andExpect(jsonPath("$[1].yearOfRelease", equalTo(1977)))
                .andExpect(jsonPath("$[1].rating", equalTo(8.1)))
                .andExpect(jsonPath("$[1].price", equalTo(198.98)))
                .andExpect(jsonPath("$[1].picturePath", equalTo("https://images-na.ssl-images-amazon.com/images/M/MV5BYTUwNTdiMzMtNThmNS00ODUzLThlMDMtMTM5Y2JkNWJjOGQ2XkEyXkFqcGdeQXVyNzQ1ODk3MTQ@._V1._SX140_CR0,0,140,209_.jpg")))
                .andExpect(jsonPath("$[2].id", equalTo(22)))
                .andExpect(jsonPath("$[2].nameRussian", equalTo("Укрощение строптивого")))
                .andExpect(jsonPath("$[2].nameNative", equalTo("Il bisbetico domato")))
                .andExpect(jsonPath("$[2].yearOfRelease", equalTo(1980)))
                .andExpect(jsonPath("$[2].rating", equalTo(7.7)))
                .andExpect(jsonPath("$[2].price", equalTo(120.0)))
                .andExpect(jsonPath("$[2].picturePath", equalTo("https://images-na.ssl-images-amazon.com/images/M/MV5BMTc5NTM5OTY0Nl5BMl5BanBnXkFtZTcwNjg1MjcyMQ@@._V1._SY209_CR3,0,140,209_.jpg")))
                .andExpect(jsonPath("$[3].id", equalTo(23)))
                .andExpect(jsonPath("$[3].nameRussian", equalTo("Блеф")))
                .andExpect(jsonPath("$[3].nameNative", equalTo("Bluff storia di truffe e di imbroglioni")))
                .andExpect(jsonPath("$[3].yearOfRelease", equalTo(1976)))
                .andExpect(jsonPath("$[3].rating", equalTo(7.6)))
                .andExpect(jsonPath("$[3].price", equalTo(100.0)))
                .andExpect(jsonPath("$[3].picturePath", equalTo("https://images-na.ssl-images-amazon.com/images/M/MV5BMjk5YmMxMjMtMTlkNi00YTI5LThhYTMtOTk2NmNiNzQwMzI0XkEyXkFqcGdeQXVyMTQ3Njg3MQ@@._V1._SX140_CR0,0,140,209_.jpg")));
    }

    @Test
    public void testGetRandomMovies() throws Exception {
        mockMvc.perform(get("/movies/random"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$", hasSize(limitRows)));
    }

    @Test
    public void testGetMoviesByGenreId() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/movies/genre/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$", hasSize(3)))
                .andExpect(jsonPath("$[0].id", equalTo(5)))
                .andExpect(jsonPath("$[0].nameRussian", equalTo("1+1")))
                .andExpect(jsonPath("$[0].nameNative", equalTo("Intouchables")))
                .andExpect(jsonPath("$[0].yearOfRelease", equalTo(2011)))
                .andExpect(jsonPath("$[0].rating", equalTo(8.3)))
                .andExpect(jsonPath("$[0].price", equalTo(120.0)))
                .andExpect(jsonPath("$[0].picturePath", equalTo("https://images-na.ssl-images-amazon.com/images/M/MV5BMTYxNDA3MDQwNl5BMl5BanBnXkFtZTcwNTU4Mzc1Nw@@._V1._SY209_CR0,0,140,209_.jpg")))
                .andExpect(jsonPath("$[1].id", equalTo(22)))
                .andExpect(jsonPath("$[1].nameRussian", equalTo("Укрощение строптивого")))
                .andExpect(jsonPath("$[1].nameNative", equalTo("Il bisbetico domato")))
                .andExpect(jsonPath("$[1].yearOfRelease", equalTo(1980)))
                .andExpect(jsonPath("$[1].rating", equalTo(7.7)))
                .andExpect(jsonPath("$[1].price", equalTo(120.0)))
                .andExpect(jsonPath("$[1].picturePath", equalTo("https://images-na.ssl-images-amazon.com/images/M/MV5BMTc5NTM5OTY0Nl5BMl5BanBnXkFtZTcwNjg1MjcyMQ@@._V1._SY209_CR3,0,140,209_.jpg")))
                .andExpect(jsonPath("$[2].id", equalTo(23)))
                .andExpect(jsonPath("$[2].nameRussian", equalTo("Блеф")))
                .andExpect(jsonPath("$[2].nameNative", equalTo("Bluff storia di truffe e di imbroglioni")))
                .andExpect(jsonPath("$[2].yearOfRelease", equalTo(1976)))
                .andExpect(jsonPath("$[2].rating", equalTo(7.6)))
                .andExpect(jsonPath("$[2].price", equalTo(100.0)))
                .andExpect(jsonPath("$[2].picturePath", equalTo("https://images-na.ssl-images-amazon.com/images/M/MV5BMjk5YmMxMjMtMTlkNi00YTI5LThhYTMtOTk2NmNiNzQwMzI0XkEyXkFqcGdeQXVyMTQ3Njg3MQ@@._V1._SX140_CR0,0,140,209_.jpg")));
    }

    @Test
    public void testGetAllMoviesOrderingByRatingDesc() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/movies?rating=desc"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$", hasSize(4)))
                .andExpect(jsonPath("$[0].id", equalTo(5)))
                .andExpect(jsonPath("$[0].nameRussian", equalTo("1+1")))
                .andExpect(jsonPath("$[0].nameNative", equalTo("Intouchables")))
                .andExpect(jsonPath("$[0].yearOfRelease", equalTo(2011)))
                .andExpect(jsonPath("$[0].rating", equalTo(8.3)))
                .andExpect(jsonPath("$[0].price", equalTo(120.0)))
                .andExpect(jsonPath("$[0].picturePath", equalTo("https://images-na.ssl-images-amazon.com/images/M/MV5BMTYxNDA3MDQwNl5BMl5BanBnXkFtZTcwNTU4Mzc1Nw@@._V1._SY209_CR0,0,140,209_.jpg")))
                .andExpect(jsonPath("$[1].id", equalTo(9)))
                .andExpect(jsonPath("$[1].nameRussian", equalTo("Звёздные войны: Эпизод 4 – Новая надежда")))
                .andExpect(jsonPath("$[1].nameNative", equalTo("Star Wars")))
                .andExpect(jsonPath("$[1].yearOfRelease", equalTo(1977)))
                .andExpect(jsonPath("$[1].rating", equalTo(8.1)))
                .andExpect(jsonPath("$[1].price", equalTo(198.98)))
                .andExpect(jsonPath("$[1].picturePath", equalTo("https://images-na.ssl-images-amazon.com/images/M/MV5BYTUwNTdiMzMtNThmNS00ODUzLThlMDMtMTM5Y2JkNWJjOGQ2XkEyXkFqcGdeQXVyNzQ1ODk3MTQ@._V1._SX140_CR0,0,140,209_.jpg")))
                .andExpect(jsonPath("$[2].id", equalTo(22)))
                .andExpect(jsonPath("$[2].nameRussian", equalTo("Укрощение строптивого")))
                .andExpect(jsonPath("$[2].nameNative", equalTo("Il bisbetico domato")))
                .andExpect(jsonPath("$[2].yearOfRelease", equalTo(1980)))
                .andExpect(jsonPath("$[2].rating", equalTo(7.7)))
                .andExpect(jsonPath("$[2].price", equalTo(120.0)))
                .andExpect(jsonPath("$[2].picturePath", equalTo("https://images-na.ssl-images-amazon.com/images/M/MV5BMTc5NTM5OTY0Nl5BMl5BanBnXkFtZTcwNjg1MjcyMQ@@._V1._SY209_CR3,0,140,209_.jpg")))
                .andExpect(jsonPath("$[3].id", equalTo(23)))
                .andExpect(jsonPath("$[3].nameRussian", equalTo("Блеф")))
                .andExpect(jsonPath("$[3].nameNative", equalTo("Bluff storia di truffe e di imbroglioni")))
                .andExpect(jsonPath("$[3].yearOfRelease", equalTo(1976)))
                .andExpect(jsonPath("$[3].rating", equalTo(7.6)))
                .andExpect(jsonPath("$[3].price", equalTo(100.0)))
                .andExpect(jsonPath("$[3].picturePath", equalTo("https://images-na.ssl-images-amazon.com/images/M/MV5BMjk5YmMxMjMtMTlkNi00YTI5LThhYTMtOTk2NmNiNzQwMzI0XkEyXkFqcGdeQXVyMTQ3Njg3MQ@@._V1._SX140_CR0,0,140,209_.jpg")));
    }

    @Test
    public void testGetAllMoviesOrderingByPriceAsc() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/movies?price=asc"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$", hasSize(4)))
                .andExpect(jsonPath("$[1].id", equalTo(5)))
                .andExpect(jsonPath("$[1].nameRussian", equalTo("1+1")))
                .andExpect(jsonPath("$[1].nameNative", equalTo("Intouchables")))
                .andExpect(jsonPath("$[1].yearOfRelease", equalTo(2011)))
                .andExpect(jsonPath("$[1].rating", equalTo(8.3)))
                .andExpect(jsonPath("$[1].price", equalTo(120.0)))
                .andExpect(jsonPath("$[1].picturePath", equalTo("https://images-na.ssl-images-amazon.com/images/M/MV5BMTYxNDA3MDQwNl5BMl5BanBnXkFtZTcwNTU4Mzc1Nw@@._V1._SY209_CR0,0,140,209_.jpg")))
                .andExpect(jsonPath("$[3].id", equalTo(9)))
                .andExpect(jsonPath("$[3].nameRussian", equalTo("Звёздные войны: Эпизод 4 – Новая надежда")))
                .andExpect(jsonPath("$[3].nameNative", equalTo("Star Wars")))
                .andExpect(jsonPath("$[3].yearOfRelease", equalTo(1977)))
                .andExpect(jsonPath("$[3].rating", equalTo(8.1)))
                .andExpect(jsonPath("$[3].price", equalTo(198.98)))
                .andExpect(jsonPath("$[3].picturePath", equalTo("https://images-na.ssl-images-amazon.com/images/M/MV5BYTUwNTdiMzMtNThmNS00ODUzLThlMDMtMTM5Y2JkNWJjOGQ2XkEyXkFqcGdeQXVyNzQ1ODk3MTQ@._V1._SX140_CR0,0,140,209_.jpg")))
                .andExpect(jsonPath("$[2].id", equalTo(22)))
                .andExpect(jsonPath("$[2].nameRussian", equalTo("Укрощение строптивого")))
                .andExpect(jsonPath("$[2].nameNative", equalTo("Il bisbetico domato")))
                .andExpect(jsonPath("$[2].yearOfRelease", equalTo(1980)))
                .andExpect(jsonPath("$[2].rating", equalTo(7.7)))
                .andExpect(jsonPath("$[2].price", equalTo(120.0)))
                .andExpect(jsonPath("$[2].picturePath", equalTo("https://images-na.ssl-images-amazon.com/images/M/MV5BMTc5NTM5OTY0Nl5BMl5BanBnXkFtZTcwNjg1MjcyMQ@@._V1._SY209_CR3,0,140,209_.jpg")))
                .andExpect(jsonPath("$[0].id", equalTo(23)))
                .andExpect(jsonPath("$[0].nameRussian", equalTo("Блеф")))
                .andExpect(jsonPath("$[0].nameNative", equalTo("Bluff storia di truffe e di imbroglioni")))
                .andExpect(jsonPath("$[0].yearOfRelease", equalTo(1976)))
                .andExpect(jsonPath("$[0].rating", equalTo(7.6)))
                .andExpect(jsonPath("$[0].price", equalTo(100.0)))
                .andExpect(jsonPath("$[0].picturePath", equalTo("https://images-na.ssl-images-amazon.com/images/M/MV5BMjk5YmMxMjMtMTlkNi00YTI5LThhYTMtOTk2NmNiNzQwMzI0XkEyXkFqcGdeQXVyMTQ3Njg3MQ@@._V1._SX140_CR0,0,140,209_.jpg")));
    }
    @Test
    public void testGetAllMoviesOrderingByPriceDesc() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/movies?price=desc"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$", hasSize(4)))
                .andExpect(jsonPath("$[1].id", equalTo(5)))
                .andExpect(jsonPath("$[1].nameRussian", equalTo("1+1")))
                .andExpect(jsonPath("$[1].nameNative", equalTo("Intouchables")))
                .andExpect(jsonPath("$[1].yearOfRelease", equalTo(2011)))
                .andExpect(jsonPath("$[1].rating", equalTo(8.3)))
                .andExpect(jsonPath("$[1].price", equalTo(120.0)))
                .andExpect(jsonPath("$[1].picturePath", equalTo("https://images-na.ssl-images-amazon.com/images/M/MV5BMTYxNDA3MDQwNl5BMl5BanBnXkFtZTcwNTU4Mzc1Nw@@._V1._SY209_CR0,0,140,209_.jpg")))
                .andExpect(jsonPath("$[0].id", equalTo(9)))
                .andExpect(jsonPath("$[0].nameRussian", equalTo("Звёздные войны: Эпизод 4 – Новая надежда")))
                .andExpect(jsonPath("$[0].nameNative", equalTo("Star Wars")))
                .andExpect(jsonPath("$[0].yearOfRelease", equalTo(1977)))
                .andExpect(jsonPath("$[0].rating", equalTo(8.1)))
                .andExpect(jsonPath("$[0].price", equalTo(198.98)))
                .andExpect(jsonPath("$[0].picturePath", equalTo("https://images-na.ssl-images-amazon.com/images/M/MV5BYTUwNTdiMzMtNThmNS00ODUzLThlMDMtMTM5Y2JkNWJjOGQ2XkEyXkFqcGdeQXVyNzQ1ODk3MTQ@._V1._SX140_CR0,0,140,209_.jpg")))
                .andExpect(jsonPath("$[2].id", equalTo(22)))
                .andExpect(jsonPath("$[2].nameRussian", equalTo("Укрощение строптивого")))
                .andExpect(jsonPath("$[2].nameNative", equalTo("Il bisbetico domato")))
                .andExpect(jsonPath("$[2].yearOfRelease", equalTo(1980)))
                .andExpect(jsonPath("$[2].rating", equalTo(7.7)))
                .andExpect(jsonPath("$[2].price", equalTo(120.0)))
                .andExpect(jsonPath("$[2].picturePath", equalTo("https://images-na.ssl-images-amazon.com/images/M/MV5BMTc5NTM5OTY0Nl5BMl5BanBnXkFtZTcwNjg1MjcyMQ@@._V1._SY209_CR3,0,140,209_.jpg")))
                .andExpect(jsonPath("$[3].id", equalTo(23)))
                .andExpect(jsonPath("$[3].nameRussian", equalTo("Блеф")))
                .andExpect(jsonPath("$[3].nameNative", equalTo("Bluff storia di truffe e di imbroglioni")))
                .andExpect(jsonPath("$[3].yearOfRelease", equalTo(1976)))
                .andExpect(jsonPath("$[3].rating", equalTo(7.6)))
                .andExpect(jsonPath("$[3].price", equalTo(100.0)))
                .andExpect(jsonPath("$[3].picturePath", equalTo("https://images-na.ssl-images-amazon.com/images/M/MV5BMjk5YmMxMjMtMTlkNi00YTI5LThhYTMtOTk2NmNiNzQwMzI0XkEyXkFqcGdeQXVyMTQ3Njg3MQ@@._V1._SX140_CR0,0,140,209_.jpg")));
    }
    @Test
    public void testGetMoviesByGenreIdOrederingByRatingDesc() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/movies/genre/1?rating=desc"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$", hasSize(3)))
                .andExpect(jsonPath("$[0].id", equalTo(5)))
                .andExpect(jsonPath("$[0].nameRussian", equalTo("1+1")))
                .andExpect(jsonPath("$[0].nameNative", equalTo("Intouchables")))
                .andExpect(jsonPath("$[0].yearOfRelease", equalTo(2011)))
                .andExpect(jsonPath("$[0].rating", equalTo(8.3)))
                .andExpect(jsonPath("$[0].price", equalTo(120.0)))
                .andExpect(jsonPath("$[0].picturePath", equalTo("https://images-na.ssl-images-amazon.com/images/M/MV5BMTYxNDA3MDQwNl5BMl5BanBnXkFtZTcwNTU4Mzc1Nw@@._V1._SY209_CR0,0,140,209_.jpg")))
                .andExpect(jsonPath("$[1].id", equalTo(22)))
                .andExpect(jsonPath("$[1].nameRussian", equalTo("Укрощение строптивого")))
                .andExpect(jsonPath("$[1].nameNative", equalTo("Il bisbetico domato")))
                .andExpect(jsonPath("$[1].yearOfRelease", equalTo(1980)))
                .andExpect(jsonPath("$[1].rating", equalTo(7.7)))
                .andExpect(jsonPath("$[1].price", equalTo(120.0)))
                .andExpect(jsonPath("$[1].picturePath", equalTo("https://images-na.ssl-images-amazon.com/images/M/MV5BMTc5NTM5OTY0Nl5BMl5BanBnXkFtZTcwNjg1MjcyMQ@@._V1._SY209_CR3,0,140,209_.jpg")))
                .andExpect(jsonPath("$[2].id", equalTo(23)))
                .andExpect(jsonPath("$[2].nameRussian", equalTo("Блеф")))
                .andExpect(jsonPath("$[2].nameNative", equalTo("Bluff storia di truffe e di imbroglioni")))
                .andExpect(jsonPath("$[2].yearOfRelease", equalTo(1976)))
                .andExpect(jsonPath("$[2].rating", equalTo(7.6)))
                .andExpect(jsonPath("$[2].price", equalTo(100.0)))
                .andExpect(jsonPath("$[2].picturePath", equalTo("https://images-na.ssl-images-amazon.com/images/M/MV5BMjk5YmMxMjMtMTlkNi00YTI5LThhYTMtOTk2NmNiNzQwMzI0XkEyXkFqcGdeQXVyMTQ3Njg3MQ@@._V1._SX140_CR0,0,140,209_.jpg")));
    }
    @Test
    public void testGetMoviesByGenreIdOrederingByPriceDesc() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/movies/genre/1?price=desc"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$", hasSize(3)))
                .andExpect(jsonPath("$[0].id", equalTo(5)))
                .andExpect(jsonPath("$[0].nameRussian", equalTo("1+1")))
                .andExpect(jsonPath("$[0].nameNative", equalTo("Intouchables")))
                .andExpect(jsonPath("$[0].yearOfRelease", equalTo(2011)))
                .andExpect(jsonPath("$[0].rating", equalTo(8.3)))
                .andExpect(jsonPath("$[0].price", equalTo(120.0)))
                .andExpect(jsonPath("$[0].picturePath", equalTo("https://images-na.ssl-images-amazon.com/images/M/MV5BMTYxNDA3MDQwNl5BMl5BanBnXkFtZTcwNTU4Mzc1Nw@@._V1._SY209_CR0,0,140,209_.jpg")))
                .andExpect(jsonPath("$[1].id", equalTo(22)))
                .andExpect(jsonPath("$[1].nameRussian", equalTo("Укрощение строптивого")))
                .andExpect(jsonPath("$[1].nameNative", equalTo("Il bisbetico domato")))
                .andExpect(jsonPath("$[1].yearOfRelease", equalTo(1980)))
                .andExpect(jsonPath("$[1].rating", equalTo(7.7)))
                .andExpect(jsonPath("$[1].price", equalTo(120.0)))
                .andExpect(jsonPath("$[1].picturePath", equalTo("https://images-na.ssl-images-amazon.com/images/M/MV5BMTc5NTM5OTY0Nl5BMl5BanBnXkFtZTcwNjg1MjcyMQ@@._V1._SY209_CR3,0,140,209_.jpg")))
                .andExpect(jsonPath("$[2].id", equalTo(23)))
                .andExpect(jsonPath("$[2].nameRussian", equalTo("Блеф")))
                .andExpect(jsonPath("$[2].nameNative", equalTo("Bluff storia di truffe e di imbroglioni")))
                .andExpect(jsonPath("$[2].yearOfRelease", equalTo(1976)))
                .andExpect(jsonPath("$[2].rating", equalTo(7.6)))
                .andExpect(jsonPath("$[2].price", equalTo(100.0)))
                .andExpect(jsonPath("$[2].picturePath", equalTo("https://images-na.ssl-images-amazon.com/images/M/MV5BMjk5YmMxMjMtMTlkNi00YTI5LThhYTMtOTk2NmNiNzQwMzI0XkEyXkFqcGdeQXVyMTQ3Njg3MQ@@._V1._SX140_CR0,0,140,209_.jpg")));
    }
    @Test
    public void testGetMoviesByGenreIdOrederingByPriceAsc() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/movies/genre/1?price=asc"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$", hasSize(3)))
                .andExpect(jsonPath("$[1].id", equalTo(5)))
                .andExpect(jsonPath("$[1].nameRussian", equalTo("1+1")))
                .andExpect(jsonPath("$[1].nameNative", equalTo("Intouchables")))
                .andExpect(jsonPath("$[1].yearOfRelease", equalTo(2011)))
                .andExpect(jsonPath("$[1].rating", equalTo(8.3)))
                .andExpect(jsonPath("$[1].price", equalTo(120.0)))
                .andExpect(jsonPath("$[1].picturePath", equalTo("https://images-na.ssl-images-amazon.com/images/M/MV5BMTYxNDA3MDQwNl5BMl5BanBnXkFtZTcwNTU4Mzc1Nw@@._V1._SY209_CR0,0,140,209_.jpg")))
                .andExpect(jsonPath("$[2].id", equalTo(22)))
                .andExpect(jsonPath("$[2].nameRussian", equalTo("Укрощение строптивого")))
                .andExpect(jsonPath("$[2].nameNative", equalTo("Il bisbetico domato")))
                .andExpect(jsonPath("$[2].yearOfRelease", equalTo(1980)))
                .andExpect(jsonPath("$[2].rating", equalTo(7.7)))
                .andExpect(jsonPath("$[2].price", equalTo(120.0)))
                .andExpect(jsonPath("$[2].picturePath", equalTo("https://images-na.ssl-images-amazon.com/images/M/MV5BMTc5NTM5OTY0Nl5BMl5BanBnXkFtZTcwNjg1MjcyMQ@@._V1._SY209_CR3,0,140,209_.jpg")))
                .andExpect(jsonPath("$[0].id", equalTo(23)))
                .andExpect(jsonPath("$[0].nameRussian", equalTo("Блеф")))
                .andExpect(jsonPath("$[0].nameNative", equalTo("Bluff storia di truffe e di imbroglioni")))
                .andExpect(jsonPath("$[0].yearOfRelease", equalTo(1976)))
                .andExpect(jsonPath("$[0].rating", equalTo(7.6)))
                .andExpect(jsonPath("$[0].price", equalTo(100.0)))
                .andExpect(jsonPath("$[0].picturePath", equalTo("https://images-na.ssl-images-amazon.com/images/M/MV5BMjk5YmMxMjMtMTlkNi00YTI5LThhYTMtOTk2NmNiNzQwMzI0XkEyXkFqcGdeQXVyMTQ3Njg3MQ@@._V1._SX140_CR0,0,140,209_.jpg")));
    }
    @Test (expected = Exception.class)
    public void testGetMoviesByGenreIdOrederingByRatingAsc() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/movies/genre/1?rating=asc"))
                .andExpect(status().isOk());
    }
    @Test (expected = Exception.class)
    public void testGetMoviesByGenreIdOrederingByRatingFakeSorting() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/movies/genre/1?rating=dasc"))
                .andExpect(status().isOk());
    }
}
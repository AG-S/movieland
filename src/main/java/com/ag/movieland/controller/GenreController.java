package com.ag.movieland.controller;

import com.ag.movieland.entity.Genre;
import com.ag.movieland.service.impl.GenreService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GenreController {

    private GenreService genreService;
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @RequestMapping(method = RequestMethod.GET, path = "/genre", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    List<Genre> findAll()  {
        logger.info("find All Genres");
        List<Genre> genres = genreService.findAll();
        return  genres;
    }

    @Autowired
    public void setGenreService(GenreService genreService) {
        this.genreService = genreService;
    }
}

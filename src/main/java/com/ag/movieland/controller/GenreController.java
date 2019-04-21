package com.ag.movieland.controller;

import com.ag.movieland.entity.Genre;
import com.ag.movieland.service.IGenreService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GenreController {

    private IGenreService genreService;
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @GetMapping(path = "/genre", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    List<Genre> findAll() {
        logger.info("find All Genres");
        List<Genre> genres = genreService.findAll();
        return genres;
    }

    @Autowired
    public void setGenreService(IGenreService genreService) {
        this.genreService = genreService;
    }
}

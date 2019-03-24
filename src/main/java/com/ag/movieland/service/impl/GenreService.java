package com.ag.movieland.service.impl;

import com.ag.movieland.dao.jdbc.GenreDao;
import com.ag.movieland.entity.Genre;
import com.ag.movieland.service.IGenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenreService implements IGenreService {

    private GenreDao genreDao;

    @Autowired
    public GenreService (GenreDao genreDao) {
        this.genreDao = genreDao;
    }

    @Override
    public List<Genre> findAll() {
        List<Genre> genres = genreDao.findAll();
        return genres;
    }


}

package com.ag.movieland.dao;

import com.ag.movieland.entity.Genre;

import java.util.List;

public interface IGenreDao {
    List<Genre> findAll();
}

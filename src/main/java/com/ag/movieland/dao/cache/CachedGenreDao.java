package com.ag.movieland.dao.cache;

import com.ag.movieland.dao.IGenreDao;
import com.ag.movieland.entity.Genre;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.List;

@Primary
@Repository("CachedGenreDao")
public class CachedGenreDao implements IGenreDao {

    private final Logger logger = LoggerFactory.getLogger(getClass());
    private List<Genre> cachedGenres;

    private IGenreDao genreDao;

    @Autowired
    public CachedGenreDao(IGenreDao genreDao) {
        this.genreDao = genreDao;
    }

    @Override
    public List<Genre> findAll() {
        return cachedGenres;
    }

    @PostConstruct
    public void initCachedGenres() {
        cachedGenres = genreDao.findAll();
        logger.info("Genre cache has been refreshed. Total size of Genre cache is : {}", cachedGenres.size());
    }

}
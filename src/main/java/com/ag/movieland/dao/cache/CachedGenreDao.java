package com.ag.movieland.dao.cache;

import com.ag.movieland.dao.IGenreDao;
import com.ag.movieland.entity.Genre;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@EnableScheduling
@Primary
@Repository
public class CachedGenreDao implements IGenreDao {

    private final Logger logger = LoggerFactory.getLogger(getClass());
    private volatile List<Genre> cachedGenres;

    private IGenreDao genreDao;

    @Autowired
    public CachedGenreDao(IGenreDao genreDao) {
        this.genreDao = genreDao;
    }

    @Override
    public List<Genre> findAll() {
        return new ArrayList<>(cachedGenres);
    }

    @PostConstruct
    @Scheduled(fixedDelayString = "${refresh-interval-millis}")
    public void initCachedGenres() {
        cachedGenres = genreDao.findAll();
        logger.info("Genre cache has been refreshed. Total size of Genre cache is : {}", cachedGenres.size());
    }

}
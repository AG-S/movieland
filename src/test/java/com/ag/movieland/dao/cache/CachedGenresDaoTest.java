package com.ag.movieland.dao.cache;

import com.ag.movieland.dao.IGenreDao;
import com.ag.movieland.entity.Genre;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/movieland-context.xml", "file:src/main/webapp/WEB-INF/movielandServlet-servlet.xml", "classpath:/test-context.xml"})
@WebAppConfiguration
public class CachedGenresDaoTest {

    @Autowired
    private IGenreDao cachedGenreDao;

    @Autowired
    @Qualifier("genreDao")
    private IGenreDao genreDao;

    @Test
    public void testFindAll() {
        List<Genre> expectedGenres = genreDao.findAll();
        List<Genre> actualGenres = cachedGenreDao.findAll();
        System.out.println(actualGenres.size());
        assertEquals(expectedGenres.size(), actualGenres.size());
        for (Genre expectedGenre : expectedGenres) {
            assertTrue(actualGenres.contains(expectedGenre));
        }
    }
}
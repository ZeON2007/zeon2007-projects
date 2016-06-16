package by.pvt.herzhot.impl;

import by.pvt.herzhot.dao.impl.NewsDaoImpl;
import by.pvt.herzhot.pojos.impl.News;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;

/**
 * @author Herzhot
 * @version 1.0
 *          16.06.2016
 */
public class NewsServiceImplTest extends Mockito {

    NewsServiceImpl newsService;
    List<News> newses;
    NewsDaoImpl dao;

    @Before
    public void setUp() throws Exception {

        dao = mock(NewsDaoImpl.class);
        newsService = NewsServiceImpl.INSTANCE;
        newses = new ArrayList<>();
    }

    @After
    public void tearDown() throws Exception {
        newses = null;
        newsService = null;
    }

    @Test
    public void classShouldReturnListOfNews() throws Exception {

        when(dao.findAll()).thenReturn(newses);
        newsService.setDao(dao);

        assertEquals(newses,  newsService.findAll());

    }

}
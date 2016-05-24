package by.pvt.herzhot;

import by.pvt.herzhot.beans.News;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Herzhot
 * @version 1.0
 *          18.05.2016
 */
public class NewsTest {
    @Test
    public void getCategoryId() throws Exception {

        News news = new News();
        int expected = 0;
        int actual = news.getCategoryId();

        assertEquals(expected, actual);
    }
}
package by.pvt.herzhot.util;

import by.pvt.herzhot.exceptions.ServiceException;
import by.pvt.herzhot.impl.AuthorServiceImpl;
import by.pvt.herzhot.impl.NewsCategoryServiceImpl;
import by.pvt.herzhot.impl.NewsServiceImpl;
import by.pvt.herzhot.pojos.impl.Author;
import by.pvt.herzhot.pojos.impl.News;
import by.pvt.herzhot.pojos.impl.NewsCategory;
import by.pvt.herzhot.utils.LoggingUtil;

import java.util.*;

/**
 * @author Herzhot
 * @version 1.0
 *          12.06.2016
 */
public class ContentGenerator {

    public void generate(){
//        Author author;
//        for (int i=0; i<10; i++) {
//            author = new Author("Fn"+i, "Ln"+i, "e@m"+i, "pa"+i, 1, null);
//            try {
//                AuthorServiceImpl.INSTANCE.saveOrUpdate(author);
//            } catch (ServiceException e) {
//                LoggingUtil.INSTANCE.logError(getClass(), e.getMessage());
//            }
//        }
//        NewsCategory newsCategory;
//        for (int i=0; i<4; i++) {
//            List<String> categoryNames = new ArrayList<>(Arrays.asList(
//                    "Политика", "Экономика", "Происшествия", "Спорт"
//            ));
//            newsCategory = new NewsCategory(categoryNames.get(i), null);
//            try {
//                NewsCategoryServiceImpl.INSTANCE.saveOrUpdate(newsCategory);
//            } catch (ServiceException e) {
//                LoggingUtil.INSTANCE.logError(getClass(), e.getMessage());
//            }
//        }
        News news;
        Author author;
        NewsCategory newsCategory;
        List<String> categoryNames = new ArrayList<>(Arrays.asList(
                "Политика", "Экономика", "Происшествия", "Спорт"
        ));
        for (int i=0; i<239; i++) {
            try {
                author = AuthorServiceImpl.INSTANCE.find((int)(Math.random()*10+1));
                newsCategory = NewsCategoryServiceImpl.INSTANCE.find((int)(Math.random()*4+1));
                news = new News(newsCategory, author, new Date(), "name"+(i+"").hashCode(),
                        "description"+(i*i+"").hashCode(), "maintext"+(i*i*i+"").hashCode());
                author.getNewses().add(news);
                newsCategory.getNewses().add(news);
                AuthorServiceImpl.INSTANCE.saveOrUpdate(author);
                NewsCategoryServiceImpl.INSTANCE.saveOrUpdate(newsCategory);
                NewsServiceImpl.INSTANCE.saveOrUpdate(news);
            } catch (ServiceException e) {
                LoggingUtil.INSTANCE.logError(getClass(), e.getMessage());
            }
        }
    }
}

package by.pvt.herzhot.services;

import by.pvt.herzhot.exceptions.ServiceException;
import by.pvt.herzhot.pojos.impl.News;

import java.util.List;
import java.util.Map;

/**
 * @author Herzhot
 * @version 1.0
 *          03.07.2016
 */
public interface INewsService extends IService<News> {

    List<News> getNewsByLogin(String login, Map<String, Integer> paginationParams) throws ServiceException;
    int countNewsByLogin(String login) throws ServiceException;
    List<News> getNewsInCategory(int id, Map<String, Integer> paginationParams) throws ServiceException;
    int countNewsInCategory(int id) throws ServiceException;
    List<News> getNewsInCategoryByLogin(int id, String login, Map<String, Integer> paginationParams) throws ServiceException;
    int countNewsInCategoryByLogin(int id, String login) throws ServiceException;
    public List<News> findAll(Map<String, Integer> paginationParams) throws ServiceException;
}

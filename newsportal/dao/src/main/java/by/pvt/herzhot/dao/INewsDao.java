package by.pvt.herzhot.dao;

import by.pvt.herzhot.dao.exceptions.DaoException;
import by.pvt.herzhot.pojos.impl.News;

import java.util.List;
import java.util.Map;

/**
 * @author Herzhot
 * @version 1.0
 *          03.07.2016
 */
public interface INewsDao extends IDao<News> {

    List<News> findAll(Map<String, Integer> paginationParams) throws DaoException;
    List<News> getNewsByLogin(String login, Map<String, Integer> paginationParams) throws DaoException;
    int countNewsByLogin(String login) throws DaoException;
    List<News> getNewsInCategory(int id, Map<String, Integer> paginationParams) throws DaoException;
    int countNewsInCategory(int id) throws DaoException;
    List<News> getNewsInCategoryByLogin(int id, String login, Map<String, Integer> paginationParams) throws DaoException;
    int countNewsInCategoryByLogin(int id, String login) throws DaoException;
}

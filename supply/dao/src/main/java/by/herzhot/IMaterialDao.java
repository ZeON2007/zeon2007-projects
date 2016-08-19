package by.herzhot;

import by.herzhot.exceptions.DaoException;

import java.util.List;
import java.util.Map;

/**
 * @author Herzhot
 * @version 1.0
 *          09.08.2016
 */
public interface IMaterialDao extends IDao<Material> {

    List<Material> findByCriterion(String criterion, Map<String, Integer> paginationParams) throws DaoException;
    Long countByCriterion(String criterion) throws DaoException;
    List<Material> readAll(Map<String, Integer> paginationParams) throws DaoException;

}

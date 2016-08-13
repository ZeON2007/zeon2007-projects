package by.herzhot;

import by.herzhot.exceptions.DaoException;

import java.util.List;

/**
 * @author Herzhot
 * @version 1.0
 *          09.08.2016
 */
public interface IMaterialDao extends IDao<Material> {

    List<Material> findByCriterion(String criterion) throws DaoException;

}

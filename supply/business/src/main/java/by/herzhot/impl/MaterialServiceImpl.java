package by.herzhot.impl;

import by.herzhot.*;
import by.herzhot.exceptions.DaoException;
import by.herzhot.exceptions.ServiceException;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;
import java.util.Map;

/**
 * @author Herzhot
 * @version 1.0
 *          03.08.2016
 */
@Stateless
public class MaterialServiceImpl extends BaseService<Material> implements IMaterialService {

    @Inject
    private IMaterialDao dao;

    @Override
    public List<Material> findByCriterion(String criterion, Map<String, Integer> paginationParams) throws ServiceException {
        List<Material> materials = null;
        try {
            materials = dao.findByCriterion(criterion, paginationParams);
        } catch (DaoException e) {
            throw new ServiceException();
        }
        return materials;
    }

    @Override
    public Long countByCriterion(String criterion) throws ServiceException {
        Long count;
        try {
            count = dao.countByCriterion(criterion);
        } catch (DaoException e) {
            throw new ServiceException();
        }
        return count;
    }

    @Override
    public List<Material> readAll(Map<String, Integer> paginationParams) throws ServiceException {
        List<Material> materials;
        try {
            materials = dao.readAll(paginationParams);
        } catch (DaoException e) {
            throw new ServiceException();
        }
        return materials;
    }


    @Override
    protected IDao<Material> getDao() {
        return dao;
    }
}

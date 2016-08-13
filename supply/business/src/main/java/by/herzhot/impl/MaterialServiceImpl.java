package by.herzhot.impl;

import by.herzhot.*;
import by.herzhot.exceptions.DaoException;
import by.herzhot.exceptions.ServiceException;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

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
    public List<Material> findByCriterion(String criterion) throws ServiceException {
        List<Material> materials = null;
        try {
            materials = dao.findByCriterion(criterion);
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

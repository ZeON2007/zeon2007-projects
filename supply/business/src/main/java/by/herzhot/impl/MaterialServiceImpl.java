package by.herzhot.impl;

import by.herzhot.*;

import javax.ejb.Stateless;
import javax.inject.Inject;

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
    protected IDao<Material> getDao() {
        return dao;
    }
}

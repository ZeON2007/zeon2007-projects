package by.herzhot.impl;

import by.herzhot.*;

import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 * @author Herzhot
 * @version 1.0
 *          09.08.2016
 */
@Stateless
public class SupplierServiceImpl extends BaseService<Supplier> implements ISupplierService {

    @Inject
    private ISupplierDao dao;

    @Override
    protected IDao<Supplier> getDao() {
        return dao;
    }
}

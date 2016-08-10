package by.herzhot.impl;

import by.herzhot.BaseDao;
import by.herzhot.ISupplierDao;
import by.herzhot.Supplier;

/**
 * @author Herzhot
 * @version 1.0
 *          09.08.2016
 */
public class SupplierDaoImpl extends BaseDao<Supplier> implements ISupplierDao {

    @Override
    protected Class<Supplier> getPersistentClass() {
        return Supplier.class;
    }
}

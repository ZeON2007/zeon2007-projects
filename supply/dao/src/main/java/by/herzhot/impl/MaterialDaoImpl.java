package by.herzhot.impl;

import by.herzhot.BaseDao;
import by.herzhot.IMaterialDao;
import by.herzhot.Material;

/**
 * @author Herzhot
 * @version 1.0
 *          03.08.2016
 */
public class MaterialDaoImpl extends BaseDao<Material> implements IMaterialDao {

    @Override
    protected Class<Material> getPersistentClass() {
        return Material.class;
    }
}

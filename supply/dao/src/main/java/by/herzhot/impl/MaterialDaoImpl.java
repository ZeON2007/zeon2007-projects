package by.herzhot.impl;

import by.herzhot.BaseDao;
import by.herzhot.IMaterialDao;
import by.herzhot.Material;
import by.herzhot.Supplier;
import by.herzhot.exceptions.DaoException;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.List;

/**
 * @author Herzhot
 * @version 1.0
 *          03.08.2016
 */
public class MaterialDaoImpl extends BaseDao<Material> implements IMaterialDao {

    @Override
    public List<Material> findByCriterion(String criterion) throws DaoException {

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Material> cq = cb.createQuery(Material.class);
        Root<Material> material = cq.from(Material.class);
        cq.select(material);
        Join<Material, Supplier> supplier = material.join("supplier", JoinType.LEFT);
        Predicate p1 = cb.like(supplier.<String>get("name"), "%"+criterion+"%");
        Predicate p2 = cb.like(material.<String>get("name"), "%"+criterion+"%");
        cq.where(cb.or(p1, p2));
        TypedQuery<Material> typedQuery = entityManager.createQuery(cq);
        return typedQuery.getResultList();
    }

    @Override
    protected Class<Material> getPersistentClass() {
        return Material.class;
    }
}

package by.herzhot.impl;

import by.herzhot.BaseDao;
import by.herzhot.IMaterialDao;
import by.herzhot.Material;
import by.herzhot.exceptions.DaoException;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
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
        CriteriaQuery<Material> cMaterial = cb.createQuery(Material.class);
        Root<Material> material = cMaterial.from(Material.class);
        Predicate p1 = cb.like(material.<String>get("name"), "%"+criterion+"%");
        Predicate p2 = cb.like(material.<String>get("supplier").<String>get("name"), "%"+criterion+"%");
        CriteriaQuery<Material> select = cMaterial.select(material).where(cb.or(p1, p2));
        TypedQuery<Material> typedQuery = entityManager.createQuery(select);
        return typedQuery.getResultList();
    }

    @Override
    protected Class<Material> getPersistentClass() {
        return Material.class;
    }
}

package by.herzhot.impl;

import by.herzhot.BaseDao;
import by.herzhot.IMaterialDao;
import by.herzhot.Material;
import by.herzhot.Supplier;
import by.herzhot.constants.CriteriaParams;
import by.herzhot.exceptions.DaoException;

import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.List;
import java.util.Map;

/**
 * @author Herzhot
 * @version 1.0
 *          03.08.2016
 */
public class MaterialDaoImpl extends BaseDao<Material> implements IMaterialDao {

    @Override
    public List<Material> findByCriterion(String criterion,
            Map<String, Integer> paginationParams) throws DaoException {

        List<Material> materials;
        int selected = paginationParams.get(CriteriaParams.SELECTED_PAGE);
        int quantity = paginationParams.get(CriteriaParams.QUANTITY_PER_PAGE);
        try {
            CriteriaBuilder cb = entityManager.getCriteriaBuilder();
            CriteriaQuery<Material> cq = cb.createQuery(Material.class);
            Root<Material> material = cq.from(Material.class);
            cq.select(material);
            Join<Material, Supplier> supplier = material.join("supplier", JoinType.LEFT);
            Predicate p1 = cb.like(supplier.<String>get("name"), "%" + criterion + "%");
            Predicate p2 = cb.like(material.<String>get("name"), "%" + criterion + "%");
            cq.where(cb.or(p1, p2));
            cq.orderBy(cb.asc(material.get("name")));
            TypedQuery<Material> typedQuery = entityManager.createQuery(cq);
            typedQuery.setFirstResult( (selected - 1)*quantity );
            typedQuery.setMaxResults( quantity );
            materials = typedQuery.getResultList();
        } catch (PersistenceException e) {
            logger.logError(getClass(), "Find materials by criterion error: " + e.getMessage());
            throw new DaoException();
        }
        return materials;
    }

    @Override
    public Long countByCriterion(String criterion) throws DaoException {
        Long count;
        try {
            CriteriaBuilder cb = entityManager.getCriteriaBuilder();
            CriteriaQuery<Long> cq = cb.createQuery(Long.class);
            Root<Material> material = cq.from(Material.class);
            Join<Material, Supplier> supplier = material.join("supplier", JoinType.LEFT);
            Predicate p1 = cb.like(supplier.<String>get("name"), "%" + criterion + "%");
            Predicate p2 = cb.like(material.<String>get("name"), "%" + criterion + "%");
            cq.where(cb.or(p1, p2));
            cq.select(cb.count(material));
            count = entityManager.createQuery(cq).getSingleResult();
        } catch (PersistenceException e) {
            logger.logError(getClass(), "Get count error: " + e.getMessage());
            throw new DaoException();
        }
        return count;
    }

    @Override
    public List<Material> readAll(Map<String, Integer> paginationParams) throws DaoException {
        List<Material> materials;
        int selected = paginationParams.get(CriteriaParams.SELECTED_PAGE);
        int quantity = paginationParams.get(CriteriaParams.QUANTITY_PER_PAGE);
        try {
            CriteriaBuilder cb = entityManager.getCriteriaBuilder();
            CriteriaQuery<Material> cq = cb.createQuery(getPersistentClass());
            Root<Material> from = cq.from(getPersistentClass());
            cq.select(from);
            cq.orderBy(cb.asc(from.get("name")));
            TypedQuery<Material> typedQuery = entityManager.createQuery(cq);
            typedQuery.setFirstResult( (selected - 1)*quantity );
            typedQuery.setMaxResults( quantity );
            materials = typedQuery.getResultList();
        } catch (PersistenceException e) {
            logger.logError(getClass(), "Find all materials error: " + e.getMessage());
            throw new DaoException();
        }
        return materials;
    }


    @Override
    protected Class<Material> getPersistentClass() {
        return Material.class;
    }
}

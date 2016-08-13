package by.herzhot;

import by.herzhot.exceptions.DaoException;
import by.herzhot.utils.LoggingUtil;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * @author Herzhot
 * @version 1.0
 *          09.08.2016
 */
public abstract class BaseDao<T> implements IDao<T> {    

    @PersistenceContext(unitName = "supply")
    protected EntityManager entityManager;
    protected LoggingUtil logger = LoggingUtil.INSTANCE;

    @Override
    public void create(T t) throws DaoException {
        try {
            entityManager.persist(t);
        } catch (PersistenceException e) {
            logger.logError(getClass(), "Save entity error: " + e.getMessage());
            throw new DaoException();
        }

    }

    @Override
    public T read(Long id) throws DaoException {
        T entity;
        try {
            entity = entityManager.find(getPersistentClass(), id);
        } catch (PersistenceException e) {
            logger.logError(getClass(), "Find entity error: " + e.getMessage());
            throw new DaoException();
        }
        return entity;
    }

    @Override
    public void update(T t) throws DaoException {
        try {
            entityManager.merge(t);
        } catch (PersistenceException e) {
            logger.logError(getClass(), "Update entity error: " + e.getMessage());
            throw new DaoException();
        }
    }

    @Override
    public void delete(Long id) throws DaoException {
        try {
            T entity = entityManager.find(getPersistentClass(), id);
            entityManager.remove(entity);
        } catch (PersistenceException e) {
            logger.logError(getClass(), "Delete entity error: " + e.getMessage());
            throw new DaoException();
        }
    }

    @Override
    public List<T> readAll() throws DaoException {
        List<T> entityList;
        try {
            CriteriaBuilder cb = entityManager.getCriteriaBuilder();
            CriteriaQuery<T> criteriaQuery = cb.createQuery(getPersistentClass());
            Root<T> from = criteriaQuery.from(getPersistentClass());
            CriteriaQuery<T> select = criteriaQuery.select(from);
            TypedQuery<T> typedQuery = entityManager.createQuery(select);
            entityList = typedQuery.getResultList();
        } catch (PersistenceException e) {
            logger.logError(getClass(), "Find all entities error: " + e.getMessage());
            throw new DaoException();
        }
        return entityList;
    }

    @Override
    public Integer count() throws DaoException {
        return null;
    }

    protected abstract Class<T> getPersistentClass();
}

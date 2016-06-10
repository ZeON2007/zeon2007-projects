package by.pvt.herzhot.services.impl;

import by.pvt.herzhot.dao.IDao;
import by.pvt.herzhot.dao.exceptions.DaoException;
import by.pvt.herzhot.dao.impl.DaoImpl;
import by.pvt.herzhot.managers.EntityManager;
import by.pvt.herzhot.pojos.associations.Address;
import by.pvt.herzhot.pojos.associations.Teacher;
import by.pvt.herzhot.services.IService;
import by.pvt.herzhot.services.exceptions.ServiceException;
import org.apache.log4j.Logger;

import java.util.List;

/**
 * @author Herzhot
 * @version 1.0
 *          08.06.2016
 */
public enum TeacherServiceImpl implements IService {

    INSTANCE;

    private IDao dao;
    private EntityManager entityManager;
    Teacher teacher;
    private static Logger logger = Logger.getLogger(IService.class);

    TeacherServiceImpl() {
        dao = DaoImpl.getInstance();
        entityManager = EntityManager.INSTANCE;
        teacher = new Teacher();
    }

    public Teacher find(int id) throws ServiceException {
        Teacher teacher;
        try {
            teacher = (Teacher) dao.find(this.teacher, id);
        } catch (DaoException e) {
            logger.error("Dao (find) method problem : " + e.getMessage());
            throw new ServiceException();
        }
        return teacher;
    }
    public List<Teacher> findAll() throws ServiceException {
        List<Teacher> teachers;
        try {
            teachers = (List<Teacher>) dao.findAll(teacher);
        } catch (DaoException e) {
            logger.error("Dao (findAll) method problem : " + e.getMessage());
            throw new ServiceException();
        }
        return teachers;
    }
    public boolean delete(int id) throws ServiceException {
        try {
            dao.delete(teacher, id);
        } catch (DaoException e) {
            logger.error("Dao (delete) method problem : " + e.getMessage());
            throw new ServiceException();
        }
        return true;
    }
    public boolean saveOrUpdate() throws ServiceException {
        Teacher teacher = (Teacher) entityManager.buildEntity(this.teacher);
        Address address = new Address();
        address = (Address) entityManager.buildEntity(address);
        teacher.setAddress(address);
        address.setTeacher(teacher);
        try {
            dao.saveOrUpdate(teacher);
        } catch (DaoException e) {
            logger.error("Dao (saveOrUpdate) method problem : " + e.getMessage());
            throw new ServiceException();
        }
        return true;
    }

}

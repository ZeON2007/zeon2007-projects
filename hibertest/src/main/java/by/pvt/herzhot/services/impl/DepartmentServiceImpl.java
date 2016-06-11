package by.pvt.herzhot.services.impl;

import by.pvt.herzhot.dao.IDao;
import by.pvt.herzhot.dao.exceptions.DaoException;
import by.pvt.herzhot.dao.impl.DaoImpl;
import by.pvt.herzhot.managers.EntityManager;
import by.pvt.herzhot.pojos.associations.Address;
import by.pvt.herzhot.pojos.associations.Department;
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
public enum  DepartmentServiceImpl implements IService {

    INSTANCE;

    private IDao dao;
    private EntityManager entityManager;
    private Department department;
    private static Logger logger = Logger.getLogger(IService.class);

    DepartmentServiceImpl() {
        dao = DaoImpl.getInstance();
        entityManager = EntityManager.INSTANCE;
        department = new Department();
    }

    public Department find(int id) throws ServiceException {
        Department department;
        try {
            department = (Department) dao.find(this.department, id);
        } catch (DaoException e) {
            logger.error("Dao (find) method problem : " + e.getMessage());
            throw new ServiceException();
        }
        return department;
    }
    public List<Department> findAll() throws ServiceException {
        List<Department> departments;
        try {
            departments = (List<Department>) dao.findAll(department);
        } catch (DaoException e) {
            logger.error("Dao (findAll) method problem : " + e.getMessage());
            throw new ServiceException();
        }
        return departments;
    }
    public boolean delete(int id) throws ServiceException {
        try {
            dao.delete(department, id);
        } catch (DaoException e) {
            logger.error("Dao (delete) method problem : " + e.getMessage());
            throw new ServiceException();
        }
        return true;
    }
    public boolean saveOrUpdate() throws ServiceException {
        Department department = (Department) entityManager.buildEntity(this.department);
        Teacher teacher = (Teacher) entityManager.buildEntity(new Teacher());
        Address address = (Address) entityManager.buildEntity(new Address());
        try {
            teacher.setAddress(address);
            address.setTeacher(teacher);
            teacher.setDepartment(department);
            department.getTeachers().add(teacher);
            dao.saveOrUpdate(department);
            dao.saveOrUpdate(teacher);
        } catch (DaoException e) {
            logger.error("Dao (saveOrUpdate) method problem : " + e.getMessage());
            throw new ServiceException();
        }
        return true;
    }

}

package by.pvt.herzhot.services.impl;

import by.pvt.herzhot.dao.IDao;
import by.pvt.herzhot.dao.exceptions.DaoException;
import by.pvt.herzhot.dao.impl.DaoImpl;
import by.pvt.herzhot.managers.EntityManager;
import by.pvt.herzhot.pojos.associations.Address;
import by.pvt.herzhot.pojos.associations.Department;
import by.pvt.herzhot.pojos.associations.Meeting;
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
public enum MeetingServiceImpl implements IService {
    INSTANCE;

    private IDao dao;
    private EntityManager entityManager;
    Meeting meeting;
    private static Logger logger = Logger.getLogger(IService.class);

    MeetingServiceImpl() {
        dao = DaoImpl.getInstance();
        entityManager = EntityManager.INSTANCE;
        meeting = new Meeting();
    }

    public Meeting find(int id) throws ServiceException {
        Meeting meeting;
        try {
            meeting = (Meeting) dao.find(this.meeting, id);
        } catch (DaoException e) {
            logger.error("Dao (find) method problem : " + e.getMessage());
            throw new ServiceException();
        }
        return meeting;
    }
    public List<Meeting> findAll() throws ServiceException {
        List<Meeting> meetings;
        try {
            meetings = (List<Meeting>) dao.findAll(meeting);
        } catch (DaoException e) {
            logger.error("Dao (findAll) method problem : " + e.getMessage());
            throw new ServiceException();
        }
        return meetings;
    }
    public boolean delete(int id) throws ServiceException {
        try {
            dao.delete(meeting, id);
        } catch (DaoException e) {
            logger.error("Dao (delete) method problem : " + e.getMessage());
            throw new ServiceException();
        }
        return true;
    }
    public boolean saveOrUpdate() throws ServiceException {
        Meeting meeting = (Meeting) entityManager.buildEntity(this.meeting);
        Department department = (Department) entityManager.buildEntity(new Department());
        Teacher teacher = (Teacher) entityManager.buildEntity(new Teacher());
        Address address = (Address) entityManager.buildEntity(new Address());
        try {
            teacher.setAddress(address);
            address.setTeacher(teacher);
            teacher.setDepartment(department);
            teacher.getMeetings().add(meeting);
            department.getTeachers().add(teacher);
            meeting.getTeachers().add(teacher);
            dao.saveOrUpdate(department);
            dao.saveOrUpdate(teacher);
            dao.saveOrUpdate(meeting);
        } catch (DaoException e) {
            logger.error("Dao (saveOrUpdate) method problem : " + e.getMessage());
            throw new ServiceException();
        }
        return true;
    }
}

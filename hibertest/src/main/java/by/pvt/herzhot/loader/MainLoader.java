package by.pvt.herzhot.loader;

import by.pvt.herzhot.dao.exceptions.DaoException;
import by.pvt.herzhot.dao.impl.DaoImpl;
import by.pvt.herzhot.managers.CommandManager;
import by.pvt.herzhot.managers.EntityManager;
import by.pvt.herzhot.pojos.Entity;
import by.pvt.herzhot.services.exceptions.ServiceException;
import by.pvt.herzhot.services.impl.DepartmentServiceImpl;
import by.pvt.herzhot.services.impl.MeetingServiceImpl;
import by.pvt.herzhot.services.impl.TeacherServiceImpl;
import by.pvt.herzhot.utils.InputValueValidator;

import java.util.List;
import java.util.Scanner;

import static by.pvt.herzhot.managers.CommandManager.*;
import static java.lang.System.in;
import static java.lang.System.out;

/**
 * @author Herzhot
 * @version 1.0
 *          30.05.2016
 */
public class MainLoader {
    public static void main(String[] args) {

        CommandManager commandManager = INSTANCE;
        EntityManager entityManager = EntityManager.INSTANCE;
        InputValueValidator inputValueValidator = InputValueValidator.INSTANCE;
        DaoImpl<Entity> dao = DaoImpl.getInstance();
        TeacherServiceImpl teacherService = TeacherServiceImpl.INSTANCE;
        MeetingServiceImpl meetingService = MeetingServiceImpl.INSTANCE;
        DepartmentServiceImpl departmentService = DepartmentServiceImpl.INSTANCE;
        Scanner scanner = new Scanner(in);
        boolean isLaunched = true;
        Integer selectedItem = 0;

        while (isLaunched) {
            commandManager.getMenuCommands();
            selectedItem = inputValueValidator.validate(selectedItem.TYPE);
            switch (selectedItem) {
                case DELETE_ENTITY_COMMAND: {
                    out.println("You choose - " + selectedItem);
                    commandManager.getMenuEntities();
                    selectedItem = commandManager.getSelectedItem();
                    Entity entity = (Entity) commandManager.getEntities().get(selectedItem-1);
                    out.println("Please select ID for deleting:");
                    try {
                        int id  = Integer.valueOf(scanner.nextLine().trim());
                        out.println("Operation is successful: " + dao.delete(entity, id));
                    }
                    catch (DaoException | NullPointerException e) {
                        out.println("Deleted " + entity.getClass().getSimpleName()+ " isn't found!");
                    }
                    break;
                }
                case FIND_ENTITY_COMMAND: {
                    out.println("You choose - " + selectedItem);
                    commandManager.getMenuEntities();
                    selectedItem = commandManager.getSelectedItem();
                    Entity entity = (Entity) commandManager.getEntities().get(selectedItem-1);
                    out.println("Please select ID:");
                    try {
                        int id  = Integer.valueOf(scanner.nextLine().trim());
                        Entity receivedEntity = dao.find(entity, id);
                        out.println(receivedEntity.getClass().getSimpleName() + " is found:");
                        out.println(receivedEntity.toString());
                    }
                    catch (DaoException | NullPointerException e) {
                        out.println(entity.getClass().getSimpleName() + " isn't found!");
                    }
                    break;
                }
                case FIND_ALL_ENTITIES_COMMAND: {
                    out.println("You choose - " + selectedItem);
                    commandManager.getMenuEntities();
                    selectedItem = commandManager.getSelectedItem();
                    Entity entity = (Entity) commandManager.getEntities().get(selectedItem-1);
                    out.println("List of " + entity.getClass().getSimpleName() + ":");
                    List<Entity> entities;
                    try {
                        entities = dao.findAll(entity);
                        for (Object object : entities) {
                                out.println(object.toString());
                        }
                    }
                    catch (DaoException e) {
                        out.println(entity.getClass().getSimpleName() + "(e)s isn't found!");
                    }
                    break;
                }
                case SAVE_OR_UPDATE_ENTITY_COMMAND: {
                    out.println("You choose - " + selectedItem);
                    commandManager.getMenuEntities();
                    selectedItem = commandManager.getSelectedItem();
                    Entity entity = (Entity) commandManager.getEntities().get(selectedItem - 1);
                    Entity receivedEntity = entityManager.buildEntity(entity);
                    try {
                        out.println("Operation is successful: " + dao.saveOrUpdate(receivedEntity));
                    } catch (DaoException | NullPointerException e) {
                        out.println("Operation failed. DAO error!");
                    }
                    break;
                }
                case SAVE_OR_UPDATE_THEACHER: {
                    out.println("You choose - " + selectedItem);
                    try {
                        out.println("Operation is successful: " + teacherService.saveOrUpdate());
                    } catch (ServiceException | NullPointerException e) {
                        out.println("Operation failed. Service error!");
                    }
                    break;
                }
                case SAVE_OR_UPDATE_DEPARTMENT: {
                    out.println("You choose - " + selectedItem);
                    try {
                        out.println("Operation is successful: " + departmentService.saveOrUpdate());
                    } catch (ServiceException | NullPointerException e) {
                        out.println("Operation failed. Service error!");
                    }
                    break;
                }
                case SAVE_OR_UPDATE_MEETING: {
                    out.println("You choose - " + selectedItem);
                    try {
                        out.println("Operation is successful: " + meetingService.saveOrUpdate());
                    } catch (ServiceException | NullPointerException e) {
                        out.println("Operation failed. Service error!");
                    }
                    break;
                }
                case EXIT_COMMAND: {
                    out.println("You choose - " + selectedItem);
                    out.println("Good-bye!");
                    isLaunched = false;
                    break;
                }
                default: {
                    out.println("You choose wrong command!");
                }

            }
        }
    }
}

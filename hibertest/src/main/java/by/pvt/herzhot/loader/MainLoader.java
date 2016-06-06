package by.pvt.herzhot.loader;

import by.pvt.herzhot.dao.exceptions.DaoException;
import by.pvt.herzhot.dao.impl.DaoImpl;
import by.pvt.herzhot.managers.CommandManager;
import by.pvt.herzhot.managers.EntityManager;
import by.pvt.herzhot.pojos.Entity;

import java.util.List;
import java.util.Scanner;

import static java.lang.System.*;

/**
 * @author Herzhot
 * @version 1.0
 *          30.05.2016
 */
public class MainLoader {
    public static void main(String[] args) {

        CommandManager commandManager = CommandManager.INSTANCE;
        EntityManager entityManager = EntityManager.INSTANCE;
        DaoImpl<Entity> dao = DaoImpl.getInstance();
        Scanner scanner = new Scanner(in);
        boolean isLaunched = true;
        int selectedItem;

        while (isLaunched) {
            commandManager.getMenuCommands();
            try {
                selectedItem = Integer.valueOf(scanner.nextLine().trim());
            }
            catch (NumberFormatException e) {
                selectedItem = 0;
            }
            switch (selectedItem) {
                // Delete entity
                case 1: {
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
                // Get entity by id
                case 2: {
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
                // Get all entities
                case 3: {
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
                // Save or update entity
                case 4: {
                    out.println("You choose - " + selectedItem);
                    commandManager.getMenuEntities();
                    selectedItem = commandManager.getSelectedItem();
                    Entity entity = (Entity) commandManager.getEntities().get(selectedItem-1);
                    Entity receivedEntity = entityManager.buildEntity(entity);
                    try {
                        out.println("Operation is successful: " + dao.saveOrUpdate(receivedEntity));
                    }
                    catch (DaoException | NullPointerException e) {
                        out.println("Operation failed. DAO error!");
                    }
                    break;
                }
                // Exit program
                case 5: {
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

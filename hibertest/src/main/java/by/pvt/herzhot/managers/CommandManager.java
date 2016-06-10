package by.pvt.herzhot.managers;

import by.pvt.herzhot.pojos.Entity;
import by.pvt.herzhot.pojos.inheritance.BankAccount;
import by.pvt.herzhot.pojos.inheritance.CreditCard;
import by.pvt.herzhot.pojos.other.Author;
import by.pvt.herzhot.pojos.other.CategoryOfNews;
import by.pvt.herzhot.utils.InputValueValidator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.System.out;

/**
 * @author Herzhot
 * @version 1.0
 *          03.06.2016
 */
public enum CommandManager {

    INSTANCE;

    public static final int DELETE_ENTITY_COMMAND = 1;
    public static final int FIND_ENTITY_COMMAND = 2;
    public static final int FIND_ALL_ENTITIES_COMMAND = 3;
    public static final int SAVE_OR_UPDATE_ENTITY_COMMAND = 4;
    public static final int SAVE_OR_UPDATE_THEACHER = 5;
    public static final int SAVE_OR_UPDATE_DEPARTMENT = 6;
    public static final int SAVE_OR_UPDATE_MEETING = 7;
    public static final int EXIT_COMMAND = 8;

    private List<String> menu;
    private List<Entity> entities;
    private InputValueValidator inputValueValidator;

    CommandManager() {

        inputValueValidator = InputValueValidator.INSTANCE;

        // Menu of commands
        menu = new ArrayList<>(Arrays.asList(
                "Delete entity", // 1
                "Find entity", // 2
                "Find all entities", // 3
                "Save or update entity", // 4
                "Save or update Teacher (one to one)", // 5
                "Save or update Department (one to many)", // 6
                "Save or update Meeting (many to many)", // 7
                "Exit" // 8
        ));

        // Declaring all entities
        entities = new ArrayList<>(Arrays.asList(
                new Author(),
                new CategoryOfNews(),
                new CreditCard(),
                new BankAccount()
        ));
    }

    public void getMenuCommands(){
        out.println("\nPlease choose next command:");
        for (String item : menu) {
            out.println((menu.indexOf(item)+1)+": "+item);
        }
    }
    public void getMenuEntities(){
        out.println("Please choose type of entity:");
        for (Object object : entities) {
            out.println((entities.indexOf(object)+1)+": "+object.getClass().getSimpleName());
        }
    }
    public int getSelectedItem() {
        Integer selectedItem = 0;
        while (true) {
            selectedItem = inputValueValidator.validate(selectedItem.TYPE);
            if (selectedItem < 1 || selectedItem > getEntities().size()) {
                out.println("You input not allowed number! Try once again:");
                continue;
            }
            break;
        }
        return selectedItem;
    }
    public List getEntities() {
        return entities;
    }
}

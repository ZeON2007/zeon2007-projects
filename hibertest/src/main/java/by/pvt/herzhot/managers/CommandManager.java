package by.pvt.herzhot.managers;

import by.pvt.herzhot.pojos.inheritance.BankAccount;
import by.pvt.herzhot.pojos.inheritance.BillingDetails;
import by.pvt.herzhot.pojos.inheritance.CreditCard;
import by.pvt.herzhot.pojos.other.Author;
import by.pvt.herzhot.pojos.other.CategoryOfNews;
import by.pvt.herzhot.pojos.Entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

/**
 * @author Herzhot
 * @version 1.0
 *          03.06.2016
 */
public enum CommandManager {

    INSTANCE;

    private Scanner scanner = new Scanner(in);
    // Menu of commands
    private List<String> menu = new ArrayList<>(Arrays.asList(
            "Delete entity",
            "Find entity",
            "Find all entities",
            "Save or update entity",
            "Exit"
    ));
    // Declaring all entities
    private List<Entity> entities = new ArrayList<>(Arrays.asList(
            new Author(),
            new CategoryOfNews(),
            new CreditCard(),
            new BankAccount()
    ));

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
        int selectedItem;
        try {
            selectedItem = Integer.valueOf(scanner.nextLine().trim());
            if (selectedItem < 1 || selectedItem > getEntities().size()) {
                selectedItem = 1;
            }
        }
        catch (NumberFormatException e) {
            selectedItem = 1;
        }
        return selectedItem;
    }
    public List<String> getMenu() {
        return menu;
    }

    public List getEntities() {
        return entities;
    }
}

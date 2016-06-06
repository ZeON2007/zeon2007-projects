package by.pvt.herzhot.managers;

import by.pvt.herzhot.pojos.inheritance.BankAccount;
import by.pvt.herzhot.pojos.inheritance.CreditCard;
import by.pvt.herzhot.pojos.other.Author;
import by.pvt.herzhot.pojos.other.CategoryOfNews;
import by.pvt.herzhot.pojos.Entity;
import by.pvt.herzhot.utils.InputValueValidator;

import java.lang.reflect.Field;
import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

/**
 * @author Herzhot
 * @version 1.0
 *          04.06.2016
 */
public enum EntityManager {

    INSTANCE;

    private Scanner scanner = new Scanner(in);

    public Entity buildEntity(final Entity entity) {
        if (entity instanceof Author) {

            Entity instance = null;
            Class<?> clazz = entity.getClass();
            try {
                instance = (Entity) clazz.newInstance();
                Field[] fields = clazz.getDeclaredFields();
                for (Field field : fields) {
                    field.setAccessible(true);
                    if (!field.getName().equals("serialVersionUID")) {
                        out.println("Input " + field.getName() + ":");
                        field.set(instance, InputValueValidator.INSTANCE.validate(field.getType()));
                    }
                }
            } catch (Exception e) {}

            return instance;
        } else if (entity instanceof CategoryOfNews) {
            CategoryOfNews categoryOfNews = new CategoryOfNews();
            categoryOfNews.setId(assignId());
            out.println("Please enter category name:");
            categoryOfNews.setCategory(scanner.nextLine().trim());
            return categoryOfNews;

        } else if (entity instanceof CreditCard) {
            return new CreditCard();
        } else if (entity instanceof BankAccount) {
            return new BankAccount();
        } else return null;
    }
    private int assignId() {
        int id;
        try {
            out.println("Please enter id:");
            id  = Integer.valueOf(scanner.nextLine().trim());
        }
        catch (NullPointerException | NumberFormatException e) {
            out.println("You enter not number!");
            out.println("Id was defined as 0");
            id = 0;
        }
        return id;
    }
}

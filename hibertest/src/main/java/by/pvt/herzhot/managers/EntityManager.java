package by.pvt.herzhot.managers;

import by.pvt.herzhot.pojos.inheritance.BankAccount;
import by.pvt.herzhot.pojos.inheritance.CreditCard;
import by.pvt.herzhot.pojos.other.Author;
import by.pvt.herzhot.pojos.other.CategoryOfNews;
import by.pvt.herzhot.pojos.Entity;
import by.pvt.herzhot.utils.InputValueValidator;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
    private List<Field> allFields = new ArrayList<>();
    private Entity instance = null;
    private Class<?> clazz = null;

    public Entity buildEntity(final Entity entity) {
            clazz = entity.getClass();
            try {
                instance = (Entity) clazz.newInstance();
                while (clazz != Object.class) {
                    allFields.addAll(Arrays.asList(clazz.getDeclaredFields()));
                    clazz = clazz.getSuperclass();
                }
                for (Field field : allFields) {
                    field.setAccessible(true);
                    if (!field.getName().equals("serialVersionUID")) {
                        out.println("Input " + field.getName() + ":");
                        field.set(instance, InputValueValidator.INSTANCE.validate(field.getType()));
                    }
                }
            } catch (Exception e) {
                out.println("Build entity error!");

            }
            return instance;
    }
}

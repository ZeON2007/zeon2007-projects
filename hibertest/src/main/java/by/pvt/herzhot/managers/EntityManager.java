package by.pvt.herzhot.managers;

import by.pvt.herzhot.pojos.Entity;
import by.pvt.herzhot.utils.InputValueValidator;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static java.lang.System.out;

/**
 * @author Herzhot
 * @version 1.0
 *          04.06.2016
 */
public enum EntityManager {

    INSTANCE;

    private final List<Field> allFields;
    private final InputValueValidator inputValueValidator;
    private Entity instance;

    EntityManager() {
        allFields = new ArrayList<>();
        inputValueValidator = InputValueValidator.INSTANCE;
    }

    public Entity buildEntity(final Entity entity) {
        Class<?> clazz = entity.getClass();
        out.println("Input " + clazz.getSimpleName() + "'s data:");
            try {
                instance = (Entity) clazz.newInstance();
                while (clazz != Object.class) {
                    allFields.addAll(Arrays.asList(clazz.getDeclaredFields()));
                    clazz = clazz.getSuperclass();
                }
                for (Field field : allFields) {
                    field.setAccessible(true);
                    if (!field.getName().equals("serialVersionUID")
                            && !field.getName().equals("id")
                            && !field.getType().isInstance(Collection.class)
                            && !Collection.class.isAssignableFrom(field.getType())
                            && !Entity.class.isAssignableFrom(field.getType())) {
                        out.println("Input " + field.getName() + ":");
                        field.set(instance, inputValueValidator.validate(field.getType()));
                    }
                }
            } catch (Exception e) {
                out.println("Build entity error!");
            } finally {
                allFields.clear();
            }
            return instance;
    }
}

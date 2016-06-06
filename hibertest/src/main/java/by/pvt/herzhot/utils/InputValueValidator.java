package by.pvt.herzhot.utils;

import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

/**
 * @author Herzhot
 * @version 1.0
 *          06.06.2016
 */
public enum  InputValueValidator {

    INSTANCE;

    private Scanner scanner = new Scanner(in);

    public <T> T validate(Class<T> clazz) {
        T t = null;
        if (clazz == int.class) {
            while (true) {
                try {
                    t = (T) Integer.valueOf(scanner.nextLine().trim());
                    break;
                } catch (NumberFormatException e) {
                    out.println("You input wrong value! Try once again:");
                }
            }
        } else if (clazz == String.class) {
            while (true) {
                try {
                    t = (T) scanner.nextLine().trim();
                    break;
                } catch (NumberFormatException e) {
                    out.println("You input wrong value! Try once again:");
                }
            }
        }
        return t;
    }
}

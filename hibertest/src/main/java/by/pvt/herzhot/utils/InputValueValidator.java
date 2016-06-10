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

    private Scanner scanner;

    InputValueValidator() {
        scanner = new Scanner(in);
    }

    public <T> T validate(Class<T> clazz) {
        T t = null;
        if (clazz == Integer.TYPE) {
            Integer value;
            while (true) {
                try {
                    value = Integer.valueOf(scanner.nextLine().trim());
                    if (value >= 0) {
                        t = (T) value;
                        break;
                    } else {
                        out.println("You input negative number! Try once again:");
                    }
                } catch (NumberFormatException e) {
                    out.println("You input not integer! Try once again:");
                }
            }
        } else if (clazz == String.class) {
            while (true) {
                try {
                    t = (T) scanner.nextLine().trim();
                    break;
                } catch (NumberFormatException e) {
                    out.println("You input not string! Try once again:");
                }
            }
        }
        return t;
    }
}

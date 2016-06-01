package by.pvt.herzhot.loader;

import by.pvt.herzhot.dao.exceptions.DaoException;
import by.pvt.herzhot.dao.impl.AuthorDaoImpl;
import by.pvt.herzhot.pojos.Author;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Herzhot
 * @version 1.0
 *          30.05.2016
 */
public class MainLoader {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        boolean isLaunched = true;
        while (isLaunched) {
            System.out.println("Please choose next command:");
            System.out.println("1: Delete author");
            System.out.println("2: Find author");
            System.out.println("3: Find all authors");
            System.out.println("4: Save or update author");
            System.out.println("5: Exit");

            switch (Integer.valueOf(scanner.nextLine().trim())) {
                case 1: {
                    System.out.println("You choose - 1");
                    System.out.println("Please select ID for deleting:");
                    try {
                        System.out.println("Operation is successful: "
                                + AuthorDaoImpl.INSTANCE.delete(Integer.valueOf(scanner.nextLine().trim())));
                    }
                    catch (DaoException e) {
                        System.out.println("Deleted author isn't found!");
                    }
                    break;
                }
                case 2: {
                    System.out.println("You choose - 2");
                    System.out.println("Please select ID:");
                    Author author;
                    try {
                        author = AuthorDaoImpl.INSTANCE.find(Integer.valueOf(scanner.nextLine().trim()));
                        System.out.println("Author is found: "
                                + author.getFirstName() + " "
                                + author.getLastName());
                    }
                    catch (DaoException e) {
                        System.out.println("Author isn't found!");
                    }
                    break;
                }
                case 3: {
                    System.out.println("You choose - 3");
                    System.out.println("List of authors:");
                    List<Author> authors;
                    try {
                        authors = AuthorDaoImpl.INSTANCE.findAll();
                        for (Object author: authors) {
                            System.out.println("No: "
                                    + ((Author)author).getId() + " | "
                                    + ((Author)author).getFirstName() + " "
                                    + ((Author)author).getLastName());
                        }
                    }
                    catch (DaoException e) {
                        System.out.println("Authors isn't found!");
                    }
                    break;
                }
                case 4: {
                    System.out.println("You choose - 4");
                    Author author = new Author();
                    System.out.println("Please enter name:");
                    author.setFirstName(scanner.nextLine().trim());
                    System.out.println("Please enter surname:");
                    author.setLastName(scanner.nextLine().trim());
                    try {
                        System.out.println("Operation is successful: "
                                + AuthorDaoImpl.INSTANCE.saveOrUpdate(author));
                    }
                    catch (DaoException e) {
                        System.out.println("Operation failed. DAO error!");
                    }
                    break;
                }
                case 5: {
                    System.out.println("You choose - 5");
                    System.out.println("Good-bye!");
                    isLaunched = false;
                    break;
                }
                default: {
                    System.out.println("You choose wrong command!");
                }

            }
        }
    }
}

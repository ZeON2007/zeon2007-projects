package by.pvt.herzhot.managers;

import by.pvt.herzhot.pojos.Author;
import by.pvt.herzhot.pojos.CategoryOfNews;
import by.pvt.herzhot.pojos.Entity;

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
            Author author = new Author();
            author.setId(assignId());
            out.println("Please enter name:");
            author.setFirstName(scanner.nextLine().trim());
            out.println("Please enter surname:");
            author.setLastName(scanner.nextLine().trim());
            return author;
        } else if (entity instanceof CategoryOfNews) {
            CategoryOfNews categoryOfNews = new CategoryOfNews();
            categoryOfNews.setId(assignId());
            out.println("Please enter category name:");
            categoryOfNews.setCategory(scanner.nextLine().trim());
            return categoryOfNews;
        } else return null;
    }
    private int assignId() {
        int id;
        try {
            out.println("Please enter id:");
            id  = Integer.valueOf(scanner.nextLine().trim());
        }
        catch (NullPointerException e) {
            out.println("You enter not number!");
            out.println("Id was defined as 0");
            id = 0;
        }
        return id;
    }
}

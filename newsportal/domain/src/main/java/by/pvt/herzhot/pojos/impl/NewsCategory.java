package by.pvt.herzhot.pojos.impl;

import by.pvt.herzhot.pojos.IEntity;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Herzhot
 * @version 1.0
 *          09.05.2016
 */
public class NewsCategory implements IEntity {

    private static final long serialVersionUID = 1L;
    private int id;
    private String category;
    private Set<News> newses = new HashSet<>();

    public NewsCategory() {
        category = "";
    }
    public NewsCategory(String category, Set<News> newses) {
        this.category = category;
        this.newses = newses;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NewsCategory newsCategory = (NewsCategory) o;
        return id == newsCategory.id;
    }
    @Override
    public int hashCode() {
        int result = category != null ? category.hashCode() : 0;
        result = 31 * result + (newses != null ? newses.hashCode() : 0);
        return result;
    }
    @Override
    public String toString() {
        return "NewsCategory{" +
                "id=" + id +
                ", category='" + category + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }

    public Set<News> getNewses() {
        return newses;
    }
    public void setNewses(Set<News> newses) {
        this.newses = newses;
    }
}

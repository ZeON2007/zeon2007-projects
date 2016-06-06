package by.pvt.herzhot.pojos.other;

import by.pvt.herzhot.pojos.Entity;

/**
 * @author Herzhot
 * @version 1.0
 *          09.05.2016
 */
public class CategoryOfNews implements Entity {

    private static final long serialVersionUID = 1L;
    private int id;
    private String category;

    public CategoryOfNews() {
        category = "";
    }
    public CategoryOfNews(int id, String category) {
        this.id = id;
        this.category = category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CategoryOfNews that = (CategoryOfNews) o;

        return id == that.id && (category != null ? category.equals(that.category) : that.category == null);

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (category != null ? category.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "CategoryOfNews{" +
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
}

package by.pvt.herzhot.beans;

/**
 * @author Herzhot
 * @version 1.0
 *          09.05.2016
 */
public class CategoryOfNews extends Entity {

    private static final long serialVersionUID = 1L;
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

        if (id != that.id) return false;
        return category != null ? category.equals(that.category) : that.category == null;

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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}

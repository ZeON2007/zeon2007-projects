package by.pvt.herzhot.beans;

/**
 * @author Herzhot
 * @version 1.0
 * 19.05.2016
 */
public class News extends Entity {

    private static final long serialVersionUID = 1L;
    private int categoryId;
    private int authorId;
    private String date;
    private String name;
    private String description;
    private String mainText;

    public News() {
        date = "";
        name = "";
        description = "";
        mainText = "";
    }

    public News(int id, int categoryId, int authorId, String date, String name,
                String description, String mainText) {
        this.id = id;
        this.categoryId = categoryId;
        this.authorId = authorId;
        this.date = date;
        this.name = name;
        this.description = description;
        this.mainText = mainText;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        News news = (News) o;

        if (id != news.id) return false;
        if (categoryId != news.categoryId) return false;
        if (authorId != news.authorId) return false;
        if (date != null ? !date.equals(news.date) : news.date != null) return false;
        if (name != null ? !name.equals(news.name) : news.name != null) return false;
        if (description != null ? !description.equals(news.description) : news.description != null) return false;
        return mainText != null ? mainText.equals(news.mainText) : news.mainText == null;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + categoryId;
        result = 31 * result + authorId;
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (mainText != null ? mainText.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "News{" +
                "id=" + id +
                ", categoryId=" + categoryId +
                ", authorId=" + authorId +
                ", date='" + date + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", mainText='" + mainText + '\'' +
                '}';
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMainText() {
        return mainText;
    }

    public void setMainText(String mainText) {
        this.mainText = mainText;
    }
}

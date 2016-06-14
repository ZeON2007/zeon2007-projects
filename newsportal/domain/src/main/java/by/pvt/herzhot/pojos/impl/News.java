package by.pvt.herzhot.pojos.impl;

import by.pvt.herzhot.pojos.IEntity;

import java.util.Date;

/**
 * @author Herzhot
 * @version 1.0
 * 19.05.2016
 */
public class News implements IEntity {

    private static final long serialVersionUID = 1L;
    private int id;
    private NewsCategory newsCategory;
    private Author author;
    private Date date;
    private String name;
    private String description;
    private String mainText;

    public News() {
        name = "";
        description = "";
        mainText = "";
    }
    public News(NewsCategory newsCategory, Author author, Date date,
                String name, String description, String mainText) {
        this.newsCategory = newsCategory;
        this.author = author;
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
        return id == news.id;
    }
    @Override
    public int hashCode() {
        int result = date != null ? date.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (mainText != null ? mainText.hashCode() : 0);
        return result;
    }
    @Override
    public String toString() {
        return "News{" +
                "id=" + id +
                ", date=" + date +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", mainText='" + mainText + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public NewsCategory getNewsCategory() {
        return newsCategory;
    }
    public void setNewsCategory(NewsCategory newsCategory) {
        this.newsCategory = newsCategory;
    }

    public Author getAuthor() {
        return author;
    }
    public void setAuthor(Author author) {
        this.author = author;
    }

    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
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

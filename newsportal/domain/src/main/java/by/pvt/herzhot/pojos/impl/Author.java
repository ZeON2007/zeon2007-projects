package by.pvt.herzhot.pojos.impl;

import by.pvt.herzhot.pojos.IEntity;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Herzhot
 * @version 1.0
 *          08.05.2016
 */
public class Author implements IEntity {

    private static final long serialVersionUID = 1L;
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private int accessLevel;
    private Set<News> newses = new HashSet<>();

    public Author() {
        firstName = "";
        lastName = "";
        email = "";
        password = "";
    }
    public Author(String firstName, String lastName, String email,
                  String password, int accessLevel, Set<News> newses) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.accessLevel = accessLevel;
        this.newses = newses;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return id == author.id;
    }
    @Override
    public int hashCode() {
        int result = firstName != null ? firstName.hashCode() : 0;
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + accessLevel;
        return result;
    }
    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", accessLevel=" + accessLevel +
                '}';
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public int getAccessLevel() {
        return accessLevel;
    }
    public void setAccessLevel(int accessLevel) {
        this.accessLevel = accessLevel;
    }

    public Set<News> getNewses() {
        return newses;
    }
    public void setNewses(Set<News> newses) {
        this.newses = newses;
    }
}

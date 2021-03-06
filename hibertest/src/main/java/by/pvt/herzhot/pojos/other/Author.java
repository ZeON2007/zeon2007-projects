package by.pvt.herzhot.pojos.other;

import by.pvt.herzhot.pojos.Entity;

/**
 * @author Herzhot
 * @version 1.0
 *          30.05.2016
 */
public class Author implements Entity {

    private static final long serialVersionUID = 1L;
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private int accessLevel;

    public Author() {
        firstName = "";
        lastName = "";
        email = "";
        password = "";
    }
    public Author(int id, String firstName, String lastName, String email, String password, int accessLevel) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.accessLevel = accessLevel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Author author = (Author) o;

        return id == author.id
                && accessLevel == author.accessLevel
                && (firstName != null ? firstName.equals(author.firstName) : author.firstName == null
                && (lastName != null ? lastName.equals(author.lastName) : author.lastName == null
                && (email != null ? email.equals(author.email) : author.email == null
                && (password != null ? password.equals(author.password) : author.password == null))));

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
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
}

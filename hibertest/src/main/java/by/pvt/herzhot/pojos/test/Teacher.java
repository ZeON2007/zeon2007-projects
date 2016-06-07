package by.pvt.herzhot.pojos.test;

import by.pvt.herzhot.pojos.Entity;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Herzhot
 * @version 1.0
 *          06.06.2016
 */
public class Teacher implements Entity {

    private static final long serialVersionUID = 1L;
    private int id;
    private String firstName;
    private String lastName;
    private int age;
    private Address address;
    private Set<University> universities;

    public Teacher() {
        this.firstName = "";
        this.lastName = "";
        this.age = 20;
        this.address = new Address();
        this.universities = new HashSet<>();
    }

    public Teacher(int id, String firstName, String lastName, int age, Address address, Set<University> universities) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.address = address;
        this.universities = universities;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Teacher teacher = (Teacher) o;

        if (id != teacher.id) return false;
        if (age != teacher.age) return false;
        if (firstName != null ? !firstName.equals(teacher.firstName) : teacher.firstName != null) return false;
        if (lastName != null ? !lastName.equals(teacher.lastName) : teacher.lastName != null) return false;
        if (address != null ? !address.equals(teacher.address) : teacher.address != null) return false;
        return universities != null ? universities.equals(teacher.universities) : teacher.universities == null;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + age;
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (universities != null ? universities.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", address=" + address +
                ", universities=" + universities +
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Set<University> getUniversities() {
        return universities;
    }

    public void setUniversities(Set<University> universities) {
        this.universities = universities;
    }
}

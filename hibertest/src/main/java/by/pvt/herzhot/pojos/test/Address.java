package by.pvt.herzhot.pojos.test;

import by.pvt.herzhot.pojos.Entity;

/**
 * @author Herzhot
 * @version 1.0
 *          06.06.2016
 */
public class Address implements Entity {

    private static final long serialVersionUID = 1L;
    private int id;
    private String city;
    private String street;
    private Teacher teacher;

    public Address() {
        this.teacher = new Teacher();
        this.city = "";
        this.street = "";
    }

    public Address(String city, int id, String street, Teacher teacher) {
        this.city = city;
        this.id = id;
        this.street = street;
        this.teacher = teacher;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Address address = (Address) o;

        if (id != address.id) return false;
        if (city != null ? !city.equals(address.city) : address.city != null) return false;
        if (street != null ? !street.equals(address.street) : address.street != null) return false;
        return teacher != null ? teacher.equals(address.teacher) : address.teacher == null;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (street != null ? street.hashCode() : 0);
        result = 31 * result + (teacher != null ? teacher.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", teacher=" + teacher +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
}

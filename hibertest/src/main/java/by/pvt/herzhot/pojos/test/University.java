package by.pvt.herzhot.pojos.test;

import by.pvt.herzhot.pojos.Entity;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Herzhot
 * @version 1.0
 *          06.06.2016
 */
public class University implements Entity {

    private static final long serialVersionUID = 1L;
    private int id;
    private City city;
    private String name;
    private Set<Teacher> teachers;

    public University() {
        this.city = new City();
        this.name = "";
        this.teachers = new HashSet<>();
    }

    public University(Set<Teacher> teachers, String name, City city, int id) {
        this.teachers = teachers;
        this.name = name;
        this.city = city;
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        University that = (University) o;

        if (id != that.id) return false;
        if (city != null ? !city.equals(that.city) : that.city != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        return teachers != null ? teachers.equals(that.teachers) : that.teachers == null;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (teachers != null ? teachers.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "University{" +
                "id=" + id +
                ", city=" + city +
                ", name='" + name + '\'' +
                ", teachers=" + teachers +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(Set<Teacher> teachers) {
        this.teachers = teachers;
    }

}

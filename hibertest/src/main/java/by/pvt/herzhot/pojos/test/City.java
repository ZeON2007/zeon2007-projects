package by.pvt.herzhot.pojos.test;

import by.pvt.herzhot.pojos.Entity;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Herzhot
 * @version 1.0
 *          06.06.2016
 */
public class City implements Entity {

    private static final long serialVersionUID = 1L;
    private int id;
    private String name;
    private Set<University> universities;

    public City() {
        this.name = "";
        this.universities = new HashSet<>();
    }

    public City(String name, int id, Set<University> universities) {
        this.name = name;
        this.id = id;
        this.universities = universities;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        City city = (City) o;

        if (id != city.id) return false;
        if (name != null ? !name.equals(city.name) : city.name != null) return false;
        return universities != null ? universities.equals(city.universities) : city.universities == null;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (universities != null ? universities.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", universities=" + universities +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<University> getUniversities() {
        return universities;
    }

    public void setUniversities(Set<University> universities) {
        this.universities = universities;
    }
}

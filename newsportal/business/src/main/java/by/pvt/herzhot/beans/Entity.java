package by.pvt.herzhot.beans;

import java.io.Serializable;

/**
 * @author Herzhot
 * @version 1.0
 * 08.05.2016
 */
public abstract class Entity implements Serializable {

    private static final long serialVersionUID = 1L;
    protected int id;

    public Entity() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

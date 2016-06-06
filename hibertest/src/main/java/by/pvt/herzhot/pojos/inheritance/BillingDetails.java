package by.pvt.herzhot.pojos.inheritance;

public abstract class BillingDetails implements by.pvt.herzhot.pojos.Entity {

    private static final long serialVersionUID = 1L;
    protected int id;
    private String owner;


    protected BillingDetails() {
        owner = "";
    }
    protected BillingDetails(String owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "BillingDetails{" +
                "id=" + id +
                ", owner='" + owner + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getOwner() {
        return owner;
    }
    public void setOwner(String owner) {
        this.owner = owner;
    }
}

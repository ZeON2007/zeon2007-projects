package by.herzhot;

import javax.persistence.*;
import java.util.Set;

/**
 * @author Herzhot
 * @version 1.0
 *          09.08.2016
 */
@Entity
@Table(name = "supplier")
public class Supplier implements IEntity {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id_supplier")
    private Long id;
    @Column(name = "name", nullable = false, insertable = false, updatable = false)
    private String name;
    @Column(name = "settlement_account", nullable = false, insertable = false, updatable = false)
    private String settlementAccount;
    @Column(name = "contact_person", insertable = false, updatable = false)
    private String contactPerson;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "supplier")
    private Set<Material> materials;

    public Supplier() {}
    public Supplier(String name, String settlementAccount, String contactPerson, Set<Material> materials) {
        this.name = name;
        this.settlementAccount = settlementAccount;
        this.contactPerson = contactPerson;
        this.materials = materials;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Supplier supplier = (Supplier) o;
        return id.equals(supplier.getId());
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (settlementAccount != null ? settlementAccount.hashCode() : 0);
        result = 31 * result + (contactPerson != null ? contactPerson.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Supplier{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", settlementAccount='" + settlementAccount + '\'' +
                ", contactPerson='" + contactPerson + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getSettlementAccount() {
        return settlementAccount;
    }
    public void setSettlementAccount(String settlementAccount) {
        this.settlementAccount = settlementAccount;
    }

    public String getContactPerson() {
        return contactPerson;
    }
    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }

    public Set<Material> getMaterials() {
        return materials;
    }
    public void setMaterials(Set<Material> materials) {
        this.materials = materials;
    }
}

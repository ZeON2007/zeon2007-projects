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

    @Id
    @Column(name = "id_supplier")
    private Long id;
    @Column(name = "name", nullable = false, insertable = false, updatable = false)
    private String name;
    @Column(name = "settlement_account", nullable = false, insertable = false, updatable = false)
    private String settlementAccount;
    @Column(name = "contact_person", insertable = false, updatable = false)
    private String contactPerson;
    @OneToMany(fetch = FetchType.LAZY)
    private Set<Material> materials;

    public Supplier() {}
    public Supplier(String name, String settlementAccount, String contactPerson, Set<Material> materials) {
        this.name = name;
        this.settlementAccount = settlementAccount;
        this.contactPerson = contactPerson;
        this.materials = materials;
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

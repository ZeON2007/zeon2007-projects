package by.herzhot.ldap.entries;

import org.springframework.ldap.odm.annotations.Attribute;
import org.springframework.ldap.odm.annotations.DnAttribute;
import org.springframework.ldap.odm.annotations.Entry;
import org.springframework.ldap.odm.annotations.Id;

import javax.naming.Name;

@Entry(base = "ou=MACEntries", objectClasses = {"top", "MACEntry"})
public class MacEntry {

    @Id
    private Name dn;
    @Attribute
    @DnAttribute(value = "macAddress", index = 1)
    private String macAddress;
    @Attribute(name = "clientclassname")
    private String clientClassName;



    public String getMacAddress() {
        return macAddress;
    }
    public void setMacAddress(String macAddress) {
        this.macAddress = macAddress;
    }

    public String getClientClassName() {
        return clientClassName;
    }
    public void setClientClassName(String clientClassName) {
        this.clientClassName = clientClassName;
    }

    @Override
    public String toString() {
        return "MacEntry{" +
                "macAddress='" + macAddress + '\'' +
                ", clientClassName='" + clientClassName + '\'' +
                '}';
    }
}

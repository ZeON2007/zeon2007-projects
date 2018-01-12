package by.herzhot.ldap.dao;

import by.herzhot.ldap.entries.MacEntry;

import java.util.List;

public interface ILdapDao {

//   List<String> getAll();

   List<MacEntry> getAll();
   MacEntry findByMacAddress(String macAddress);
   MacEntry create(MacEntry macEntry);
   void update(MacEntry macEntry);
   void delete(MacEntry macEntry);

}

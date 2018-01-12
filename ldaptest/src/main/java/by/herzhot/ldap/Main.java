package by.herzhot.ldap;

import by.herzhot.ldap.dao.ILdapDao;
import by.herzhot.ldap.entries.MacEntry;

public class Main {

    private ILdapDao dao;

    public Main() {
        dao = (ILdapDao) ContextHolder.INSTANCE.getContext().getBean("dao");
    }

    public static void mains(String[] args) {

        Main main = new Main();
        ILdapDao dao = main.getDao();
        LdapData data = new LdapData("ldap://localhost:10389");
        ContextHolder.INSTANCE.refreshLdapConfig(data);

//        System.out.println(dao.findByMacAddress("1,6,aa:aa:aa:aa:aa:02"));

        for (int i = 1; i < 10; i++) {
            MacEntry macEntry = new MacEntry();
            macEntry.setMacAddress("1,6,ff:ff:ff:ff:ff:f" + i);
            macEntry.setClientClassName("client10" + i);
            System.out.println(dao.create(macEntry));
        }

//        MacEntry macEntry = new MacEntry();
//        macEntry.setMacAddress("1,6,ff:ff:ff:ff:ff:f1");
//        macEntry.setClientClassName("client101");
//        dao.update(macEntry);

//        MacEntry macEntry = new MacEntry();
//        macEntry.setMacAddress("1,6,ff:ff:ff:ff:ff:f1");
//        dao.delete(macEntry);

        System.out.println(dao.getAll());

//        data = new LdapData("ldap://localhost:389");
//        ContextHolder.INSTANCE.refreshLdapConfig(data);
//        System.out.println(dao.getAll());
//
//        data = new LdapData("ldap://localhost:10389");
//        ContextHolder.INSTANCE.refreshLdapConfig(data);
//        System.out.println(dao.getAll());
//
//        data = new LdapData("ldap://localhost:389");
//        ContextHolder.INSTANCE.refreshLdapConfig(data);
//        System.out.println(dao.getAll());

    }

    public ILdapDao getDao() {
        return dao;
    }
}

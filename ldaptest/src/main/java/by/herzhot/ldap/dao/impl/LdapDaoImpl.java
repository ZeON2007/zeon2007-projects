package by.herzhot.ldap.dao.impl;

import by.herzhot.ldap.dao.ILdapDao;
import by.herzhot.ldap.entries.MacEntry;
import org.springframework.ldap.core.AttributesMapper;
import org.springframework.ldap.core.LdapTemplate;

import javax.naming.NamingException;
import javax.naming.directory.Attributes;
import java.util.Collections;
import java.util.List;

import static org.springframework.ldap.query.LdapQueryBuilder.query;

public abstract class LdapDaoImpl implements ILdapDao {

//    public List<String> getAll() {
//        List<String> list = getLdapTemplate().search(
//                query().where("objectclass").is("MACEntry"),
//                new AttributesMapper<String>() {
//                    @Override
//                    public String mapFromAttributes(Attributes attrs) throws NamingException {
//                        return ((String) attrs.get("macAddress").get()).replace("1,6,", "");
//                    }
//                });
//    Collections.sort(list);
//    return list;
//    }


    @Override
    public List<MacEntry> getAll() {
        return getLdapTemplate().findAll(MacEntry.class);
    }

    @Override
    public MacEntry findByMacAddress(String macAddress) {
        return getLdapTemplate().findOne(query().where("macAddress").is(macAddress), MacEntry.class);
    }

    @Override
    public MacEntry create(MacEntry macEntry) {
        getLdapTemplate().create(macEntry);
        return macEntry;
    }

    @Override
    public void update(MacEntry macEntry) {
        getLdapTemplate().update(macEntry);
    }

    @Override
    public void delete(MacEntry macEntry) {
        getLdapTemplate().delete(macEntry);
    }

    public abstract LdapTemplate getLdapTemplate();
}

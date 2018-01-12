package by.herzhot.ldap;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.net.URI;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;

public enum ContextHolder {

    INSTANCE;

//    private static String host = "ldap://localhost:10389";
    private static Integer number = 0;
    private static String host = "";
    //private static final String resourceName = "ldap-context.xml";
    private static ApplicationContext context; // = new ClassPathXmlApplicationContext("ldap-context.xml");
    static {
        try {
            number++;
            context = new ClassPathXmlApplicationContext("lldap-context.xml");
            if (context == null) throw new RuntimeException();
            System.out.println(number);
        } catch (Throwable t) {
            try {
                number++;
                context = new ClassPathXmlApplicationContext("lldap-context.xml");
                if (context == null) throw new RuntimeException();
                System.out.println(number);
            } catch (Throwable t1) {
                try {
                    number++;
                    ClassLoader classloader = Thread.currentThread().getContextClassLoader();
                    URL resourceURL = classloader.getResource("lldap-context.xml");
                    context = new ClassPathXmlApplicationContext(resourceURL.toString());
                    if (context == null) throw new RuntimeException();
                    System.out.println(number);
                } catch (Throwable t2) {
                    try {
                        number++;
                        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
                        URL resourceURL = classloader.getResource("ldap-context.xml");
                        URI resourceURI = resourceURL.toURI();
                        context = new ClassPathXmlApplicationContext(resourceURI.toString());
                        System.out.println(number);
                    } catch (Throwable t3) {
                        number++;
                        System.out.println(number);

                    }
                }
            }
        }
    }

    public void refreshLdapConfig(LdapData data) {
        host = data.getHost();
    }

    public static String getHost() {
        return host;
    }
    public ApplicationContext getContext() {
        return context;
    }
}

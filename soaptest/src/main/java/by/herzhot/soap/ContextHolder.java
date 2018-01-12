package by.herzhot.soap;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public enum ContextHolder {

    INSTANCE;

    private static ApplicationContext context = new ClassPathXmlApplicationContext("soap-context.xml");

    public static ApplicationContext getContext() {
        return context;
    }

}

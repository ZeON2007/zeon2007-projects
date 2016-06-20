package by.pvt.herzhot.loader;

import by.pvt.herzhot.pojos.Knight;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Herzhot
 * @version 1.0
 *          20.06.2016
 */
public class MainLoader {
    public static void main(String[] args) {

        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("META-INF/spring/knight.xml");
        Knight knight = context.getBean(Knight.class);
        knight.embarkOnQuest();
        context.close();

    }
}

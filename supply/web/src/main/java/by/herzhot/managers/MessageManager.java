package by.herzhot.managers;

import by.herzhot.constants.Configs;
import by.herzhot.constants.Parameters;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * @author Herzhot
 * @version 1.0
 *          08.05.2016
 */
public enum MessageManager {

    INSTANCE;

    public String getProperty(String key, HttpServletRequest request) {
        HttpSession session = request.getSession();
        Locale locale = (Locale) session.getAttribute(Parameters.LOCALE);
        return ResourceBundle.getBundle(Configs.MESSAGES_SOURCE, locale).getString(key);
    }
}

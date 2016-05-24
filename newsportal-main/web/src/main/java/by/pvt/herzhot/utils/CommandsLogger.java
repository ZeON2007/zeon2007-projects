package by.pvt.herzhot.utils;

import org.apache.log4j.Logger;

/**
 * @author Herzhot
 * @version 1.0
 *          08.05.2016
 */
public enum CommandsLogger {

    INSTANCE;

    private Logger logger;

    public void logError(Class sender, String message) {
        logger = Logger.getLogger(sender);
        logger.error(message);
    }

}

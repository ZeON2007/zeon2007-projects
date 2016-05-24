package by.pvt.herzhot.commands.news;

import by.pvt.herzhot.commands.AbstractCommand;
import by.pvt.herzhot.constants.ConfigConstants;
import by.pvt.herzhot.managers.impl.ConfigManagerImpl;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Herzhot
 * @version 1.0
 *          22.05.2016
 */
public class AddNewsPageCommand extends AbstractCommand {

    @Override
    public String execute(HttpServletRequest request) {
        return ConfigManagerImpl.INSTANCE.getProperty(ConfigConstants.ADD_NEWS_PAGE_PATH);
    }
}

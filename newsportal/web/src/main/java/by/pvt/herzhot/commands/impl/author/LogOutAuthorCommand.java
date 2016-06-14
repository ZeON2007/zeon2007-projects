package by.pvt.herzhot.commands.impl.author;

import by.pvt.herzhot.commands.AbstractCommand;
import by.pvt.herzhot.constants.ConfigConstants;
import by.pvt.herzhot.managers.ConfigManagerImpl;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Herzhot
 * @version 1.0
 *          10.05.2016
 */
public class LogOutAuthorCommand extends AbstractCommand {

    @Override
    public String execute(HttpServletRequest request) {
        request.getSession().invalidate();
        return ConfigManagerImpl.INSTANCE.getProperty(ConfigConstants.LOGIN_PAGE_PATH);
    }
}

package by.pvt.herzhot.commands.author;

import by.pvt.herzhot.commands.AbstractCommand;
import by.pvt.herzhot.constants.ConfigConstants;
import by.pvt.herzhot.managers.impl.ConfigManagerImpl;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Herzhot
 * @version 1.0
 *          22.05.2016
 */
public class LoginPageCommand extends AbstractCommand {

    @Override
    public String execute(HttpServletRequest request) {
        return ConfigManagerImpl.INSTANCE.getProperty(ConfigConstants.LOGIN_PAGE_PATH);
    }
}

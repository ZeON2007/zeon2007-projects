package by.pvt.herzhot.commands.impl.author;

import by.pvt.herzhot.commands.AbstractCommand;
import by.pvt.herzhot.constants.ConfigConstants;
import by.pvt.herzhot.managers.ConfigManagerImpl;
import by.pvt.herzhot.util.ContentGenerator;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Herzhot
 * @version 1.0
 *          22.05.2016
 */
public class LoginPageCommand extends AbstractCommand {

    @Override
    public String execute(HttpServletRequest request) {
//        new ContentGenerator().generate();
        return ConfigManagerImpl.INSTANCE.getProperty(ConfigConstants.LOGIN_PAGE_PATH);
    }
}

package by.pvt.herzhot.commands.factory;

import by.pvt.herzhot.commands.ICommand;
import by.pvt.herzhot.commands.news.MainPageCommand;
import by.pvt.herzhot.constants.Parameters;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Herzhot
 * @version 1.0
 *          09.05.2016
 */
public enum CommandFactory {

    INSTANCE;

    public ICommand defineCommand(HttpServletRequest request) {

        String commandName = request.getParameter(Parameters.COMMAND);
        if (commandName == null) return new MainPageCommand();

        for (CommandType c : CommandType.values()) {
            if (c.name().equals(commandName.toUpperCase())) {
                return c.valueOf(commandName.toUpperCase()).getCurrentCommand();
            }
        }
        return new MainPageCommand();
    }
}

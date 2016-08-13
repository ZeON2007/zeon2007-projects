package by.herzhot.commands;

import by.herzhot.commands.impl.GotoMainPage;
import by.herzhot.commands.impl.StartSession;
import by.herzhot.constants.Parameters;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author Herzhot
 * @version 1.0
 *          10.08.2016
 */
public enum CommandFactory {

    INSTANCE;

    public ICommand defineCommand(HttpServletRequest request) {

        ICommand command = null;
        String commandName = request.getParameter(Parameters.COMMAND);
        HttpSession session = request.getSession();

        if (commandName == null) {
            command = new StartSession();
        } else {
            for (CommandType c : CommandType.values()) {
                if (c.name().equals(commandName.toUpperCase())) {
                    session.setAttribute(Parameters.LAST_COMMAND, commandName);
                    command = CommandType.valueOf(commandName.toUpperCase()).getCurrentCommand();
                }
            }
        }

        return command != null ? command : new GotoMainPage();
    }
}

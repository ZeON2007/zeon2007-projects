package by.pvt.herzhot.commands.factory;

import by.pvt.herzhot.commands.ICommand;
import by.pvt.herzhot.commands.impl.news.MainPageCommand;
import by.pvt.herzhot.constants.Parameters;
import by.pvt.herzhot.util.Paginator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Locale;

/**
 * @author Herzhot
 * @version 1.0
 *          09.05.2016
 */
public enum CommandFactory {

    INSTANCE;

    public ICommand defineCommand(HttpServletRequest request) {

        HttpSession session = request.getSession();
        ICommand command = null;
        String commandName = request.getParameter(Parameters.COMMAND);

        if (commandName == null) {
            command = new MainPageCommand();
            session.setAttribute(Parameters.PREVIOUS_COMMAND, CommandType.GOTOMAINPAGE.name());
            commandName = "";
        } else {
            for (CommandType c : CommandType.values()) {
                if (c.name().equals(commandName.toUpperCase()) && !c.name().equals("UPDATEPAGE")) {
                    command = c.valueOf(commandName.toUpperCase()).getCurrentCommand();
                    session.setAttribute(Parameters.PREVIOUS_COMMAND, c.name());
                }
            }
        }

        if (commandName.equals("updatePage")) {
            if (request.getParameter(Parameters.QUANTITY_PER_PAGE) != null) {

                Paginator.INSTANCE.update(request);

            } else if (request.getParameter(Parameters.SELECTED_PAGE) != null) {

                Paginator.INSTANCE.update(request);

            } else if (request.getParameter(Parameters.LANGUAGE) != null) {

                String language = request.getParameter(Parameters.LANGUAGE);
                if (language.equals("ru")) {
                    session.setAttribute(Parameters.LOCALE, new Locale("ru", "RU"));
                }
                if (language.equals("en")) {
                    session.setAttribute(Parameters.LOCALE, new Locale("en", "US"));
                }

            }
            String previousCommandName = (String) session.getAttribute(Parameters.PREVIOUS_COMMAND);
            if (previousCommandName.equals(CommandType.ADDNEWS.name())
                    || previousCommandName.equals(CommandType.DELETENEWS.name())) {
                previousCommandName = CommandType.LOGIN.name();
            }
            command = CommandType.valueOf(previousCommandName).getCurrentCommand();
        }

        return command != null ? command : new MainPageCommand();
    }
}

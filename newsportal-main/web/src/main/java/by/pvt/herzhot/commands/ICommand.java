package by.pvt.herzhot.commands;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Herzhot
 * @version 1.0
 *          09.05.2016
 */
public interface ICommand {

    String execute(HttpServletRequest request);

}

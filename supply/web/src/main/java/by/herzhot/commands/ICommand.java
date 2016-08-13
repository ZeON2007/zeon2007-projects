package by.herzhot.commands;

import by.herzhot.IService;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @author Herzhot
 * @version 1.0
 *          10.08.2016
 */
public interface ICommand {

    String execute(HttpServletRequest request, Map<String, IService> services);

}

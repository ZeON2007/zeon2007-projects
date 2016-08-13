package by.herzhot.commands.impl;

import by.herzhot.IMaterialService;
import by.herzhot.IService;
import by.herzhot.commands.ICommand;
import by.herzhot.constants.Messages;
import by.herzhot.constants.Parameters;
import by.herzhot.constants.Paths;
import by.herzhot.exceptions.ServiceException;
import by.herzhot.managers.MessageManager;
import by.herzhot.managers.PathManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Map;

/**
 * @author Herzhot
 * @version 1.0
 *          13.08.2016
 */
public class FindMaterials implements ICommand {

    @Override
    public String execute(HttpServletRequest request, Map<String, IService> services) {

        IMaterialService materialService = (IMaterialService) services.get("materialService");
        String page = PathManager.INSTANCE.getProperty(Paths.MAIN_PAGE_PATH);
        HttpSession session = request.getSession();
        String criterion = request.getParameter(Parameters.CRITERION);

        try {

            criterion = URLDecoder.decode(criterion, "UTF-8");
            session.setAttribute(Parameters.CRITERION, criterion);
            session.setAttribute(Parameters.MATERIAL_LIST, materialService.findByCriterion(criterion));

        } catch (ServiceException e) {
            request.setAttribute(Parameters.ERROR_DATABASE,
                    MessageManager.INSTANCE.getProperty(Messages.ERROR_DATABASE, request));
            page = PathManager.INSTANCE.getProperty(Paths.ERROR_PAGE_PATH);
        } catch (UnsupportedEncodingException e) {
            request.setAttribute(Parameters.ERROR_CRITERION,
                    MessageManager.INSTANCE.getProperty(Messages.ERROR_CRITERION, request));
            page = PathManager.INSTANCE.getProperty(Paths.ERROR_PAGE_PATH);
        }

        return page;
    }
}

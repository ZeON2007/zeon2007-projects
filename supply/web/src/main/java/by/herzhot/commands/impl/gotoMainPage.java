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
import by.herzhot.utils.MenuHelper;
import by.herzhot.utils.Paginator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @author Herzhot
 * @version 1.0
 *          10.08.2016
 */
public class GotoMainPage implements ICommand {


    @Override
    public String execute(HttpServletRequest request, Map<String, IService> services) {

        IMaterialService materialService = (IMaterialService) services.get("materialService");
        String page = PathManager.INSTANCE.getProperty(Paths.MAIN_PAGE_PATH);
        HttpSession session = request.getSession();
        Paginator paginator = Paginator.INSTANCE;
        MenuHelper menuHelper = MenuHelper.INSTANCE;
        Map<String, Integer> paginationParams;

        try {
            paginationParams = paginator.update(request, materialService.count());
            session.setAttribute(Parameters.PAGINATION_PARAMS, paginationParams);
            session.setAttribute(Parameters.PAGINATION_MENU, menuHelper.createStringMenu(paginationParams));

            session.removeAttribute(Parameters.CRITERION);
            session.setAttribute(Parameters.MATERIAL_LIST, materialService.readAll(paginationParams));

        } catch (ServiceException e) {
            request.setAttribute(Parameters.ERROR_DATABASE,
                    MessageManager.INSTANCE.getProperty(Messages.ERROR_DATABASE, request));
            page = PathManager.INSTANCE.getProperty(Paths.ERROR_PAGE_PATH);
        }
        return page;
    }
}

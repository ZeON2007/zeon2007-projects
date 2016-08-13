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
import java.util.Map;

/**
 * @author Herzhot
 * @version 1.0
 *          10.08.2016
 */
public class GotoEditMaterialPage implements ICommand {

    @Override
    public String execute(HttpServletRequest request, Map<String, IService> services) {

        IMaterialService materialService = (IMaterialService) services.get("materialService");
        String page = PathManager.INSTANCE.getProperty(Paths.EDIT_MATERIAL_PAGE_PATH);
        String selectedItem = request.getParameter(Parameters.SELECTED_ITEM);
        if (selectedItem != null) {
            Long id = Long.valueOf(selectedItem);
            try {
                request.setAttribute(Parameters.MATERIAL, materialService.read(id));
            } catch (ServiceException e) {
                request.setAttribute(Parameters.ERROR_DATABASE,
                        MessageManager.INSTANCE.getProperty(Messages.ERROR_DATABASE, request));
                page = PathManager.INSTANCE.getProperty(Paths.ERROR_PAGE_PATH);
            }
        }
        return page;
    }
}

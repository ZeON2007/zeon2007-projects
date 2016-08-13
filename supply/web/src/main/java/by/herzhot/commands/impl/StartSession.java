package by.herzhot.commands.impl;

import by.herzhot.*;
import by.herzhot.commands.ICommand;
import by.herzhot.constants.Messages;
import by.herzhot.constants.Parameters;
import by.herzhot.constants.Paths;
import by.herzhot.exceptions.ServiceException;
import by.herzhot.managers.MessageManager;
import by.herzhot.managers.PathManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/**
 * @author Herzhot
 * @version 1.0
 *          12.08.2016
 */
public class StartSession implements ICommand {

    @Override
    public String execute(HttpServletRequest request, Map<String, IService> services) {

        String page = PathManager.INSTANCE.getProperty(Paths.MAIN_PAGE_PATH);
        HttpSession session = request.getSession();
        String lastCommand = (String) session.getAttribute(Parameters.LAST_COMMAND);

        if (lastCommand == null) {
            ISupplierService supplierService = (ISupplierService) services.get("supplierService");
            IMaterialService materialService = (IMaterialService) services.get("materialService");
            session.setAttribute(Parameters.LOCALE, new Locale("ru", "RU"));
            session.setAttribute(Parameters.CATEGORY, "materials");
            try {

                List<Supplier> suppliers = supplierService.readAll();
                session.setAttribute(Parameters.SUPPLIER_LIST, suppliers);
                List<Material> materials = materialService.readAll();
                session.setAttribute(Parameters.MATERIAL_LIST, materials);

            } catch (ServiceException e) {
                request.setAttribute(Parameters.ERROR_DATABASE,
                        MessageManager.INSTANCE.getProperty(Messages.ERROR_DATABASE, request));
                page = PathManager.INSTANCE.getProperty(Paths.ERROR_PAGE_PATH);
            }
        }
        return page;
    }
}

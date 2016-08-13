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
import java.util.Map;

/**
 * @author Herzhot
 * @version 1.0
 *          10.08.2016
 */
public class EditMaterial implements ICommand {

    @Override
    public String execute(HttpServletRequest request, Map<String, IService> services) {

        String page = null;
        Supplier supplier = null;
        Material material = new Material();
        Integer materialPrice = null;
        Long supplierId = null;
        ISupplierService supplierService = (ISupplierService) services.get("supplierService");
        IMaterialService materialService = (IMaterialService) services.get("materialService");
        String selectedItem = request.getParameter(Parameters.SELECTED_ITEM);

        String stringSupplierId = request.getParameter(Parameters.SUPPLIER_ID);
        if (stringSupplierId != null && !stringSupplierId.equals("")) {
            supplierId = Long.valueOf(stringSupplierId);
        }

        String stringMaterialPrice = request.getParameter(Parameters.MATERIAL_PRICE);
        if (stringMaterialPrice != null
                && !stringMaterialPrice.equals("")
                && Integer.valueOf(stringMaterialPrice) > 0) {
            materialPrice = Integer.valueOf(stringMaterialPrice);
        }

        try {
            if (supplierId != null) {
                supplier = supplierService.read(supplierId);
            }

            material.setName(request.getParameter(Parameters.MATERIAL_NAME));
            if (materialPrice != null) {
                material.setPrice(materialPrice);
            }
            material.setSupplier(supplier);
            if (selectedItem == null || selectedItem.equals("")) {
                materialService.create(material);
            } else {
                material.setId(Long.valueOf(selectedItem));
                materialService.update(material);
            }
            request.getSession().setAttribute(Parameters.MATERIAL_LIST, materialService.readAll());

        } catch (ServiceException e) {
            request.setAttribute(Parameters.ERROR_DATABASE,
                    MessageManager.INSTANCE.getProperty(Messages.ERROR_DATABASE, request));
            page = PathManager.INSTANCE.getProperty(Paths.ERROR_PAGE_PATH);
        }

        return page;
    }
}

package by.herzhot.commands.impl;

import by.herzhot.*;
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
public class EditMaterial implements ICommand {

    @Override
    public String execute(HttpServletRequest request, Map<String, IService> services) {

        String page = PathManager.INSTANCE.getProperty(Paths.INDEX_PAGE_PATH);
        HttpSession session = request.getSession();
        Paginator paginator = Paginator.INSTANCE;
        MenuHelper menuHelper = MenuHelper.INSTANCE;
        Map<String, Integer> paginationParams;
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
        if (priceValidate(stringMaterialPrice)) {
            if (stringMaterialPrice != null && !stringMaterialPrice.equals("")) {
                materialPrice = Integer.valueOf(stringMaterialPrice);
            }
        } else {
            request.setAttribute(Parameters.ERROR_INPUT,
                    MessageManager.INSTANCE.getProperty(Messages.ERROR_INPUT, request));
            page = PathManager.INSTANCE.getProperty(Paths.EDIT_MATERIAL_PAGE_PATH);
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
            if (priceValidate(stringMaterialPrice)) {
                if (selectedItem == null || selectedItem.equals("")) {
                    materialService.create(material);
                } else {
                    material.setId(Long.valueOf(selectedItem));
                    materialService.update(material);
                }
                paginationParams = paginator.update(request, materialService.count());
                session.setAttribute(Parameters.PAGINATION_PARAMS, paginationParams);
                session.setAttribute(Parameters.PAGINATION_MENU, menuHelper.createStringMenu(paginationParams));
                session.setAttribute(Parameters.MATERIAL_LIST, materialService.readAll(paginationParams));
            } else {
                request.setAttribute(Parameters.MATERIAL, material);
            }
        } catch (ServiceException e) {
            request.setAttribute(Parameters.ERROR_DATABASE,
                    MessageManager.INSTANCE.getProperty(Messages.ERROR_DATABASE, request));
            page = PathManager.INSTANCE.getProperty(Paths.ERROR_PAGE_PATH);
        }
        session.removeAttribute(Parameters.CRITERION);
        return page;
    }

    private boolean priceValidate(String price) {
        boolean success = false;
        if (price != null && !price.equals("")) {
            try {
                Integer priceValue = Integer.valueOf(price);
                if (priceValue > 0) {
                    success = true;
                }
            } catch (NumberFormatException e) {
                    success = false;
            }
        } else {
            success = true;
        }
        return success;
    }
}

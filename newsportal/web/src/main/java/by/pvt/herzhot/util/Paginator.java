package by.pvt.herzhot.util;

import by.pvt.herzhot.constants.Parameters;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Herzhot
 * @version 1.0
 *          12.06.2016
 */
public enum Paginator {

    INSTANCE;

    public Map<String, Integer> update(HttpServletRequest request) {

        HttpSession session = request.getSession();

        Map<String, Integer> paginationParams =
                (Map<String, Integer>) session.getAttribute(Parameters.PAGINATION_PARAMS);

        if (paginationParams == null) {
            paginationParams = new HashMap<>();
            paginationParams.put(Parameters.TOTAL_PAGES_QUANTITY, 5);
            paginationParams.put(Parameters.QUANTITY_PER_PAGE, 5);
            paginationParams.put(Parameters.SELECTED_PAGE, 1);
            session.setAttribute(Parameters.PAGINATION_PARAMS, paginationParams);
        }

        if (request.getParameter(Parameters.QUANTITY_PER_PAGE) != null) {
            int quantityPerPage =  Integer.valueOf(request
                    .getParameter(Parameters.QUANTITY_PER_PAGE));

            paginationParams.replace(Parameters.QUANTITY_PER_PAGE, quantityPerPage);
            paginationParams.replace(Parameters.SELECTED_PAGE, 1);
            session.setAttribute(Parameters.PAGINATION_PARAMS, paginationParams);
        }

        if (request.getParameter(Parameters.SELECTED_PAGE) != null) {
            int selectedPage = Integer.valueOf(request
                    .getParameter(Parameters.SELECTED_PAGE));

            paginationParams.replace(Parameters.SELECTED_PAGE, selectedPage);
            session.setAttribute(Parameters.PAGINATION_PARAMS, paginationParams);
        }
        if (session.getAttribute(Parameters.TOTAL_PAGES_QUANTITY) != null) {
            int totalQuantity = Integer.valueOf(session
                    .getAttribute(Parameters.TOTAL_PAGES_QUANTITY).toString());

            paginationParams.replace(Parameters.TOTAL_PAGES_QUANTITY, totalQuantity);
            session.setAttribute(Parameters.PAGINATION_PARAMS, paginationParams);
        }

        generateStringMenu(paginationParams, request);

        return paginationParams;
    }
    private void generateStringMenu(Map<String, Integer> paginationParams, HttpServletRequest request) {
        int maxMenuSize = 11;
        int selected = paginationParams.get(Parameters.SELECTED_PAGE);
        int quantity = paginationParams.get(Parameters.QUANTITY_PER_PAGE);
        int count = paginationParams.get(Parameters.TOTAL_PAGES_QUANTITY);
        List<Integer> menuItems = new ArrayList<>();

        int pages = count /quantity;
        int currentMenuSize;

        if (count%quantity == 0) {
            currentMenuSize = pages;
        } else {
            currentMenuSize = pages + 1;
        }

        if (currentMenuSize <= maxMenuSize) {
            for (int i = 1; i <= currentMenuSize; i++ ) {
                menuItems.add(i);
            }
        } else {
            if (selected <= 5) {
                for (int i = 1; i <= maxMenuSize-1; i++ ) {
                    menuItems.add(i);
                }
                menuItems.add(currentMenuSize);
            } else if (selected >= currentMenuSize - 4) {
                menuItems.add(1);
                for (int j = currentMenuSize - (maxMenuSize - 2) ; j <= currentMenuSize; j++ ) {
                    menuItems.add(j);
                }
            } else {
                menuItems.add(1);
                for (int i = selected - 4; i <= selected + 4; i++ ) {
                    menuItems.add(i);
                }
                menuItems.add(currentMenuSize);
            }
        }
        request.getSession().setAttribute(Parameters.PAGINATION_MENU, menuItems);
    }
}
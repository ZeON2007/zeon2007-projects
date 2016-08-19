package by.herzhot.utils;

import by.herzhot.constants.Parameters;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Herzhot
 * @version 1.0
 *          16.08.2016
 */
public enum Paginator {

    INSTANCE;

    public Map<String, Integer> update(HttpServletRequest request, Long count) {

        Map<String, Integer> paginationParams =
                (Map<String, Integer>) request.getSession().getAttribute(Parameters.PAGINATION_PARAMS);

        if (request.getParameter(Parameters.QUANTITY_PER_PAGE) != null) {
            int quantityPerPage =  Integer.valueOf(request
                    .getParameter(Parameters.QUANTITY_PER_PAGE));

            paginationParams.put(Parameters.QUANTITY_PER_PAGE, quantityPerPage);
            paginationParams.put(Parameters.SELECTED_PAGE, 1);
        }

        if (request.getParameter(Parameters.SELECTED_PAGE) != null) {
            int selectedPage = Integer.valueOf(request
                    .getParameter(Parameters.SELECTED_PAGE));

            paginationParams.put(Parameters.SELECTED_PAGE, selectedPage);
        } else {
            paginationParams.put(Parameters.SELECTED_PAGE, 1);
        }

        paginationParams.put(Parameters.TOTAL_PAGES_QUANTITY, count.intValue());

        return paginationParams;
    }
}

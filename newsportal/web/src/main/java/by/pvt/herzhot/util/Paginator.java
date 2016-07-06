package by.pvt.herzhot.util;

import by.pvt.herzhot.constants.Parameters;
import org.springframework.stereotype.Component;

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
@Component
public class Paginator {

    public Paginator() {}

    public Map<String, Integer> update(HttpServletRequest request, int count) {

        HttpSession session = request.getSession();
        Map<String, Integer> paginationParams =
                (Map<String, Integer>) session.getAttribute(Parameters.PAGINATION_PARAMS);

        if (paginationParams == null) {
            paginationParams = new HashMap<>();
            paginationParams.put(Parameters.TOTAL_PAGES_QUANTITY, 5);
            paginationParams.put(Parameters.QUANTITY_PER_PAGE, 5);
            paginationParams.put(Parameters.SELECTED_PAGE, 1);
        }

        if (request.getParameter(Parameters.QUANTITY_PER_PAGE) != null) {
            int quantityPerPage =  Integer.valueOf(request
                    .getParameter(Parameters.QUANTITY_PER_PAGE));

            paginationParams.replace(Parameters.QUANTITY_PER_PAGE, quantityPerPage);
            paginationParams.replace(Parameters.SELECTED_PAGE, 1);
        }

        if (request.getParameter(Parameters.SELECTED_PAGE) != null) {
            int selectedPage = Integer.valueOf(request
                    .getParameter(Parameters.SELECTED_PAGE));

            paginationParams.replace(Parameters.SELECTED_PAGE, selectedPage);
        } else {
            paginationParams.replace(Parameters.SELECTED_PAGE, 1);
        }

        paginationParams.replace(Parameters.TOTAL_PAGES_QUANTITY, count);

        return paginationParams;
    }
}

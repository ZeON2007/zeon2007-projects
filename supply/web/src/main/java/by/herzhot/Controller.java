package by.herzhot;

import by.herzhot.exceptions.ServiceException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Herzhot
 * @version 1.0
 *          03.08.2016
 */
@WebServlet(urlPatterns = "/servlet")
public class Controller extends HttpServlet {

    @Inject
    ISupplierService supplierService;

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



        try {


//            service.create(new Material("test1", null, null));
            Supplier supplier = supplierService.read(3L);

            request.getSession().setAttribute("material", supplier);

        } catch (ServiceException e) {
            System.out.println("--------ERROR------------:" + e);
        }

        RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/index.jsp");
        dispatcher.forward(request, response);

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }


}

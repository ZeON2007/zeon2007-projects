package by.herzhot.controller;

import by.herzhot.IMaterialService;
import by.herzhot.IService;
import by.herzhot.ISupplierService;
import by.herzhot.commands.CommandFactory;
import by.herzhot.commands.ICommand;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Herzhot
 * @version 1.0
 *          03.08.2016
 */
@WebServlet(urlPatterns = "/controller")
public class FrontController extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private Map<String, IService> services;
    @Inject
    private IMaterialService materialService;
    @Inject
    private ISupplierService supplierService;


    @Override
    public void init() throws ServletException {
        super.init();
        services = new HashMap<>();
        services.put("materialService", materialService);
        services.put("supplierService", supplierService);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ICommand command = CommandFactory.INSTANCE.defineCommand(request);
        String page = command.execute(request, services);

        if (page != null) {
            RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher(page);
            dispatcher.forward(request, response);
        } else {
            response.sendRedirect(request.getContextPath() + "/index.jsp");
        }
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

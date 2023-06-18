package Servlet;

import Controller.LabActions;
import Model.LabOrder;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

public class GenerateLabOrder extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String petId = request.getParameter("petId");
        String orderDetails = request.getParameter("orderDetails");

        LabOrder labOrder = new LabOrder();
        labOrder.setPetId(Integer.parseInt(petId));
        labOrder.setOrderDetails(orderDetails);

        int status = LabActions.generateLabOrder(labOrder);
        if (status > 0) {
            response.sendRedirect("LabOrderGenerated.jsp");
        } else {
            response.sendRedirect("error.jsp");
        }
    }
}

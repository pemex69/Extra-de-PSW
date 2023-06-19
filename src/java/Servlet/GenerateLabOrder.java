package Servlet;

import Controller.LabActions;
import Model.LabOrder;
import Model.PetHistory;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GenerateLabOrder
 */
public class GenerateLabOrder extends HttpServlet {

    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public GenerateLabOrder() {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Handle GET request if needed
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            // Get parameters from the form
            int petId = Integer.parseInt(request.getParameter("petId"));
            String orderDetails = request.getParameter("orderDetails");

            String consultationNotes = request.getParameter("consultationNotes");
            String consultationTreatment = request.getParameter("consultationTreatment");

            //insert the pethistory thingy . . .
            
            PetHistory ph = new PetHistory();
            ph.setConsultationNotes(consultationNotes);
            ph.setConsultationTreatment(consultationTreatment);
            
            // Create a LabOrder object
            LabOrder labOrder = new LabOrder();
            labOrder.setPetId(petId);
            labOrder.setOrderDetails(orderDetails);

            // Save the LabOrder
            int status = LabActions.generateLabOrder(labOrder, ph);

            if (status > 0) {
                // Success: Redirect to a success page
                response.sendRedirect("vetPetHistory.jsp?petId=" + petId);
            } else {
                // Error: Redirect to an error page
                response.sendRedirect("LabOrderError.jsp");
            }
        }
    }
}

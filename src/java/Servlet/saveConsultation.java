package Servlet;

import Controller.ConsultationActions;
import Model.Consultation;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class saveConsultation extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            String petId = request.getParameter("petId");
            String veterinarian = request.getParameter("veterinarian");
            String consultationDate = request.getParameter("consultationDate");
            String consultationDetails = request.getParameter("consultationDetails");

            Consultation consultation = new Consultation();
            consultation.setPetId(Integer.parseInt(petId));
            consultation.setVeterinarian(veterinarian);
            consultation.setConsultationDate(consultationDate);
            consultation.setConsultationDetails(consultationDetails);

            int status = ConsultationActions.registerConsultation(consultation);
            if (status > 0) {
                response.sendRedirect("ConsultationSaved.jsp");
            } else {
                response.sendRedirect("error.jsp");
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}

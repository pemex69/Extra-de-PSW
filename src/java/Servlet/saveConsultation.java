package Servlet;

import Controller.ConsultationActions;
import Model.Consultation;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/saveConsultation2")
public class saveConsultation extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int vetId = Integer.parseInt(request.getParameter("vetId"));
        int petId = Integer.parseInt(request.getParameter("petId"));
        String consultationDate = request.getParameter("consultationDate");
        String consultationNotes = request.getParameter("consultationNotes");
        String consultationTreatment = request.getParameter("consultationTreatment");

        Consultation consultation = new Consultation();
        consultation.setVetId(vetId);
        consultation.setPetId(petId);
        consultation.setConsultationDate(consultationDate);
        consultation.setConsultationNotes(consultationNotes);
        consultation.setConsultationTreatment(consultationTreatment);

        ConsultationActions consultationController = new ConsultationActions();
        boolean success = consultationController.addConsultation(consultation);

        if (success) {
            response.sendRedirect("vetPetHistory.jsp?petId=" + petId);
        } else {
            response.sendRedirect("error.jsp");
        }
    }
}

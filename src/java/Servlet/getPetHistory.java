package Servlet;

import Controller.PetActions;
import Model.PetHistory;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class getPetHistory extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json");
        try ( PrintWriter out = response.getWriter()) {
            int petId = Integer.parseInt(request.getParameter("petId"));

            ArrayList<PetHistory> petHistory = PetActions.getPetHistoryByPetId(petId);

            StringBuilder json = new StringBuilder();
            json.append("[");
            for (int i = 0; i < petHistory.size(); i++) {
                PetHistory pet = petHistory.get(i);
                json.append("{");
                json.append("\"historyId\":").append(pet.getHistoryId()).append(",");
                json.append("\"petId\":").append(pet.getPetId()).append(",");
                json.append("\"consultationDate\":\"").append(pet.getConsultationDate()).append("\",");
                json.append("\"consultationNotes\":\"").append(pet.getConsultationNotes()).append("\",");
                json.append("\"consultationTreatment\":\"").append(pet.getConsultationTreatment()).append("\",");
                json.append("\"petLabHistory\":\"").append(pet.getPetLabHistory()).append("\"");
                json.append("}");
                if (i < petHistory.size() - 1) {
                    json.append(",");
                }
            }
            json.append("]");

            out.println(json.toString());
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

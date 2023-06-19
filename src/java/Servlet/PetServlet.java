package Servlet;

import Controller.AppointmentActions;
import Controller.PetActions;
import Model.Pet;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;

public class PetServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            String action = request.getParameter("action");
            if (action != null) {
                switch (action) {
                    case "add":
                        addPet(request, response);
                        break;
                    case "edit":
                        editPet(request, response);
                        break;
                    case "update":
                        updatePet(request, response);
                        break;
                    case "delete":
                        deletePet(request, response);
                        break;
                    default:
                        response.sendRedirect("error.jsp");
                        break;
                }
            } else {
                response.sendRedirect("error.jsp");
            }
        }
    }

    protected void addPet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String petName = request.getParameter("petName");
        String petSpecies = request.getParameter("petSpecies");
        String petRace = request.getParameter("petRace");
        float petWeight = Float.parseFloat(request.getParameter("petWeight"));
        String petHealthState = request.getParameter("petHealthState");
        int clientId = Integer.parseInt(request.getParameter("clientId"));

        Pet pet = new Pet();
        pet.setPetName(petName);
        pet.setPetSpecies(petSpecies);
        pet.setPetRace(petRace);
        pet.setPetWeight(petWeight);
        pet.setPetHealthState(petHealthState);
        pet.setClientId(clientId);

        int status = PetActions.addPet(pet);
        if (status > 0) {
            response.sendRedirect("agenda.jsp");
        } else {
            response.sendRedirect("error.jsp");
        }
    }

    protected void editPet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int petId = Integer.parseInt(request.getParameter("petId"));
        Pet pet = PetActions.getPetById(petId);
        request.setAttribute("pet", pet);
        request.getRequestDispatcher("editPet.jsp").forward(request, response);
    }

    protected void updatePet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int petId = Integer.parseInt(request.getParameter("petId"));
        String petName = request.getParameter("petName");
        String petSpecies = request.getParameter("petSpecies");
        String petRace = request.getParameter("petRace");
        float petWeight = Float.parseFloat(request.getParameter("petWeight"));
        String petHealthState = request.getParameter("petHealthState");
        int clientId = Integer.parseInt(request.getParameter("clientId"));

        Pet pet = new Pet();
        pet.setPetId(petId);
        pet.setPetName(petName);
        pet.setPetSpecies(petSpecies);
        pet.setPetRace(petRace);
        pet.setPetWeight(petWeight);
        pet.setPetHealthState(petHealthState);
        pet.setClientId(clientId);

        int status = PetActions.updatePet(pet);
        if (status > 0) {
            response.sendRedirect("allPets.jsp?clientId=" + clientId);
        } else {
            response.sendRedirect("error.jsp");
        }
    }

    protected void deletePet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int petId = Integer.parseInt(request.getParameter("petId"));
        int clientId = Integer.parseInt(request.getParameter("clientId"));

        // Eliminate appointments related to the pet
        int deleteAppointmentsStatus = AppointmentActions.deleteAppointmentsByPetId(petId);

        // Eliminate consultations related to the pet
        int deleteConsultationsStatus = AppointmentActions.deleteConsultationsByPetId(petId);

        // Eliminate lab orders related to the pet
        int deleteLabOrdersStatus = AppointmentActions.deleteLabOrdersByPetId(petId);

        // Eliminate pet's history
        int deletePetHistoryStatus = PetActions.deletePetHistoryByPetId(petId);

        // Check if appointments, consultations, lab orders, and pet history were deleted successfully
        if (deleteAppointmentsStatus >= 0 && deleteConsultationsStatus >= 0 && deleteLabOrdersStatus >= 0 && deletePetHistoryStatus >= 0) {
            // Appointments, consultations, lab orders, and pet history were deleted successfully or there were no associated records

            // Delete the pet
            int deletePetStatus = PetActions.deletePet(petId);

            if (deletePetStatus > 0) {
                response.sendRedirect("allPets.jsp?clientId=" + clientId);
            } else {
                response.sendRedirect("error.jsp");
            }
        } else {
            // An error occurred while deleting appointments, consultations, lab orders, or pet history
            response.sendRedirect("error.jsp");
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
        return "CRUD Operations for Pets";
    }
}

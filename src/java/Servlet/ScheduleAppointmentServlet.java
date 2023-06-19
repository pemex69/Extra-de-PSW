package Servlet;

import Controller.AppointmentActions;
import Model.Appointment;
import Model.Client;
import Model.DatabaseConnection;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.*;

/**
 *
 * @author que
 */
public class ScheduleAppointmentServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {

            HttpSession session = request.getSession(false); // Pass false to getSession() to prevent creating a new session if it doesn't exist
            String client = null;

            if (session != null) {
                client = (String) session.getAttribute("clientName");
            }

            if (client == null) {
                response.sendRedirect("login.html"); // Redirige al usuario a la página de inicio de sesión si no hay sesión activa
            } else {
                String petName = request.getParameter("petName");
                String appointmentDateStr = request.getParameter("appointmentDate");
                Date appointmentDate = new SimpleDateFormat("yyyy-MM-dd").parse(appointmentDateStr);
                String appointmentNotes = request.getParameter("appointmentNotes");
                int clientId = Integer.parseInt(request.getParameter("clientId"));

                int petId;

                Connection con = DatabaseConnection.getConnection();
                String getPetIdByClientIdAndPetNameQuery = "SELECT petId FROM Pets WHERE clientId = ? AND petName = ?";
                PreparedStatement ps = con.prepareStatement(getPetIdByClientIdAndPetNameQuery);
                ps.setInt(1, clientId);
                ps.setString(2, petName);
                ResultSet rs = ps.executeQuery();
                petId = 0;
                if (rs.next()) {
                    petId = rs.getInt("petId");
                }

                Appointment appointment = new Appointment();
                appointment.setClientId(clientId);
                appointment.setPetId(petId);
                appointment.setAppointmentDate(appointmentDate);
                appointment.setAppointmentNotes(appointmentNotes);

                int status = AppointmentActions.scheduleAppointment(appointment);
                if (status > 0) {
                    response.sendRedirect("appointments.jsp"); // Redirige al usuario a la página de citas después de agendar la cita
                } else {
                    response.sendRedirect("error.jsp"); // Redirige al usuario a una página de error si no se pudo agendar la cita
                }
            }
        } catch (Exception ex) {
            Logger.getLogger("error: " + ex);
            System.out.println("error. . . : " + ex);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

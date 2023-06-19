package Controller;

import Model.Appointment;
import Model.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;

public class AppointmentActions {

    public static int scheduleAppointment(Appointment appointment) {
        int status = 0;
        try {
            Connection con = DatabaseConnection.getConnection();
            String insertQuery = "INSERT INTO Appointments (clientId, petId, appointmentDate, appointmentNotes) "
                    + "VALUES (?, ?, ?, ?)";

            PreparedStatement ps = con.prepareStatement(insertQuery);
            ps.setInt(1, appointment.getClientId());
            ps.setInt(2, appointment.getPetId());
            ps.setTimestamp(3, new java.sql.Timestamp(appointment.getAppointmentDate().getTime()));
            ps.setString(4, appointment.getAppointmentNotes());

            status = ps.executeUpdate();

            con.close();
        } catch (Exception e) {
            System.out.println("Error scheduling appointment: " + e.getMessage());
        }
        return status;
    }

    public static int deleteAppointmentsByPetId(int petId) {
        int status = 0;
        try {
            Connection conn = DatabaseConnection.getConnection();
            String query = "DELETE FROM Appointments WHERE petId=?";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, petId);

            status = pstmt.executeUpdate();

            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return status;
    }

    public static int deleteConsultationsByPetId(int petId) {
        int status = 0;
        try {
            Connection conn = DatabaseConnection.getConnection();
            String query = "DELETE FROM Consultations WHERE petId=?";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, petId);

            status = pstmt.executeUpdate();

            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return status;
    }

    public static int deleteLabOrdersByPetId(int petId) {
        int status = 0;
        try {
            Connection conn = DatabaseConnection.getConnection();
            String query = "DELETE FROM LabOrders WHERE petId=?";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, petId);

            status = pstmt.executeUpdate();

            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return status;
    }

    public static List<Appointment> getAppointmentsByClientId(int clientId) {
        List<Appointment> appointments = new ArrayList<>();
        try {
            Connection con = DatabaseConnection.getConnection();
            String selectQuery = "SELECT * FROM Appointments WHERE clientId = ?";

            PreparedStatement ps = con.prepareStatement(selectQuery);
            ps.setInt(1, clientId);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Appointment appointment = new Appointment();
                appointment.setAppointmentId(rs.getInt("appointmentId"));
                appointment.setClientId(rs.getInt("clientId"));
                appointment.setPetId(rs.getInt("petId"));
                appointment.setAppointmentDate(rs.getTimestamp("appointmentDate"));
                appointment.setAppointmentNotes(rs.getString("appointmentNotes"));

                appointments.add(appointment);
            }

            con.close();
        } catch (Exception e) {
            System.out.println("Error getting appointments: " + e.getMessage());
        }
        return appointments;
    }
}

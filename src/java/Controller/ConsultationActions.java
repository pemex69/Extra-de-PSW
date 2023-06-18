/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import Model.DatabaseConnection;
import Model.Consultation;

public class ConsultationActions {

    // ...
    public static int registerConsultation(Consultation consultation) {
        int status = 0;
        try {
            Connection con = DatabaseConnection.getConnection();
            String registerConsultationQuery = "INSERT INTO Consultations(petId, veterinarian, consultationDate, consultationDetails)"
                    + " VALUES (?, ?, ?, ?)";

            PreparedStatement ps = con.prepareStatement(registerConsultationQuery);

            ps.setInt(1, consultation.getPetId());
            ps.setString(2, consultation.getVeterinarian());
            ps.setString(3, consultation.getConsultationDate());
            ps.setString(4, consultation.getConsultationDetails());

            status = ps.executeUpdate();

            con.close();

        } catch (Exception err) {
            System.out.println("Error creating consultation: " + err.getMessage());
        }
        return status;
    }

    // ...
}

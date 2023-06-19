package Controller;

import Model.Consultation;
import Model.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConsultationActions {

    public boolean addConsultation(Consultation consultation) {
        try {
            Connection connection = DatabaseConnection.getConnection();
            String query = "INSERT INTO Consultations (vetId, petId, consultationDate, consultationNotes, consultationTreatment) "
                    + "VALUES (?, ?, ?, ?, ?)";

            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, consultation.getVetId());
            preparedStatement.setInt(2, consultation.getPetId());
            preparedStatement.setString(3, consultation.getConsultationDate());
            preparedStatement.setString(4, consultation.getConsultationNotes());
            preparedStatement.setString(5, consultation.getConsultationTreatment());

            int rowsInserted = preparedStatement.executeUpdate();
            preparedStatement.close();

            String petHistoryInsert = "INSERT INTO PetHistory (petId, consultationDate, consultationNotes, consultationTreatment) "
                    + "VALUES (?, ?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(query);
            preparedStatement.setInt(1, consultation.getPetId());
            preparedStatement.setString(2, consultation.getConsultationDate());
            preparedStatement.setString(3, consultation.getConsultationNotes());
            preparedStatement.setString(4, consultation.getConsultationTreatment());
            int useless = ps.executeUpdate();
            ps.close();
            
            connection.close();

            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}

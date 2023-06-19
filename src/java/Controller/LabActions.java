package Controller;

import Model.DatabaseConnection;
import Model.LabOrder;
import Model.PetHistory;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * Controller class for LabOrder related actions.
 */
public class LabActions {

    public static int generateLabOrder(LabOrder labOrder, PetHistory ph) {
        int status = 0;
        try {
            Connection con = DatabaseConnection.getConnection();
            String generateLabOrderQuery = "INSERT INTO LabOrders (petId, orderDate, orderDetails) VALUES (?, NOW(), ?)";

            PreparedStatement ps = con.prepareStatement(generateLabOrderQuery);
            ps.setInt(1, labOrder.getPetId());
            ps.setString(2, labOrder.getOrderDetails());

            status = ps.executeUpdate();
            ps.close();

            String insertLabPetHistoryQuery = "INSERT INTO PetHistory (petId, consultationDate, consultationNotes, "
                    + " consultationTreatment, petLabHistory) VALUES (?, NOW(), ?, ?, ?)";
            PreparedStatement prepared = con.prepareStatement(insertLabPetHistoryQuery);
            prepared.setInt(1, labOrder.getPetId());
            prepared.setString(2, ph.getConsultationNotes());
            prepared.setString(3, ph.getConsultationTreatment());
            prepared.setString(4, labOrder.getOrderDetails());

            int useless = prepared.executeUpdate();
            prepared.close();

            con.close();
        } catch (Exception err) {
            System.out.println("Error generating lab order: " + err.getMessage());
        }
        return status;
    }
}

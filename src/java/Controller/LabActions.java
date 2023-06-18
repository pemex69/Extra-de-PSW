package Controller;

import Model.DatabaseConnection;
import Model.LabOrder;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class LabActions {

    public static int generateLabOrder(LabOrder labOrder) {
        int status = 0;
        try {
            Connection con = DatabaseConnection.getConnection();
            String generateLabOrderQuery = "INSERT INTO LabOrders(petId, orderDetails) VALUES (?, ?)";

            PreparedStatement ps = con.prepareStatement(generateLabOrderQuery);
            ps.setInt(1, labOrder.getPetId());
            ps.setString(2, labOrder.getOrderDetails());

            status = ps.executeUpdate();

            con.close();
        } catch (Exception err) {
            System.out.println("Error generating lab order: " + err.getMessage());
        }
        return status;
    }
}

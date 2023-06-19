package Controller;

import Model.DatabaseConnection;
import Model.Veterinarian;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VeterinarianActions {

    public static int loginVeterinarian(Veterinarian vet) {
        int vetId = 0;
        try {
            Connection con = DatabaseConnection.getConnection();
            String loginQuery = "SELECT vetId FROM Vets WHERE vetEmail = ? AND vetPass = ?";

            PreparedStatement ps = con.prepareStatement(loginQuery);
            ps.setString(1, vet.getVetEmail());
            ps.setString(2, vet.getVetPass());

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                vetId = rs.getInt("vetId");
            }

            con.close();
        } catch (Exception err) {
            System.out.println("Error during veterinarian login: " + err.getMessage());
        }
        return vetId;
    }

    public static int registerVeterinarian(Veterinarian veterinarian) {
        int status = 0;
        try {
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO Vets (name, email, password, license) VALUES (?, ?, ?, ?)");
            preparedStatement.setString(1, veterinarian.getVetName());
            preparedStatement.setString(2, veterinarian.getVetEmail());
            preparedStatement.setString(3, veterinarian.getVetPass());
            preparedStatement.setString(4, veterinarian.getVetLicense());

            status = preparedStatement.executeUpdate();

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return status;
    }

    public static int updateVeterinarian(Veterinarian veterinarian) {
        int status = 0;
        try {
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "UPDATE Vets SET name=?, email=?, password=?, license=? WHERE vet_id=?");
            preparedStatement.setString(1, veterinarian.getVetName());
            preparedStatement.setString(2, veterinarian.getVetEmail());
            preparedStatement.setString(3, veterinarian.getVetPass());
            preparedStatement.setString(4, veterinarian.getVetLicense());
            preparedStatement.setInt(5, veterinarian.getVetId());

            status = preparedStatement.executeUpdate();

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return status;
    }

    public static Veterinarian getVeterinarianById(int veterinarianId) {
        Veterinarian veterinarian = null;
        try {
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Vets WHERE vet_id=?");
            preparedStatement.setInt(1, veterinarianId);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                veterinarian = new Veterinarian();
                veterinarian.setVetId(resultSet.getInt("vet_id"));
                veterinarian.setVetName(resultSet.getString("name"));
                veterinarian.setVetEmail(resultSet.getString("email"));
                veterinarian.setVetPass(resultSet.getString("password"));
                veterinarian.setVetLicense(resultSet.getString("license"));
            }

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return veterinarian;
    }

    public static List<Veterinarian> getAllVeterinarians() {
        List<Veterinarian> veterinarians = new ArrayList<>();
        try {
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Vets");

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Veterinarian veterinarian = new Veterinarian();
                veterinarian.setVetId(resultSet.getInt("vet_id"));
                veterinarian.setVetName(resultSet.getString("name"));
                veterinarian.setVetEmail(resultSet.getString("email"));
                veterinarian.setVetPass(resultSet.getString("password"));
                veterinarian.setVetLicense(resultSet.getString("license"));

                veterinarians.add(veterinarian);
            }

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return veterinarians;
    }

    public static int deleteVeterinarian(int veterinarianId) {
        int status = 0;
        try {
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM Vets WHERE vet_id=?");
            preparedStatement.setInt(1, veterinarianId);

            status = preparedStatement.executeUpdate();

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return status;
    }
}

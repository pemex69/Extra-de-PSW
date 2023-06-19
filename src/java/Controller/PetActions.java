package Controller;

import Model.DatabaseConnection;
import Model.PetHistory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import Model.DatabaseConnection;
import Model.Pet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PetActions {

    public static int addPet(Pet pet) {
        int status = 0;
        try {
            Connection conn = DatabaseConnection.getConnection();
            String query = "INSERT INTO Pets (petName, petSpecies, petRace, petWeight, petHealthState, clientId) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, pet.getPetName());
            pstmt.setString(2, pet.getPetSpecies());
            pstmt.setString(3, pet.getPetRace());
            pstmt.setFloat(4, pet.getPetWeight());
            pstmt.setString(5, pet.getPetHealthState());
            pstmt.setInt(6, pet.getClientId());

            status = pstmt.executeUpdate();

            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return status;
    }

    public static int updatePet(Pet pet) {
        int status = 0;
        try {
            Connection conn = DatabaseConnection.getConnection();
            String query = "UPDATE Pets SET petName=?, petSpecies=?, petRace=?, petWeight=?, petHealthState=?, clientId=? WHERE petId=?";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, pet.getPetName());
            pstmt.setString(2, pet.getPetSpecies());
            pstmt.setString(3, pet.getPetRace());
            pstmt.setFloat(4, pet.getPetWeight());
            pstmt.setString(5, pet.getPetHealthState());
            pstmt.setInt(6, pet.getClientId());
            pstmt.setInt(7, pet.getPetId());

            status = pstmt.executeUpdate();

            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return status;
    }

    public static int deletePet(int petId) {
        int status = 0;
        try {
            Connection conn = DatabaseConnection.getConnection();
            String query = "DELETE FROM Pets WHERE petId=?";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, petId);

            status = pstmt.executeUpdate();

            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return status;
    }

    public static Pet getPetById(int petId) {
        Pet pet = new Pet();
        try {
            Connection conn = DatabaseConnection.getConnection();
            String query = "SELECT * FROM Pets WHERE petId=?";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, petId);

            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                pet.setPetId(rs.getInt("petId"));
                pet.setPetName(rs.getString("petName"));
                pet.setPetSpecies(rs.getString("petSpecies"));
                pet.setPetRace(rs.getString("petRace"));
                pet.setPetWeight(rs.getFloat("petWeight"));
                pet.setPetHealthState(rs.getString("petHealthState"));
                pet.setClientId(rs.getInt("clientId"));
            }

            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pet;
    }

    public static ArrayList<PetHistory> getPetHistoryByPetId(int petId) {
        ArrayList<PetHistory> petHistoryList = new ArrayList<>();

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = DatabaseConnection.getConnection();
            String query = "SELECT * FROM PetHistory WHERE petId = ?";
            statement = connection.prepareStatement(query);
            statement.setInt(1, petId);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int historyId = resultSet.getInt("historyId");
                String consultationDate = resultSet.getString("consultationDate");
                String consultationNotes = resultSet.getString("consultationNotes");
                String consultationTreatment = resultSet.getString("consultationTreatment");
                String petLabHistory = resultSet.getString("petLabHistory");

                PetHistory petHistory = new PetHistory(historyId, petId, consultationDate, consultationNotes,
                        consultationTreatment, petLabHistory);
                petHistoryList.add(petHistory);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return petHistoryList;
    }

    public static ArrayList<Pet> getPetsByClientId(int clientId) {
        ArrayList<Pet> pets = new ArrayList<>();

        try {
            Connection conn = DatabaseConnection.getConnection();
            String query = "SELECT * FROM Pets WHERE clientId=?";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, clientId);

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                Pet pet = new Pet();
                pet.setPetId(rs.getInt("petId"));
                pet.setPetName(rs.getString("petName"));
                pet.setPetSpecies(rs.getString("petSpecies"));
                pet.setPetRace(rs.getString("petRace"));
                pet.setPetWeight(rs.getFloat("petWeight"));
                pet.setPetHealthState(rs.getString("petHealthState"));
                pet.setClientId(rs.getInt("clientId"));

                pets.add(pet);
            }

            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return pets;
    }

}

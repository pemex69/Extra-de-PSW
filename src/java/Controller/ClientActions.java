/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Client;
import Model.DatabaseConnection;
import java.util.ArrayList;
import java.sql.*;

/**
 *
 * @author que
 */
public class ClientActions {

    public static int registerClient(Client cli) {
        int status = 0;
        try {
            Connection con = DatabaseConnection.getConnection();
            String registerClientQuery = "INSERT INTO Clients(clientName, clientEmail, clientPass)"
                    + " VALUES (?, ?, ?)";

            PreparedStatement ps = con.prepareStatement(registerClientQuery);

            ps.setString(1, cli.getClientName());
            ps.setString(2, cli.getClientEmail());
            ps.setString(3, cli.getClientPass());

            status = ps.executeUpdate();

            con.close();

        } catch (Exception err) {
            System.out.println("Error creating client: " + err.getMessage());
        }
        return status;
    }

    public static int updateClient(Client cli) {
        int status = 0;
        try {
            Connection con = DatabaseConnection.getConnection();
            String updateClientQuery = "UPDATE Clients SET "
                    + "clientName = ?, clientEmail = ?, clientPass = ? WHERE clientId = ?";

            PreparedStatement ps = con.prepareStatement(updateClientQuery);
            ps.setString(1, cli.getClientName());
            ps.setString(2, cli.getClientEmail());
            ps.setString(3, cli.getClientPass());
            ps.setInt(4, cli.getClientId());

            status = ps.executeUpdate();

            con.close();

        } catch (Exception err) {
            System.out.println("Error updating client: " + err.getMessage());
        }
        return status;
    }

    public static int deleteClientById(int clientId) {
        int status = 0;
        try {
            Connection con = DatabaseConnection.getConnection();
            String deleteClientQuery = "DELETE FROM Clients WHERE clientId = ?";

            PreparedStatement ps = con.prepareStatement(deleteClientQuery);
            ps.setInt(1, clientId);

            status = ps.executeUpdate();

            con.close();

        } catch (Exception err) {
            System.out.println("Error updating client: " + err.getMessage());
        }
        return status;
    }

    public static Client getClientById(int id) {
        Client cli = new Client();
        try {
            Connection con = DatabaseConnection.getConnection();
            String getClientByIdQuery = "SELECT * FROM Clients WHERE clientId = ?";

            PreparedStatement ps = con.prepareStatement(getClientByIdQuery);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                cli.setClientId(rs.getInt(1));
                cli.setClientName(rs.getString(2));
                cli.setClientEmail(rs.getString(3));
                cli.setClientPass(rs.getString(4));
            }
            System.out.println("Client found . . .");
            con.close();

        } catch (Exception err) {
            System.out.println("Error searching client: " + err.getMessage());
        }
        return cli;
    }

    public static ArrayList<Client> getAllClients(int id) {
        ArrayList<Client> al = new ArrayList<Client>();
        try {
            Connection con = DatabaseConnection.getConnection();
            String getAllClients = "SELECT * FROM Clients";

            PreparedStatement ps = con.prepareStatement(getAllClients);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Client cli = new Client();
                cli.setClientId(rs.getInt(1));
                cli.setClientName(rs.getString(2));
                cli.setClientEmail(rs.getString(3));
                cli.setClientPass(rs.getString(4));
                al.add(cli);
            }
            System.out.println("Client found . . .");
            con.close();

        } catch (Exception err) {
            System.out.println("Error getting all clients: " + err.getMessage());
        }
        return al;
    }
}

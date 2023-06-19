<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="javax.naming.*" %>
<%@ page import="javax.sql.*" %>
<%@ page import="java.util.*" %>
<%@ page import="Model.*" %>
<%@ page import="Controller.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Veterinarian Homepage</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    </head>
    <body>
        <div class="container">
            <h1>Welcome, Veterinarian!</h1>
            <h2>Upcoming Appointments</h2>
            <table class="table">
                <thead>
                    <tr>
                        <th>Date</th>
                        <th>Pet Name</th>
                        <th>Owner Name</th>
                        <th>Notes</th>
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody>
                    <% 
                    try {
                        Connection con = DatabaseConnection.getConnection();
                        String query = "SELECT a.appointmentDate, p.petId, p.petName, cl.clientName, a.appointmentNotes FROM Appointments a " +
                                       "INNER JOIN Pets p ON a.petId = p.petId " +
                                       "INNER JOIN Clients cl ON p.clientId = cl.clientId " +
                                       "ORDER BY a.appointmentDate";
                        PreparedStatement ps = con.prepareStatement(query);
                        ResultSet rs = ps.executeQuery();
                    
                        while (rs.next()) {
                            java.sql.Timestamp appointmentDate = rs.getTimestamp("appointmentDate");
                            int petId = rs.getInt("petId");
                            String petName = rs.getString("petName");
                            String clientName = rs.getString("clientName");
                            String appointmentNotes = rs.getString("appointmentNotes");
                
                    %>
                    <tr>
                        <td><%= appointmentDate %></td>
                        <td><%= petName %></td>
                        <td><%= clientName %></td>
                        <td><%= appointmentNotes %></td>
                        <td><a href="vetPetHistory.jsp?petId=<%= petId %>">View Medical History</a></td>
                    </tr>
                    <% 
                        }
                        con.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    %>
                </tbody>
            </table>

            <h2>All Pets</h2>
            <table class="table">
                <thead>
                    <tr>
                        <th>Pet ID</th>
                        <th>Pet Name</th>
                        <th>Owner Name</th>
                        <th>Species</th>
                        <th>History</th>
                    </tr>
                </thead>
                <tbody>
                    <% 
                    try {
                        Connection con = DatabaseConnection.getConnection();
                        String query = "SELECT p.petId, p.petName, cl.clientName, p.petSpecies FROM Pets p " +
                                       "INNER JOIN Clients cl ON p.clientId = cl.clientId";
                        PreparedStatement ps = con.prepareStatement(query);
                        ResultSet rs = ps.executeQuery();
                    
                        while (rs.next()) {
                            int petId = rs.getInt("petId");
                            String petName = rs.getString("petName");
                            String ownerName = rs.getString("clientName");
                            String species = rs.getString("petSpecies");
                
                    %>
                    <tr>
                        <td><%= petId %></td>
                        <td><%= petName %></td>
                        <td><%= ownerName %></td>
                        <td><%= species %></td>
                        <td><a href="vetPetHistory.jsp?petId=<%= petId %>">View Medical History</a></td>

                    </tr>
                    <% 
                        }
                        con.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    %>
                </tbody>
            </table>
            <br> <br> <br> <br>

            <h2>Add New Consultation</h2>
            <form action="saveConsultation" method="post">
                <div class="mb-3">
                    <label for="petId" class="form-label">Pet ID:</label>
                    <select class="form-control" id="petId" name="petId">
                        <% 
                        try {
                            Connection con = DatabaseConnection.getConnection();
                            String query = "SELECT petId FROM Pets";
                            PreparedStatement ps = con.prepareStatement(query);
                            ResultSet rs = ps.executeQuery();
                        
                            while (rs.next()) {
                                int petId = rs.getInt("petId");
                        %>
                        <option value="<%= petId %>"><%= petId %></option>
                        <% 
                            }
                            con.close();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        %>
                    </select>
                </div>
                <div class="mb-3">
                    <label for="vetId" class="form-label">Veterinarian:</label>
                    <select class="form-control" id="vetId" name="vetId">
                        <% 
                        try {
                            Connection con = DatabaseConnection.getConnection();
                            String query = "SELECT * FROM Vets";
                            PreparedStatement ps = con.prepareStatement(query);
                            ResultSet rs = ps.executeQuery();
                        
                            while (rs.next()) {
                                int vetId = rs.getInt("vetId");
                                String vetName = rs.getString("vetName");
                        %>
                        <option value="<%= vetId %>"><%= vetName %></option>
                        <% 
                            }
                            con.close();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        %>
                    </select>
                </div>
                <div class="mb-3">
                    <label for="consultationDate" class="form-label">Consultation Date:</label>
                    <input type="date" class="form-control" id="consultationDate" name="consultationDate" required>
                </div>
                <div class="mb-3">
                    <label for="consultationNotes" class="form-label">Consultation Notes:</label>
                    <textarea class="form-control" id="consultationNotes" name="consultationNotes" rows="3" required></textarea>
                </div>
                <div class="mb-3">
                    <label for="consultationTreatment" class="form-label">Consultation Treatment:</label>
                    <textarea class="form-control" id="consultationTreatment" name="consultationTreatment" rows="3" required></textarea>
                </div>
                <button type="submit" class="btn btn-primary">Add Consultation</button>
            </form>

        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
    </body>
</html>

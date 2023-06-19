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
        <title>Pet Medical History</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    </head>
    <body>
        <div class="container">
            <h1>Pet Medical History</h1>
            <table class="table">
                <thead>
                    <tr>
                        <th>petId</th>
                        <th>Date</th>
                        <th>Notes</th>
                        <th>Treatment</th>
                        <th>Lab</th>
                    </tr>
                </thead>
                <tbody>
                    <% 
                    int petId = Integer.parseInt(request.getParameter("petId"));

                    try {
                        Connection con = DatabaseConnection.getConnection();
                        String query = "SELECT * FROM PetHistory WHERE petId = ?";
                        PreparedStatement ps = con.prepareStatement(query);
                        ps.setInt(1, petId);
                        ResultSet rs = ps.executeQuery();
                    
                        while (rs.next()) {
                            int consultationId = rs.getInt("petId");
                            java.sql.Timestamp consultationDate = rs.getTimestamp("consultationDate");
                            String consultationNotes = rs.getString("consultationNotes");
                            String consultationTreatment = rs.getString("consultationTreatment");
                            String petLabHistory = rs.getString("petLabHistory");
                            if (petLabHistory == null) {
                                petLabHistory = "nada que mostrar . . .";
                            }
                    %>
                    <tr>
                        <td><%= petId %></td>
                        <td><%= consultationDate %></td>
                        <td><%= consultationNotes %></td>
                        <td><%= consultationTreatment %></td>
                        <td><%= petLabHistory %></td>
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
            <br><br><br><br>
            <center>
                <a href="CreateLabOrder.jsp?petId=<%= petId %>"><h3>Crear orden de laboratorio para esta mascota</h3></a>
            </center>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
    </body>
</html>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="Model.PetHistory" %>
<%@ page import="Controller.PetActions"%>
<%@ page import="java.sql.*"%>
<%@ page import="Model.DatabaseConnection"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pet History</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
    </head>
    <body>
        <div class="container">
            <h1 class="mt-4 mb-4">Pet History</h1>
            <table class="table">
                <thead class="thead-dark">
                    <tr>
                        <th>ID</th>
                        <th>Date</th>
                        <th>Consultation Notes</th>
                        <th>Treatment</th>
                        <th>Lab History</th>
                    </tr>
                </thead>
                <tbody>
                    <% 
                        int petId = Integer.parseInt(request.getParameter("petId"));
                        ArrayList<PetHistory> petHistoryList = PetActions.getPetHistoryByPetId(petId);
                        for (PetHistory petHistory : petHistoryList) {
                    %>
                    <tr>
                        <td><%= petHistory.getHistoryId() %></td>
                        <td><%= petHistory.getConsultationDate() %></td>
                        <td><%= petHistory.getConsultationNotes() %></td>
                        <td><%= petHistory.getConsultationTreatment() %></td>
                        <td><%= petHistory.getPetLabHistory() %></td>
                    </tr>
                    <% } %>
                </tbody>
            </table>
            <% 
String clientEmail = (String) session.getAttribute("clientEmail");
String clientId = "";
try {
// Aquí debes realizar la conexión a la base de datos y ejecutar la consulta para obtener el ID del cliente
// Puedes utilizar JDBC para conectarte a la base de datos y ejecutar la consulta

// Ejemplo de conexión y consulta utilizando JDBC
Connection con = DatabaseConnection.getConnection();
String getclientEmailQuery = "SELECT clientId FROM Clients WHERE clientEmail = ?";
PreparedStatement ps = con.prepareStatement(getclientEmailQuery);
ps.setString(1, clientEmail);
ResultSet rs = ps.executeQuery();
if (rs.next()) {
    clientId = rs.getString("clientId");
}
con.close();
} catch (Exception e) {
e.printStackTrace();
}
            %>

            <a href="allPets.jsp?clientId=<%=clientId %>" class="btn btn-primary btn-sm">Back to Pets</a>
        </div>
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    </body>
</html>

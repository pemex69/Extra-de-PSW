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
    <nav class="navbar">
        <div class="content">
            <div class="logo">
                <a href="#">Dr. Paws</a>
            </div>
            <ul class="menu-list">
                <div class="icon cancel-btn">
                    <i class="fas fa-times"></i>
                </div>
                <li><a href="./index.html">Inicio</a></li>
                <li><a href="./pets.jsp">Registro de mascotas</a></li>
                <li><a href="./auth.html">Registrate/Inicia Sesión</a></li>
                <li><a href="./agenda.jsp">Citas</a></li>
            </ul>
            <div class="icon menu-btn">
                <i class="fas fa-bars"></i>
            </div>
        </div>
    </nav>
    <body>
        <div class="container">
            <h1 class="mt-4 mb-4">Historial de la mascota</h1>
            <table class="table">
                <thead class="thead-dark">
                    <tr>
                        <th>ID</th>
                        <th>Fecha</th>
                        <th>Notas de consulta</th>
                        <th>Tratamiento</th>
                        <th>Historial de laboratorio</th>
                    </tr>
                </thead>
                <tbody>
                    <% 
                        int petId = Integer.parseInt(request.getParameter("petId"));
                        ArrayList<PetHistory> petHistoryList = PetActions.getPetHistoryByPetId(petId);
                        for (PetHistory petHistory : petHistoryList) {
                        String nn = petHistory.getPetLabHistory();
                        if (nn == null) {
                            nn = "N/A";
                        }
                    %>
                    <tr>
                        <td><%= petHistory.getHistoryId() %></td>
                        <td><%= petHistory.getConsultationDate() %></td>
                        <td><%= petHistory.getConsultationNotes() %></td>
                        <td><%= petHistory.getConsultationTreatment() %></td>
                        <td><%= nn %></td>
                    </tr>
                    <% } %>
                </tbody>
            </table>
            <% 
String clientEmail = (String) session.getAttribute("clientEmail");
String clientId = "";
try {
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

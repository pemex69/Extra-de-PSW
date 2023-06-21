<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="Model.Client" %>
<%@ page import="java.sql.*"%>
<%@ page import="Model.DatabaseConnection"%>

<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Título de la página</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    </head>
    <body>
        <header>
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
        </header>

        <div class="container">
            <table class="table">
                <thead>
                    <tr>
                        <th>ID de cliente</th>
                        <th>Nombre de cliente</th>
                    </tr>
                </thead>
                <tbody>
                    <% 
                    try {
                        Connection conn = DatabaseConnection.getConnection(); // Establish the database connection
                        Statement stmt = conn.createStatement();
                        ResultSet rs = stmt.executeQuery("SELECT * FROM Clients"); // Assuming there is a 'clients' table in the database
                    
                        ArrayList<Client> clientsList = new ArrayList<>();
                        while (rs.next()) {
                            Client client = new Client();
                            client.setClientId(rs.getInt("clientId"));
                            client.setClientName(rs.getString("clientName"));
                            clientsList.add(client);
                        }
                    
                        for (Client client : clientsList) {
                    %>
                    <tr>
                        <td><%= client.getClientId() %></td>
                        <td><%= client.getClientName() %></td>
                    </tr>
                    <% 
                        }
                    
                        conn.close(); // Close the database connection
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    %>
                </tbody>
            </table>
        </div>

        <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    </body>
</html>

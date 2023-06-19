<%-- 
    Document   : getAllUsers
    Created on : 15 Jun. 2023, 2:18:16 pm
    Author     : que
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Model.Client"%>
<%@page import="Controller.ClientActions"%>
<%@page import="java.util.ArrayList"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="preconnect">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
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
        <h1>Tabla de todos los usuarios</h1>
        <br>
        <div class="container">
            <table class="table">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Nombre de usuario</th>
                        <th>Email</th>
                        <th>Contrasenia</th>
                        <th></th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                    <% for (Client cli : al) { %>
                    <tr>
                        <td><%= cli.getClientId() %></td>
                        <td><%= cli.getClientName() %></td>
                        <td><%= cli.getClientEmail() %></td>
                        <td><%= cli.getClientPass() %></td>
                        <td><a href="updateClient.jsp?clientId=<%= cli.getClientId() %>">Editar</a></td>
                        <td><a href="deleteClient?clientId=<%= cli.getClientId() %>">Borrar</a></td>
                    </tr>
                    <% } %>
                </tbody>
            </table>
        </div>
        
    </body>
</html>

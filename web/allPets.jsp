<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="Model.Pet" %>
<%@ page import="Controller.PetActions"%>
<%@ page import="java.sql.*"%>
<%@ page import="Model.DatabaseConnection"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pets</title>
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
            <h1 class="mt-4 mb-4">Pets</h1>
            <table class="table">
                <thead class="thead-dark">
                    <tr>
                        <th>ID</th>
                        <th>Nombre</th>
                        <th>Especie</th>
                        <th>Raza</th>
                        <th>Peso</th>
                        <th>Estado de salud</th>
                        <th>Accion</th>
                    </tr>
                </thead>
                <tbody>
                    <% 
                        int clientId = Integer.parseInt(request.getParameter("clientId"));
                        ArrayList<Pet> pets = PetActions.getPetsByClientId(clientId);
                        for (Pet pet : pets) {
                    %>
                    <tr>
                        <td><%= pet.getPetId() %></td>
                        <td><%= pet.getPetName() %></td>
                        <td><%= pet.getPetSpecies() %></td>
                        <td><%= pet.getPetRace() %></td>
                        <td><%= pet.getPetWeight() %></td>
                        <td><%= pet.getPetHealthState() %></td>
                        <td>
                            <a href="editPet.jsp?petId=<%= pet.getPetId()%>" class="btn btn-primary btn-sm">Editar</a>
                            <a href="PetServlet?action=delete&petId=<%= pet.getPetId() %>&clientId=<%= clientId %>" class="btn btn-danger btn-sm">Borrar</a>
                            <a href="PetHistory.jsp?petId=<%= pet.getPetId() %>" class="btn btn-secondary btn-sm">Ver historial</a>
                        </td>
                    </tr>
                    <% } %>
                </tbody>
            </table>

            <h2 class="mt-4 mb-4">Agregar mascota</h2>
            <form action="PetServlet?action=add" method="post" id="forum">
                <input type="hidden" name="clientId" value="<%= clientId %>">
                <div class="form-group">
                    <label>Nombre</label>
                    <input id="petName" type="text" name="petName" class="form-control" required>
                </div>
                <div class="form-group">
                    <label>Especie</label>
                    <input id="petSpecies" type="text" name="petSpecies" class="form-control" required>
                </div>
                <div class="form-group">
                    <label>Raza:</label>
                    <input id="petRace" type="text" name="petRace" class="form-control" required>
                </div>
                <div class="form-group">
                    <label>Peso:</label>
                    <input id="petWeight" type="number" name="petWeight" class="form-control" required>
                </div>
                <div class="form-group">
                    <label>Estado de salud:</label>
                    <input id="petHealthState" type="text" name="petHealthState" class="form-control" required>
                </div>
                <input type="submit" value="Add" class="btn btn-primary">
            </form>
        </div>
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
        <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
        <script src="./JS/other pets.js"></script>
    </body>
</html>

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
    <body>
        <div class="container">
            <h1 class="mt-4 mb-4">Pets</h1>
            <table class="table">
                <thead class="thead-dark">
                    <tr>
                        <th>ID</th>
                        <th>Name</th>
                        <th>Species</th>
                        <th>Race</th>
                        <th>Weight</th>
                        <th>Health State</th>
                        <th>Action</th>
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
                            <a href="editPet.jsp?petId=<%= pet.getPetId()%>" class="btn btn-primary btn-sm">Edit</a>
                            <a href="PetServlet?action=delete&petId=<%= pet.getPetId() %>&clientId=<%= clientId %>" class="btn btn-danger btn-sm">Delete</a>
                            <a href="PetHistory.jsp?petId=<%= pet.getPetId() %>" class="btn btn-secondary btn-sm">View History</a>
                        </td>
                    </tr>
                    <% } %>
                </tbody>
            </table>

            <h2 class="mt-4 mb-4">Add Pet</h2>
            <form action="PetServlet?action=add" method="post">
                <input type="hidden" name="clientId" value="<%= clientId %>">
                <div class="form-group">
                    <label>Name:</label>
                    <input type="text" name="petName" class="form-control" required>
                </div>
                <div class="form-group">
                    <label>Species:</label>
                    <input type="text" name="petSpecies" class="form-control" required>
                </div>
                <div class="form-group">
                    <label>Race:</label>
                    <input type="text" name="petRace" class="form-control" required>
                </div>
                <div class="form-group">
                    <label>Weight:</label>
                    <input type="number" name="petWeight" class="form-control" required>
                </div>
                <div class="form-group">
                    <label>Health State:</label>
                    <input type="text" name="petHealthState" class="form-control" required>
                </div>
                <input type="submit" value="Add" class="btn btn-primary">
            </form>
        </div>
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    </body>
</html>

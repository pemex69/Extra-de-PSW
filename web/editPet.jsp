<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="Model.Pet" %>
<%@ page import="Controller.PetActions"%>
<%@ page import="java.sql.*"%>
<%@ page import="Model.DatabaseConnection"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Pet</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
    </head>
    <body>
        <div class="container">
            <h1 class="mt-4 mb-4">Edit Pet</h1>

            <% 
                int petId = Integer.parseInt(request.getParameter("petId"));
                Pet pet = PetActions.getPetById(petId);
            %>

            <form action="PetServlet?action=update" method="post">
                <input type="hidden" name="petId" value="<%= pet.getPetId() %>">
                <input type="hidden" name="clientId" value="<%= pet.getClientId() %>">
                <div class="form-group">
                    <label>Name:</label>
                    <input type="text" name="petName" class="form-control" value="<%= pet.getPetName() %>" required>
                </div>
                <div class="form-group">
                    <label>Species:</label>
                    <input type="text" name="petSpecies" class="form-control" value="<%= pet.getPetSpecies() %>" required>
                </div>
                <div class="form-group">
                    <label>Race:</label>
                    <input type="text" name="petRace" class="form-control" value="<%= pet.getPetRace() %>" required>
                </div>
                <div class="form-group">
                    <label>Weight:</label>
                    <input type="number" name="petWeight" class="form-control" value="<%= pet.getPetWeight() %>" required>
                </div>
                <div class="form-group">
                    <label>Health State:</label>
                    <input type="text" name="petHealthState" class="form-control" value="<%= pet.getPetHealthState() %>" required>
                </div>
                <input type="submit" value="Update" class="btn btn-primary">
            </form>
        </div>
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    </body>
</html>

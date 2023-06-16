<%-- 
    Document   : updateClient
    Created on : 15 Jun. 2023, 3:02:53 pm
    Author     : que
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Model.Client"%>
<%@page import="Controller.ClientActions"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="preconnect" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <link rel="preconnect" href="./CSS/style sheets.css">
        <link rel="stylesheet" href="./CSS/style sheets.css">
    </head>
    <body>
        <h1>Edita el cliente</h1>
        <br>
        <form method="post" action="updateClient">
            <table border="2">
                <%
                    int id = Integer.parseInt(request.getParameter("clientId"));
                    Client cli = ClientActions.getClientById(id);
                %>
                <div class="form-group">
                    <label for="clientName">ID</label>
                    <input value="<%=cli.getClientId()%>" type="hidden" class="form-control" id="clientId" name="clientIdUPD" placeholder="Nombre">
                </div>
                <div class="form-group">
                    <label for="clientName">Nombre</label>
                    <input value="<%=cli.getClientName()%>" type="text" class="form-control" id="clientName" name="clientNameUPD" placeholder="Nombre">
                </div>
                <div class="form-group">
                    <label for="clientEmail">Correo</label>
                    <input value="<%=cli.getClientEmail()%>" type="email" class="form-control" id="clientEmail" name="clientEmailUPD" placeholder="Correo">
                </div>
                <div class="form-group">
                    <label for="clientPass">Contrasenia</label>
                    <input value="<%=cli.getClientPass()%>" type="password" class="form-control" id="clientPass" name="clientPassUPD"
                           placeholder="Contrasenia">
                </div>
                <input type="submit" value="Actualizar"> <input type="reset" value="Limpiar">
            </table>
        </form>
    </body>
</html>

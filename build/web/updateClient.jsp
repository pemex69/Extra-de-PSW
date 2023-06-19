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

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
    </head>
    <body>
        <h1>Tabla de todos los usuarios</h1>
        <br>
        <table>
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Nombre de usuario</th>
                    <th>Emai</th>
                    <th>Contraseña</th>
                    <th></th>
                    <th></th>
                </tr>
            </thead>
            <tbody>
                <%
                    ArrayList<Client> al = ClientActions.getAllClients(0); // or pass any default value if needed
                    for (Client cli : al) {
                %>
                <tr>
                    <td><%=cli.getClientId()%></td>
                    <td><%=cli.getClientName()%></td>
                    <td><%=cli.getClientEmail()%></td>
                    <td><%=cli.getClientPass()%></td>
                    <td><a href="updateClient.jsp?clientId=<%=cli.getClientId()%>">Editar</a></td>
                    <td><a href="deleteClient?clientId=<%=cli.getClientId()%>">Borrar</a></td>
                </tr>
                <%
                    }
                %>
            </tbody>
        </table>
    </body>
</html>

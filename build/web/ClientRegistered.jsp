<%-- 
    Document   : DueñoRegistrado
    Created on : 15 Jun. 2023, 2:01:05 am
    Author     : que
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" session="true" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Registrado perro</h1>
        <%-- Access the username from the session --%>
        <% String clientName = (String) session.getAttribute("clientName"); %>

        <%-- Display the username --%>
        <p>Welcome, <%= clientName %></p>
    </body>
</html>

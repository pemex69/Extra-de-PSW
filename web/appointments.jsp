<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="java.sql.*"%>
<%@page import="Model.DatabaseConnection"%>
<!DOCTYPE html>
<html lang="es">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Cita registrada</title>
        <link rel="preconnect" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <link rel="stylesheet" href="./CSS/style sheets.css">
        <link rel="stylesheet" href="./CSS/agenda style sheet.css">
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
        <br><br><br><br>
        <main>
            <div class="container">
                <a href="./index.html"><h1>Cita registrad <strong>Volver a inicio</strong> </h1></a>
            </div>
        </main>
        <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
        <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
    </body>

</html>

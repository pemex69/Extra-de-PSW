<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="Model.Pet" %>
<%@ page import="java.sql.*"%>
<%@ page import="Model.DatabaseConnection"%>

<!DOCTYPE html>
<html lang="es">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Agenda tu cita</title>
        <link rel="preconnect" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <link rel="preconnect" href="./CSS/style sheets.css">
        <link rel="stylesheet" href="./CSS/style sheets.css">
        <link rel="preconnect" href="./CSS/agenda style sheet.css">
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
                        <li><a href="./auth.html">Registrate/Inicia SesiÃ³n</a></li>
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
                <% String clientName = (String) session.getAttribute("clientName");
                if (clientName == null) {
                    clientName = "No tienes una sesion activa";
                    }
                %>

                <h2>La mascota se registrara a nombre de: <strong><%=clientName%></strong></h2>
                <br>
                <form action="PetServlet" method="post">
                    <% 
                    String clientEmail = (String) session.getAttribute("clientEmail");
                    String clientId = "";
                    try {
                        Connection con = DatabaseConnection.getConnection();
                        String getclientEmailQuery = "SELECT clientId FROM Clients WHERE clientEmail = ?";
                        PreparedStatement ps = con.prepareStatement(getclientEmailQuery);
                        ps.setString(1, clientEmail);
                        ResultSet rs = ps.executeQuery();
                        if (rs.next()) {
                            clientId = rs.getString("clientId");
                        }
                        con.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    %>
                    <input type="hidden" name="action" value="add">
                    <input type="hidden" id="clientId" name="clientId" value="<%= clientId %>">
                    <div class="form-group">
                        <label for="petName">Nombre de la mascota:</label>
                        <input type="text" class="form-control" id="petName" name="petName" value="Mascota de <%= clientName%>" required>
                    </div>
                    <div class="form-group">
                        <label for="petSpecies">Especie:</label>
                        <input type="text" class="form-control" id="petSpecies" name="petSpecies" required>
                    </div>
                    <div class="form-group">
                        <label for="petRace">Raza:</label>
                        <input type="text" class="form-control" id="petRace" name="petRace" required>
                    </div>
                    <div class="form-group">
                        <label for="petWeight">Peso:</label>
                        <input type="number" class="form-control" id="petWeight" name="petWeight" step="0.01" required>
                    </div>
                    <div class="form-group">
                        <label for="petHealthState">Estado de salud:</label>
                        <input type="text" class="form-control" id="petHealthState" name="petHealthState" required>
                    </div>
                    <input type="submit" class="btn btn-primary" value="Registrar mascota">
                </form>
                <center>
                    <a href="allPets.jsp?clientId=<%=clientId %>"><h4>Consultar <strong>mis mascotas</strong> </h4></a>
                </center>
            </div>
        </main>
        <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
        <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
        <script src="./JS/pets.js"></script>
    </body>

</html>
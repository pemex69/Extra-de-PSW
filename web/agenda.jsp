<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="java.sql.*"%>
<%@page import="Model.DatabaseConnection"%>
<!DOCTYPE html>
<html lang="es">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Agenda tu cita</title>
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
                <% String clientName = (String) session.getAttribute("clientName");
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


                <h2>La cita se registrará a nombre de: <strong><%=clientName%></strong></h2>
                <br>
                <form method="post" action="ScheduleAppointmentServlet">
                    <input type="hidden" name="clientId" value="<%=clientId%>">
                    <label for="start">Nombre de tu mascota</label>
                    <input type="text" id="other" name="petName" value="lmfao" min="2023-01-01" max="2023-12-31">
                    <br><br>
                    <label for="start">Día de la cita:</label>
                    <input type="date" id="start" name="appointmentDate" value="2023-06-19" min="2023-01-01" max="2023-12-31">
                    <br><br>
                    <div class="form-group">
                        <label for="reason">Razón de la cita (máx. 255 caracteres)</label>
                        <textarea class="form-control" id="reason" name="appointmentNotes" rows="3" maxlength="255"></textarea>
                    </div>
                    <center>
                        <button class="button-58" type="submit">Agendar una cita</button>
                    </center>
                </form>
            </div>
        </main>
        <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
        <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
    </body>

</html>

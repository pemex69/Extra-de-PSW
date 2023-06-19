<!DOCTYPE html>
<html>

<head>
    <title>Generar Orden de Laboratorio</title>
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
        <h1>Generar Orden de Laboratorio</h1>
        <br><br>
        <form action="GenerateLabOrder" method="post" id="labOrderForm">
            <input type="hidden" name="petId" value="<%= request.getParameter("petId") %>">
            <div class="form-group">
                <label for="labOrderName">Nombre del estudio:</label>
                <input id="studyName" type="text" class="form-control" name="orderDetails" required>
            </div>
            <div class="form-group">
                <label for="labOrderName">Porque se solicita el estudio:</label>
                <input id="studyReason" type="text" class="form-control" name="consultationNotes" value="El estudio se programa para la proxima cita debido a: " required>
            </div>
            <div class="form-group">
                <label for="labOrderName">Tratamiento mientras tanto:</label>
                <input id="precautionTreatment" type="text" class="form-control" name="consultationTreatment" required>
            </div>
            <input type="submit" class="btn btn-primary" value="Generar Orden de Laboratorio">
        </form>
    </div>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
    <script src="./JS/labOrder.js"></script>
</body>

</html>
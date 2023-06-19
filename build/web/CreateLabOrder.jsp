<!DOCTYPE html>
<html>
    <head>
        <title>Generar Orden de Laboratorio</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
    </head>
    <body>
        <div class="container">
            <h1>Generar Orden de Laboratorio</h1>
            <form action="GenerateLabOrder" method="post">
                <input type="hidden" name="petId" value="<%= request.getParameter("petId") %>">
                <div class="form-group">
                    <label for="labOrderName">Nombre de la Orden de Laboratorio:</label>
                    <input type="text" class="form-control" name="orderDetails" required>
                </div>
                <!-- Agrega los demás campos del formulario -->

                <input type="submit" class="btn btn-primary" value="Generar Orden de Laboratorio">
            </form>
        </div>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    </body>
</html>

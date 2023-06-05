<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css"  rel="stylesheet">
</head>

<body>
    <h1>Crear Capacitación</h1>
    <form id="form-capacitacion">
        <label for="rutCliente">RUT del Cliente:</label>
        <input type="text" id="rutCliente" name="rutCliente" required><br>
        
        <label for="dia">Día:</label>
        <input type="text" id="dia" name="dia" required><br>
        
        <label for="hora">Hora:</label>
        <input type="text" id="hora" name="hora" required><br>
        
        <label for="lugar">Lugar:</label>
        <input type="text" id="lugar" name="lugar" required><br>
        
        <label for="duracion">Duración:</label>
        <input type="text" id="duracion" name="duracion" required><br>
        
        <label for="cantidadAsistentes">Cantidad de Asistentes:</label>
        <input type="text" id="cantidadAsistentes" name="cantidadAsistentes" required><br>
        
        <button type="submit">Crear Capacitación</button>
    </form>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="js/capacitacion.js"></script>
</body>
</html>
</html>
<%@page import="cl.awakelab.ejercicio.model.entity.Usuario"%> <%@page
import="cl.awakelab.ejercicio.model.entity.Cliente"%> <%@page
import="cl.awakelab.ejercicio.model.entity.Administrativo"%> <%@page
import="cl.awakelab.ejercicio.model.entity.Profesional"%> <%@page
import="java.util.List"%> <%@ page language="java" contentType="text/html;
charset=UTF-8" pageEncoding="UTF-8"%> <%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <title>Listado de Usuarios</title>
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css"
      rel="stylesheet"
    />
    <link rel="stylesheet" href="css/styles.css" />
  </head>

  <body>
    <!-- Navbar -->
    <jsp:include page="navbar.jsp" />
    <!-- End Navbar -->
    <div class="container mt-5">
      <h2 class="text-center mb-4">Lista Usuarios</h2>

      <div
        class="form-floating col-10 offset-1 col-md-6 offset-md-3 mt-4"
        id="table-usuario"
      >
        <select
          name="tipoUsuario"
          class="form-select"
          id="floatingSelect"
          aria-label="Floating label select example"
        >
          <option id="type" selected>Seleccione tipo de usuario</option>
          <option id="type" value="administrativo">Administrativo</option>
          <option id="type" value="cliente">Cliente</option>
          <option id="type" value="profesional">Profesional</option>
        </select>
        <label for="floatingSelect">Tipo de usuario</label>

        <!-- <div class="d-grid gap-2 mt-3 mb-3 col-10 offset-1 col-md-6 offset-md-3 mt-4">

				<button type="submit" class="btn btn-primary" >OK</button>
			</div> -->
      </div>
      <div class="container mt-5">
        <div id="table-container"></div>
      </div>
    </div>

    <script
      src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"
      integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz"
      crossorigin="anonymous"
    ></script>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="js/usuarioTabla.js"></script>
    <script src="js/listByType.js"></script>
  </body>
</html>

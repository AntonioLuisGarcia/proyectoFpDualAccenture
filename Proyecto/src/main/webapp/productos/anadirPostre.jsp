<%@ page pageEncoding="UTF-8"%>
<%@page import="agg.persistence.dao.clases.Productos.Postre"%>

<html>
<head>
    <link href="/Proyecto/assets/css/" rel="stylesheet" type="text/css">
</head>
<body>
<%Postre postre = (Postre) request.getAttribute("postre");%>
<div class="center">
  <h1><%= postre.getNombre() %></h1>
  <%
      String imagen = postre.getImagen();
  %>
    <img src="/Proyecto/assets/images/<%=imagen%>" alt="">
  </div>
  <div class="detail-box">

    <p>
      <%= postre.getDescripcion() %>
    </p>
    <div class="options">
      <h6>
            <%= postre.getPrecio() %>  $
            &nbsp&nbsp&nbsp&nbsp&nbsp
            <%= postre.getKcal() %> Kcal.
            &nbsp&nbsp&nbsp&nbsp&nbsp
            <%= postre.getPersonasParaCompartir()%> personas.

      </h6>
  <form action="/Proyecto/servlet-anadirComida" method="POST">
    <div class="inputbox">
      <input type="number" required="required" name="cantidad" min="0" max="100">
      <input type="hidden" name="idProducto" value="<%=postre.getId()%>">
      <span>Cantidad</span>
    </div>
    <div class="inputbox">
      <input type="submit" value="submit" class="boton">
    </div>
  </form>
</div>

</body>
</html>
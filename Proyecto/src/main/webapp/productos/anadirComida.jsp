<%@ page pageEncoding="UTF-8"%>
<%@page import="agg.persistence.dao.clases.Productos.*"%>

<html>
<head>
    <link href="/Proyecto/css/" rel="stylesheet" type="text/css">
</head>
<body>
<%Comida comida = (Comida) request.getAttribute("comida");%>
<div class="center">
  <h1><%= comida.getNombre() %></h1>
  <%
      String imagen = comida.getImagen();
  %>
    <img src="/Proyecto/images/<%=imagen%>" alt="">
  </div>
  <div class="detail-box">

    <p>
      <%= comida.getDescripcion() %>
    </p>
    <div class="options">
      <h6>
            <%= comida.getPrecio() %>  $
            &nbsp&nbsp&nbsp&nbsp&nbsp
            <%= comida.getTiempoDePreparacion() %> min.
            &nbsp&nbsp&nbsp&nbsp&nbsp
            <%if(comida.isVegano()){%>
             Vegano
            <%}else{%>
            No vegano
            <%}%>
      </h6>
  <form action="/Proyecto/servlet-anadirComida" method="POST">
    <div class="inputbox">
      <input type="number" required="required" name="cantidad" min="0" max="100">
      <input type="hidden" name="idProducto" value="<%=comida.getId()%>">
      <span>Cantidad</span>
    </div>
    <div class="inputbox">
      <input type="submit" value="submit" class="boton">
    </div>
  </form>
</div>

</body>
</html>

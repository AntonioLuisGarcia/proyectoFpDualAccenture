<%@ page pageEncoding="UTF-8"%>
<%@page import="agg.persistence.dao.clases.Productos.Bebida"%>

<html>
<head>
    <link href="/Proyecto/assets/css/" rel="stylesheet" type="text/css">
</head>
<body>
<%Bebida bebida = (Bebida) request.getAttribute("bebida");%>
<div class="center">
  <h1><%= bebida.getNombre() %></h1>
  <%
      String imagen = bebida.getImagen();
  %>
    <img src="/Proyecto/assets/images/<%=imagen%>" alt="">
  </div>
  <div class="detail-box">

    <p>
      <%= bebida.getDescripcion() %>
    </p>
    <div class="options">
      <h6>
            <%= bebida.getPrecio() %>  $
            &nbsp&nbsp&nbsp&nbsp&nbsp
            <%= bebida.getMiliLitros() %> ml.
            &nbsp&nbsp&nbsp&nbsp&nbsp
            <%if(bebida.isAlcoholica()){%>
             Con Alcohol
            <%}else{%>
            Sin Alcohol
            <%}%>
      </h6>
  <form action="/Proyecto/servlet-anadirComida" method="POST">
    <div class="inputbox">
      <input type="number" required="required" name="cantidad" min="0" max="100">
      <input type="hidden" name="idProducto" value="<%=bebida.getId()%>">
      <span>Cantidad</span>
    </div>
    <div class="inputbox">
      <input type="submit" value="submit" class="boton">
    </div>
  </form>
</div>

</body>
</html>
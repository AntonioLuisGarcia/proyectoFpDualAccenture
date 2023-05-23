<%@ page pageEncoding="UTF-8"%>
<%@page import="agg.persistence.dao.clases.Productos.Producto"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.Map.Entry"%>

<html>
<head>
    <link href="/Proyecto/assets/css/" rel="stylesheet" type="text/css">
</head>
<body>
    <%HashMap<Producto, Integer> lista  = (HashMap<Producto, Integer>) request.getAttribute("lista");
        int idComanda = (int) request.getAttribute("idComanda");
        %><%=idComanda%>

<div class="center">

        <% for(Map.Entry<Producto, Integer> p : lista.entrySet()){ %>

              <h1><%= p.getKey().getNombre() %></h1>
              <%
                  String imagen = p.getKey().getImagen();
              %>
                <img src="/Proyecto/assets/images/<%=imagen%>" alt="">
              </div>
              <div class="detail-box">

                <p>
                  <%= p.getKey().getDescripcion() %>
                </p>
                <div class="options">
                  <h4>
                        Precio: <%= p.getKey().getPrecio() %> $

                        <form action="/Proyecto/servlet-cambiarCantidadProductoEnComanda" method="POST">
                          <div class="inputbox">
                            <input type="hidden" value="<%=(p.getKey()).getId()%>" name="idProducto">
                            <input type="hidden" value="<%=idComanda%>" name="idComanda">
                            Unidades: <input type="number" value="<%=lista.get(p.getKey())%>" name="cantidad">  <br>
                            <input type="submit" value="Cambiar" class="boton">
                          </div>
                        </form>

                        <form action="/Proyecto/servlet-borrarComanda" method="POST">
                            <input type="hidden" value="<%=(p.getKey()).getId()%>" name="idProducto">
                            <input type="hidden" value="<%=idComanda%>" name="idComanda">
                          <div class="inputbox">
                            <input type="submit" value="Borrar" class="boton">
                          </div>
                        </form>
                  </h4>
            </div>
        <%}%>

        <form action="/Proyecto//servlet-anadirMasProductos" method="POST">
          <div class="inputbox">
            <input type="hidden" value="<%=idComanda%>" name="idComanda">
            <br>
            <input type="submit" value="Mas Productos" class="boton">
          </div>
        </form>

        <a href="menu/menu.jsp">Menu</a>
</body>
</html>
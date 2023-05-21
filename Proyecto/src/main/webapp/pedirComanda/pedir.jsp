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
    <%HashMap<Producto, Integer> lista  = (HashMap<Producto, Integer>) session.getAttribute("lista");%>
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
                  <h6>
                        <%= p.getKey().getPrecio() %>  $
                        <%=(int) lista.get(p.getKey())%> Unidades
                  </h6>
            </div>
        <%}%>

        <%
          //////////////////////Pasar por parametro el HashMap actualizado por si se cambia
          ////////////////////////EN EL FROMULARIO DE ARRIBA AÑADIREMOS UN BOOLEAN PARA SABER SI LLAMAMOS A ANADIRCOMIDA DESDE AQUI O DESDE OTRO LADO PARA QUE NOS VUELVA A ENVIAR AQUI Y NO TENER QUE VOLVER A RECORRER EL MENU(PODEMOS HACERLO YA O PARA ACABAR Y COMPLETARLO MAS)
          //////////////////////////Poner Email Contacto Mesa
        %>
            <form action="/Proyecto/servlet-crearComanda" method="POST">
              <div class="inputbox">
                <input type="text" name="email">
                <input type="number" name="mesa">
                <input type="submit" value="Pedir" class="boton">
              </div>
            </form>
</body>
</html>
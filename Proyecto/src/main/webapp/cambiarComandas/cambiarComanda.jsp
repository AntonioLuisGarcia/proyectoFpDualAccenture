<%@ page pageEncoding="UTF-8"%>
<%@page import="agg.persistence.dao.clases.Productos.Producto"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.Map.Entry"%>

<html>
<head>
    <link href="/Proyecto/assets/css/productos.css" rel="stylesheet" type="text/css">
</head>
<body>
    <%
    HashMap<Producto, Integer> lista  = (HashMap<Producto, Integer>) request.getAttribute("lista");
        int idComanda = (int) request.getAttribute("idComanda");
        %>

<div class="center">

        <% for(Map.Entry<Producto, Integer> p : lista.entrySet()){ %>

             <div class="product-card">
                <div class="product-tumb">
                    <%String imagen = (p.getKey()).getImagen();%>
                    <img src="/Proyecto/assets/images/<%=imagen%>" alt="">
                </div>
                <div class="product-details">
                    <span class="product-catagory">          </span>
                    <h4><a href=""><%= (p.getKey()).getNombre() %></a></h4>
                    <p><%= (p.getKey()).getDescripcion() %></p>
                    <div class="product-bottom-details">
                        <div class="product-price">
                            <%= (p.getKey()).getPrecio() %> $
                        </div>

                        <form action="/Proyecto/servlet-aumentarCantidad" method="POST">
                          <div class="inputbox">
                              <span style="font-size: 16px;color: #fbb72c;font-weight: 300;">Cantidad:</span>
                            <input type="hidden" value="<%=(p.getKey()).getId()%>" name="idProducto">
                            <input type="hidden" value="<%= idComanda %>" name="idComanda">
                            <input type="number" value="<%=lista.get(p.getKey())%>" name="cantidad" min="<%=lista.get(p.getKey())%>" max=100>
                          </div>
                          <div class="inputbox">
                            <input type="submit" value="Cambiar" class="boton">
                          </div>
                        </form>
                    </div>
                </div>
            </div>
        <%}%>

        <form id="anadir" action="/Proyecto//servlet-anadirMasProductos" method="POST">
            <input type="hidden" value="<%=idComanda%>" name="idComanda">
        </form>

        <div class="center-container" style="font-size:0.8rem">
              <button type="button" onclick="anadir('anadir')" style="--c:#E95A49">Añadir</button>
        </div>

        <div class="center-container" style="font-size:1.5rem">
            <a href="menu/menu.jsp">
              <button style="--c:#E95A49">Menu</button>
            </a>
        </div>

        <script>
          function anadir(formId) {
            document.getElementById(formId).submit();
          }
        </script>
</body>
</html>
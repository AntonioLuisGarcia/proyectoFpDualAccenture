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
    <%HashMap<Producto, Integer> lista  = (HashMap<Producto, Integer>) session.getAttribute("lista");%>
<div class="center">

        <% for(Map.Entry<Producto, Integer> p : lista.entrySet()){ %>


            <div class="product-card">
        		<div class="badge">Hot</div>
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

        				<form action="/Proyecto/servlet-anadirComida" method="POST">
                        <div class="inputbox">
                            <span style="font-size: 16px;color: #fbb72c;font-weight: 300;">Cantidad:</span>
                          <input type="hidden" value="<%=(p.getKey()).getId()%>" name="idProducto">
                          <input type="hidden" value="<%= true %>" name="cambio">
                          <input type="number" value="<%=lista.get(p.getKey())%>" name="cantidad">
                        </div>
                        <div class="inputbox">
                          <input type="submit" value="submit" class="boton">
                        </div>
                      </form>
        			</div>
        		</div>
        	</div>
        <%}%>


        <div class="product-card">
            <div class="product-details">

                <div class="product-bottom-details">
                    <form action="/Proyecto/servlet-crearComanda" method="POST">
                      <div class="inputbox">
                      Email:
                        <input type="text" name="email">
                        <br>
                        Nº Mesa:
                        <input type="number" name="mesa">
                        <br> <br>
                        <input type="submit" value="Pedir" class="boton">
                      </div>
                    </form>
                </div>
            </div>
        </div>

            <%
                String error = (String) request.getAttribute("error");
                if(error != null){%>
                <p><%= error %></p>
            <%  }%>

        <div class="center-container">
            <a href="menu/menu.jsp">
              <button style="--c:#E95A49">Volver</button>
            </a>
        </div>

</body>
</html>
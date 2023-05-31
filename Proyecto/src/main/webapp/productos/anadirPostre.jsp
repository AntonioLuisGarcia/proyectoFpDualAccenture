<%@ page pageEncoding="UTF-8"%>
<%@page import="agg.persistence.dao.clases.Productos.Postre"%>

<html>
<head>
    <link href="/Proyecto/assets/css/productos.css" rel="stylesheet" type="text/css">
</head>
<body>
<%Postre postre = (Postre) request.getAttribute("postre");%>


    <div class="product-card">
		<div class="badge">Casera</div>
		<div class="product-tumb">
		<%String imagen = postre.getImagen();%>
			<img src="/Proyecto/assets/images/<%=imagen%>" alt="">
		</div>
		<div class="product-details">
			<span class="product-catagory">Postre</span>
			<h4><a href=""><%= postre.getNombre() %></a></h4>
			<p><%= postre.getDescripcion() %></p>
			<div class="product-bottom-details">
				<div class="product-price">
				    <%= postre.getPrecio() %> $
				    <br>
                    <%= postre.getKcal() %> Kcal
                    <br>
                    <%=postre.getPersonasParaCompartir()%> Personas
                </div>

				<form action="/Proyecto/servlet-anadirComida" method="POST">
                <div class="inputbox">
                    <span style="font-size: 16px;color: #fbb72c;font-weight: 300;">Cantidad:</span>
                    <br>
                  <input type="number" required="required" name="cantidad" min="1" max="100">
                  <br>
                  <input type="hidden" name="idProducto" value="<%=postre.getId()%>">

                </div>
                <div class="inputbox">
                  <input type="submit" value="Pedir" class="boton">
                </div>
              </form>
			</div>
		</div>
	</div>

	<div class="center-container">
        <a href="menu/menu.jsp">
          <button style="--c:#E95A49">Volver</button>
        </a>
    </div>

</body>
</html>
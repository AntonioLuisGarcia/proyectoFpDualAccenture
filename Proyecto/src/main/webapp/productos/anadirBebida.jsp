<%@ page pageEncoding="UTF-8"%>
<%@page import="agg.persistence.dao.clases.Productos.Bebida"%>

<html>
<head>
    <link href="/Proyecto/assets/css/productos.css" rel="stylesheet" type="text/css">
</head>
<body>
<%Bebida bebida = (Bebida) request.getAttribute("bebida");%>

	<div class="product-card">
		<div class="badge">Hot</div>
		<div class="product-tumb">
		<%String imagen = bebida.getImagen();%>
			<img src="/Proyecto/assets/images/<%=imagen%>" alt="">
		</div>
		<div class="product-details">
			<span class="product-catagory">Bebida</span>
			<h4><a href=""><%= bebida.getNombre() %></a></h4>
			<p><%= bebida.getDescripcion() %></p>
			<div class="product-bottom-details">
				<div class="product-price">
				    <%= bebida.getPrecio() %> $
				    <br>
                    <%= bebida.getMiliLitros() %> ml
                    <br>
                    <%if(bebida.isAlcoholica()){%>
                        Con Alcohol
                    <%}else{%>
                        Sin Alcohol
                    <%}%>
				</div>

				<form action="/Proyecto/servlet-anadirComida" method="POST">
                <div class="inputbox">
                    <span style="font-size: 16px;color: #fbb72c;font-weight: 300;">Cantidad:</span>
                    <br>
                  <input type="number" required="required" name="cantidad" min="0" max="100">
                  <br>
                  <input type="hidden" name="idProducto" value="<%=bebida.getId()%>">

                </div>
                <div class="inputbox">
                  <input type="submit" value="submit" class="boton">
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
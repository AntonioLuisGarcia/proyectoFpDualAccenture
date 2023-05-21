<%@ page pageEncoding="UTF-8"%>
<%@page import="agg.persistence.dao.clases.Comanda"%>

<html>
<head>
    <link href="/Proyecto/assets/css/" rel="stylesheet" type="text/css">
</head>
<body>

        <%
          ////////////////////////Primero creamos Comanda -> Luego recorremos el HashMap y por cada objeto se crea una nueva ComandaProducto en BD
          //////////////////////////Borramos la lista de productos de esa comanda de la sesion por si hacemos otra comanda en otra mesa
          ////////////////////////////Para modificar la comanda pondremos otra funcion mas tarde cuando completemos esto
          Comanda comanda = (Comanda) request.getAttribute("comanda");
          %>

           <h1>Comanda Completada<h1>
           <h2>Id: <%=comanda.getId()%><h2>
           <a href="menu/menu.jsp">Menu</a>
</body>
</html>
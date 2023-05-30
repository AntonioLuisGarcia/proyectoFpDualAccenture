<%@ page pageEncoding="UTF-8"%>
<%@page import="agg.persistence.dao.clases.Comanda"%>
<%@page import="agg.client.ComandaProductoClient"%>
<%@page import="agg.service.ComandaProductoService"%>
<%@page import="agg.client.CamareroClient"%>
<%@page import="agg.service.CamareroService"%>
<%@page import="java.util.List"%>
<%@page import="agg.client.ProductoClient"%>
<%@page import="agg.persistence.dao.clases.ComandaProducto"%>
<%@page import="agg.persistence.dao.clases.ComandaProducto"%>
<%@page import="agg.persistence.dao.clases.Productos.Comida"%>
<%@page import="agg.service.ProductoService"%>

<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

    <link href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
    <link href="/Proyecto/assets/css/productos.css" rel="stylesheet" type="text/css">
</head>
<body style="background-color: #fffbee">
<%List<Comanda> comandas = (List<Comanda>) request.getAttribute("comandas");%>

<table class="table table-bordered">
  <thead>
    <tr>
      <th scope="col">Id</th>
      <th scope="col">Camarero</th>
      <th scope="col">Mesa</th>
      <th scope="col">Fecha</th>
      <th scope="col">Email</th>
      <th scope="col">Total</th>
      <th scope="col">Acciones</th>
    </tr>
  </thead>
  <tbody>

  <%
  String modificarComanda = "";
  String pagarComanda = "";
  double total = 0;
  String nombre = "";
  ComandaProductoService comandaProductoService = new ComandaProductoService(new ComandaProductoClient());
  ProductoService productoService = new ProductoService(new ProductoClient());
  CamareroService camareroService = new CamareroService(new CamareroClient());

    for(Comanda c : comandas){

        nombre = camareroService.getById(c.getIdCamarero()).getNombre();
        total = 0;
        List<ComandaProducto> comandasProducto = comandaProductoService.getByIdComanda(c.getId());

        for(ComandaProducto cp : comandasProducto){
            total += productoService.getById(cp.getIdProducto()).getPrecio() * cp.getCantidad();
        }

        //Para que solo salgan dos decimales
        total = ((int)(total * 100.0))/100.0;

        modificarComanda = "modificar" + c.getId();
        pagarComanda = "pagar" + c.getId();
  %>

  <tr>
            <th scope="row"><%= c.getId() %></th>
            <td><%= nombre %></td>
            <td><%= c.getIdMesa() %></td>
            <td><%= c.getLlegada()%></td>
            <td><%= c.getEmailContacto()%></td>
            <td><%=total%></td>
            <%if(!c.isPagada()){%>
            <form id="<%=modificarComanda%>" action="/Proyecto/servlet-modificarComanda" method="POST">
                  <input type="hidden" name="idComanda" value="<%=c.getId()%>">
            </form>

              <form id="<%=pagarComanda%>" action="/Proyecto/servlet-pagarComanda" method="POST">
                    <input type="hidden" name="idComanda" value="<%=c.getId()%>">
              </form>

            <td class="py-2">
              <button href="#" onclick="document.getElementById('<%=modificarComanda%>').submit()" type="button" class="btn btn-sm btn-primary"><i class="fa fa-eye"></i></button>
              <button href="#" onclick="document.getElementById('<%=pagarComanda%>').submit()" type="button" class="btn btn-sm btn-success"><i class="fa fa-edit"></i></button>
            </td>
            <%}%>
          </tr>
    <%}%>

     </tbody>
    </table>

    <div class="center-container">
                <a href="menu/menu.jsp">
                  <button style="--c:#E95A49">Inicio</button>
                </a>
            </div>
</body>
</html>
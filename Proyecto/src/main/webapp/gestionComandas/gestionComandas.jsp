<%@ page pageEncoding="UTF-8"%>
<%@page import="agg.persistence.dao.clases.Comanda"%>
<%@page import="java.util.List"%>

<html>
<head>
    <link href="/Proyecto/assets/css/" rel="stylesheet" type="text/css">
</head>
<body>
<%List<Comanda> comandas = (List<Comanda>) request.getAttribute("comandas");%>

  <%
    for(Comanda c : comandas){
  %>
  <div class="detail-box">

        <h3>Id: <%= c.getId() %><h3>
        <div class="options">
          <h3>
            Mesa: <%= c.getIdMesa() %>
            &nbsp&nbsp&nbsp&nbsp&nbsp
            Camarero: <%= c.getIdCamarero() %>
            &nbsp&nbsp&nbsp&nbsp&nbsp
            Llegada: <%= c.getLlegada()%>
            &nbsp&nbsp&nbsp&nbsp&nbsp
            Email: <%= c.getEmailContacto()%>
            <%
                //Calcular el total
            %>
          <h3>

          <form action="/Proyecto/servlet-modificarComanda" method="POST">
            <div class="inputbox">
              <input type="hidden" name="idComanda" value="<%=c.getId()%>">
            </div>
            <div class="inputbox">
              <input type="submit" value="Modificar" class="boton">
            </div>
          </form>

          <form action="/Proyecto/servlet-pagarComanda" method="POST">
              <div class="inputbox">
                <input type="hidden" name="idComanda" value="<%=c.getId()%>">
              </div>
              <div class="inputbox">
                <input type="submit" value="Pagar" class="boton">
              </div>
           </form>
        </div>
     </div>
    <%}%>
</body>
</html>
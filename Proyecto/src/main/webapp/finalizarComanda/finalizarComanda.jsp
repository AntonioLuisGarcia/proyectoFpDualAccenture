<%@ page pageEncoding="UTF-8"%>
<%@page import="agg.persistence.dao.clases.Comanda"%>

<html>
<head>
    <link href="/Proyecto/assets/css/productos.css" rel="stylesheet" type="text/css">
</head>
<body>

        <%
          Comanda comanda = (Comanda) request.getAttribute("comanda");

          if(comanda.isPagada()){
          %>
          <div class="product-card">
              <div class="product-details">
                  <h2>Pagado</h2>
                  <div class="product-bottom-details">
                      <div class="product-price">
                          Id: <%=comanda.getId()%>
                      </div>
                  </div>
              </div>
         </div>
          <%
            //calcular total de la cuenta
          }else{%>

           <div class="product-card">
               <div class="product-details">
                   <h2>Comanda Completada</h2>
                   <div class="product-bottom-details">
                       <div class="product-price">
                           Id: <%=comanda.getId()%>
                       </div>
                   </div>
               </div>
          </div>

           <%}%>

            <div class="center-container">
                       <a href="menu/menu.jsp">
                         <button style="--c:#E95A49">Inicio</button>
                       </a>
                   </div>
</body>
</html>
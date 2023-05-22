<%@ page pageEncoding="UTF-8"%>
<%@page import="agg.persistence.dao.clases.Productos.Postre"%>

<html>
<head>
    <!-- <link href="/Proyecto/assets/css/" rel="stylesheet" type="text/css"> -->
    <!-- <link rel="shortcut icon" href="/Proyecto/assets/images/favicon.png" type=""> -->

      <title> Feane </title>

      <!-- bootstrap core css -->
      <link rel="stylesheet" type="text/css" href="/Proyecto/assets/css/bootstrap.css" />

      <!--owl slider stylesheet -->
      <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/OwlCarousel2/2.3.4/assets/owl.carousel.min.css" />
      <!-- nice select  -->
      <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jquery-nice-select/1.1.0/css/nice-select.min.css" integrity="sha512-CruCP+TD3yXzlvvijET8wV5WxxEh5H8P4cmz0RFbKK6FlZ2sYl3AEsKlLPHbniXKSrDdFewhbmBK5skbdsASbQ==" crossorigin="anonymous" />
      <!-- font awesome style -->
      <link href="/Proyecto/assets/css/font-awesome.min.css" rel="stylesheet" />

      <!-- Custom styles for this template -->
      <link href="/Proyecto/assets/css/style.css" rel="stylesheet" />
      <!-- responsive style -->
      <link href="/Proyecto/assets/css/responsive.css" rel="stylesheet" />
</head>
<body>
<%Postre postre = (Postre) request.getAttribute("postre");%>

    <div class="filters-content">
      <div class="row grid">
      <h1><%= postre.getNombre() %></h1>

            <div class="col-sm-6 col-lg-4 all postre">
              <div class="box">
                <div>
                  <div class="img-box">
                  <%
                      String imagen = postre.getImagen();
                  %>
                    <img src="/Proyecto/assets/images/<%=imagen%>" alt="">
                  </div>
                  <div class="detail-box">
                    <h5>
                      <%= postre.getNombre() %>
                    </h5>
                    <p>
                      <%= postre.getDescripcion() %>
                    </p>
                    <div class="options">
                      <h6>

                    <%= postre.getPrecio() %>  $
                    &nbsp&nbsp&nbsp&nbsp&nbsp
                    <%= postre.getKcal() %> Kcal
                    &nbsp&nbsp&nbsp&nbsp&nbsp
                    <%= postre.getPersonasParaCompartir() %> personas

                      </h6>

                      <form action="/Proyecto/servlet-anadirComida" method="POST">
                          <div class="inputbox">
                            <input type="number" required="required" name="cantidad" min="0" max="100">
                            <input type="hidden" name="idProducto" value="<%=postre.getId()%>">
                            <span>Cantidad</span>
                          </div>
                          <div class="inputbox">
                            <input type="submit" value="submit" class="boton">
                          </div>
                        </form>
                    </div>
                  </div>
                </div>
              </div>
            </div>
        </div>
      </div>
</body>
</html>
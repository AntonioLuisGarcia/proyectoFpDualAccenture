<%@ page pageEncoding="UTF-8"%>
<html>
<head>
    <link href="/Proyecto/assets/css/login.css" rel="stylesheet" type="text/css">
</head>
<body>

    <div class="center">
      <h1>Login</h1>
      <form action="/Proyecto/servlet-login" method="POST">
        <div class="inputbox">
          <input type="text" required="required" name="usuario">
          <span>Usuario</span>
        </div>
        <div class="inputbox">
          <input type="password" required="required" name="contrasenia">
          <span>Contraseña</span>
        </div>
        <div class="inputbox">
          <input type="submit" value="Entrar" class="boton">
        </div>

        <% if(request.getAttribute("error")!=null){ %>
            <p style="color: red"><%=request.getAttribute("error")%></p>
        <%}%>

      </form>
    </div>

</body>
</html>

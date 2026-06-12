<!DOCTYPE html>
<html>
<head>
    <title>Login NexusPC</title>
</head>
<body>

<h2>Login NexusPC</h2>

<form action="${pageContext.request.contextPath}/login"
      method="post">

    <input type="text"
           name="usuario"
           placeholder="Usuario"
           required>

    <br><br>

    <input type="password"
           name="password"
           placeholder="Contraseña"
           required>

    <br><br>

    <button type="submit">
        Ingresar
    </button>

</form>

<br>

<a href="register.jsp">
    Registrarse
</a>

</body>
</html>
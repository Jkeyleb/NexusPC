<%@ page contentType="text/html;charset=UTF-8"%>

<!DOCTYPE html>
<html>
<head>

<title>Dashboard Admin</title>

<link rel="stylesheet"
href="${pageContext.request.contextPath}/assets/css/style.css">

</head>

<body>

<div class="sidebar">

    <div class="logo">
        NexusPC
    </div>

    <div class="menu">

        <a href="#">Dashboard</a>

        <a href="#">Inventario</a>

        <a href="#">Clientes</a>

        <a href="#">Ventas</a>

        <a href="#">Garantías</a>

        <a href="#">Usuarios</a>

        <a href="#">Reportes</a>

        <a href="${pageContext.request.contextPath}/logout">
            Cerrar Sesión
        </a>

    </div>

</div>

<div class="main">

    <div class="card">

        <h1>Panel Administrador</h1>

        <br>

        <p>
            Bienvenido a NexusPC
        </p>

        <h3>JWT</h3>

        <textarea rows="8"
                  cols="90">

        ${sessionScope.jwt}

        </textarea>
    </div>

</div>

</body>
</html>
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

        <a href="${pageContext.request.contextPath}/dashboard-admin">
            Dashboard
        </a>

        <a href="${pageContext.request.contextPath}/inventario">
            Inventario
        </a>

        <a href="${pageContext.request.contextPath}/clientes">
            Clientes
        </a>

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

        <div class="container mt-4">

        <h2>Dashboard NexusPC</h2>

        <br>

        <div class="row">

        <div class="col-md-4">

        <div class="card shadow">

        <div class="card-body text-center">

        <h6>Total Productos</h6>

        <h2>${totalProductos}</h2>

        </div>

        </div>

        </div>

        <div class="col-md-4">

        <div class="card shadow">

        <div class="card-body text-center">

        <h6>Stock Bajo</h6>

        <h2 class="text-danger">

        ${stockBajo}

        </h2>

        </div>

        </div>

        </div>

        <div class="col-md-4">

        <div class="card shadow">

        <div class="card-body text-center">

        <h6>Valor Inventario</h6>

        <h2 class="text-success">

        S/ ${valorInventario}

        </h2>

        </div>

        </div>

        </div>

        </div>

        <br>

        <h4>

        Últimos Productos

        </h4>

        <table class="table table-striped">

        <tr>

        <th>ID</th>

        <th>Producto</th>

        <th>Stock</th>

        <th>Precio</th>

        </tr>

        <%@ page import="java.util.List"%>
        <%@ page import="com.nexuspc.model.Producto"%>

        <%

        List<Producto> lista =
        (List<Producto>) request.getAttribute("ultimosProductos");

        if (lista != null) {

            for (Producto p : lista) {
        %>

        <tr>
            <td><%=p.getIdProducto()%></td>
            <td><%=p.getNombre()%></td>
            <td><%=p.getStock()%></td>
            <td>S/ <%=p.getPrecio()%></td>
        </tr>

        <%
            }
        }
        %>

        </table>

        </div>
    </div>

</div>

</body>
</html>
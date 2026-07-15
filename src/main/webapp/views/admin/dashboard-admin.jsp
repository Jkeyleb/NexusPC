<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="com.nexuspc.model.Producto"%>

<div class="main">

    <div class="content-card">

        <h1>Panel Administrador</h1>

        <br>

        <p>
            Bienvenido a NexusPC
        </p>

        <div class="container mt-4">

        <h2>Dashboard NexusPC</h2>

        <br>

        <div class="dashboard-cards">

            <div class="card shadow">
                <div class="card-body text-center">
                    <h6>Total Productos</h6>
                    <h2>${totalProductos}</h2>
                </div>
            </div>

            <div class="card shadow">
                <div class="card-body text-center">
                    <h6>Stock Bajo</h6>
                    <h2 class="text-danger">${stockBajo}</h2>
                </div>
            </div>

            <div class="card shadow">
                <div class="card-body text-center">
                    <h6>Valor Inventario</h6>
                    <h2 class="text-success">S/ ${valorInventario}</h2>
                </div>
            </div>

            <div class="card shadow">
                <div class="card-body text-center">
                    <h6>Total Clientes</h6>
                    <h2 class="text-primary">${totalClientes}</h2>
                </div>
            </div>

        </div>

        <br>

        <h4>Últimos Productos</h4>

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
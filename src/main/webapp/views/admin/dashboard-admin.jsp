<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="com.nexuspc.model.Producto"%>
<%@ page import="com.nexuspc.model.User"%>

<%
User usuario = (User) session.getAttribute("user");
%>

<div class="main">

    <div class="content-card">

        <h1 class="fw-bold">

            ¡Bienvenido,
            <%=usuario.getNombre()%>!

        </h1>

        <p class="text-muted">

            Rol:
            <strong><%=usuario.getRole().getNombre()%></strong>

        </p>

        <p class="text-muted">

            📅 Fecha:
            ${fechaActual}

        </p>

        <hr>

        <div class="container mt-4">

        <h2 class="mb-4">

        📊 Dashboard General

        </h2>

        <br>

        <div class="dashboard-cards">

            <div class="card shadow border-0 bg-primary text-white">
                <div class="card-body text-center">

                    <h1>📦</h1>

                    <h5>Total Productos</h5>

                    <h2>${totalProductos}</h2>

                </div>
            </div>

            <div class="card shadow border-0 bg-danger text-white">

            <div class="card-body text-center">

            <h1>⚠</h1>

            <h5>Stock Bajo</h5>

            <h2>${stockBajo}</h2>

            </div>

            </div>

            <div class="card shadow border-0 bg-success text-white">

            <div class="card-body text-center">

            <h1>💰</h1>

            <h5>Valor Inventario</h5>
                    <h2>

                    S/ ${valorInventario}

                    </h2>
                </div>
            </div>

            <div class="card shadow border-0 bg-info text-white">

            <div class="card-body text-center">

            <h1>👥</h1>

            <h5>Clientes</h5>

            <h2>${totalClientes}</h2>

            </div>

            </div>

        </div>

        <br>

        <h4 class="mt-5 mb-3">

        📦 Últimos productos registrados

        </h4>

        <table class="table table-hover table-bordered shadow-sm">

        <tr>

        <th class="text-center">ID</th>
        <th class="text-center">Producto</th>
        <th class="text-center">Stock</th>
        <th class="text-center">Precio</th>

        </tr>

        <%

        List<Producto> lista =
        (List<Producto>) request.getAttribute("ultimosProductos");


        if (lista != null && !lista.isEmpty()) {

            for (Producto p : lista) {
        %>

        <tr>
            <td class="text-center"><%=p.getIdProducto()%></td>
            <td class="text-center"><%=p.getNombre()%></td>
            <td class="text-center"><%=p.getStock()%></td>
            <td class="text-center">S/ <%=p.getPrecio()%></td>
        </tr>

        <%

            }
        }else {
         %>

         <tr>

             <td colspan="4"
                 class="text-center text-muted">

                 No existen productos registrados.

             </td>

         </tr>

         <%
         }
        %>


        </table>

        </div>
    </div>

</div>

</body>
</html>
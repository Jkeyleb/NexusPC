<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="com.nexuspc.model.Producto"%>

<div class="content-card">

    <h2 class="mb-4">
        ⚠ Reporte de Productos con Stock Bajo
    </h2>

    <table class="table table-hover table-bordered">

        <thead class="table-dark">

        <tr>

            <th>ID</th>
            <th>Producto</th>
            <th>Proveedor</th>
            <th>Stock</th>
            <th>Stock Mínimo</th>
            <th>Estado</th>

        </tr>

        </thead>

        <tbody>

<%

List<Producto> lista =
(List<Producto>) request.getAttribute("productos");

if(lista != null && !lista.isEmpty()){

for(Producto p : lista){

%>

<tr>

    <td><%=p.getIdProducto()%></td>

    <td><%=p.getNombre()%></td>

    <td><%=p.getProveedor()%></td>

    <td>

        <span class="badge bg-danger">

            <%=p.getStock()%>

        </span>

    </td>

    <td><%=p.getStockMinimo()%></td>

    <td>

        <span class="badge bg-warning text-dark">

            Reponer

        </span>

    </td>

</tr>

<%

}

}else{

%>

<tr>

<td colspan="6"
    class="text-center text-success">

    No existen productos con stock bajo.

</td>

</tr>

<%

}

%>

        </tbody>

    </table>

</div>
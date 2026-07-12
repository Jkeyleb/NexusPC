<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="com.nexuspc.model.Producto"%>

<!DOCTYPE html>
<html>
<head>

<title>Inventario</title>

<link rel="stylesheet"
href="${pageContext.request.contextPath}/assets/css/style.css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/css/bootstrap.min.css"
      rel="stylesheet">
<link rel="stylesheet"
href="${pageContext.request.contextPath}/assets/css/inventario.css">
</head>

<body>

<div class="main">

<h1>Inventario NexusPC</h1>

<br>

<a href="${pageContext.request.contextPath}/views/admin/inventario.jsp">

Nuevo Producto

</a>

<br><br>

<div style="display:flex;gap:20px;margin-bottom:20px;">

<div class="row mb-4">

<div class="col-md-4">

<div class="card kpi-card">

<div class="card-body text-center">

<h6>Total Productos</h6>

<h2 class="text-primary">

${totalProductos}

</h2>

</div>

</div>

</div>

<div class="col-md-4">

<div class="card kpi-card">

<div class="card-body text-center">

<h6>Stock Bajo</h6>

<h2 class="text-danger">

${stockBajo}

</h2>

</div>

</div>

</div>

<div class="col-md-4">

<div class="card kpi-card">

<div class="card-body text-center">

<h6>Valor Inventario</h6>

<h2 class="text-success">

S/ ${valorInventario}

</h2>

</div>

</div>

</div>

</div>

</div>

<div class="card mb-3">

<div class="card-body">

<form action="${pageContext.request.contextPath}/inventario"
      method="get">

<div class="row">

<div class="col-md-10">

<input
type="text"
name="buscar"
value="${param.buscar}"
class="form-control"
placeholder="Buscar por nombre o proveedor">

</div>

<div class="col-md-2">

<button
class="btn btn-primary w-100">

Buscar

</button>

</div>

</div>

</form>

</div>

</div>
<table class="table table-hover table-striped align-middle">

<tr>

<th>ID</th>
<th>Nombre</th>
<th>Precio</th>
<th>Stock</th>
<th>Stock Min.</th>
<th>Proveedor</th>
<th>Estado</th>
<th>Acciones</th>

</tr>

<%

List<Producto> productos =
(List<Producto>)
request.getAttribute("productos");

for(Producto p : productos){
%>
<tr>

<td><%=p.getIdProducto()%></td>

<td><%=p.getNombre()%></td>

<td>S/ <%=p.getPrecio()%></td>

<td><%=p.getStock()%></td>

<td><%=p.getStockMinimo()%></td>

<td><%=p.getProveedor()%></td>

<td>

<%
if(p.getStock() <= p.getStockMinimo()){
%>

<span class="badge bg-danger">

STOCK BAJO

</span>

<%
}else{
%>

<span class="badge bg-success">

DISPONIBLE

</span>

<%
}
%>
<%
if(productos.isEmpty()){
%>

<tr>

<td colspan="8" class="text-center">

No se encontraron productos.

</td>

</tr>

<%
}
%>

</td>

<td>

<a
class="btn btn-warning btn-sm"
href="${pageContext.request.contextPath}/editar-producto?id=<%=p.getIdProducto()%>">

Editar

</a>

<a
class="btn btn-danger btn-sm"
href="${pageContext.request.contextPath}/eliminar-producto?id=<%=p.getIdProducto()%>"
onclick="return confirm('¿Eliminar producto?')">

Eliminar

</a>

</td>

</tr>

<%
}
%>

</table>

</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
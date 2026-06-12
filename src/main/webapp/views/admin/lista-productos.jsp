<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="com.nexuspc.model.Producto"%>

<!DOCTYPE html>
<html>
<head>

<title>Inventario</title>

<link rel="stylesheet"
href="${pageContext.request.contextPath}/assets/css/style.css">

</head>

<body>

<div class="main">

<h1>Inventario NexusPC</h1>

<br>

<a href="${pageContext.request.contextPath}/views/admin/inventario.jsp">

Nuevo Producto

</a>

<br><br>

<table border="1" cellpadding="10">

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

<span style="color:red;font-weight:bold;">
STOCK BAJO
</span>

<%
}else{
%>

<span style="color:green;font-weight:bold;">
OK
</span>

<%
}
%>

</td>

<td>

<a href="${pageContext.request.contextPath}/editar-producto?id=<%=p.getIdProducto()%>">
Editar
</a>

|

<a href="${pageContext.request.contextPath}/eliminar-producto?id=<%=p.getIdProducto()%>"
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

</body>
</html>
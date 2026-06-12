<%@ page import="com.nexuspc.model.Producto"%>

<%
Producto p =
(Producto) request.getAttribute("producto");
%>

<form action="${pageContext.request.contextPath}/editar-producto"
      method="post">

<input type="hidden"
       name="id"
       value="<%=p.getIdProducto()%>">

Nombre:

<input type="text"
       name="nombre"
       value="<%=p.getNombre()%>">

<br><br>

Descripción:

<input type="text"
       name="descripcion"
       value="<%=p.getDescripcion()%>">

<br><br>

Precio:

<input type="number"
       step="0.01"
       name="precio"
       value="<%=p.getPrecio()%>">

<br><br>

Stock:

<input type="number"
       name="stock"
       value="<%=p.getStock()%>">

<br><br>

Stock Mínimo:

<input type="number"
       name="stockMinimo"
       value="<%=p.getStockMinimo()%>">

<br><br>

Proveedor:

<input type="text"
       name="proveedor"
       value="<%=p.getProveedor()%>">

<br><br>

<button type="submit">

Actualizar

</button>

</form>
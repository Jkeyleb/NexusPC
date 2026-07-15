<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="com.nexuspc.model.Cliente"%>
<%@ page import="com.nexuspc.model.Producto"%>

<div class="content-card">

<h2>Nueva Venta</h2>

<br>

<form action="${pageContext.request.contextPath}/agregar-producto-venta"
      method="post">
<div class="mb-3">

<label>Cliente</label>

<select name="idCliente" class="form-select">

<%
List<Cliente> clientes =
(List<Cliente>)request.getAttribute("clientes");

for(Cliente c : clientes){
%>

<option value="<%=c.getIdCliente()%>">

<%=c.getNombre()%>

</option>

<%
}
%>

</select>

</div>

<div class="mb-3">

<label>Producto</label>

<select name="idProducto" class="form-select">

<%
List<Producto> productos =
(List<Producto>)request.getAttribute("productos");

for(Producto p : productos){
%>

<option value="<%=p.getIdProducto()%>">

<%=p.getNombre()%>

</option>

<%
}
%>

</select>

</div>

<div class="mb-3">

<label>Cantidad</label>

<input
type="number"
name="cantidad"
class="form-control"
value="1"
min="1">

</div>

<button
class="btn btn-success"
type="submit">

Agregar al carrito

</button>

</form>

<hr>

<h4>Detalle de Venta</h4>

<table class="table table-striped">

<thead>

<tr>

<th>Producto</th>
<th>Cantidad</th>
<th>Precio</th>
<th>Subtotal</th>

</tr>

</thead>

<tbody>

<%
List<com.nexuspc.model.DetalleVenta> carrito =
        (List<com.nexuspc.model.DetalleVenta>)
                session.getAttribute("carrito");

double subtotal = 0;

if(carrito != null && !carrito.isEmpty()){

    for(com.nexuspc.model.DetalleVenta d : carrito){

        subtotal += d.getSubtotal();
%>

<tr>

<td><%=d.getProducto().getNombre()%></td>

<td><%=d.getCantidad()%></td>

<td>S/ <%=d.getPrecioUnitario()%></td>

<td>S/ <%=d.getSubtotal()%></td>

</tr>

<%
    }

}else{
%>

<tr>

<td colspan="4"
class="text-center">

Aún no hay productos.

</td>

</tr>

<%
}
%>

</tbody>

</table>

<%
double igv = subtotal * 0.18;
double total = subtotal + igv;
%>

<hr>

<div style="text-align:right;">

<h5>

Subtotal:
S/ <%=String.format("%.2f",subtotal)%>

</h5>

<h5>

IGV (18%):
S/ <%=String.format("%.2f",igv)%>

</h5>

<h3>

Total:
S/ <%=String.format("%.2f",total)%>

</h3>

</div>

<form
action="${pageContext.request.contextPath}/registrar-venta"
method="post">

<input
type="hidden"
name="idCliente"
value="<%=request.getParameter("idCliente")==null?"1":request.getParameter("idCliente")%>">

<button
class="btn btn-primary btn-lg mt-3">

Registrar Venta

</button>

</form>

</div>
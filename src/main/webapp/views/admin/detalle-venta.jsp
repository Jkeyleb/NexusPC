<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="com.nexuspc.model.Venta"%>
<%@ page import="com.nexuspc.model.DetalleVenta"%>
<%@ page import="java.util.List"%>

<%
Venta venta = (Venta) request.getAttribute("venta");

List<DetalleVenta> detalles =
        (List<DetalleVenta>) request.getAttribute("detalles");

double subtotal = 0;

for(DetalleVenta d : detalles){

    subtotal += d.getSubtotal();

}

double igv = subtotal * 0.18;
double total = subtotal + igv;
%>

<div class="content-card">

<h2>Detalle de Venta</h2>

<hr>

<div class="row">

<div class="col-md-6">

<p>

<b>N° Venta:</b>

<%=venta.getIdVenta()%>

</p>

<p>

<b>Cliente:</b>

<%=venta.getCliente().getNombre()%>

</p>

</div>

<div class="col-md-6">

<p>

<b>Fecha:</b>

<%=venta.getFecha()%>

</p>

<p>

<b>Vendedor:</b>

<%=venta.getUsuario().getNombre()%>

</p>

</div>

</div>

<hr>

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
for(DetalleVenta d : detalles){
%>

<tr>

<td><%=d.getProducto().getNombre()%></td>

<td><%=d.getCantidad()%></td>

<td>S/ <%=String.format("%.2f",d.getPrecioUnitario())%></td>

<td>S/ <%=String.format("%.2f",d.getSubtotal())%></td>

</tr>

<%
}
%>

</tbody>

</table>

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

TOTAL:

S/ <%=String.format("%.2f",total)%>

</h3>

</div>

<hr>

<a
class="btn btn-secondary"
href="${pageContext.request.contextPath}/ventas">

Volver

</a>

<a
class="btn btn-danger"
href="${pageContext.request.contextPath}/boleta-pdf?id=<%=venta.getIdVenta()%>">

📄 Descargar PDF

</a>

</div>
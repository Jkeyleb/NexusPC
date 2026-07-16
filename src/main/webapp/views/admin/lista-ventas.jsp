<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="com.nexuspc.model.Venta"%>
<%@ page import="java.time.format.DateTimeFormatter"%>

<div class="content-card">

<h2>Historial de Ventas</h2>

<br>

<form action="${pageContext.request.contextPath}/ventas"
      method="get"
      class="row g-3 mb-4">

    <div class="col-md-4">

        <label class="form-label">
            Buscar por fecha
        </label>

        <input
                type="date"
                name="fecha"
                class="form-control"
                value="<%=request.getAttribute("fechaSeleccionada")==null?"":request.getAttribute("fechaSeleccionada")%>">

    </div>

    <div class="col-md-8 d-flex align-items-end">

        <button
                class="btn btn-primary me-2"
                type="submit">

            🔍 Buscar

        </button>

        <a
                href="${pageContext.request.contextPath}/ventas"
                class="btn btn-secondary">

            Mostrar todas

        </a>

    </div>

</form>

<br>

<table class="table table-hover">

<thead>

<tr>

<th>ID</th>
<th>Fecha</th>
<th>Hora</th>
<th>Cliente</th>
<th>Vendedor</th>
<th>Total</th>
<th class="text-center">Acciones</th>

</tr>

</thead>

<tbody>

<%
DateTimeFormatter formatoFecha =
        DateTimeFormatter.ofPattern("dd/MM/yyyy");

DateTimeFormatter formatoHora =
        DateTimeFormatter.ofPattern("HH:mm");

List<Venta> ventas =
        (List<Venta>) request.getAttribute("ventas");

if (ventas != null) {

    for (Venta v : ventas) {
%>

<tr>

<td><%=v.getIdVenta()%></td>

<td><%=v.getFecha().format(formatoFecha)%></td>

<td><%=v.getFecha().format(formatoHora)%></td>

<td><%=v.getCliente().getNombre()%></td>

<td><%=v.getUsuario().getNombre()%></td>

<td>S/ <%=String.format("%.2f",v.getTotal())%></td>

<td class="text-center">
<a
class="btn btn-outline-primary btn-sm"
href="${pageContext.request.contextPath}/detalle-venta?id=<%=v.getIdVenta()%>">

👁 Ver

</a>
</td>

</tr>

<%

}

}

%>

</tbody>

</table>

</div>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="java.time.format.DateTimeFormatter"%>
<%@ page import="com.nexuspc.model.Venta"%>

<%
List<Venta> ventas =
        (List<Venta>)request.getAttribute("ventas");

DateTimeFormatter formato =
        DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
%>

<div class="content-card">

    <h2>📈 Reporte de Ventas</h2>

    <hr>

    <form action="${pageContext.request.contextPath}/reporte-ventas"
          method="get"
          class="row g-3 mb-4">

        <div class="col-md-4">

            <label class="form-label">

                Desde

            </label>

            <input
                    type="date"
                    name="desde"
                    class="form-control"
                    value="${desde}">

        </div>

        <div class="col-md-4">

            <label class="form-label">

                Hasta

            </label>

            <input
                    type="date"
                    name="hasta"
                    class="form-control"
                    value="${hasta}">

        </div>

        <div class="col-md-4 d-flex align-items-end">

            <button
                    type="submit"
                    class="btn btn-primary">

                🔍 Buscar

            </button>

            <a
            class="btn btn-danger ms-2"
            href="${pageContext.request.contextPath}/reporte-ventas-pdf?desde=${desde}&hasta=${hasta}">

                📄 Exportar PDF

            </a>

        </div>

    </form>

    <table class="table table-hover table-bordered">

        <thead class="table-dark">

        <tr>

            <th>ID</th>
            <th>Fecha</th>
            <th>Cliente</th>
            <th>Vendedor</th>
            <th>Total</th>

        </tr>

        </thead>

        <tbody>

        <%

        if(ventas != null && !ventas.isEmpty()){

            for(Venta v : ventas){

        %>

        <tr>

            <td><%=v.getIdVenta()%></td>

            <td><%=v.getFecha().format(formato)%></td>

            <td><%=v.getCliente().getNombre()%></td>

            <td><%=v.getUsuario().getNombre()%></td>

            <td>
                S/
                <%=String.format("%.2f",v.getTotal())%>
            </td>

        </tr>

        <%

            }

        }else{

        %>

        <tr>

            <td colspan="5"
                class="text-center text-muted">

                No existen ventas para ese rango de fechas.

            </td>

        </tr>

        <%

        }

        %>

        </tbody>

    </table>

    <div class="card mt-4 shadow">

        <div class="card-body text-end">

            <h4>

                Total vendido:

                <span class="text-success">

                    S/
                    <%=String.format("%.2f",
                    (Double)request.getAttribute("totalVentas"))%>

                </span>

            </h4>

        </div>

    </div>

</div>
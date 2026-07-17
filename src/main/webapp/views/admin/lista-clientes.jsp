<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="com.nexuspc.model.Cliente"%>


<title>Clientes</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/css/bootstrap.min.css"
      rel="stylesheet">


<div class="content-card">

    <h2 class="mb-4">
        👥 Clientes
    </h2>

    <a
        class="btn btn-primary mb-3"
        href="${pageContext.request.contextPath}/nuevo-cliente">

        ➕ Nuevo Cliente

    </a>

    <table class="table table-striped table-hover">

<tr>

<th>ID</th>
<th>Nombre</th>
<th>Tipo</th>
<th>Teléfono</th>
<th>Email</th>
<th>Acciones</th>

</tr>

<%

List<Cliente> lista =
(List<Cliente>) request.getAttribute("clientes");

for(Cliente c : lista){

%>

<tr>

    <td><%=c.getIdCliente()%></td>

    <td><%=c.getNombre()%></td>

    <td><%=c.getTipo()%></td>

    <td><%=c.getTelefono()%></td>

    <td><%=c.getEmail()%></td>

    <td class="d-flex gap-2">

        <a class="btn btn-warning btn-sm"
           href="${pageContext.request.contextPath}/editar-cliente?id=<%=c.getIdCliente()%>">

            Editar

        </a>

        <a class="btn btn-danger btn-sm"
           href="${pageContext.request.contextPath}/eliminar-cliente?id=<%=c.getIdCliente()%>"
           onclick="return confirm('¿Desea deshabilitar este cliente?');">

            Deshabilitar

        </a>

    </td>

</tr>

<%

}

%>

</table>

</div>

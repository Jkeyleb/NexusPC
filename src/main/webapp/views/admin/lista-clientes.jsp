<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="com.nexuspc.model.Cliente"%>

<!DOCTYPE html>

<html>

<head>

<title>Clientes</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/css/bootstrap.min.css"
      rel="stylesheet">

</head>

<body class="bg-light">

<div class="container mt-4">

<h2>Clientes</h2>

<a
class="btn btn-primary mb-3"
href="${pageContext.request.contextPath}/views/admin/nuevo-cliente.jsp">

Nuevo Cliente

</a>

<table class="table table-striped table-hover">

<tr>

<th>ID</th>
<th>Nombre</th>
<th>Tipo</th>
<th>Teléfono</th>
<th>Email</th>

</tr>

<%

List<Cliente> lista =
(List<Cliente>)request.getAttribute("clientes");

for(Cliente c : lista){

%>

<tr>

<td><%=c.getIdCliente()%></td>

<td><%=c.getNombre()%></td>

<td><%=c.getTipo()%></td>

<td><%=c.getTelefono()%></td>

<td><%=c.getEmail()%></td>

</tr>

<%

}

%>

</table>

</div>

</body>

</html>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="com.nexuspc.model.Cliente"%>

<%
Cliente cliente =
(Cliente)request.getAttribute("cliente");
%>

<div class="content-card">

<h2>Editar Cliente</h2>

<br>

<form
action="${pageContext.request.contextPath}/actualizar-cliente"
method="post">

<input
type="hidden"
name="id"
value="<%=cliente.getIdCliente()%>">

<div class="mb-3">

<label>Nombre</label>

<input
type="text"
name="nombre"
class="form-control"
value="<%=cliente.getNombre()%>"
required>

</div>

<div class="mb-3">

<label>Tipo</label>

<input
type="text"
name="tipo"
class="form-control"
value="<%=cliente.getTipo()%>"
required>

</div>

<div class="mb-3">

<label>Teléfono</label>

<input
type="text"
name="telefono"
class="form-control"
value="<%=cliente.getTelefono()%>">

</div>

<div class="mb-3">

<label>Email</label>

<input
type="email"
name="email"
class="form-control"
value="<%=cliente.getEmail()%>">

</div>

<button
class="btn btn-success">

Actualizar Cliente

</button>

</form>

</div>
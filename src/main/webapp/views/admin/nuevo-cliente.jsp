<%@ page contentType="text/html;charset=UTF-8"%>

<!DOCTYPE html>

<html>

<head>

<title>Nuevo Cliente</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/css/bootstrap.min.css"
      rel="stylesheet">

</head>

<body class="bg-light">

<div class="container mt-5">

<div class="card shadow">

<div class="card-body">

<h3>Registrar Cliente</h3>

<form
method="post"
action="${pageContext.request.contextPath}/clientes">

<div class="mb-3">

<label>Nombre</label>

<input
name="nombre"
class="form-control"
required>

</div>

<div class="mb-3">

<label>Tipo</label>

<select
name="tipo"
class="form-select">

<option value="PERSONA">

PERSONA

</option>

<option value="EMPRESA">

EMPRESA

</option>

</select>

</div>

<div class="mb-3">

<label>Teléfono</label>

<input
name="telefono"
class="form-control">

</div>

<div class="mb-3">

<label>Email</label>

<input
type="email"
name="email"
class="form-control">

</div>

<button
class="btn btn-success">

Guardar Cliente

</button>

<a
class="btn btn-secondary"
href="${pageContext.request.contextPath}/clientes">

Cancelar

</a>

</form>

</div>

</div>

</div>

</body>

</html>
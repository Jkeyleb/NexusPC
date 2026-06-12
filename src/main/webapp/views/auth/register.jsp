<!DOCTYPE html>
<html>
<head>
    <title>Registro</title>
</head>
<body>

<h2>Registro NexusPC</h2>

<form action="${pageContext.request.contextPath}/register"
      method="post">

    <input type="text"
           name="nombre"
           placeholder="Nombre"
           required>

    <br><br>

    <input type="text"
           name="usuario"
           placeholder="Usuario"
           required>

    <br><br>

    <input type="password"
           name="password"
           placeholder="Contraseña"
           required>

    <br><br>

    <select name="rol">

        <option value="1">
            ADMIN
        </option>

        <option value="2">
            VENDEDOR
        </option>

        <option value="3">
            ALMACEN
        </option>

    </select>

    <br><br>

    <button type="submit">
        Registrar
    </button>

</form>

</body>
</html>
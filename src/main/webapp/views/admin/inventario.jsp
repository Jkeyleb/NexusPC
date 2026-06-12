<%@ page contentType="text/html;charset=UTF-8"%>

<!DOCTYPE html>
<html>
<head>

<title>Inventario</title>

</head>
<body>

<h1>Registrar Producto</h1>

<form action="${pageContext.request.contextPath}/producto"
      method="post">

    <input type="text"
           name="nombre"
           placeholder="Nombre">

    <br><br>

    <input type="text"
           name="descripcion"
           placeholder="Descripción">

    <br><br>

    <input type="number"
           step="0.01"
           name="precio"
           placeholder="Precio">

    <br><br>

    <input type="number"
           name="stock"
           placeholder="Stock">

    <br><br>

    <input type="number"
           name="stockMinimo"
           placeholder="Stock Mínimo">

    <br><br>

    <input type="text"
           name="proveedor"
           placeholder="Proveedor">

    <br><br>

    <button type="submit">
        Guardar
    </button>

</form>

</body>
</html>
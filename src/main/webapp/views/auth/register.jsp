<%@ page contentType="text/html;charset=UTF-8"%>

<!DOCTYPE html>

<html>

<head>

    <title>Registro - NexusPC</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/css/bootstrap.min.css"
          rel="stylesheet">

    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/assets/css/login.css">

</head>

<body class="login-body">

<div class="overlay">

    <div class="login-card">

        <img
                src="${pageContext.request.contextPath}/assets/img/nexus.png"
                class="logo">

        <h2>Crear Cuenta</h2>

        <p class="text-muted">

            Registro de usuarios NexusPC

        </p>

        <form action="${pageContext.request.contextPath}/register"
              method="post">

            <div class="mb-3">

                <input
                        type="text"
                        name="nombre"
                        class="form-control"
                        placeholder="Nombre completo"
                        required>

            </div>

            <div class="mb-3">

                <input
                        type="text"
                        name="usuario"
                        class="form-control"
                        placeholder="Usuario"
                        required>

            </div>

            <div class="mb-3">

                <input
                        type="password"
                        name="password"
                        class="form-control"
                        placeholder="Contraseña"
                        required>

            </div>

            <div class="mb-4">

                <select
                        name="rol"
                        class="form-select">

                    <option value="1">

                        Administrador

                    </option>

                    <option value="2">

                        Vendedor

                    </option>

                    <option value="3">

                        Almacén

                    </option>

                </select>

            </div>

            <button
                    class="btn btn-success w-100 btn-login"
                    type="submit">

                Registrarse

            </button>

        </form>

        <div class="text-center mt-4">

            ¿Ya tienes una cuenta?

            <a href="login.jsp">

                Iniciar sesión

            </a>

        </div>

    </div>

</div>

</body>

</html>
<%@ page contentType="text/html;charset=UTF-8"%>

<!DOCTYPE html>

<html>

<head>

    <title>Login - NexusPC</title>

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

        <h2>NexusPC</h2>

        <p class="text-muted">

            Sistema CMR de Inventario

        </p>

        <%
        String error =
                (String) session.getAttribute("error");

        if(error != null){
        %>

        <div class="alert alert-danger">

            <%=error%>

        </div>

        <%
        session.removeAttribute("error");
        }
        %>

        <form action="${pageContext.request.contextPath}/login"
              method="post">

            <div class="mb-3">

                <input
                        type="text"
                        name="usuario"
                        class="form-control"
                        placeholder="Usuario"
                        required>

            </div>

            <div class="mb-4">

                <input
                        type="password"
                        name="password"
                        class="form-control"
                        placeholder="Contraseña"
                        required>

            </div>

            <button
                    type="submit"
                    class="btn btn-primary w-100 btn-login">

                Iniciar sesión

            </button>

        </form>

        <div class="text-center mt-4">

            ¿No tienes cuenta?

            <a href="register.jsp">

                Registrarse

            </a>

        </div>

    </div>

</div>

</body>

</html>
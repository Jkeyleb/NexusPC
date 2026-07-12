<%@ page contentType="text/html;charset=UTF-8"%>

<div class="bg-dark text-white vh-100 p-3"
     style="width:250px;position:fixed;">

    <h3 class="text-center mb-4">

        NexusPC

    </h3>

    <hr>

    <a class="btn btn-dark w-100 text-start mb-2"
       href="${pageContext.request.contextPath}/dashboard-admin">

        📊 Dashboard

    </a>

    <a class="btn btn-dark w-100 text-start mb-2"
       href="${pageContext.request.contextPath}/inventario">

        📦 Inventario

    </a>

    <a class="btn btn-dark w-100 text-start mb-2"
       href="${pageContext.request.contextPath}/clientes">

        👥 Clientes

    </a>

    <a class="btn btn-dark w-100 text-start mb-2"
       href="#">

        🛒 Ventas

    </a>

    <a class="btn btn-dark w-100 text-start mb-2"
       href="#">

        🛡 Garantías

    </a>

    <a class="btn btn-dark w-100 text-start mb-2"
       href="#">

        👤 Usuarios

    </a>

    <hr>

    <a class="btn btn-danger w-100"
       href="${pageContext.request.contextPath}/logout">

        Cerrar sesión

    </a>

</div>
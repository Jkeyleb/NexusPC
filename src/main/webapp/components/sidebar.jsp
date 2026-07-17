<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="com.nexuspc.model.User"%>

<%
User usuario = (User) session.getAttribute("user");

String rol = "";

if(usuario != null &&
   usuario.getRole() != null){

    rol = usuario.getRole().getNombre();

}
%>

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

    <%
    if(rol.equals("ADMIN") || rol.equals("ALMACEN")){
    %>

    <a class="btn btn-dark w-100 text-start mb-2"
       href="${pageContext.request.contextPath}/inventario">

        📦 Inventario

    </a>

    <%
    }
    %>

    <%
    if(rol.equals("ADMIN") || rol.equals("VENDEDOR")){
    %>

    <a class="btn btn-dark w-100 text-start mb-2"
       href="${pageContext.request.contextPath}/clientes">

        👥 Clientes

    </a>

    <%
    }
    %>

    <%
    if(rol.equals("ADMIN") || rol.equals("VENDEDOR")){
    %>

    <a class="btn btn-dark w-100 text-start mb-2"
       href="${pageContext.request.contextPath}/nueva-venta">

        🛒 Ventas

    </a>

    <%
    }
    %>

    <%
    if(rol.equals("ADMIN") || rol.equals("VENDEDOR")){
    %>

    <a class="btn btn-dark w-100 text-start mb-2"
       href="${pageContext.request.contextPath}/ventas">

        📋 Historial de Ventas

    </a>

    <%
    }
    %>

    <%
    if(rol.equals("ADMIN") || rol.equals("ALMACEN")){
    %>

    <a class="btn btn-dark w-100 text-start mb-2"
       href="${pageContext.request.contextPath}/reportes">

        📈 Reportes

    </a>

    <%
    }
    %>

    <%
    if(rol.equals("ADMIN")){
    %>

    <a class="btn btn-dark w-100 text-start mb-2"
       href="${pageContext.request.contextPath}/usuarios">

        👤 Usuarios

    </a>

    <%
    }
    %>

    <hr>

    <a class="btn btn-danger w-100"
       href="${pageContext.request.contextPath}/logout">

        Cerrar sesión

    </a>

</div>
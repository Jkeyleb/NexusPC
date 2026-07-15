<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="com.nexuspc.model.User"%>

<%
User user =
(User)request.getAttribute("usuario");
%>

<div class="content-card">

<h2>Editar Usuario</h2>

<br>

<form action="${pageContext.request.contextPath}/actualizar-usuario"
      method="post">

    <input
            type="hidden"
            name="id"
            value="<%=user.getIdUsuario()%>">

    <div class="mb-3">

        <label>Nombre</label>

        <input
                class="form-control"
                name="nombre"
                value="<%=user.getNombre()%>">

    </div>

    <div class="mb-3">

        <label>Usuario</label>

        <input
                class="form-control"
                name="usuario"
                value="<%=user.getUsuario()%>">

    </div>

    <div class="mb-3">

        <label>Rol</label>

        <select
                name="idRol"
                class="form-select">

            <option value="1"
            <%=user.getRole().getIdRol()==1?"selected":""%>>
                ADMIN
            </option>

            <option value="2"
            <%=user.getRole().getIdRol()==2?"selected":""%>>
                VENDEDOR
            </option>

            <option value="3"
            <%=user.getRole().getIdRol()==3?"selected":""%>>
                ALMACEN
            </option>

        </select>

    </div>

    <button class="btn btn-success">

        Actualizar

    </button>

</form>

</div>
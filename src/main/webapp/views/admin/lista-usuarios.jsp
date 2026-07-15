<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="com.nexuspc.model.Usuario"%>

<div class="card">

    <h2>Gestión de Usuarios</h2>

    <br>

    <a class="btn btn-primary"
       href="${pageContext.request.contextPath}/nuevo-usuario">
        Nuevo Usuario
    </a>

    <br><br>

    <table class="table table-striped">

        <thead>

        <tr>

            <th>ID</th>
            <th>Nombre</th>
            <th>Usuario</th>
            <th>Rol</th>
            <th>Acciones</th>

        </tr>

        </thead>

        <tbody>

        <%
            List<Usuario> lista =
                    (List<Usuario>) request.getAttribute("usuarios");

            if (lista != null) {

                for (Usuario u : lista) {
        %>

        <tr>

            <td><%=u.getIdUsuario()%></td>

            <td><%=u.getNombre()%></td>

            <td><%=u.getUsuario()%></td>

            <td><%=u.getRol()%></td>

            <td>

                <a class="btn btn-warning btn-sm">
                    Editar
                </a>

                <a class="btn btn-danger btn-sm">
                    Eliminar
                </a>

            </td>

        </tr>

        <%
                }
            }
        %>

        </tbody>

    </table>

</div>
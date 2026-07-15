<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="com.nexuspc.model.User"%>

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
            <th>Estado</th>
            <th>Acciones</th>

        </tr>

        </thead>

        <tbody>

        <%
            List<User> lista =
            (List<User>) request.getAttribute("usuarios");

            if (lista != null) {

               for (User u : lista) {
        %>

        <tr>

            <td><%=u.getIdUsuario()%></td>

            <td><%=u.getNombre()%></td>

            <td><%=u.getUsuario()%></td>

            <td><%=u.getRole().getNombre()%></td>

            <td>

            <%
            if("ACTIVO".equals(u.getEstado())){
            %>

            <span class="badge bg-success">

            ACTIVO

            </span>

            <%
            }else{
            %>

            <span class="badge bg-secondary">

            INACTIVO

            </span>

            <%
            }
            %>

            </td>

            <td>

                <a
                class="btn btn-warning btn-sm"
                href="${pageContext.request.contextPath}/editar-usuario?id=<%=u.getIdUsuario()%>">

                    Editar

                <a
                class="btn btn-danger btn-sm"
                href="${pageContext.request.contextPath}/deshabilitar-usuario?id=<%=u.getIdUsuario()%>"
                onclick="return confirm('¿Desea deshabilitar este usuario?')">

                Deshabilitar

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
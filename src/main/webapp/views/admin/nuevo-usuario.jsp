<%@ page contentType="text/html;charset=UTF-8"%>

<div class="content-card">

    <h2>Nuevo Usuario</h2>

    <br>

    <form action="${pageContext.request.contextPath}/registrar-usuario"
          method="post">

        <div class="mb-3">

            <label>Nombre</label>

            <input
                    type="text"
                    name="nombre"
                    class="form-control"
                    required>

        </div>

        <div class="mb-3">

            <label>Usuario</label>

            <input
                    type="text"
                    name="usuario"
                    class="form-control"
                    required>

        </div>

        <div class="mb-3">

            <label>Contraseña</label>

            <input
                    type="password"
                    name="password"
                    class="form-control"
                    required>

        </div>

        <div class="mb-3">

            <label>Rol</label>

            <select
                    name="idRol"
                    class="form-select">

                <option value="1">ADMIN</option>

                <option value="2">VENDEDOR</option>

                <option value="3">ALMACEN</option>

            </select>

        </div>

        <button class="btn btn-success">

            Guardar Usuario

        </button>

    </form>

</div>
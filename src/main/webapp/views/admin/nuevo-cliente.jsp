<%@ page contentType="text/html;charset=UTF-8"%>

<div class="content-card">

    <h2 class="mb-4">

        👥 Registrar Cliente

    </h2>

    <form
            method="post"
            action="${pageContext.request.contextPath}/clientes">

        <div class="row">

            <div class="col-md-6 mb-3">

                <label class="form-label">

                    Nombre

                </label>

                <input
                        type="text"
                        name="nombre"
                        class="form-control"
                        required>

            </div>

            <div class="col-md-6 mb-3">

                <label class="form-label">

                    Tipo

                </label>

                <select
                        name="tipo"
                        class="form-select">

                    <option value="PERSONA">

                        PERSONA

                    </option>

                    <option value="EMPRESA">

                        EMPRESA

                    </option>

                </select>

            </div>

        </div>

        <div class="row">

            <div class="col-md-6 mb-3">

                <label class="form-label">

                    Teléfono

                </label>

                <input
                        type="text"
                        name="telefono"
                        class="form-control">

            </div>

            <div class="col-md-6 mb-3">

                <label class="form-label">

                    Email

                </label>

                <input
                        type="email"
                        name="email"
                        class="form-control">

            </div>

        </div>

        <hr>

        <button
                type="submit"
                class="btn btn-success">

            💾 Guardar Cliente

        </button>

        <a
                href="${pageContext.request.contextPath}/clientes"
                class="btn btn-secondary ms-2">

            ↩ Cancelar

        </a>

    </form>

</div>
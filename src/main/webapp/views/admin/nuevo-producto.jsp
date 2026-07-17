<%@ page contentType="text/html;charset=UTF-8"%>

<div class="content-card">

    <h2 class="mb-4">📦 Registrar Producto</h2>

    <form action="${pageContext.request.contextPath}/producto"
          method="post">

        <div class="row">

            <div class="col-md-6 mb-3">

                <label class="form-label">
                    Nombre
                </label>

                <input
                        type="text"
                        class="form-control"
                        name="nombre"
                        placeholder="Ingrese el nombre del producto"
                        required>

            </div>

            <div class="col-md-6 mb-3">

                <label class="form-label">
                    Proveedor
                </label>

                <input
                        type="text"
                        class="form-control"
                        name="proveedor"
                        placeholder="Ingrese el proveedor"
                        required>

            </div>

        </div>

        <div class="mb-3">

            <label class="form-label">
                Descripción
            </label>

            <textarea
                    class="form-control"
                    name="descripcion"
                    rows="3"
                    placeholder="Descripción del producto"></textarea>

        </div>

        <div class="row">

            <div class="col-md-4 mb-3">

                <label class="form-label">
                    Precio (S/)
                </label>

                <input
                        type="number"
                        step="0.01"
                        class="form-control"
                        name="precio"
                        placeholder="0.00"
                        required>

            </div>

            <div class="col-md-4 mb-3">

                <label class="form-label">
                    Stock
                </label>

                <input
                        type="number"
                        class="form-control"
                        name="stock"
                        placeholder="0"
                        required>

            </div>

            <div class="col-md-4 mb-3">

                <label class="form-label">
                    Stock Mínimo
                </label>

                <input
                        type="number"
                        class="form-control"
                        name="stockMinimo"
                        placeholder="0"
                        required>

            </div>

        </div>

        <hr>

        <button
                type="submit"
                class="btn btn-success">

            💾 Guardar Producto

        </button>

        <a
                href="${pageContext.request.contextPath}/inventario"
                class="btn btn-secondary ms-2">

            ↩ Volver

        </a>

    </form>

</div>
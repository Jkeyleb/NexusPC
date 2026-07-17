<%@ page contentType="text/html;charset=UTF-8"%>

<div class="content-card">

    <h2>📈 Reportes del Sistema</h2>

    <hr>

    <div class="row mt-4">

        <div class="col-md-6 mb-4">

            <div class="card shadow">

                <div class="card-body">

                    <h4>💰 Reporte de Ventas</h4>

                    <p>
                        Consulta todas las ventas realizadas
                        entre dos fechas.
                    </p>

                    <a class="btn btn-primary"
                       href="${pageContext.request.contextPath}/reporte-ventas">

                        Abrir

                    </a>

                </div>

            </div>

        </div>

        <div class="col-md-6 mb-4">

            <div class="card shadow">

                <div class="card-body">

                    <h4>📦 Stock Bajo</h4>

                    <p>
                        Productos que necesitan reposición.
                    </p>

                    <a class="btn btn-warning"
                       href="#">

                        Próximamente

                    </a>

                </div>

            </div>

        </div>

        <div class="col-md-6 mb-4">

            <div class="card shadow">

                <div class="card-body">

                    <h4>🏆 Productos Más Vendidos</h4>

                    <p>
                        Ranking de productos vendidos.
                    </p>

                    <a class="btn btn-success"
                       href="#">

                        Próximamente

                    </a>

                </div>

            </div>

        </div>

        <div class="col-md-6 mb-4">

            <div class="card shadow">

                <div class="card-body">

                    <h4>👥 Clientes Frecuentes</h4>

                    <p>
                        Clientes con mayor cantidad de compras.
                    </p>

                    <a class="btn btn-info"
                       href="#">

                        Próximamente

                    </a>

                </div>

            </div>

        </div>

    </div>

</div>
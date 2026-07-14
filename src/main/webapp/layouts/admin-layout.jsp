<%@ page contentType="text/html;charset=UTF-8"%>

<!DOCTYPE html>
<html lang="es">

<head>

    <meta charset="UTF-8">

    <title>NexusPC</title>

    <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/css/bootstrap.min.css"
            rel="stylesheet">

    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/assets/css/style.css">

</head>

<body>

<jsp:include page="/components/sidebar.jsp"/>

<div class="main">

    <jsp:include page="/components/navbar.jsp"/>

    <jsp:include page="${contenido}"/>

    <jsp:include page="/components/footer.jsp"/>

</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/js/bootstrap.bundle.min.js"></script>

</body>

</html>
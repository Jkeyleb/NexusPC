<%@ page contentType="text/html;charset=UTF-8"%>

<!DOCTYPE html>

<html>

<head>

<meta charset="UTF-8">

<title>NexusPC</title>

<link
href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/css/bootstrap.min.css"
rel="stylesheet">

<link
rel="stylesheet"
href="${pageContext.request.contextPath}/assets/css/style.css">

</head>

<body>

<jsp:include page="/components/sidebar.jsp"/>

<div
style="margin-left:270px;padding:20px;">

<jsp:include page="/components/navbar.jsp"/>

<!-- CONTENIDO -->

<jsp:include page="${contenido}"/>

<jsp:include page="/components/footer.jsp"/>

</div>

</body>

</html>
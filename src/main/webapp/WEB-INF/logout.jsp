<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Logged Out" />
    </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp" />
<div class="container mt-5">

    <div class="row">
        <div class="col-md-2"></div>

        <div class="col-md-8">
        <h1>You have been logged out.</h1>
        <hr>
        <h2>Visit us again for your music needs!</h2>

        </div>

        <div class="col-md-2"></div>
    </div>

</div>
</body>
</html>
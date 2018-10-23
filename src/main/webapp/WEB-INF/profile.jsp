<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Your Profile" />
    </jsp:include>
</head>
<body>
    <jsp:include page="/WEB-INF/partials/navbarLogin.jsp" />

    <div class="container">
        <h1>Welcome, ${sessionScope.user.username}!</h1>
        <hr>
        <h2>Here are your Ads.</h2>
        <br>
        <%--Needs to show the user's ads--%>
        <c:forEach var="ad" items="${ads}">
        <div class="card-group">
        <div class="card">
            <div class="card-body">
                <h4 class="card-title">${ad.title}</h4>
                <%--<h6 class="card-subtitle mb-2 text-muted">${}</h6>--%>
                <p class="card-text">${ad.description}</p>
                <a href="#" class="btn btn-info">Edit Ad</a>
                <a href="#" class="btn btn-danger">Delete Ad</a>
            </div>
        </div>
        </div>
        </c:forEach>
    </div>
</body>
</html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Viewing All The Ads" />
    </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbarLogin.jsp" />
<div class="container">
    <h1>Latest Happenings in the community.</h1>
    <hr>
    <c:forEach var="ad" items="${ads}">
    <div class="card-group">
    <div class="card">
        <div class="card-body">
            <h2 class="card-title">${ad.title}</h2>
            <p class="card-text">${ad.description}</p>
            <a href="/contact" class="btn btn-primary">Contact Seller</a>
        </div>
        </div>
        </c:forEach>
</div>
</body>
</html>

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
        <h3>Here are your Ads.</h3>
        <%--Needs to show the user's ads--%>
        <c:forEach var="ad" items="${ads}">
            <div>
                <h2>${ad.id}${ad.title}</h2>
                <%--<h2><a href="profile/ads/show?id=${ad.id}">${ad.title}</a></h2>--%>
                <blockquote>${ad.description}</blockquote>
                <%--<blockquote><a href="profile/ads/show?id=${ad.id}">${ad.description}</a></blockquote>--%>
                <button type="button" class="btn btn-info">Edit Ad</button>
                <button type="button" class="btn btn-danger">Delete Ad</button>
            </div>
        </c:forEach>
        <%--<c:forEach var="ad" items="${ads}">--%>
            <%--<div>--%>
                <%--<h2><a href="/ads/show?id=${ad.id}">${ad.title}</a></h2>--%>
            <%--</div>--%>
        <%--</c:forEach>--%>
        <%--<c:forEach var="ad" items="${ad}">--%>
            <%--<div class="product">--%>
                <%--<h2>${ad.title}</h2>--%>
                <%--<p>${ad.description}</p>--%>
                <%--<p>${ad.user_id}</p>--%>
            <%--</div>--%>
        <%--</c:forEach>--%>
                    <%--Needs to be able update and delete ads--%>
        <%--<button type="button" class="btn btn-info">Edit Ad</button>--%>
        <%--<button type="button" class="btn btn-danger">Delete Ad</button>--%>
    </div>



</body>
</html>

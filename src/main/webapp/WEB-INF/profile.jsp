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
    </div>
<%--Needs to show the user's ads--%>
<%--Needs to be able update and delete ads--%>
<%--Search bar to find ads--%>
<%--Ability to update profile--%>

</body>
</html>

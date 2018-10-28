<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Please Log In" />
    </jsp:include>
</head>
<body>
    <jsp:include page="/WEB-INF/partials/navbar.jsp" />
    <div class="container mt-5">
        <div class="row">
            <div class="col-md-2"></div>
            <div class="col-md-8">
                <%--Idea to try to get if statement to show invaild UserName/Passwore--%>
                <%--<c:if test="${validAttempt}">--%>
                <%--Sorry. Wrong user name or password--%>
                <%--</c:if>--%>

                <h1>Please Log In</h1>
                <c:if test="${loginError != null}">
                    <div class="alert alert-danger col-md-6">
                        <h5>${loginError}</h5>
                    </div>

                </c:if>
                <form action="/login" method="POST">


                    <div class="form-group">
                        <label for="username">Username</label>
                        <input id="username" name="username" class="form-control" type="text">
                    </div>
                    <div class="form-group">
                        <label for="password">Password</label>
                        <input id="password" name="password" class="form-control" type="password">
                    </div>
                    <input type="submit" class="btn btn-primary btn-block" value="Log In">
                </form>
            </div>
            <div class="col-md-2"></div>
        </div>
    </div>
</body>
</html>

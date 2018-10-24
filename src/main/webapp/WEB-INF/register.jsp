<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <jsp:include page="partials/head.jsp">
        <jsp:param name="title" value="Register For Our Site!" />
    </jsp:include>
</head>
<body>
    <jsp:include page="partials/navbar.jsp" />

    <div class="container">




        <h1>Please fill in your information.</h1>
        <form action="/register" method="post">

            <div class="form-group">

                <%--1) Test to see if, in the RegisterServlet, the usernameError is true--%>
                <c:if test="${usernameError != null}">

                    <%--2) If the usernameError is true, so show the alert message to the user--%>
                    <div class="alert alert-danger" role="alert">${usernameError}</div>

                </c:if>

                <label for="username">Username</label>
                <input id="username" name="username" class="form-control" type="text">
            </div>



            <div class="form-group">


                <%--3)Test to see if, in the RegisterServlet, the emailError is true--%>
                <c:if test="${emailError != null}">

                    <%--4) If the emailError is true, so show the alert message to the user--%>

                    <div class="alert alert-danger" role="alert">${emailError}</div>

                </c:if>


                <label for="email">Email</label>
                <input id="email" name="email" class="form-control" type="text">
            </div>


            <div class="form-group">

                <%--5)Test to see if, in the RegisterServlet, the passwordError is true--%>

                <c:if test="${passwordError != null}">

                    <%--6) If the passwordError exists so show the alert message to the user--%>
                    <div class="alert alert-danger" role="alert">${passwordError}</div>

                </c:if>

                <label for="password">Password</label>
                <input id="password" name="password" class="form-control" type="password">
            </div>



            <div class="form-group">


            <%--7)Test to see if, in the RegisterServlet, the passwordConfirmationError is true--%>
            <c:if test="${passwordConfirmationError != null}">

                <%--8) If the passwordConfirmationError exists so show the alert message to the user--%>

                <div class="alert alert-danger" role="alert">${passwordConfirmationError}</div>

            </c:if>

                <label for="confirm_password">Confirm Password</label>
                <input id="confirm_password" name="confirm_password" class="form-control" type="password">
            </div>
            <input type="submit" class="btn btn-primary btn-block">
        </form>
    </div>
</body>
</html>

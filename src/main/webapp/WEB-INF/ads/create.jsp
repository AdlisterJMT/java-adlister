<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Create a new Ad" />
    </jsp:include>
</head>
<body>

<jsp:include page="/WEB-INF/partials/navbarLogin.jsp" />
    <div class="container m-5">
        <div clas="row">
            <div class="col-md-2"></div>
            <div class="col-md-8">
                <%--From the create ad servlet in the doPost section; check to see if the input has errors in the title or the description.
                    If there are errors in the title, show the title error alert. If there are errors in the description show the description error.
                    Otherwise don't show anything at all.--%>

                <%--line by line explanation --%>

                <%--1) Test to see if, in the CreateAd Servlet, the titleError attribute that was set on the request in the doPost exists--%>

                <c:if test="${titleError != null}">
                    <%--2) If the titleError exists that means either the title was too long or it was empty, so show the alert message to the user--%>
                    <div class="alert alert-danger" role="alert">${titleError}</div>

                </c:if>

                <%--3)Test to see if, in the CreateAd Servlet, the descriptionError attribute that was set on the request in the doPost exists--%>
                <c:if test="${descriptionError != null}">

                    <%--4) If the descriptionError exists that means either the description is too long or it is empty, so show the alert message to user--%>

                    <div class="alert alert-danger" role="alert">${descriptionError}</div>

                </c:if>

                <%--end of explanation--%>
                <h1>Create a new Ad</h1>
                <form action="/ads/create" method="post">
                    <div class="form-group">
                        <label for="title">Title</label>
                        <input id="title" name="title" class="form-control" type="text">
                    </div>
                    <div class="form-group">
                        <label for="exampleFormControlSelect1">Category</label>
                        <select class="form-control" id="exampleFormControlSelect1">
                            <option>Make A Selection</option>
                            <option>Equipment</option>
                            <option>Services</option>
                            <option>Facilities</option>
                            <option>Products</option>
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="description">Description</label>
                        <textarea id="description" name="description" class="form-control" type="text"></textarea>
                    </div>
                    <input type="submit" class="btn btn-block btn-primary">
                </form>

            </div>
            <div class="col-md-2"></div>

        </div>
    </div>

</div>
</body>
</html>
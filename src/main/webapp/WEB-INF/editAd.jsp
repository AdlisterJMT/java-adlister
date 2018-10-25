<%--
  Created by IntelliJ IDEA.
  User: Michael
  Date: 10/25/18
  Time: 9:31 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Your Profile"/>
    </jsp:include>
</head>
<body>
    <jsp:include page="/WEB-INF/partials/navbarLogin.jsp"/>

    <div class="container">

        <h1>Edit your Ad</h1>
        <form action="/editAd" method="post">
            <div class="form-group">
                <label for="title">Title</label>
                <input id="title" name="title" class="form-control" type="text" value="${ad.title}">
            </div>
            <div class="form-group">

            </div>
            <div class="form-group">
                <label for="description">Description</label>
                <textarea id="description" name="description" class="form-control" type="text">${ad.description}</textarea>
            </div>
            <input type="submit" class="btn btn-block btn-primary">
            <input type="hidden" name="id" value="${ad.id}"/>
        </form>


    </div>

</body>
</html>

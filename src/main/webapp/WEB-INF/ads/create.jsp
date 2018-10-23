<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Create a new Ad" />
    </jsp:include>
</head>
<body>

    <c:if test="${titleError != null}">
        <h1>${titleError}</h1>
    </c:if>

    <c:if test="${descriptionError != null}">
        <h1>${descriptionError}</h1>
    </c:if>

    <c:if test="${emptyTitleError != null}">
        <h1>${emptyTitleError}</h1>
    </c:if>
    <c:if test="${emptyDescriptionError != null}">
        <h1>${emptyDescriptionError}</h1>
    </c:if>

    <div class="container">
        <h1>Create a new Ad</h1>
        <form action="/ads/create" method="post">
            <div class="form-group">
                <label for="title">Title</label>
                <input id="title" name="title" class="form-control" type="text">
            </div>
            <div class="form-group">
                <label for="description">Description</label>
                <textarea id="description" name="description" class="form-control" type="text"></textarea>
            </div>
            <input type="submit" class="btn btn-block btn-primary">
        </form>
    </div>
</body>
</html>

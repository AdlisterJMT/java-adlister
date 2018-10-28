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
<div class="container m-5">

    <div class="row">

        <div class="col-md-2"></div>

        <div class="col-md-8">


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
                    <textarea style="resize: none;" id="description" name="description" class="form-control" type="text"><c:out value="${ad.description}"/></textarea>
                </div>
                <input type="submit" class="btn btn-block btn-primary">
                <input type="hidden" name="id" value="${ad.id}"/>
            </form>

        </div>

    </div>
    <div class="col-md-2"></div>
</div>
</body>
</html>

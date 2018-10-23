<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Contact the Seller" />
    </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbarLogin.jsp" />
<div class="container">
    <h1>Contact Seller</h1>
    <form action="/contact" method="post">
        <div class="form-group">
            <label for="title">To:</label>
            <input id="title" name="title" class="form-control" type="text">
        </div>
        <div class="form-group">
            <label for="exampleFormControlSelect1">Subject</label>
            <input class="form-control" id="exampleFormControlSelect1" type="text">
        </div>
        <div class="form-group">
            <label for="description">Message</label>
            <textarea id="description" name="description" class="form-control" type="text"></textarea>
        </div>
        <input type="submit" class="btn btn-block btn-primary">
    </form>
</div>
</body>
</html>

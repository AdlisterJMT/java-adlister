<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Welcome to my site!" />
    </jsp:include>
</head>
<body>
    <jsp:include page="/WEB-INF/partials/navbar.jsp" />
    <div class="container">
        <h1>Let's Make Music!</h1>
        <hr>
        <blockquote>If you are interested in any of the ads below; we ask that you log into your account, in order to contact the Seller.
                    If this is your first time to the site, please join the community by creating an account.
        </blockquote>
    </div>
</body>
</html>

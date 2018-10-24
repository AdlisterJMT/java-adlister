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
        <h1 style="text-align: center">Making Music!</h1>
        <hr>
        <blockquote style="padding-top: 5%">We are a community of individuals who enjoy collaborating inorder to create musical magnificence. What does collaboration
                    look like? Creating Ads for the buying and selling of goods and/or services you have to offer to the community.
                    Once you create an account you can see all the ads posted by the members of our community. You can even create your own ad.
                    If you come across an ad that peaks your interest, click 'Contact Seller' and send them an email. Already a prestigious member?
                    Just click Login, and you know the drill.🎤🎧🎼🎹🥁🎷🎺🎸🎻</blockquote>
    </div>
</body>
</html>

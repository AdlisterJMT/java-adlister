<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Your Profile" />
    </jsp:include>
</head>
<body>
    <jsp:include page="/WEB-INF/partials/navbarLogin.jsp" />
<%--Expression language  --%>
    <div class="container">

        <%--To use the user's username in the profile page we must access the session in order to retrieve the user object--%>
        <%--use the ESL symbols and take the sessionScope which relates to the "request.getSession()" where you set user attribute
         in the LoginServlet to user, and access the user's username property--%>

        <h1>Welcome, ${sessionScope.user.username}!</h1>
        <hr>
        <h3>Here are your Ads.</h3>

        <%--use the ESL symbols and take the session scope which relates to the "request.getSession()" where you set the
         ad attribute in the CreateAdServlet, and access the ad object's user_id which is specific to the user --%>
        <blockquote>${sessionScope.ad.user_id}


                    ${ads.title}
                    ${ads.description}</blockquote>
        <button type="button" class="btn btn-info">Edit Ad</button>
        <button type="button" class="btn btn-danger">Delete Ad</button>
    </div>
<%--Needs to show the user's ads--%>
<%--Needs to be able update and delete ads--%>
<%--Search bar to find ads--%>
<%--Ability to update profile--%>

</body>
</html>

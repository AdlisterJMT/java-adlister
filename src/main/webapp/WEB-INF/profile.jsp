<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <div class="container m-5">

        <%--To use the user's username in the profile page we must access the session in order to retrieve the user object--%>
        <%--use the ESL symbols and take the sessionScope which relates to the "request.getSession()" where you set user attribute
         in the LoginServlet to user, and access the user's username property--%>

            <div class="row">
                <div class="col-md-2"></div>
                <div class="col-md-8">
        <h1>Welcome, ${sessionScope.user.username}!</h1>
        <hr>
            <h2>Here are your Ads.</h2>
            <br>

        <%--use the ESL symbols and take the session scope which relates to the "request.getSession()" where you set the
         ad attribute in the CreateAdServlet, and access the ad object's user_id which is specific to the user --%>



        <%--Needs to show the user's ads--%>
        <c:forEach var="ad" items="${ads}">
        <div class="card-group">
        <div class="card">
            <div class="card-body">
                <h4 class="card-title">${ad.title}</h4>
                <hr>
                <%--<h6 class="card-subtitle mb-2 text-muted">${}</h6>--%>
                <p class="card-text">${ad.description}</p>
                <a href="/editAd?id=${ad.id}" class="btn btn-info">Edit Ad</a>
                <form action="/deleteAd" method="post">
                    <input type="hidden" name="adId" value="${ad.id}" />
                    <button class="btn btn-danger" type="submit">Delete Ad</button></form>
                <%--<a href="#" class="btn btn-danger">Delete Ad</a>--%>
            </div>
        </div>
        </div>
        </c:forEach>

    <div>
        <% if (request.getSession().getAttribute("submitDone") == null ) { %>
        <% request.getSession().setAttribute("submitDone", false); %>
        <% } else if (request.getSession().getAttribute("submitDone").equals("done") ) { %>
        <script>alert("Form submitted"); </script>
        <% } %>

    </div>

            </div>
                <div class="col-md-2"></div>
    </div>
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: tamisharutledge
  Date: 10/11/18
  Time: 10:49 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    if (request.getMethod().equalsIgnoreCase("post")) {
        String username = request.getParameter("user_name");
        String password = request.getParameter("password");
        if (username.equals("admin") && password.equals("password")) {
            response.sendRedirect("/profile.jsp");
        }
    }
%>
<html>
<head>
    <title>Login</title>
</head>
<body>
<jsp:include page="partials/navbar.jsp"/>
<h1>Please Log In</h1>
    <form action="/login.jsp" method="post">
        <table>
            <tr>
                <td>User Name</td>
                <td><input type="text" name="user_name" placeholder="enter user name" /></td>
            </tr>
            <tr>
                <td>Password</td>
                <td><input type="text" name="password" placeholder="enter password" /></td>
            </tr>
           </table>
        <input type="submit" value="Log In" />
    </form>


</body>
</html>

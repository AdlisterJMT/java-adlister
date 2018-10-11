<%--
  Created by IntelliJ IDEA.
  User: tamisharutledge
  Date: 10/11/18
  Time: 10:49 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
    <form action="login_form" method="post">
        <table>
            <tr>
                <td>User Name</td>
                <td><input type="text" name="user_name" /></td>
            </tr>
            <tr>
                <td>Password</td>
                <td><input type="text" name="password" /></td>
            </tr>
           </table>
        <input type="submit" value="Submit" />
    </form>

    <c:choose>
        <c:when test="Admin">
            <p>Welcome, <c:out value="Admin" /> </p>
        </c:when>
        <c:when test="password">
            <p>boolean_expression_1 was false, and boolean_expression_2 was true</p>
        </c:when>
        <c:otherwise>
            <p>You're not an Admin, going back to login.</p>
        </c:otherwise>
    </c:choose>

</body>
</html>

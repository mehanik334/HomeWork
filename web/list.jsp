<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 05.05.2019
  Time: 18:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Список</title>
</head>
<body>
<table border='2' width='100%'>
    <tr>
        <th>Login</th>
        <th>Password</th>
        <th>Edit</th>
        <th>Delete</th>
    </tr>
    <c:forEach items="${users}" var="user">
        <tr>
            <td><c:out value="${user.getLogin()}"/></td>
            <td><c:out value="${user.getPassword()}"/></td>
            <td><a href='edit?login=${user.getLogin()}'>edit</a></td>
            <td><a href='delete?login=${user.getLogin()}'>delete</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>

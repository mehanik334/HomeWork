<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 05.05.2019
  Time: 18:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Admin page</title>
</head>
<body>
    <c:out value="${message}"/>
    <table border='2' width='100%'>
        <tr>
            <th>Login</th>
            <th>Password</th>
            <th>Role</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>
        <c:forEach items="${users}" var="user">
            <tr>
                <td><c:out value="${user.getLogin()}"/></td>
                <td><c:out value="${user.getPassword()}"/></td>
                <td><c:out value="${user.getRole().getValue()}"/></td>
                <td><a href='edit?id=${user.getId()}'>edit</a></td>
                <td><a href='delete?id=${user.getId()}'>delete</a></td>
            </tr>
        </c:forEach>
    </table>
    <table border='2' width='100%'>
        <tr>
            <th>Name</th>
            <th>Description</th>
            <th>Price</th>
            <th>Action</th>
        </tr>
        <c:forEach items="${allGoods}" var="good">
            <tr>
                <td><c:out value="${good.getName()}"/></td>
                <td><c:out value="${good.getDescription()}"/></td>
                <td><c:out value="${good.getPrice()}"/></td>
                <td><a href='deleteGood?id=${good.getId()}'>delete</a></td>
            </tr>
        </c:forEach>
    </table>
    <form action="addGood.jsp">
        <input type="submit" value="add good">
    </form>
</body>
</html>

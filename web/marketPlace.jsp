<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 06.05.2019
  Time: 00:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>User page</title>
</head>
<body>
<table border='2' width='100%'>
    <tr>
        <th>Name</th>
        <th>Description</th>
        <th>Price</th>
        <th>Buy</th>
    </tr>
    <c:forEach items="${allGoods}" var="good">
        <tr>
            <td><c:out value="${good.getName()}"/></td>
            <td><c:out value="${good.getDescription()}"/></td>
            <td><c:out value="${good.getPrice()}"/></td>
            <td><a href='buy?id=${good.getId()}'>BUY</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>

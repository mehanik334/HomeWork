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
    <title>Hpme page</title>
</head>
<body>
    <c:out value="${message}"/>
    <form action="list" method="get">
        <input type="submit" value="посмотреть всех юзеров" name="login">
    </form>
</body>
</html>

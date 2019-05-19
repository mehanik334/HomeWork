<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 05.05.2019
  Time: 19:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Edit</title>
</head>
<body>
<h3>Введите новый пароль для <c:out value="${id}"/></h3>
<form method="post">
    <label> Password:
        <input type="text" name="password"><br/><br/>
    </label>
    <button type="submit">Изменить</button>
</form>
</body>
</html>

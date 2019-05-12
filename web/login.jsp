<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Вход</title>
</head>
<body>
<c:out value="${message}"/>
<form action="login" method="post">
    Введите логин <input type="text" name="loginUser"/>
    Введите пароль <input type="text" name="loginPassword"/>
    <input type="submit" value=" Вход ">
</form>
</body>
</html>
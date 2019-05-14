<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 15.05.2019
  Time: 01:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Add good</title>
</head>
<body>
<form action="addgood" method="post" \>
    Введите название товара <input type="text" name="nameGood"/>
    Введите описание <input type="text" name="description"/>
    Введите цену <input type="text" name="price">
</form>
</body>
</html>

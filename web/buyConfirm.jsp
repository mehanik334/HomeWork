<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Подтверждение покупки</title>
</head>
<body>
<h2>Введите одноразовы код</h2>
<div align="center">
    <form action="buy" method="post">
        <input hidden type="text" name="good_id" value="<c:out value="${good_id}"/>">
        <input type="password" title="Код" name="code"/>
        <input type="submit"/>
    </form>
</div>
</body>
</html>
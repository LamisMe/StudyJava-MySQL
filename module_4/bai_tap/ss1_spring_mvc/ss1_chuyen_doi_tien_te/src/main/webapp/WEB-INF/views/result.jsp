<%--
  Created by IntelliJ IDEA.
  User: TUẤN
  Date: 9/14/2023
  Time: 11:00 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Trang hiển thị</title>
</head>
<body>
<h1>Currency conversion application</h1>
<form action="/exchange">
    <label>
        <input type="number" name="amountOfMoney" value="amountOfMoney" required placeholder="Enter number">
    </label>
    <button type="submit" value="/exchange">Exchange</button>
</form>
<h2>${convert}</h2>
</body>
</html>

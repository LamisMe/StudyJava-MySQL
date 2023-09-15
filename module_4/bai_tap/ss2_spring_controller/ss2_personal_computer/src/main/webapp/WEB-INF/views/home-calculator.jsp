<%--
  Created by IntelliJ IDEA.
  User: TUẤN
  Date: 9/15/2023
  Time: 2:26 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Trang Tính Toán</title>
</head>
<body>
<h1>Calculator</h1>
<form action="/total">
    <label>
        <input type="number" required name="first-number" placeholder="Enter first number">
    </label>
    <label>
        <input type="number" required name="second-number" placeholder="Enter Second number">
    </label>
    <label>
        <button type="submit" name="allowable" value="+">Addition(+)</button>
    </label>
    <label>
        <button type="submit" name="allowable" value="-">Subtraction(-)</button>
    </label>
    <label>
        <button type="submit" name="allowable" value="*">Multiplication(*)</button>
    </label>
    <label>
        <button type="submit" name="allowable" value="/">Division(/)</button>
    </label>
</form>

</body>
</html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Trang Tính Toán</title>
</head>
<body>
<h1>Calculator</h1>
<form action="/total">
    <label>
        <input type="number" required name="first-number" placeholder="Enter first number" value="${firstNum}">
    </label>
    <label>
        <input type="number" required name="second-number" placeholder="Enter Second number" value="${secondNum}">
    </label>
    <br>
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
<c:if test="${result != -1 && result != -99}">
    <h3>Result: <span style="color: crimson">${result}</span></h3>
</c:if>
<c:if test="${result == -99}">
    <h3>Result: <span style="color: crimson">Please enter number</span></h3>
</c:if>
<c:if test="${result == -1}">
    <h3>Result: <span style="color: crimson">Cannot divide by 0</span></h3>
</c:if>
</body>
</html>

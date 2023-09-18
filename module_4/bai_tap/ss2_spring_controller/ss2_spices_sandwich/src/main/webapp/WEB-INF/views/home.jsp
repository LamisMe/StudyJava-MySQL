<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Trang Hiển Thị</title>
</head>
<body>
<form action="/save">
    <label>
        <input type="checkbox" value="Lettuce" name="condiment">Lettuce
    </label>
    <label>
        <input type="checkbox" value="Tomato" name="condiment">Tomato
    </label>
    <label>
        <input type="checkbox" value="Mustard" name="condiment">Mustard
    </label>
    <label>
        <input type="checkbox" value="Sprouts" name="condiment">Sprouts
    </label>
    <br>
    <button type="submit">Save</button>
</form>
<c:if test="${condiment  != null}">
    <h3> List condiment to Sandwich</h3>
    <c:forEach var="spi" items="${condiment}">
        ${spi}
    </c:forEach>
</c:if>
</body>
</html>

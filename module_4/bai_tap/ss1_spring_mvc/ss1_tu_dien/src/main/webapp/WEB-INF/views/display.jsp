
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/message" method="post">
    <label>
        <input type="text" placeholder="Enter vocabulary" name="vocabulary">
    </label>
    <button type="submit" >Submit</button>
</form>
<c:if test="${message != null}">
    ${message}
</c:if>
<c:if test="${result != null}">
    ${result}
</c:if>
</body>
</html>

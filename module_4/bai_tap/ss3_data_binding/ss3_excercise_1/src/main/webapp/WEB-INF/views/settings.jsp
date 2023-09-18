<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Trang settings</title>
</head>
<body>
<h1>Settings</h1>
<form:form modelAttribute="email" action="/setting" method="post">
    <strong>Languages </strong>
    <form:select path="languages">
        <form:options items="${languages}"/>
    </form:select><br>
    <strong>Page Size </strong>
    Show <form:select path="pageSize">
    <form:options items="${pageSize}"/>
</form:select> emails per page<br>
    <strong>Spams Filter </strong>
    <form:checkbox path="spamsFilter" value="false" label="Enable spams filter"/><br>
    <strong style="text-align: center">Signature </strong>
    <form:textarea path="signature" cssStyle="height: 100px"/><br>
    <form:button>Update</form:button> <a href="/now">
    <button type="button">Cancel</button>
</a>
</form:form>
<c:if test="${msg != null}">
    <strong>${msg}</strong>
</c:if>
</body>
</html>

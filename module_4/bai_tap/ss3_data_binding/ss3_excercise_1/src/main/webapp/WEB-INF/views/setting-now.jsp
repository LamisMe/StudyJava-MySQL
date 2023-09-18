<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Trang cấu hình hiện tại</title>
    <style>
        table{
            border-collapse: collapse;
            text-align: center;
        }
    </style>
</head>
<body>
<h1>Settings Now</h1>
<table border="1px">
    <tr>
        <th>Languages</th>
        <th>PageSize</th>
        <th>SpamsFilter</th>
        <th>Signature</th>
    </tr>
    <tr>
        <td>${email.languages}</td>
        <td>${email.pageSize}</td>
        <c:if test="${email.spamsFilter == false}">
            <td>Turn off</td>
        </c:if>
        <c:if test="${email.spamsFilter == true}">
            <td>Turn on</td>
        </c:if>
        <td>${email.signature}</td>
    </tr>
</table>
<br>
<a href="/setting"><button>Update</button></a>
</body>
</html>

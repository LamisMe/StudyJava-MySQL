<%--
  Created by IntelliJ IDEA.
  User: TUẤN
  Date: 8/28/2023
  Time: 3:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <style>
        table{
            border-collapse: collapse;
        }
    </style>
  </head>
<body>
<table border="2px">
    <thead>
    <tr>
        <th>Tên</th>
        <th>Ngày Sinh</th>
        <th>Địa Chỉ</th>
        <th>Ảnh</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="s" items="${customers}">
        <tr>
            <td><c:out value="${s.name}"/></td>
            <td><c:out value="${s.dayOfBirth}"/></td>
            <td><c:out value="${s.address}"/></td>
            <td><img src="${s.photo}" width="50%" height="50%"></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>

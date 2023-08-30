<%--
  Created by IntelliJ IDEA.
  User: TUẤN
  Date: 8/30/2023
  Time: 4:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>
  <a href="users?action=users">List All Users</a>
</h2>
<form method="post">
  <label for="nameSearch">
    <input type="search" name="nameSearch" id="nameSearch" placeholder="input name search" value="${nameSearch}">
  </label>
  <button type="submit" class="btn btn-primary">Search</button>
</form>
</body>
<table border="1px">
<tr>
  <th>ID</th>
  <th>Name</th>
  <th>Email</th>
  <th>Country</th>
</tr>
<c:forEach var="user" items="${users}" varStatus="hung">
  <tr>
    <td><c:out value="${hung.count}"/></td>
    <td><c:out value="${user.name}"/></td>
    <td><c:out value="${user.email}"/></td>
    <td><c:out value="${user.country}"/></td>
  </tr>
</c:forEach>
</table>
</html>

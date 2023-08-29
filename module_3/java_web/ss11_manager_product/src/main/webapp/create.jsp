<%--
  Created by IntelliJ IDEA.
  User: TUẤN
  Date: 8/29/2023
  Time: 3:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/product?action=create" method="post">
    <label for="name">Tên Sản Phẩm</label>
    <input type="text" id="name" name="name"><br>
    <label for="price">Giá</label>
    <input type="number" name="price" id="price">
    <label for="description">Mô Tả</label>
    <input type="text" id="description" name="description"><br>
    <label for="supplier">Nhà cung cấp</label>
    <input type="text" id="supplier" name="supplier"><br>
    <button type="submit">Thêm mới</button>
</form>
</body>
</html>

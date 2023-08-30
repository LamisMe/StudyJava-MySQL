<%--
  Created by IntelliJ IDEA.
  User: TUẤN
  Date: 8/29/2023
  Time: 3:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
<html>
<head>
    <title>Thêm Sản Phẩm</title>
</head>
<body>
<div class="container-fluid">
    <!-- As a link -->
    <nav class="navbar bg-body-tertiary">
        <div class="container-fluid">
            <a href="/product"><button type="submit" class="btn btn-danger" >Trở về</button></a>
        </div>
    </nav>

<form action="/product?action=create" method="post">
        <div class="mb-3">
            <label for="name" class="form-label">Tên Sản Phẩm</label>
            <input type="text" class="form-control" id="name" aria-describedby="name" name="name">
        </div>
        <div class="mb-3">
            <label for="price" class="form-label">Giá</label>
            <input type="number" class="form-control" id="price" name="price">
        </div> <div class="mb-3">
            <label for="description" class="form-label">Mô tả</label>
            <input type="text" class="form-control" id="description" name="description">
        </div>
    <div class="mb-3">
        <label for="supplier" class="form-label">Nhà cung cấp</label>
        <input type="text" class="form-control" id="supplier" name="supplier">
    </div>
        <button type="submit" class="btn btn-danger">Thêm Mới</button>
</form>
</div>
</body>
</html>

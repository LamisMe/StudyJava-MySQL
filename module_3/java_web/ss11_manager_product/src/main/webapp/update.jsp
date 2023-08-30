<%--
  Created by IntelliJ IDEA.
  User: TUẤN
  Date: 8/30/2023
  Time: 11:17 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">

<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="container-fluid">
    <nav class="navbar bg-body-tertiary">
        <div class="container-fluid">
            <a href="/product"><button type="submit" class="btn btn-danger" >Trở về</button></a>
        </div>
    </nav>
<form action="/product?action=update" method="post">
    <c:if test="${product != null}">
        <input type="hidden" name="id" value="<c:out value='${product.id}' />"/>
    </c:if>
    <div class="mb-3">
        <label for="name" class="form-label">Tên Sản Phẩm</label>
        <input type="text" class="form-control" id="name" aria-describedby="name" name="name"
               value="<c:out value='${product.name}' />">
    </div>
    <div class="mb-3">
        <label for="price" class="form-label">Giá</label>
        <input type="number" class="form-control" id="price" name="price" value="<c:out value='${product.price}'/>">
    </div>
    <div class="mb-3">
        <label for="description" class="form-label">Mô tả</label>
        <input type="text" class="form-control" id="description" name="description"
               value="<c:out value='${product.description}'/>">
    </div>
    <div class="mb-3">
        <label for="supplier" class="form-label">Nhà cung cấp</label>
        <input type="text" class="form-control" id="supplier" name="supplier" value="<c:out value='${product.name}'/>">
    </div>
    <button type="submit" class="btn btn-danger">Cập nhật</button>
</form>
</div>
</body>
</html>

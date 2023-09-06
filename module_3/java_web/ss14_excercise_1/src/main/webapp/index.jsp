<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Gải Phương Trình Bậc 2!" %>
</h1>
<br/>
<form action="/giai-phuong-trinh-bac-hai" method="post">
    <lable>Nhập giá trị cho a:</lable>
    <input type="number" name="a" id="a" value="${a}">
    <br>
    <lable>Nhập giá trị cho b:</lable>
    <input type="number" name="b" id="b" value="${b}">
    <br>
    <lable>Nhập giá trị cho c:</lable>
    <input type="number" name="c" id="c" value="${c}">
    <br>
    <button type="submit">Kết Quả</button>
    <br>
</form>
<c:out value="${ketQua}"/>
</body>
</html>
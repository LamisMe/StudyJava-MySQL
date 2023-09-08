<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Quên mật khẩu!" %>
</h1>
<br/>
<a href="/send-mail?action=hienthiform">Nhấn vào đây để lấy lại mật khẩu</a>
<c:out value="${err}"/>
</body>
</html>
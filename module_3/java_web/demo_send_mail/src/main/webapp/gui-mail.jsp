<%--
  Created by IntelliJ IDEA.
  User: TUẤN
  Date: 9/7/2023
  Time: 10:56 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link href="vendor/bootstrap-4.1/bootstrap.min.css" rel="stylesheet" media="all">
</head>
<body>
<form action="/send-mail?action=guimail" method="post">
    <div class="row form-group">
        <div class="col col-md-3">
            <label for="email" class="form-label">Email</label>
        </div>
        <div class="col-12 col-md-9">
            <input type="email" class="form-control" id="email" name="email">
        </div>
    </div>
    <div class="row form-group">
        <div class="card-footer">
            <button type="submit" class="btn btn-primary btn-sm">
                Xác nhận
            </button>
        </div>
    </div>
</form>
</body>
</html>

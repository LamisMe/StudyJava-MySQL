<%--
  Created by IntelliJ IDEA.
  User: TUẤN
  Date: 9/5/2023
  Time: 2:35 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div align="center">
    <form method="post" action="/users?action=add-transaction">
        <table border="1" cellpadding="5">
            <caption>
                <h2>Add New User Transaction</h2>
            </caption>
            <tr>
                <td>User name</td>
                <td><input type="text" name="name" size="45"/></td>
            </tr>
            <tr>
                <td>User email</td>
                <td><input type="text" name="email" size="45"/></td>
            </tr>
            <tr>
                <td>User country</td>
                <td><input type="text" name="country" size="15"/></td>
            </tr>
            <tr>
                <td colspan="1" align="center">
                    <button type="submit">Submit</button>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>

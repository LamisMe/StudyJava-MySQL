<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<br/>
<h1>Simple Calculator</h1>
<form action="/simple-calculator" method="post">
    <table>
        <tr>
            <td><label for="first">First operand:</label></td>
            <td><input type="text" name="first" id="first"></td>
        </tr>
        <tr>
            <td><label>Operator:</label></td>
            <td><select name="operator">
                <option value="+">Addition</option>
                <option value="-">Subtraction</option>
                <option value="*">Multiplication</option>
                <option value="/">Division</option>
            </select></td>
        </tr>
        <tr>
            <td><label for="second">Second operand:</label></td>
            <td><input type="text" name="second" id="second"></td>
        </tr>
        <tr><td colspan="3"><input type="submit" id="submit" value="Calculate"></td></tr>
    </table>
</form>
</body>
</html>
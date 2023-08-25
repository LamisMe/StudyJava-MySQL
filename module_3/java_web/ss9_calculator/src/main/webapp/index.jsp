<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Index Pages</title>
    <meta charset="utf-8">
</head>
<body>
<form action="/discount-servlet" method="post">
    <label for="description">Product Description</label><br/>
    <input type="text" name="product" id="description" value="${product}"><br/>
    <label for="price">List Price</label><br/>
    <input type="number" name="price" id="price" value="${price}">
    <br/><label for="discount">Discount Percent</label><br/>
    <input type="number" name="discount" id="discount" value="${discount}"><br/>
    <button type="submit">Calculate Discount</button>
    <br/>
</form>
${result}
</body>
</html>
<%--
  Created by IntelliJ IDEA.
  User: aquam
  Date: 2/16/2022
  Time: 12:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Add customer</title>
</head>
<body>
<form action="customer-servlet" method="post">
  <input type="hidden" name="act" value="/addCustomer">
  <input type="number" name="zip" placeholder="zip">
  <input type="text" name="name" placeholder="name">
  <input type="text" name="firstAddress" placeholder="first address">
  <input type="text" name="secondAddress" placeholder="second address">
  <input type="number" name="numbFax" placeholder="number fax">
  <input type="text" name="city" placeholder="city">
  <input value="add" type="submit">
</form>
<form action="customer-servlet" method="post">
  <input type="hidden" name="act" value="default">
  <input value="main" type="submit">
</form>
</body>
</html>

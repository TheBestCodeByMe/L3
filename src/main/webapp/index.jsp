<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Customers</title>
</head>
<body>
<h3>Would you like to see all the customers</h3>
<form action="customer-servlet" method="post">
    <input type="hidden" name="act" value="/show">
    <input value="all customers" type="submit">
</form>
<h3>Would you like to add a new customer?</h3>
<form action="customer-servlet" method="post">
    <input type="hidden" name="act" value="/new">
    <input value="add new customer" type="submit">
</form>
<h3>Would you like to see the customer with exact number fax and zip?</h3>
<form action="customer-servlet" method="post">
    <input type="number" name="numbFax" placeholder="number fax">
    <input type="number" name="zip" placeholder="zip">
    <input type="hidden" name="act" value="/exact">
    <input value="show the customer" type="submit">
</form>
</body>
</html>
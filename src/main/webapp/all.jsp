<%--
  Created by IntelliJ IDEA.
  User: aquam
  Date: 2/16/2022
  Time: 12:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>All customers</title>
    <style>table, tr, th, td {border: 1px solid black; border-collapse: separate}</style>
</head>
<body>
<table>
    <tr>
        <th>ID</th>
        <th>ZIP</th>
        <th>NAME</th>
        <th>FIRST ADDRESS</th>
        <th>SECOND ADDRESS</th>
        <th>NUMBER FAX</th>
        <th>CITY</th>
    </tr>
    <c:forEach items="${allCustomers}" var="customer">
        <tr>
            <td>${customer.getId()}</td>
            <td>${customer.getZip()}</td>
            <td>${customer.getName()}</td>
            <td>${customer.getFirstAddress()}</td>
            <td>${customer.getSecondAddress()}</td>
            <td>${customer.getNumbFax()}</td>
            <td>${customer.getCity()}</td>
        </tr>
    </c:forEach>
</table>
<form action="customer-servlet" method="post">
    <input type="hidden" name="act" value="default">
    <input value="main" type="submit">
</form>
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: aquam
  Date: 2/16/2022
  Time: 12:56 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Find</title>
</head>
<body>
<c:forEach items="${find}" var="excustomer">
    Name >> ${excustomer.getName()}<br>
    Number fax >> ${excustomer.getNumbFax()}<br>
    Zip >> ${excustomer.getZip()}<br>
    ****************************************************<br>
</c:forEach>
<form action="customer-servlet" method="post">
    <input type="hidden" name="act" value="default">
    <input value="main" type="submit">
</form>
</body>
</html>

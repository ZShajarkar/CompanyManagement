<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 6/5/2022
  Time: 10:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>مشاهده اطلاعات بن های خریده شده و خریدارها</title>
</head>
<body>


<table>

    <thead>
    <td>نام خریدار</td>
    <td>نام خانوادگی خریدار</td>
    <td>نام بن</td>
    <td>قیمت بن</td>
    </thead>
    <br>
    <c:forEach items="${requestScope.bonusesPurchasers}" var="item">
        <thead>
        <td><c:out value="${item.employee.firstName}"/></td>
        <td><c:out value="${item.employee.lastName}"/></td>
        <td><c:out value="${item.bonus.name}"/></td>
        <td><c:out value="${item.bonus.price}"/></td>
        </thead>
        <br>
    </c:forEach>
</table>

</body>
</html>

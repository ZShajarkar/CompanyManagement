<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 6/5/2022
  Time: 1:34 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<table>
    <thead>
    <td>نام</td>
    <td>تعداد</td>
    <td>قیمت</td>
    <td>عملیات</td>
    </thead>
    <c:forEach items="${requestScope.bonuses}" var="item">
        <thead>
        <form action="/api/bonus/purchase">
            <td><c:out value="${item.name}"/></td>
            <td><c:out value="${item.number}" /></td>
            <td><c:out value="${item.price}" /></td>
            <td><input type="hidden" name="bonus_id" value="${item.id}"></td>
            <td>
                <button type="submit">خرید بن</button>
            </td>
        </form>
        </thead>
    </c:forEach>

</table>

</body>
</html>

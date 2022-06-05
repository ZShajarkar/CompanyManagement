<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 6/3/2022
  Time: 1:10 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>صفحه سفارش بن</title>
</head>
<body>
test

<table>

    <tr>
        <td>نام</td>
        <td>تعداد</td>
        <td>قیمت</td>
        <td>عملیات</td>
    </tr>

        <c:forEach items="${requestScope.bonuses}" var="item">
    <form action="/api/bonus/edit">
            <tr>
                <td><input name="name" value="${item.name}"/></td>
                <td><input name="number" value="${item.number}"/></td>
                <td><input name="price" value="${item.price}"/></td>
                <td><input type="hidden" name="id" value="${item.id}"/></td>
                <td>
                    <button type="submit">ویرایش</button>
                </td>
            </tr>
    </form>
        </c:forEach>

</table>

</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 6/1/2022
  Time: 5:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <form action="/api/bonus/save">
    <label>نام</label>
    <input type="text" name="name"/>
    <br>
    <label>قیمت</label>
    <input type="text" name="price"/>
    <br>
    <label>تعداد</label>
    <input type="text" name="number"/>
    <br>
    <input type="submit" value="SAVE"/>
  </form>
  </body>
</html>

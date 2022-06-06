<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 6/6/2022
  Time: 8:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>صفحه ورود</title>
</head>
<body>

<form action="/api/login">
    <label>نام کاربری</label>
    <input name="username">
    <br>
    <label>رمز عبور</label>
    <input type="password" name="password">
    <button type="submit">ورود</button>
</form>
</body>
</html>

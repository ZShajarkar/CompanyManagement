<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 6/7/2022
  Time: 9:02 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<form action="/api/employee/save">
    <label>نام</label>
    <input type="text" name="firstName"/>
    <br>
    <label>فامیل</label>
    <input type="text" name="lastName"/>
    <br>
    <label>کد</label>
    <input type="text" name="code"/>
    <br><label>نام کاربری</label>
    <input type="text" name="username"/>
    <br><label>رمز عبور</label>
    <input type="password" name="pass"/>
    <br>
    <input type="hidden" name="role" value="user"/>
    <br>
    <input type="submit" value="SAVE"/>
</form>
</body>
</html>

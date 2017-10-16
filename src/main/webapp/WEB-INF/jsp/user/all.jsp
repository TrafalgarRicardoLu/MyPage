<%@ page import="java.util.List" %>
<%@ page import="LibraryManagementSystem.Entity.User" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: trafalgar
  Date: 17-9-15
  Time: 下午4:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>ALL User</title>
</head>
<body>
<table border="1" cellpadding="10" cellspacing="0">
    <tr>
        <th>用户名</th>
        <th>密码</th>
    </tr>

    <c:forEach items="${users}" var="user">
        <tr>
            <td>${user.name}</td>
            <td>${user.password}</td>
        </tr>
    </c:forEach>
</table>
</html>

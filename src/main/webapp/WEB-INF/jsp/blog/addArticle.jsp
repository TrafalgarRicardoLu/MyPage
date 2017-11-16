<%--
  Created by IntelliJ IDEA.
  User: trafalgar
  Date: 17-10-26
  Time: 下午5:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>AddArticle</title>
</head>
<body>
<form action="/blog/addArticle" method="post">
    <input type="text" name="title"><br>
    <textarea rows="30" cols="30" name="content"></textarea><br>
    <input type="submit" name="提交">
</form>
</body>
</html>

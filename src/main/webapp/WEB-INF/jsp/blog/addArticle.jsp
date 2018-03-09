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
    <script src="/assets/plugins/bootstrap/js/jquery-3.2.1.min.js"></script>
    <script type="text/javascript">
        function check() {
            var title = document.getElementById("title").value;
            var content = document.getElementById("content").value;
            if(title==""){
                alert("Title Can't be Null");
                return false;
            }else if(content == ""){
                alert("Content Can't be Null")
                return false;
            }else {
                return true;
            }
        }
    </script>
</head>
<body>
<form action="/blog/Article" method="post" enctype="multipart/form-data" onsubmit="return check()">
    Img: <input type="file" accept="image/jpeg" name="image"><br>
    Title: <input type="text" id="title"><br>
    Content: <textarea rows="30" cols="30" id="content"></textarea><br>
    <input type="submit" name="提交">
</form>
</body>
</html>

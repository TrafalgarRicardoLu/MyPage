<%--
  Created by IntelliJ IDEA.
  User: trafalgar
  Date: 18-1-30
  Time: 下午2:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>updateArticle</title>
    <script type="text/javascript">
        function checkID() {
            var ID = document.getElementsByName("id").item(0).value;
            if(ID==""){
                alert("ID Can't be Null");
                return false;
            }else{
                return true;
            }
        }
    </script>
</head>
<body>
<form action="/blog/Article" method="put" enctype="multipart/form-data" onsubmit="return checkID()">
    ID <input type="text" name="id"><br>
    Title<input type="text" name="title"><input type="checkbox" name="checkTile"><br>
    Image<input type="file" accept="image/jpeg" name="image"><input type="checkbox" name="checkImage"><br>
    Content<textarea rows="30" cols="30" name="content"></textarea><input type="checkbox" name="checkContent"><br>
    <input type="submit" name="提交">
</form>
</body>
</html>

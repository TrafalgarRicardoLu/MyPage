<%--
  Created by IntelliJ IDEA.
  User: trafalgar
  Date: 17-10-15
  Time: 下午4:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>用户登录</title>
    <link rel="stylesheet" href="/assets/plugins/bootstrap/css/bootstrap.min.css">
    <style>
        body {

            overflow: hidden;

            position: fixed;

            width: 100%;

            height: 100%;

            background: url("/assets/images/banner.jpg") no-repeat;

            background-size: cover;

        }

        .container {
            display: table;
            height: 100%;
        }

        .row {
            display: table-cell;
            vertical-align: middle;
        }

        .row-centered {
            text-align: center;
        }

        .col-centered {
            display: inline-block;
            float: none;
            text-align: left;
            margin-right: -4px;
        }
    </style>
    <script type="text/javascript">
        function check() {
            var name = document.getElementsByName("name").item(0).value;
            var password = document.getElementsByName("password").item(0).value;
            if (name == "") {
                alert("Title Can't be Null");
                return false;
            } else if (password == "") {
                alert("Content Can't be Null")
                return false;
            } else {
                return true;
            }
        }
    </script>
</head>

<body>
<div class="container">
    <div class="row row-centered">
        <div class="well col-md-6 col-centered">
            <h2>欢迎登录</h2>
            <form action="/blog/loginCheck" role="form" method="post" onsubmit="return check()">
                <div class="input-group input-group-md">
                    <span class="input-group-addon" id="sizing-addon1">
                        <i class="glyphicon glyphicon-user" aria-hidden="true"></i></span>
                    <input type="text" class="form-control" id="name" name="name" placeholder="请输入用户ID"/>
                </div>
                <div class="input-group input-group-md">
                    <span class="input-group-addon" id="sizing-addon1">
                        <i class="glyphicon glyphicon-lock"></i></span>
                    <input type="password" class="form-control" id="password" name="password" placeholder="请输入密码"/>
                </div>
                <br/>
                <button type="submit" class="btn btn-primary btn-block">登录</button>
            </form>
        </div>
    </div>
</div>


<script src="/assets/plugins/jquery-1.11.2.min.js"></script>
<script src="/assets/plugins/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>

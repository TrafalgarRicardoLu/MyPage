<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>${article.title}</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://fonts.googleapis.com/css?family=Work+Sans:300,400,500,700,800" rel="stylesheet">

    <link rel="stylesheet" href="/assets/css/icomoon.css">
    <link rel="stylesheet" href="/assets/plugins/bootstrap/css/bootstrap.css">
    <link rel="stylesheet" href="/assets/css/styleSingle.css">
    <script src="/assets/js/respond.min.js"></script>

</head>
<body class="single">
<div id="page">
    <div id="fh5co-aside" style="background-image: url(${imagePath})" data-stellar-background-ratio="0.5">
        <div class="overlay"></div>
        <nav role="navigation">
            <ul>
                <li><a href="/blog/index?Page=1"><i class="icon-home"></i></a></li>
            </ul>
        </nav>
        <div class="page-title">
            <h2>${article.title}</h2>
            <span>${article.date}</span>
        </div>
    </div>
    <div id="fh5co-main-content">
        <div class="fh5co-post">
            <div class="fh5co-entry padding">
                <div>
                    ${article.content}
                </div>
            </div>


        </div>
    </div>
</div>
<div class="fh5co-navigation">
    <div class="fh5co-cover prev fh5co-cover-sm" style="background-image: url(${preImagePath})">

        <div class="overlay"></div>
        <a class="copy" href="/blog/Article?id=${id}&change=pre">
            <div class="display-t">
                <div class="display-tc">
                    <div>
                        <span>Previous Post</span>
                        <h2>${preTitle}</h2>
                    </div>
                </div>
            </div>
        </a>

    </div>
    <div class="fh5co-cover next fh5co-cover-sm" style="background-image: url(${nextImagePath})">
        <div class="overlay"></div>
        <a class="copy" href="/blog/Article?id=${id}&change=next">
            <div class="display-t">
                <div class="display-tc">
                    <div>
                        <span>Next Post</span>
                        <h2>${nextTitle}</h2>
                    </div>
                </div>
            </div>
        </a>

    </div>
</div>

<div class="gototop js-top">
    <a href="/blog/updateArticle"><i class="icon-arrow-up"></i></a>
</div>


<script src="/assets/plugins/jquery-1.11.2.min.js"></script>
<script src="/assets/js/jquery.easing.1.3.js"></script>
<script src="/assets/plugins/bootstrap/js/bootstrap.min.js"></script>
<script src="/assets/js/jquery.waypoints.min.js"></script>
<script src="/assets/js/mainBlog.js"></script>

</body>
</html>


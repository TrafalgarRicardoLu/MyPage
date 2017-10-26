<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML>
<html>
<head>
    <title>Home</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <link href="/assets/plugins/bootstrap/css/bootstrap.css" rel='stylesheet' type='text/css'/>
    <link href="/assets/css/styleBlog.css" rel='stylesheet' type='text/css'/>
    <link href="/assets/css/Divider.css" rel='stylesheet' type='text/css'/>
    <link rel="stylesheet" href="/assets/css/icomoon.css">
    <link rel="stylesheet" href="/assets/css/styleSingle.css">
    <script src="/assets/plugins/jquery-1.11.2.min.js"></script>
    <script type="text/javascript">
        jQuery(document).ready(function ($) {
            $(".scroll").click(function (event) {
                event.preventDefault();
                $('html,body').animate({scrollTop: $(this.hash).offset().top}, 1000);
            });
        });


    </script>

</head>
<body>
<div class="header">
    <div class="container">
        <h1>Im TrafalgarRicardoLu</h1>
        <h2>Im a web developer</h2>
        <p>Here is my blog.</p>
        <div class="header_arrow">
            <a href="#articleList" class="scroll"><span> </span></a>
        </div>
    </div>
</div>
<div class="content_top" id="articleList">
    <div class="container">
        <div class="fh5co-post">
            <c:forEach items="${articleMap}" var="article">
                <div class="fh5co-entry padding">
                    <img src="/assets/images/blog/article${article.key}.jpg" alt="${article.value.title}">
                    <div>
                        <span class="fh5co-post-date">${article.value.date}</span>
                        <h2><a href="/blog/changeArticle?id=${article.key}">${article.value.title}</a></h2>
                        <p>${article.value.title}</p>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
</div>
<div>
    <nav class="Lagination">
        <ul>
            <li class="Lagination-first"><a href="/blog/index?Page=1" title="First page" aria-label="First page">First</a></li>
            <c:forEach var="i" begin="1" end="${countPage}">
                <c:if test="${i==currentPage}">
                <li class="Lagination-number Lagination-current"><a href="/blog/index?Page=${i}" title="Page ${i}">${i}</a></li>
                </c:if>
                <c:if test="${i!=currentPage}">
                <li class="Lagination-number"><a href="/blog/index?Page=${i}" title="Page ${i}">${i}</a></li>
                </c:if>
            </c:forEach>

            <li class="Lagination-last"><a href="/blog/index?Page=${countPage}" title="Last page" aria-label="Last page">Last</a></li>
        </ul>
    </nav>
</div>
<div class="gototop js-top">
    <a href="/blog/add"><i class="icon-file-add"></i></a>
</div>

<script src="/assets/plugins/jquery-1.11.2.min.js"></script>
<script src="/assets/js/jquery.easing.1.3.js"></script>
<script src="/assets/plugins/bootstrap/js/bootstrap.min.js"></script>
<script src="/assets/js/jquery.waypoints.min.js"></script>
<script src="/assets/js/jquery.stellar.min.js"></script>
<script src="/assets/js/mainBlog.js"></script>


</body>
</html>


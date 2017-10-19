<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE HTML>
<html>
<head>
    <title>Home</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <link href="/assets/plugins/bootstrap/css/bootstrap.css" rel='stylesheet' type='text/css'/>
    <link href="/assets/css/styleBlog.css" rel='stylesheet' type='text/css'/>
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

            <div class="fh5co-entry padding">
                <img src="/assets/images/blog/article${listId=listId+1}.jpg" alt="article${listId}">
                <div>
                    <span class="fh5co-post-date">October 12, 2016</span>
                    <h2><a href="/blog/changeArticle?id=${listId}">How to be an effective web developer</a></h2>
                    <p>How two simple exercises changed my life</p>
                </div>
            </div>

            <div class="fh5co-entry padding">
                <img src="/assets/images/blog/article${listId=listId+1}.jpg" alt="article${listId}">
                <div>
                    <span class="fh5co-post-date">October 12, 2016</span>
                    <h2><a href="/blog/changeArticle?id=${listId}">How to be an effective web developer</a></h2>
                    <p>How two simple exercises changed my life</p>
                </div>
            </div>

            <div class="fh5co-entry padding">
                <img src="/assets/images/blog/article${listId=listId+1}.jpg" alt="article${listId}">
                <div>
                    <span class="fh5co-post-date">October 12, 2016</span>
                    <h2><a href="/blog/changeArticle?id=${listId}">How to be an effective web developer</a></h2>
                    <p>How two simple exercises changed my life</p>
                </div>
            </div>

        </div>
    </div>
</div>
</body>
</html>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<!--[if IE 8]> <html lang="en" class="ie8"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9"> <![endif]-->

<html lang="en"> <!--<![endif]-->
<head>
    <title>Trafalgar Ricardo Lu</title>
    <!-- Meta -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="Responsive HTML5 Website landing Page for Developers">
    <meta name="author" content="3rd Wave Media">
    <link rel="shortcut icon" href="favicon.ico">
    <link rel="stylesheet" href="assets/plugins/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="assets/plugins/font-awesome/css/font-awesome.css">
    <link id="theme-style" rel="stylesheet" href="assets/css/styles.css">
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>

</head>

<body>
<!-- ******HEADER****** -->
<header class="header">
    <div class="container">
        <img class="profile-image img-responsive pull-left" src="assets/images/profile.png" alt="Trafalgar Ricardo Lu"/>
        <div class="profile-content pull-left">
            <h1 class="name">Trafalgar Ricardo Lu</h1>
            <h2 class="desc">Web App Developer</h2>
            <ul class="social list-inline">
                <li><a href="https://twitter.com/TrafalgarLu"><i class="fa fa-twitter"></i></a></li>
                <li><a href="https://www.facebook.com/trafalgarricardo.lu.3"><i class="fa fa-facebook"></i></a></li>
                <li><a href="https://www.linkedin.com/in/建惠-鲁-520858137"><i class="fa fa-linkedin"></i></a></li>
                <li><a href="https://github.com/TrafalgarRicardoLu"><i class="fa fa-github-alt"></i></a></li>
            </ul>
        </div><!--//profile-->
        <a class="btn btn-cta-primary pull-right" href="mailto:trafalgarricardolu@gmail.com" target="_blank"><i
                class="fa fa-paper-plane"></i> Contact Me</a>
    </div><!--//container-->
</header><!--//header-->

<div class="container sections-wrapper">
    <div class="row">
        <div class="primary col-md-8 col-sm-12 col-xs-12">
            <section class="about section">
                <div class="section-inner">
                    <h2 class="heading">About Me</h2>
                    <div class="content">
                        <p>I am a Java web developer,</p>

                    </div><!--//content-->
                </div><!--//section-inner-->
            </section><!--//section-->

            <section class="latest section">
                <div class="section-inner">
                    <h2 class="heading">Articles</h2>
                    <div class="content">
                        <div class="item featured text-center">
                            <h3 class="title"><a href="/blog/index?Page=1" target="_blank" >Blog Index</a></h3>
                            <p class="summary">My Blog which contain lots of articles</p>
                            <div class="featured-image">
                                <a href="/blog/index?Page=1" target="_blank">
                                    <img class="img-responsive project-image"
                                         src="assets/images/blog/banner.jpg" alt="MyBlog"/>
                                </a>
                            </div>

                            <div class="desc text-left">
                                <p>It's my blog, there are some articles about Algorithm, Web, Hadoop and so on.</p>
                            </div><!--//desc-->

                        </div><!--//item-->
                        <hr class="divider"/>

                    </div><!--//content-->
                </div><!--//section-inner-->
            </section><!--//section-->

            <div class="copyrights">Collect from <a href="http://www.cssmoban.com/">网页模板</a></div>

            <section class="projects section">
                <div class="section-inner">
                    <h2 class="heading">Latest Projects</h2>
                    <div class="content">
                        <div class="item">
                            <h3 class="title"><a href="#">MyPage</a> <span
                                    class="label label-theme">Open Source</span></h3>
                            <p class="summary">A simple web application which built as my own page.</p>
                            <p><a class="more-link"
                                  href="https://github.com/TrafalgarRicardoLu/MyPage"
                                  target="_blank"><i class="fa fa-external-link"></i> Find out more</a></p>
                        </div>

                        <div class="item">
                            <h3 class="title"><a href="/user/login" target="_blank">Library Management System</a> <span
                                    class="label label-theme">Open Source</span></h3>
                            <p class="summary">A simple Java Web application accomplished with SpringMVC ,Spring
                                ,Hibernate.
                                It is build as a Maven Project. </p>
                            <p><a class="more-link"
                                  href="https://github.com/TrafalgarRicardoLu/MyPage"
                                  target="_blank"><i class="fa fa-external-link"></i> View on GitHub</a></p>
                        </div><!--//item-->
                        <div class="item">
                            <h3 class="title"><a
                                    href="https://github.com/TrafalgarRicardoLu/Algorithm-and-DataStructure"
                                    target="_blank">Algorithm-and-DataStructure</a> <span
                                    class="label label-theme">Open Source</span></h3>
                            <p class="summary">Some algorithm and DataStructure.</p>
                            <p><a class="more-link"
                                  href="https://github.com/TrafalgarRicardoLu/Algorithm-and-DataStructure"
                                  target="_blank"><i class="fa fa-external-link"></i> View on GitHub</a></p>
                        </div>

                        <a class="btn btn-cta-secondary" href="#">More on CoderWall <i class="fa fa-chevron-right"></i></a>

                    </div><!--//content-->
                </div><!--//section-inner-->
            </section><!--//section-->

        </div><!--//primary-->
        <div class="secondary col-md-4 col-sm-12 col-xs-12">
            <aside class="info aside section">
                <div class="section-inner">
                    <h2 class="heading sr-only">Basic Information</h2>
                    <div class="content">
                        <ul class="list-unstyled">
                            <li><i class="fa fa-map-marker"></i><span class="sr-only">Location:</span>HangZhou, CN
                            </li>
                            <li><i class="fa fa-envelope-o"></i><span class="sr-only">Email:</span><a
                                    href="mailto:trafalgarricardo@gmail.com">trafalgarricardo@gmail.com</a>
                            </li>
                            <li><i class="fa fa-link"></i><span class="sr-only">Website:</span><a
                                    href="https://github.com/TrafalgarRicardoLu">github.com/TrafalgarRicardoLu</a>
                            </li>
                        </ul>
                    </div><!--//content-->
                </div><!--//section-inner-->
            </aside><!--//aside-->

            <aside class="skills aside section">
                <div class="section-inner">
                    <h2 class="heading">Skills</h2>
                    <div class="content">
                        <p class="intro">
                            There are my skills.</p>

                        <div class="skillset">

                            <div class="item">
                                <h3 class="level-title">Java<span class="level-label"
                                                                  data-toggle="tooltip"
                                                                  data-placement="left"
                                                                  data-animation="true"
                                                                  title="You can use the tooltip to add more info...">Expert</span>
                                </h3>
                                <div class="level-bar">
                                    <div class="level-bar-inner" data-level="96%">
                                    </div>
                                </div><!--//level-bar-->
                            </div><!--//item-->

                            <div class="item">
                                <h3 class="level-title">Spring &amp; Hibernate<span class="level-label">Expert</span>
                                </h3>
                                <div class="level-bar">
                                    <div class="level-bar-inner" data-level="96%">
                                    </div>
                                </div><!--//level-bar-->
                            </div><!--//item-->

                            <div class="item">
                                <h3 class="level-title">HTML5 &amp; CSS3<span
                                        class="level-label">Expert</span></h3>
                                <div class="level-bar">
                                    <div class="level-bar-inner" data-level="96%">
                                    </div>
                                </div><!--//level-bar-->
                            </div><!--//item-->

                            <div class="item">
                                <h3 class="level-title">SQL<span class="level-label">Pro</span></h3>
                                <div class="level-bar">
                                    <div class="level-bar-inner" data-level="85%">
                                    </div>
                                </div><!--//level-bar-->
                            </div><!--//item-->

                            <p><a class="more-link" href="#"><i class="fa fa-external-link"></i> More on Coderwall</a>
                            </p>
                        </div>
                    </div><!--//content-->
                </div><!--//section-inner-->
            </aside><!--//section-->


            <aside class="education aside section">
                <div class="section-inner">
                    <h2 class="heading">Education</h2>
                    <div class="content">
                        <div class="item">
                            <h3 class="title"><i class="fa fa-graduation-cap"></i>Computer Science
                            </h3>
                            <h4 class="university">HangZhou Dianzi University<span class="year">(2016-2020)</span></h4>
                        </div><!--//item-->
                    </div><!--//content-->
                </div><!--//section-inner-->
            </aside><!--//section-->

            <aside class="languages aside section">
                <div class="section-inner">
                    <h2 class="heading">Languages</h2>
                    <div class="content">
                        <ul class="list-unstyled">
                            <li class="item">
                                <span class="title"><strong>Chinese:</strong></span>
                                <span class="level">Native Speaker <br class="visible-xs"/><i class="fa fa-star"></i> <i
                                        class="fa fa-star"></i> <i class="fa fa-star"></i> <i class="fa fa-star"></i> <i
                                        class="fa fa-star"></i> </span>
                            </li><!--//item-->
                            <li class="item">
                                <span class="title"><strong>English:</strong></span>
                                <span class="level">Professional Proficiency <br class="visible-sm visible-xs"/><i
                                        class="fa fa-star"></i> <i class="fa fa-star"></i> <i class="fa fa-star"></i> <i
                                        class="fa fa-star-half"></i></span>
                            </li><!--//item-->
                        </ul>
                    </div><!--//content-->
                </div><!--//section-inner-->
            </aside><!--//section-->


        </div><!--//secondary-->
    </div><!--//row-->
</div><!--//masonry-->

<!-- Javascript -->
<script type="text/javascript" src="assets/plugins/jquery-1.11.2.min.js"></script>
<script type="text/javascript" src="assets/plugins/jquery-migrate-1.2.1.min.js"></script>
<script type="text/javascript" src="assets/plugins/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="assets/plugins/jquery-rss/dist/jquery.rss.min.js"></script>
<script type="text/javascript" src="assets/js/main.js"></script>
</body>
</html>


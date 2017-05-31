<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>My Coupon</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<!-- CSS
================================================== -->
<link href='http://fonts.googleapis.com/css?family=Oswald' rel='stylesheet' type='text/css'>
<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="css/bootstrap-responsive.css">
<link rel="stylesheet" href="css/custom-styles.css">

<link rel="stylesheet" href="css/ihover.css">
<link rel="stylesheet" href="css/style.css">

<!-- JS
================================================== -->
<script src="http://code.jquery.com/jquery-1.8.3.min.js"></script>
<script src="js/bootstrap.js"></script>
<script src="js/jquery.custom.js"></script>

</head>
<body>

	<div class="color-bar-1"></div>
    <div class="color-bar-2 color-bg"></div>
    
    <div class="container main-container">

	<div class="row header"><!-- Begin Header -->
      
        <!-- Logo
        ================================================== -->
        <div class="span5 logo">
        	<a href="index.htm"><img src="img/piccolo-logo.png" alt="" /></a>
            <h5>Big Things... Small Packages</h5>
        </div>
        
        <!-- Main Navigation
        ================================================== -->
        <div class="span7 navigation">
            <div class="navbar hidden-phone">
            
            <ul class="nav">
            <li class="dropdown">
                <a class="dropdown-toggle" data-toggle="dropdown" href="index.htm">Home <b class="caret"></b></a>
                <ul class="dropdown-menu">
                    <li><a href="index.htm">Full Page</a></li>
                    <li><a href="index-gallery.htm">Gallery Only</a></li>
                    <li><a href="index-slider.htm">Slider Only</a></li>
                </ul>
            </li>
           <li><a href="features.htm">Features</a></li>
            <li class="dropdown active">
                <a class="dropdown-toggle" data-toggle="dropdown" href="page-full-width.htm">Pages <b class="caret"></b></a>
                <ul class="dropdown-menu">
                    <li><a href="page-full-width.htm">Full Width</a></li>
                    <li><a href="page-right-sidebar.htm">Right Sidebar</a></li>
                    <li><a href="page-left-sidebar.htm">Left Sidebar</a></li>
                    <li><a href="page-double-sidebar.htm">Double Sidebar</a></li>
                </ul>
            </li>
             <li class="dropdown">
                <a class="dropdown-toggle" data-toggle="dropdown" href="gallery-4col.htm">Gallery <b class="caret"></b></a>
                <ul class="dropdown-menu">
                    <li><a href="gallery-3col.htm">Gallery 3 Column</a></li>
                    <li><a href="gallery-4col.htm">Gallery 4 Column</a></li>
                    <li><a href="gallery-6col.htm">Gallery 6 Column</a></li>
                    <li><a href="gallery-4col-circle.htm">Gallery 4 Round</a></li>
                    <li><a href="gallery-single.htm">Gallery Single</a></li>
                </ul>
             </li>
             <li class="dropdown">
                <a class="dropdown-toggle" data-toggle="dropdown" href="blog-style1.htm">Blog <b class="caret"></b></a>
                <ul class="dropdown-menu">
                    <li><a href="blog-style1.htm">Blog Style 1</a></li>
                    <li><a href="blog-style2.htm">Blog Style 2</a></li>
                    <li><a href="blog-style3.htm">Blog Style 3</a></li>
                    <li><a href="blog-style4.htm">Blog Style 4</a></li>
                    <li><a href="blog-single.htm">Blog Single</a></li>
                </ul>
             </li>
             <li><a href="page-contact.htm">Contact</a></li>
            </ul>
           
            </div>

            <!-- Mobile Nav
            ================================================== -->
            <form action="#" id="mobile-nav" class="visible-phone">
                <div class="mobile-nav-select">
                <select onchange="window.open(this.options[this.selectedIndex].value,'_top')">
                    <option value="">Navigate...</option>
                    <option value="index.htm">Home</option>
                        <option value="index.htm">- Full Page</option>
                        <option value="index-gallery.htm">- Gallery Only</option>
                        <option value="index-slider.htm">- Slider Only</option>
                    <option value="features.htm">Features</option>
                    <option value="page-full-width.htm">Pages</option>
                        <option value="page-full-width.htm">- Full Width</option>
                        <option value="page-right-sidebar.htm">- Right Sidebar</option>
                        <option value="page-left-sidebar.htm">- Left Sidebar</option>
                        <option value="page-double-sidebar.htm">- Double Sidebar</option>
                    <option value="gallery-4col.htm">Gallery</option>
                        <option value="gallery-3col.htm">- 3 Column</option>
                        <option value="gallery-4col.htm">- 4 Column</option>
                        <option value="gallery-6col.htm">- 6 Column</option>
                        <option value="gallery-4col-circle.htm">- Gallery 4 Col Round</option>
                        <option value="gallery-single.htm">- Gallery Single</option>
                    <option value="blog-style1.htm">Blog</option>
                        <option value="blog-style1.htm">- Blog Style 1</option>
                        <option value="blog-style2.htm">- Blog Style 2</option>
                        <option value="blog-style3.htm">- Blog Style 3</option>
                        <option value="blog-style4.htm">- Blog Style 4</option>
                        <option value="blog-single.htm">- Blog Single</option>
                    <option value="page-contact.htm">Contact</option>
                </select>
                </div>
                </form>
            
        </div>
        
      	</div><!-- End Header -->
		
		<div>
    <div class="container" style="margin:0 auto;">
        <h1 class="title-bg">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;My Coupon</h1>
        <br>
        <h2><span style="color:red">쿠폰은 모바일에서 사용가능합니다!</span></h2>
        <br>
      </div>
        <div class="ih-item circle effect2 left_to_right" style="float:left;"><a href="#">
        <div class="img"><img src="images/circ_img1.jpg" alt="img"></div>
        <div class="info">
          <h3>소주1+1(~6/2)</h3>
          <p>담소사골순대</p>
          <button class="btn btn-inverse" type="button">Delete</button>
        </div></a></div>
        <div class="ih-item circle effect2 left_to_right" style="float:left;"><a href="#">
        <div class="img"><img src="images/circ_img2.jpg" alt="img"></div>
        <div class="info">
          <h3>수육1000원 할인(~6/2)</h3>
          <p>담소사골순대</p>
          <button class="btn btn-inverse" type="button">Delete</button>
        </div></a></div>
        <div class="ih-item circle effect2 left_to_right" style="float:left;"><a href="#">
        <div class="img"><img src="images/circ_img3.jpg" alt="img"></div>
        <div class="info">
          <h3>사이다 서비스(~6/2)</h3>
          <p>담소사골순대</p>
          <button class="btn btn-inverse" type="button">Delete</button>
        </div></a></div>
        <div class="ih-item circle effect2 left_to_right" style="float:left;"><a href="#">
        <div class="img"><img src="images/circ_img4.jpg" alt="img"></div>
        <div class="info">
          <h3>밥 한공기 더(~6/2)</h3>
          <p>담소사골순대</p>
          <button class="btn btn-inverse" type="button">Delete</button>
        </div></a></div>
    </div>	
      
	
	</div>
	
</body>
</html>
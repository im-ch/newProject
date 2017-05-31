<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Company detail</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<!-- CSS
================================================== -->
<link href='http://fonts.googleapis.com/css?family=Oswald' rel='stylesheet' type='text/css'>
<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="css/bootstrap-responsive.css">
<link rel="stylesheet" href="css/jquery.lightbox-0.5.css">
<link rel="stylesheet" href="css/custom-styles.css">
<!-- 쿠폰css -->
<link rel="stylesheet" href="css/ihover.css">
<link rel="stylesheet" href="css/style.css">


<!-- Favicons
================================================== -->
<link rel="shortcut icon" href="img/favicon.ico">
<link rel="apple-touch-icon" href="img/apple-touch-icon.png">
<link rel="apple-touch-icon" sizes="72x72" href="img/apple-touch-icon-72x72.png">
<link rel="apple-touch-icon" sizes="114x114" href="img/apple-touch-icon-114x114.png">

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
     
    <!-- Page Content
    ================================================== --> 
    <div class="row"><!--Container row-->

    <!-- Title Header -->
        <div class="span8"><!--Begin page content column-->

            <h2>담소사골순대</h2>
            <p class="lead">소사골의 소고기 순대국, 올바름에 대해 고민하는 사람들</p>

            <h5 class="title-bg">Pictures</h5>

            <div class="row">
                <div class="span2">
                    <img src="img/gallery/gallery-img-1-6col.jpg" alt="Image" class="thumbnail">
                </div>
                <div class="span2">
                    <img src="img/gallery/gallery-img-1-6col.jpg" alt="Image" class="thumbnail">
                </div>
                <div class="span2">
                    <img src="img/gallery/gallery-img-13-6col.jpg" alt="Image" class="thumbnail">
                </div>
                <div class="span2">
                    <img src="img/gallery/gallery-img-14-6col.jpg" alt="Image" class="thumbnail">
                </div>
            </div>

        </div> <!--End page content column-->

        <!-- Blog Sidebar
        ================================================== --> 
        <div class="span4 sidebar page-sidebar"><!-- Begin sidebar column -->
            
            <!--Testimonials-->
            <h5 class="title-bg">Map</h5>
    		<img src="img/location-map.jpg" alt="map">	
			&nbsp;
			<div class="alert alert-success">
                <button type="button" class="close" data-dismiss="alert">×</button>
                <strong>영업시간 : </strong> 오전11시 ~ 익일2시
            </div>
        </div><!-- End sidebar column -->
    </div><!-- End container row -->
    <div>
    <div class="container" style="margin:0 auto;">
        <h3>Coupon</h3>
      </div>
        <div class="ih-item circle effect2 left_to_right" style="float:left;"><a href="#">
        <div class="img"><img src="images/circ_img1.jpg" alt="img"></div>
        <div class="info">
          <h3>소주 1+1</h3>
          <p>쿠폰받기!(~6/2)</p>
        </div></a></div>
        <div class="ih-item circle effect2 left_to_right" style="float:left;"><a href="#">
        <div class="img"><img src="images/circ_img2.jpg" alt="img"></div>
        <div class="info">
          <h3>수육1000원 할인</h3>
          <p>쿠폰받기!(~6/2)</p>
        </div></a></div>
        <div class="ih-item circle effect2 left_to_right" style="float:left;"><a href="#">
        <div class="img"><img src="images/circ_img3.jpg" alt="img"></div>
        <div class="info">
          <h3>사이다 서비스</h3>
          <p>쿠폰받기!(~6/2)</p>
        </div></a></div>
        <div class="ih-item circle effect2 left_to_right" style="float:left;"><a href="#">
        <div class="img"><img src="images/circ_img4.jpg" alt="img"></div>
        <div class="info">
          <h3>밥 한공기 더</h3>
          <p>쿠폰받기!(~6/2)</p>
        </div></a></div>
    </div>
    <br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
    <div>
    <section class="comments">
                <h4 class="title-bg"><a name="comments"></a>Reviews</h4>
               <ul>
                    <li>
                        <img src="img/user-avatar.jpg" alt="Image" />
                        <span class="comment-name">임창희</span>&nbsp;&nbsp;&nbsp;
                        <span class="comment-date">2017/05/29 | <a href="#">수정</a>/<a href="#">삭제</a></span>
                        <div class="comment-content">파워 블로거라서 공짜로 얻어 먹었네요(개이득=9) 블로그에 잘 게시하겠습니닷&nbsp;&nbsp;<a href="#">[신고]</a></div>
                    </li>
                    <li>
                        <img src="img/user-avatar.jpg" alt="Image" />
                        <span class="comment-name">황희현</span>&nbsp;&nbsp;&nbsp;
                        <span class="comment-date">2017/05/29 | <a href="#">수정</a>/<a href="#">삭제</a></span>
                        <div class="comment-content">님들님들 여기 개노맛 가지마셈&nbsp;&nbsp;<a href="#">[신고]</a></div>
                    </li>
                    <li>
                        <img src="img/user-avatar.jpg" alt="Image" />
                        <span class="comment-name">이연철</span>&nbsp;&nbsp;&nbsp;
                        <span class="comment-date">2017/05/29 | <a href="#">수정</a>/<a href="#">삭제</a></span>
                        <div class="comment-content">전 다 필요없고 소주 무한리필이 너무 좋습니다 사랑합니다♡&nbsp;&nbsp;<a href="#">[신고]</a></div>
                    </li>
                    
               </ul>
            
                <!-- Comment Form -->
                <div class="comment-form-container">
                    <h6>Leave a Review</h6>
                    <form action="#" id="comment-form">
                        <textarea class="span6"></textarea>
                        <div class="row">
                            <div class="span2">
                                <input type="submit" class="btn btn-inverse" value="Post My Review">
                            </div>
                        </div>
                    </form>
                </div>
        </section><!-- Close comments section-->
		</div> 
     
    </div> <!-- End Container -->
    
    <!-- Scroll to Top -->  
    <div id="toTop" class="hidden-phone hidden-tablet">Back to Top</div>
</body>
</html>
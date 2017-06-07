<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<title>Jeff</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<!-- CSS
================================================== -->
<link href='http://fonts.googleapis.com/css?family=Oswald' rel='stylesheet' type='text/css'>
<link rel="stylesheet" href="${ctx}/resources/css/bootstrap.css">
<link rel="stylesheet" href="${ctx}/resources/css/bootstrap-responsive.css">
<link rel="stylesheet" href="${ctx}/resources/css/prettyPhoto.css" />
<link rel="stylesheet" href="${ctx}/resources/css/flexslider.css" />
<link rel="stylesheet" href="${ctx}/resources/css/custom-styles.css">
<link rel="stylesheet" href="${ctx}/resources/inner/css/main.css" />




<!-- Favicons
================================================== -->
<link rel="shortcut icon" href="${ctx}/resources/img/favicon.ico">
<link rel="apple-touch-icon" href="${ctx}/resources/img/apple-touch-icon.png">
<link rel="apple-touch-icon" sizes="72x72" href="${ctx}/resources/img/apple-touch-icon-72x72.png">
<link rel="apple-touch-icon" sizes="114x114" href="${ctx}/resources/img/apple-touch-icon-114x114.png">

<!-- JS
================================================== -->
<script src="http://code.jquery.com/jquery-1.8.3.min.js"></script>
<script src="${ctx}/resources/js/bootstrap.js"></script>
<script src="${ctx}/resources/js/jquery.prettyPhoto.js"></script>
<script src="${ctx}/resources/js/jquery.flexslider.js"></script>
<script src="${ctx}/resources/js/jquery.custom.js"></script> 
<script type="text/javascript">

$(document).ready(function () {

    $("#btn-blog-next").click(function () {
      $('#blogCarousel').carousel('next')
    });
     $("#btn-blog-prev").click(function () {
      $('#blogCarousel').carousel('prev')
    });

     $("#btn-client-next").click(function () {
      $('#clientCarousel').carousel('next')
    });
     $("#btn-client-prev").click(function () {
      $('#clientCarousel').carousel('prev')
    });
    
});

 $(window).load(function(){

    $('.flexslider').flexslider({
        animation: "slide",
        slideshow: true,
        start: function(slider){
          $('body').removeClass('loading');
        }
    });  
});

</script>

</head>

<body class="home">
    <!-- Color Bars (above header)-->
	<div class="color-bar-1"></div>
    <div class="color-bar-2 color-bg"></div>
    
    <div class="container">
    
      <div class="row header"><!-- Begin Header -->
      
        <!-- Logo
        ================================================== -->
        <div class="span5 logo">
      		<a href="index.htm"><img src="${ctx }/resources/img/logo3.png" alt="" /></a>
      		<h5>Affiliate Friends</h5>
  		</div>
        
        <!-- Main Navigation
        ================================================== -->
        <div class="span7 navigation">
            <div class="navbar hidden-phone">
            
            <ul class="nav">
            <li class="dropdown active">
                <a class="dropdown-toggle" data-toggle="dropdown" href="index.htm">Home <b class="caret"></b></a>
                <ul class="dropdown-menu">
                    <li><a href="index.htm">Full Page</a></li>
                    <li><a href="index-gallery.htm">Gallery Only</a></li>
                    <li><a href="index-slider.htm">Slider Only</a></li>
                </ul>
            </li>
           <li><a href="features.htm">Features</a></li>
            <li class="dropdown">
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
      <h3>JEFF 제휴제안서</h3>
      <form action="${ctx }/alliance/regist" method="post">
		<table class="table01" width="100%">
          <tbody>
            <tr>
              <th width="150" >기업명<br>(Company Title)</th>
              
              <td colspan="3" id="SUBJ_CD_NM">
              <input type="text" name="comName" placeholder="asdasdasd"/></td> 
            
            </tr>
            <tr>
              <th>사업자번호<br>(Business Number)</th>
              <td colspan="3" id="FILE_NM">
              <input type="text" name="businessNumber" placeholder="asdasdasd"/></td>
            </tr>
            <tr>
              <th>기업위치<br>(Location)</th>
              <td colspan="3"    id="LESS_CD_NM">
              <input type="text" name="location" placeholder="asdasdasd"/></td>
              
            </tr>
            <tr>
              <th>영업시간<br>(Business Time)</th>
              <td id="SUBJ_LECT"><textarea name="openingHours" cols="40" rows="8"></textarea></td>
               <th>기업설명<br>(Business Detail)</th>
              <td id="GRAD_SMST_NM"><textarea name="detail" cols="40" rows="8" ></textarea></td>
            </tr>
          </tbody>
        </table>
        <div style="float:right; width:30%; height:500px;">
        <Button>승인</Button>
        <Button>취소</Button></div>
        </form>
		
</body>
</html>
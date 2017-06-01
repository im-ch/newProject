<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="ctx" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Jeff</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<!-- CSS
================================================== -->
<link href='http://fonts.googleapis.com/css?family=Oswald' rel='stylesheet' type='text/css'>
<link rel="stylesheet" href="${ctx }/resources/css/bootstrap.css">
<link rel="stylesheet" href="${ctx }/resources/css/bootstrap-responsive.css">
<link rel="stylesheet" href="${ctx }/resources/css/prettyPhoto.css" />
<link rel="stylesheet" href="${ctx }/resources/css/custom-styles.css">

<!--[if lt IE 9]>
    <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <link rel="stylesheet" href="css/style-ie.css"/>
<![endif]--> 

<!-- Favicons
================================================== -->
<link rel="shortcut icon" href="${ctx }/resources/img/favicon.ico">
<link rel="apple-touch-icon" href="${ctx }/resources/img/apple-touch-icon.png">
<link rel="apple-touch-icon" sizes="72x72" href="${ctx }/resources/img/apple-touch-icon-72x72.png">
<link rel="apple-touch-icon" sizes="114x114" href="${ctx }/resources/img/apple-touch-icon-114x114.png">

<!-- JS
================================================== -->
<script src="http://code.jquery.com/jquery-1.8.3.min.js"></script>
<script src="${ctx }/resources/js/jquery.easing.1.3.js"></script>
<script src="${ctx }/resources/js/bootstrap.js"></script>
<script src="${ctx }/resources/js/jquery.prettyPhoto.js"></script>
<script src="${ctx }/resources/js/jquery.quicksand.js"></script>
<script src="${ctx }/resources/js/jquery.custom.js"></script>


</head>

<body>
	<div class="color-bar-1"></div>
    <div class="color-bar-2 color-bg"></div>
    
    <div class="container main-container">
    
      <%@ include file="/views/header.jspf"%>
     
    <!-- Page Content
    ================================================== --> 
    <div class="row">

        <!-- Gallery Items
        ================================================== --> 
        <div class="span12 gallery">

            <ul id="filterOptions" class="gallery-cats clearfix">
                <li class="active"><a href="#" class="all">All</a></li> 
                <li><a href="#" class="illustration">Restaurant</a></li>
                <li><a href="#" class="design">Cafe</a></li>
                <li><a href="#" class="video">Bar</a></li>
                <li><a href="#" class="web">Clothing Store</a></li>
            </ul>

            <div class="row clearfix">
                <ul class="gallery-post-grid holder">

                    <!-- Gallery Item 1 -->
                    <li  class="span4 gallery-item" data-id="id-1" data-type="illustration">
                        <span class="gallery-hover-3col hidden-phone hidden-tablet">
                            <span class="gallery-icons">
                                <a href="${ctx }/resources/img/gallery/damso.jpg" class="item-zoom-link lightbox" title="Custom Illustration" data-rel="prettyPhoto"></a>
                                <a href="gallery-single.htm" class="item-details-link"></a>
                            </span>
                        </span>
                        <a href="gallery-single.htm"><img src="${ctx }/resources/img/gallery/damso.jpg" alt="Gallery"></a>
                        <span class="project-details"><a href="gallery-single.htm">담소사골순대</a>소사골의 소고기 순대국, 올바름에 대해 고민하는 사람들</span>
                    </li>

                    <!-- Gallery Item 2 -->
                    <li class="span4 gallery-item" data-id="id-2" data-type="illustration">
                        <span class="gallery-hover-3col hidden-phone hidden-tablet">
                            <span class="gallery-icons">
                                <a href="${ctx }/resources/img/gallery/parram.jpg" class="item-zoom-link lightbox" title="Custom Illustration" data-rel="prettyPhoto"></a>
                                <a href="gallery-single.htm" class="item-details-link"></a>
                            </span>
                        </span>
                        <a href="gallery-single.htm"><img src="${ctx }/resources/img/gallery/parram.jpg" alt="Gallery"></a>
                        <span class="project-details"><a href="gallery-single.htm">팔람까오</a>가산동의 작은 태국 음식점입니다 </span>
                    </li>

                    <!-- Gallery Item 3 -->
                    <li class="span4 gallery-item" data-id="id-3" data-type="web">
                        <span class="gallery-hover-3col hidden-phone hidden-tablet">
                            <span class="gallery-icons">
                                <a href="${ctx }/resources/img/gallery/6jun.jpg" class="item-zoom-link lightbox" title="Custom Illustration" data-rel="prettyPhoto"></a>
                                <a href="gallery-single.htm" class="item-details-link"></a>
                            </span>
                        </span>
                        <a href="gallery-single.htm"><img src="${ctx }/resources/img/gallery/6jun.jpg" alt="Gallery"></a>
                        <span class="project-details"><a href="gallery-single.htm">육전면사무소</a>고기로 만든 전과 생면이 있는 곳</span>
                    </li>

                    <!-- Gallery Item 4 -->
                    <li class="span4 gallery-item" data-id="id-4" data-type="video">
                        <span class="gallery-hover-3col hidden-phone hidden-tablet">
                            <span class="gallery-icons">
                                <a href="${ctx }/resources/img/gallery/gallery-img-1-full.jpg" class="item-zoom-link lightbox" title="Custom Illustration" data-rel="prettyPhoto"></a>
                                <a href="gallery-single.htm" class="item-details-link"></a>
                            </span>
                        </span>
                       <a href="gallery-single.htm"><img src="${ctx }/resources/img/gallery/gallery-img-1-3col.jpg" alt="Gallery"></a>
                        <span class="project-details"><a href="gallery-single.htm">Custom Illustration</a>For an international add campaign.</span>
                    </li>

                    <!-- Gallery Item 5 -->
                    <li class="span4 gallery-item" data-id="id-5" data-type="web illustration">
                        <span class="gallery-hover-3col hidden-phone hidden-tablet">
                            <span class="gallery-icons">
                                <a href="${ctx }/resources/img/gallery/gallery-img-1-full.jpg" class="item-zoom-link lightbox" title="Custom Illustration" data-rel="prettyPhoto"></a>
                                <a href="gallery-single.htm" class="item-details-link"></a>
                            </span>
                        </span>
                        <a href="gallery-single.htm"><img src="${ctx }/resources/img/gallery/gallery-img-1-3col.jpg" alt="Gallery"></a>
                        <span class="project-details"><a href="gallery-single.htm">Icon Design</a>Classic retro style illustration.</span>
                    </li>

                    <!-- Gallery Item 6 -->
                    <li class="span4 gallery-item" data-id="id-6" data-type="illustration design">
                        <span class="gallery-hover-3col hidden-phone hidden-tablet">
                            <span class="gallery-icons">
                                <a href="${ctx }/resources/img/gallery/gallery-img-1-full.jpg" class="item-zoom-link lightbox" title="Custom Illustration" data-rel="prettyPhoto"></a>
                                <a href="gallery-single.htm" class="item-details-link"></a>
                            </span>
                        </span>
                        <a href="gallery-single.htm"><img src="${ctx }/resources/img/gallery/gallery-img-1-3col.jpg" alt="Gallery"></a>
                        <span class="project-details"><a href="gallery-single.htm">Animation Cell</a>Creative storyboard illustration</span>
                    </li>

                </ul>
            </div>

            <!-- Pagination -->
            <div class="pagination">
                <ul>
                <li class="active"><a href="#">Prev</a></li>
                <li class="active"><a href="#">1</a></li>
                <li><a href="#">2</a></li>
                <li><a href="#">3</a></li>
                <li><a href="#">4</a></li>
                <li><a href="#">Next</a></li>
                </ul>
            </div>

        </div><!-- End gallery list-->

    </div><!-- End container row -->
    
    </div> <!-- End Container -->

    <!-- Footer Area
        ================================================== -->
	<%@ include file="/views/footer.jspf"%>

	<div id="toTop" class="hidden-phone hidden-tablet">Back to Top</div>
    
</body>
</html>

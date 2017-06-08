<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath }" />

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Jeff</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">


<!-- CSS
================================================== -->
<link href='http://fonts.googleapis.com/css?family=Oswald'
	rel='stylesheet' type='text/css'>
<link rel="stylesheet" href="${ctx }/resources/css/bootstrap.css">
<link rel="stylesheet"
	href="${ctx }/resources/css/bootstrap-responsive.css">
<link rel="stylesheet" href="${ctx }/resources/css/prettyPhoto.css" />
<link rel="stylesheet" href="${ctx }/resources/css/custom-styles.css">

<!--[if lt IE 9]>
    <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <link rel="stylesheet" href="css/style-ie.css"/>
<![endif]-->

<!-- Favicons
================================================== -->
<link rel="shortcut icon" href="${ctx }/resources/img/favicon.ico">
<link rel="apple-touch-icon"
	href="${ctx }/resources/img/apple-touch-icon.png">
<link rel="apple-touch-icon" sizes="72x72"
	href="${ctx }/resources/img/apple-touch-icon-72x72.png">
<link rel="apple-touch-icon" sizes="114x114"
	href="${ctx }/resources/img/apple-touch-icon-114x114.png">

<!-- JS
================================================== -->
<script src="http://code.jquery.com/jquery-1.8.3.min.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/js/jquery.easing.1.3.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/js/bootstrap.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/js/jquery.prettyPhoto.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/js/jquery.quicksand.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/js/jquery.custom.js"></script>

<script type="text/javascript">
	function toAjax(comId) {
		$.ajax({
			url : "${ctx}/interesting/remove",
			type : "GET",
			data : {
				comId : comId
			},
			success : function(data) {
				alert("삭제되었습니다.");
				window.location.reload();
			},
			error : function(jqXHR, textStatus, errorThrown) {
				alert("잠시 후 다시 시도해 주세요");
			}
		});
	}
</script>

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
					<li><a href="#" class="123">Illustration</a></li>
					<li><a href="#" class="456">Design</a></li>
					<li><a href="#" class="789">Video</a></li>
					<li><a href="#" class="web">Web</a></li>
				</ul>

				<div class="row clearfix">
					<c:choose>

						<c:when test="${company eq null}">
							<h1>즐겨찾기 목록이 비어있습니다.</h1>
						</c:when>
						<c:otherwise>
							<c:forEach items="${company }" var="com">
								<ul class="gallery-post-grid holder">
									<li class="span4 gallery-item" data-id="${com.comId }"
										data-type="${com.category }"><span
										class="gallery-hover-3col hidden-phone hidden-tablet">
											<span class="gallery-icons"> <a
												href="${ctx }/resources/img/gallery/parram.jpg"
												class="item-zoom-link lightbox" title="Custom Illustration"
												data-rel="prettyPhoto"></a> <a
												href="${ctx }/resources/gallery-single.htm"
												class="item-details-link"></a>
										</span>
									</span> <a href="gallery-single.htm"><img
											src="${ctx }/resources/img/gallery/parram.jpg" alt="Gallery"></a>
										<span class="project-details"><a
											href="${ctx }/resources/gallery-single.htm"
											id="${com.comId }">${com.comId }</a>For an international add
											campaign.</span> 
											
											<!-- ★★★★★★★★★★★★★★★★delete★★★★★★★★★★★★★★★★ --> 
											<input type="button" id="delete" class="delete"
										onclick="toAjax('${com.comId}');" name="delete" value="delete">
										<!-- ★★★★★★★★★★★★★★★★delete★★★★★★★★★★★★★★★★ -->


									</li>
									</span> <a
										href="gallery-single.htm"><img
											src="${ctx }/resources/img/gallery/parram.jpg"
											alt="Gallery"></a> <span class="project-details"><a
											href="${ctx }/resources/gallery-single.htm">${com.comId }</a>For
											an international add campaign.</span></li>
								</ul>
							</c:forEach>
						</c:otherwise>
					</c:choose>
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

			</div>
			<!-- End gallery list-->

		</div>
		<!-- End container row -->

	</div>
	<!-- End Container -->

	<%@ include file="/views/footer.jspf"%>
	<!-- Footer Area
        ================================================== -->
	<div class="footer-container">
		<!-- Begin Footer -->
		<div class="container">
			<div class="row footer-row">
				<div class="span3 footer-col">
					<h5>About Us</h5>
					<img src="img/piccolo-footer-logo.png" alt="Piccolo" /><br /> <br />
					<address>
						<strong>Design Team</strong><br /> 123 Main St, Suite 500<br />
						New York, NY 12345<br />
					</address>
					<ul class="social-icons">
						<li><a href="#" class="social-icon facebook"></a></li>
						<li><a href="#" class="social-icon twitter"></a></li>
						<li><a href="#" class="social-icon dribble"></a></li>
						<li><a href="#" class="social-icon rss"></a></li>
						<li><a href="#" class="social-icon forrst"></a></li>
					</ul>
				</div>
				<div class="span3 footer-col">
					<h5>Latest Tweets</h5>
					<ul>
						<li><a href="#">@room122</a> Lorem ipsum dolor sit amet,
							consectetur adipiscing elit.</li>
						<li><a href="#">@room122</a> In interdum felis fermentum
							ipsum molestie sed porttitor ligula rutrum. Morbi blandit
							ultricies ultrices.</li>
						<li><a href="#">@room122</a> Vivamus nec lectus sed orci
							molestie molestie. Etiam mattis neque eu orci rutrum aliquam.</li>
					</ul>
				</div>
				<div class="span3 footer-col">
					<h5>Latest Posts</h5>
					<ul class="post-list">
						<li><a href="#">Lorem ipsum dolor sit amet</a></li>
						<li><a href="#">Consectetur adipiscing elit est lacus
								gravida</a></li>
						<li><a href="#">Lectus sed orci molestie molestie etiam</a></li>
						<li><a href="#">Mattis consectetur adipiscing elit est
								lacus</a></li>
						<li><a href="#">Cras rutrum, massa non blandit convallis
								est</a></li>
					</ul>
				</div>
				<div class="span3 footer-col">
					<h5>Flickr Photos</h5>
					<ul class="img-feed">
						<li><a href="#"><img src="img/gallery/flickr-img-1.jpg"
								alt="Image Feed"></a></li>
						<li><a href="#"><img src="img/gallery/flickr-img-1.jpg"
								alt="Image Feed"></a></li>
						<li><a href="#"><img src="img/gallery/flickr-img-1.jpg"
								alt="Image Feed"></a></li>
						<li><a href="#"><img src="img/gallery/flickr-img-1.jpg"
								alt="Image Feed"></a></li>
						<li><a href="#"><img src="img/gallery/flickr-img-1.jpg"
								alt="Image Feed"></a></li>
						<li><a href="#"><img src="img/gallery/flickr-img-1.jpg"
								alt="Image Feed"></a></li>
						<li><a href="#"><img src="img/gallery/flickr-img-1.jpg"
								alt="Image Feed"></a></li>
						<li><a href="#"><img src="img/gallery/flickr-img-1.jpg"
								alt="Image Feed"></a></li>
						<li><a href="#"><img src="img/gallery/flickr-img-1.jpg"
								alt="Image Feed"></a></li>
						<li><a href="#"><img src="img/gallery/flickr-img-1.jpg"
								alt="Image Feed"></a></li>
						<li><a href="#"><img src="img/gallery/flickr-img-1.jpg"
								alt="Image Feed"></a></li>
						<li><a href="#"><img src="img/gallery/flickr-img-1.jpg"
								alt="Image Feed"></a></li>
					</ul>
				</div>
			</div>

			<div class="row">
				<!-- Begin Sub Footer -->
				<div class="span12 footer-col footer-sub">
					<div class="row no-margin">
						<div class="span6">
							<span class="left">Copyright 2012 Piccolo Theme. All
								rights reserved.</span>
						</div>
						<div class="span6">
							<span class="right"> <a href="#">Home</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;<a
								href="#">Features</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;<a
								href="#">Gallery</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;<a
								href="#">Blog</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;<a
								href="#">Contact</a>
							</span>
						</div>
					</div>
				</div>
			</div>
			<!-- End Sub Footer -->

		</div>
	</div>
	<!-- End Footer -->

	<!-- Scroll to Top -->
	<div id="toTop" class="hidden-phone hidden-tablet">Back to Top</div>

</body>
</html>
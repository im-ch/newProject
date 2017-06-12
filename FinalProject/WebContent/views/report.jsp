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
<link rel="stylesheet"
	href="${ctx }/resources/css/jquery.lightbox-0.5.css">
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
<script src="${ctx }/resources/js/bootstrap.js"></script>
<script src="${ctx }/resources/js/jquery.custom.js"></script>
<script type='text/javascript'>
	function complete() {
		alert("신고가 완료되었습니다.");
	}
</script>
</head>

<body>

	<div class="color-bar-1"></div>
	<div class="color-bar-2 color-bg"></div>

	<div class="container main-container">

		<%@ include file="/views/header.jspf"%>
	<!-- Post Comments
        ================================================== -->
	<section class="comments">
		<h1 class="title-bg">
			<a name="comments"></a>REPORT REVIEW
		</h1>
		<ul>
			<li><img src="${ctx }/resources/img/user-avatar.jpg" alt="Image" />
				<span class="comment-name">${review.userId }</span>&nbsp;&nbsp;&nbsp;
				<span class="comment-date">${review.regDate } </span>
				<div class="comment-content">${review.content }&nbsp;&nbsp;</div></li>
		</ul>
		<!-- Comment Form -->
		<div class="comment-form-container">
			<h3>신고 사유를 작성해주세요. (허위 신고시 제재가 가해질 수 있습니다.)</h3>
			<form action="${ctx }/reportReview/regist" id="report" method="post">
				<input type="hidden" value="${review.comId }" name="comId">
				<input type="hidden" value="${review.reviewId }" name="reviewId">
				<textarea class="span10" name="reportReason"></textarea>
				<div class="row">
					<div class="span1">
						<input type="submit" class="btn btn-inverse" value="REPORT"
							onclick="complete();">
					</div>
					<div class="span3">
						<input type="button" class="btn btn-inverse" value="CANCEL">
					</div>
				</div>
			</form>
		</div>
	</section>
	<!-- Close comments section-->

	</div>
	<!--Close container row-->

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

</body>
</html>

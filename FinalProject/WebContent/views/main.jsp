<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Piccolo Theme</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<!-- CSS
================================================== -->
<link href='http://fonts.googleapis.com/css?family=Oswald'
	rel='stylesheet' type='text/css'>
<link rel="stylesheet" href="${ctx }/resources/css/bootstrap.css">
<link rel="stylesheet"
	href="${ctx }/resources/css/bootstrap-responsive.css">
<link rel="stylesheet" href="${ctx }/resources/css/prettyPhoto.css" />
<link rel="stylesheet" href="${ctx }/resources/css/flexslider.css" />
<link rel="stylesheet" href="${ctx }/resources/css/custom-styles.css">
<link rel="stylesheet" href="${ctx }/resources/inner/css/main.css" />


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
<script src="${ctx }/resources/js/jquery.prettyPhoto.js"></script>
<script src="${ctx }/resources/js/jquery.flexslider.js"></script>
<script src="${ctx }/resources/js/jquery.custom.js"></script>
<script type="text/javascript">
	$(document).ready(function() {

		$("#btn-blog-next").click(function() {
			$('#blogCarousel').carousel('next')
		});
		$("#btn-blog-prev").click(function() {
			$('#blogCarousel').carousel('prev')
		});

		$("#btn-client-next").click(function() {
			$('#clientCarousel').carousel('next')
		});
		$("#btn-client-prev").click(function() {
			$('#clientCarousel').carousel('prev')
		});

	});

	$(window).load(function() {

		$('.flexslider').flexslider({
			animation : "slide",
			slideshow : true,
			start : function(slider) {
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
		
		<%@ include file="/views/header.jspf"%>
		<%@ include file="/views/searchHeader.jspf"%>

		<section class="tiles">
			<article class="style1">
				<span class="image"> <img
					src="${ctx }/resources/images/1.jpg" alt="" />
				</span> <a href="generic.html">
					<h2>Restaurant</h2>
					<div class="content">
						<p>내 주변 제휴식당</p>
					</div>
				</a>
			</article>
			<article class="style2">
				<span class="image"> <img
					src="${ctx }/resources/images/2.jpg" alt="" />
				</span> <a href="generic.html">
					<h2>Cafe</h2>
					<div class="content">
						<p>내 주변 제휴카페</p>
					</div>
				</a>
			</article>
			<article class="style3">
				<span class="image"> <img
					src="${ctx }/resources/images/3.jpg" alt="" />
				</span> <a href="generic.html">
					<h2>Clothing Store</h2>
					<div class="content">
						<p>내 주변 제휴옷가게</p>
					</div>
				</a>
			</article>
			<article class="style4">
				<span class="image"> <img
					src="${ctx }/resources/images/4.jpg" alt="" />
				</span> <a href="generic.html">
					<h2>Cinema</h2>
					<div class="content">
						<p>내 주변 제휴영화관</p>
					</div>
				</a>
			</article>
			<article class="style5">
				<span class="image"> <img
					src="${ctx }/resources/images/5.jpg" alt="" />
				</span> <a href="generic.html">
					<h2>Department store</h2>
					<div class="content">
						<p>내 주변 제휴백화점</p>
					</div>
				</a>
			</article>
			<article class="style6">
				<span class="image"> <img
					src="${ctx }/resources/images/6.jpg" alt="" />
				</span> <a href="generic.html">
					<h2>Pension</h2>
					<div class="content">
						<p>내 주변 제휴펜션</p>
					</div>
				</a>
			</article>
			<article class="style2">
				<span class="image"> <img
					src="${ctx }/resources/images/pic07.jpg" alt="" />
				</span> <a href="generic.html">
					<h2>Ipsum</h2>
					<div class="content">
						<p>Sed nisl arcu euismod sit amet nisi lorem etiam dolor
							veroeros et feugiat.</p>
					</div>
				</a>
			</article>
			<article class="style3">
				<span class="image"> <img
					src="${ctx }/resources/images/pic08.jpg" alt="" />
				</span> <a href="generic.html">
					<h2>Dolor</h2>
					<div class="content">
						<p>Sed nisl arcu euismod sit amet nisi lorem etiam dolor
							veroeros et feugiat.</p>
					</div>
				</a>
			</article>
			<article class="style1">
				<span class="image"> <img
					src="${ctx }/resources/images/pic09.jpg" alt="" />
				</span> <a href="generic.html">
					<h2>Nullam</h2>
					<div class="content">
						<p>Sed nisl arcu euismod sit amet nisi lorem etiam dolor
							veroeros et feugiat.</p>
					</div>
				</a>
			</article>
			<article class="style5">
				<span class="image"> <img
					src="${ctx }/resources/images/pic10.jpg" alt="" />
				</span> <a href="generic.html">
					<h2>Ultricies</h2>
					<div class="content">
						<p>Sed nisl arcu euismod sit amet nisi lorem etiam dolor
							veroeros et feugiat.</p>
					</div>
				</a>
			</article>
			<article class="style6">
				<span class="image"> <img
					src="${ctx }/resources/images/pic11.jpg" alt="" />
				</span> <a href="generic.html">
					<h2>Dictum</h2>
					<div class="content">
						<p>Sed nisl arcu euismod sit amet nisi lorem etiam dolor
							veroeros et feugiat.</p>
					</div>
				</a>
			</article>
			<article class="style4">
				<span class="image"> <img
					src="${ctx }/resources/images/pic12.jpg" alt="" />
				</span> <a href="generic.html">
					<h2>Pretium</h2>
					<div class="content">
						<p>Sed nisl arcu euismod sit amet nisi lorem etiam dolor
							veroeros et feugiat.</p>
					</div>
				</a>
			</article>
		</section>
	</div>

	<script src="${ctx }/resources/inner/js/jquery.min.js"></script>
	<script src="${ctx }/resources/inner/js/skel.min.js"></script>
	<script src="${ctx }/resources/inner/js/util.js"></script>
	<script src="${ctx }/resources/inner/js/main.js"></script>
	
		<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>

	<%@ include file="/views/footer.jspf"%>

	<div id="toTop" class="hidden-phone hidden-tablet">Back to Top</div>
	

</body>
</html>

<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="ctx" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Coupon Detail</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<!-- CSS
================================================== -->
<link href='http://fonts.googleapis.com/css?family=Oswald' rel='stylesheet' type='text/css'>
<link rel="stylesheet" href="${ctx }/resources/css/bootstrap.css">
<link rel="stylesheet" href="${ctx }/resources/css/bootstrap-responsive.css">
<link rel="stylesheet" href="${ctx }/resources/css/jquery.lightbox-0.5.css">
<link rel="stylesheet" href="${ctx }/resources/css/custom-styles.css">

<!-- Favicons
================================================== -->
<link rel="shortcut icon" href="img/favicon.ico">
<link rel="apple-touch-icon" href="${ctx }/resources/img/apple-touch-icon.png">
<link rel="apple-touch-icon" sizes="72x72" href="${ctx }/resources/img/apple-touch-icon-72x72.png">
<link rel="apple-touch-icon" sizes="114x114" href="${ctx }/resources/img/apple-touch-icon-114x114.png">

<!-- JS
================================================== -->
<script src="http://code.jquery.com/jquery-1.8.3.min.js"></script>
<script src="${ctx }/resources/js/bootstrap.js"></script>
<script src="${ctx }/resources/js/jquery.custom.js"></script>

<script type="text/javascript">
	function exit() {
		window.open("about:blank", "_self").close();

	}
</script>

</head>

<body>
	<div class="color-bar-1"></div>
	<div class="color-bar-2 color-bg"></div>

	<div class="container main-container">

		<div class="row">

			<div class="span5 blog">

				<article>
					<h3 class="title-bg">
						<a href="blog-single.htm">&nbsp;&nbsp;&nbsp;${coupon.couponName }</a>
					</h3>
					<div class="post-summary">
						<img src="${ctx }/resources/img/logo3.png" alt="">
						<p>${coupon.couponContent }</p>
						<input class="btn btn-small btn-inverse" type="button"
							onclick="exit();" value="Exit"/>
						<ul class="post-data">
							<li><i class="icon-calendar"></i>${coupon.expiryDate }</li>
							<li><i class="icon-user"></i>${company.comName }</li>
						</ul>
					</div>
				</article>

			</div>

		</div>

	</div>
	<!-- End Container -->

</body>
</html>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="ctx" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>My Coupon</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<!-- CSS
================================================== -->
<link href='http://fonts.googleapis.com/css?family=Oswald'
	rel='stylesheet' type='text/css'>
<link rel="stylesheet" href="${ctx }/resources/css/bootstrap.css">
<link rel="stylesheet"
	href="${ctx }/resources/css/bootstrap-responsive.css">
<link rel="stylesheet" href="${ctx }/resources/css/custom-styles.css">

<link rel="stylesheet" href="${ctx }/resources/css/ihover.css">
<link rel="stylesheet" href="${ctx }/resources/css/style.css">

<!-- JS
================================================== -->
<script src="http://code.jquery.com/jquery-1.8.3.min.js"></script>
<script src="${ctx }/resources/js/bootstrap.js"></script>
<script src="${ctx }/resources/js/jquery.custom.js"></script>

</head>
<body>

	<div class="color-bar-1"></div>
	<div class="color-bar-2 color-bg"></div>

	<div class="container main-container">

		<%@ include file="/views/header.jspf"%>

		<div>
			<div class="container" style="margin: 0 auto;">
				<h1 class="title-bg">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;My Coupon</h1>
				<br>
				<h2>
					<span style="color: red">쿠폰은 모바일에서만 사용가능합니다!</span>
				</h2>
				<br>
			</div>
			<c:forEach items="${coupon }" var="coupon">
				<div class="ih-item circle effect2 left_to_right"
					style="float: left;">
					<a href="#">
						<div class="img">
							<img src="${ctx }/resources/images/coupon.jpg" alt="img">
						</div>
						<div class="info">
							<h3>${coupon.couponName }</h3>
							<p>${coupon.expiryDate }</p>
						</div>
					</a>
					<button class="btn btn-inverse" type="button">Delete</button>
				</div>
			</c:forEach>

		</div>
	</div>

	<%@ include file="/views/footer.jspf"%>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="ctx" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Modify Coupon</title>
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

<link rel="stylesheet" type="text/css"
	href="${ctx }/resources/css/datedropper.css">

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

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script src="${ctx }/resources/js/datedropper.js"></script>

<style>
#departure {
	font-size: 20px;
	height: 40px;
	line-height: 40px
}
</style>

</head>
<body>
	<div class="color-bar-1"></div>
	<div class="color-bar-2 color-bg"></div>

	<div class="container main-container">

	<%@ include file="/views/header.jspf"%>	

		<div class="row">
			<!--Container row-->

			<div class="span8 contact">
				<!--Begin page content column-->

				<h1>Modify Coupon</h1>
				<br>
				<br>
				<div class="alert alert-success">
					쿠폰 사용기간 및 상세 내용을 정확하게 입력하세요 <Strong>*입력 실수로 인한 손해는 Jeff에서
						보상하지 않습니다.</Strong>
				</div>

				<form action="${ctx }/coupon/modify" method="POST">
					<input type="hidden" value="${coupon.couponId }" name="couponId"/>
					<div class="input-prepend">
						<span class="add-on"><i class="icon-list-alt"></i></span> <input
							class="span4" id="prependedInput" size="16" type="text"
							placeholder="Coupon Name" name="couponName"value="${coupon.couponName }">
					</div>

					<h4>사용기한</h4>
					<input type="date" id="departure" name="expiryDate"/>
					<!-- <script>
						$("#departure").dateDropper();
					</script> -->

					<textarea class="span6" placeholder="Coupon Detail" name="couponContent" >${coupon.couponContent }</textarea>
					<div class="row">
						<div class="span2">
							<button class="btn btn-large btn-warning">Modify</button>
						</div>
					</div>
				</form>

			</div>
			<!--End page content column-->


		</div>
		<!-- End container row -->
	</div>

	<%@ include file="/views/footer.jspf"%>

	<div id="toTop" class="hidden-phone hidden-tablet">Back to Top</div>

</body>
</html>
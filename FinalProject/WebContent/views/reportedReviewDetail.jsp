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
			<h3><span style="color:red">신고 사유</span></h3>
				<input type="hidden" value="${review.comId }" name="comId">
				<input type="hidden" value="${review.reviewId }" name="reviewId">
				<textarea class="span10" name="reportReason" readonly="readonly">${reportReview.reportReason }</textarea>
				<div class="row">
					<div class="span1">
						<input type="button" class="btn btn-inverse" value="보류"
							onclick="location.href='${ctx }/reportReview/remove?reviewId=${review.reviewId}'">
					</div>
					<div class="span1">
						<input type="button" class="btn btn-inverse" value="삭제"
							onclick="location.href='${ctx }/reportReview/remove?reviewId=${review.reviewId}'">
					</div>
				</div>
		</div>
	</section>
	<!-- Close comments section-->

	</div>

</body>
</html>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="ctx" value="${pageContext.request.contextPath }" />

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>User Modify</title>
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


</head>

<body>
	<div class="color-bar-1"></div>
	<div class="color-bar-2 color-bg"></div>

	<div class="container main-container">

		<%@ include file="/views/header.jspf"%>

		<!-- Page Content
    ========================================`========== -->

			<h1 class="title-bg">${user.name } Information Update</h1>
			<br>

			<form action="${ctx }/user/modify" method="POST" id="contact-form" style="margin-left: 50px">
				<div class="input-prepend">
					<span class="add-on"><i class="icon-lock"></i></span> <input
						class="span4" id="password" name="password" size="16" type="password"
						placeholder="Password">
				</div>
				<div class="input-prepend">
					<span class="add-on"><i class="icon-lock"></i></span> <input
						class="span4" id="passwordCheck" name="passwordCheck" size="16" type="password"
						placeholder="Password Check">
				</div>
				<div class="alert alert-success" >
            	    변경할 비밀번호를 입력하세요.
          		</div>
				<div class="input-prepend">
					<span class="add-on"><i class="icon-envelope"></i></span> <input
						class="span4" id="email" name="email" size="16" type="email"
						value="${user.email }">
				</div>
				<div class="input-prepend">
					<span class="add-on"><i class="icon-bell"></i></span> <input
						class="span4" id="phoneNumber" name="phoneNumber" size="16" type="number"
						value="${user.phoneNumber }">
				</div>
				
				<div class="row">
					<div class="span2" style="margin-left: 370px">
						<input type="submit" class="btn btn-inverse" value="Update">
					</div>
				</div>
			</form>

	</div>
	<!-- End Container -->

	<%@ include file="/views/footer.jspf"%>

	<!-- Scroll to Top -->
	<div id="toTop" class="hidden-phone hidden-tablet">Back to Top</div>

</body>
</html>

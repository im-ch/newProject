<%@page import="jeff.common.exception.YzRuntimeException"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isErrorPage="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Jeff</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<link href='http://fonts.googleapis.com/css?family=Oswald'
	rel='stylesheet' type='text/css'>
<link rel="stylesheet" href="${ctx }/resources/css/bootstrap.css">
<link rel="stylesheet"
	href="${ctx }/resources/css/bootstrap-responsive.css">
<link rel="stylesheet" href="${ctx }/resources/css/flexslider.css" />
<link rel="stylesheet" href="${ctx }/resources/css/custom-styles.css">

<link rel="shortcut icon" href="${ctx }/resources/img/favicon.ico">
<link rel="apple-touch-icon"
	href="${ctx }/resources/img/apple-touch-icon.png">
<link rel="apple-touch-icon" sizes="72x72"
	href="${ctx }/resources/img/apple-touch-icon-72x72.png">
<link rel="apple-touch-icon" sizes="114x114"
	href="${ctx }/resources/img/apple-touch-icon-114x114.png">

<script src="http://code.jquery.com/jquery-1.8.3.min.js"></script>
<script src="${ctx }/resources/js/bootstrap.js"></script>
<script src="${ctx }/resources/js/jquery.flexslider.js"></script>
<script src="${ctx }/resources/js/jquery.custom.js"></script>
<script type="text/javascript">
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

<body>
	<div class="color-bar-1"></div>
	<div class="color-bar-2 color-bg"></div>

	<div class="container main-container">

		<%@ include file="/views/header.jspf"%>

		<div class="row">
			<div class="span12">
				<h2>Error Page</h2>
				<p class="lead"><%=exception.getMessage()%></p>
			</div>

			<%String redirectURL = null;
				if (exception instanceof YzRuntimeException) {
					YzRuntimeException ex = (YzRuntimeException) exception;

					redirectURL = ex.getRedirectURL();
				}
				if (redirectURL != null && redirectURL.length() > 0) {
			%>
			
			<input class="btn btn-large" type="button"
				onclick="javascript:location.href='<%=redirectURL%>'" value="확인">
			<br>

			<%} else {%>
			<input class="btn btn-large" type="button"
				onclick="javascript:history.back();" value="확인">
			<%}%>
			
			<h6>Large Button</h6>
			<p>
				<button class="btn btn-large" type="button">Default</button>
				<button class="btn btn-large btn-warning" type="button">Info</button>
				<button class="btn btn-large btn-inverse" type="button">Inverse</button>
			</p>
		</div>

	</div>

</body>
</html>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="ctx" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
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
<script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script>
$(document).ready(function(){
	$("#exit").click(function(){
		var radioval = "value";
		$('#value', opener.document).append(radioval);
		window.opener.location = '${ctx}/coupon/findList';
		window.close();
	});
});
</script>

</head>
<body>
	<div class="color-bar-1"></div>
	<div class="color-bar-2 color-bg"></div>

	<div class="container main-container">

   <div class="span5 logo">
      <a href="${ctx }/views/main.jsp"><img src="${ctx }/resources/img/logo3.png"
         alt="" /></a>
      <h5>Affiliate Friends</h5>
   </div>	
<br><br><br>
		<div class="row">
			<!--Container row-->

			<div class="span8 contact">
				<!--Begin page content column-->

				<h1>Complete Payment</h1>
				<br>
				<br>

					<h4>결제가 완료되었습니다.</h4>
					<br>
					<div class="row">
						<div class="span2">
							<button type="button" id="exit" class="btn btn-large btn-warning" style="margin-left: 220px">EXIT</button>
						</div>
					</div>
				</form>

			</div>
			<!--End page content column-->


		</div>
		<!-- End container row -->
	</div>


</body>
</html>
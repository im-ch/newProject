<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath }" />
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
<link rel="stylesheet" href="${ctx }/resources/css/flexslider.css" />
<link rel="stylesheet" href="${ctx }/resources/css/custom-styles.css">
<link rel="stylesheet" href="${ctx }/resources/inner/css/main.css" />


<!-- Favicons
================================================== -->
<link rel="shortcut icon" href="img/favicon.ico">
<link rel="apple-touch-icon" href="img/apple-touch-icon.png">
<link rel="apple-touch-icon" sizes="72x72"
	href="img/apple-touch-icon-72x72.png">
<link rel="apple-touch-icon" sizes="114x114"
	href="img/apple-touch-icon-114x114.png">

<!-- JS
================================================== -->
<script src="http://code.jquery.com/jquery-1.8.3.min.js"></script>
<script src="js/bootstrap.js"></script>
<script src="js/jquery.prettyPhoto.js"></script>
<script src="js/jquery.flexslider.js"></script>
<script src="js/jquery.custom.js"></script>
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

	<div class="container main-container">

		<!-- Begin Header -->

		<%@ include file="header.jspf"%>

		<!-- End Header -->
		<br> <br> <br>



		
		<br>
		<h1>QnA</h1>
		<div style="float: right">
		

			<form name="form">
				<select name="selectBox" style="width: 200px"
					onChange="getSelectValue(this.form);">
					<option value="">카테고리</option>
					<option value="1">Cafe</option>
					<option value="2">Restaurant</option>
					<option value="3">Cinema</option>
					<option value="4">Clothing Store</option>
					<option value="5">Department store</option>
					<option value="6">Pension</option>

				</select>
				<div align="right">
					<input id="category" type="text" name="category"
						placeholder="카테고리를 선택하세요"
						style="width: 65%; display: inline-block;">
					<button type="submit" class="btn btn-primary">검색</button>
				</div>
			</form>
		</div>

	</div>

	<table class="table table-striped table-bordered table-hover">
		<colgroup>
			<col width="100" />
			<col width="200" />
			<col width="100" />
			<col width="200" />
			<col width="200" />
			<col width="*" />
			<col width="100" />
		</colgroup>
		<thead>
			<tr>
				<td style="float: middle" width="400">카테고리</td>
				<td style="float: middle" width="400">제목</td>
				<td style="float: middle" width="400">이름</td>
				<td style="float: middle" width="400">작성시간</td>
			</tr>
		</thead>
		<tbody>
			<c:choose>
				<c:when test="${questions eq null || empty questions }">
					<tr>
						<td colspan="7" align="center">등록된 질문이 없습니다.</td>
					</tr>
				</c:when>
				<c:otherwise>
					<c:forEach items="${questions }" var="question" varStatus="status">
						<fmt:formatDate var="newFormattedDate"
							value="${question.regDate }" pattern="yyyy-MM-dd HH:mm:ss" />
						<tr>
							<td>${question.category }</td>
							<td><a
								href="${ctx }/question/find?questionId=${question.questionId }">${question.title }</a></td>
							<td>${question.writerId}</td>
							<td>${newFormattedDate }</td>
						</tr>
					</c:forEach>
				</c:otherwise>
			</c:choose>
		</tbody>


	</table>


	<div align="right">
		<button type="button"
			onclick="location.href='${ctx}/views/registQuestion.jsp'" class="btn">질문
			등록</button>
	</div>
	<!-- Features -->
	<div id="features-wrapper">
		<div class="container">
			<div class="row">
				<div class="4u 12u(medium)"></div>
			</div>
		</div>
	</div>

	<div class="row">
		<div class="12u">
			<div id="copyright">
				<ul class="menu">
					<li>&copy; JavaRoad All rights reserved</li>
					<li>Design: <a href="http://html5up.net">HTML5 UP</a></li>
				</ul>
			</div>
		</div>
	</div>

	<!-- Scripts -->
	<script src="${ctx }/js/jquery.min.js"></script>
	<script src="${ctx }/js/jquery.dropotron.min.js"></script>
	<script src="${ctx }/js/skel.min.js"></script>
	<script src="${ctx }/js/util.js"></script>
	<script src="${ctx }/js/main.js"></script>

	<script language="javascript">
		function getSelectValue(frm) {
			frm.category.value = frm.selectBox.options[frm.selectBox.selectedIndex].text;

		}
	</script>


	<script src="inner/js/jquery.min.js"></script>
	<script src="inner/js/skel.min.js"></script>
	<script src="inner/js/util.js"></script>
	<script src="inner/js/main.js"></script>
</body>
</html>

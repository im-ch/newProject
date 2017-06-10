<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath }" />
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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

<script src="${ctx }/js/jquery.min.js"></script>
<script src="${ctx }/js/jquery.dropotron.min.js"></script>
<script src="${ctx }/js/skel.min.js"></script>
<script src="${ctx }/js/util.js"></script>
<script src="${ctx }/js/main.js"></script>




<script src="${ctx }/resources/inner/js/jquery.min.js"></script>
<script src="${ctx }/resources/inner/js/skel.min.js"></script>
<script src="${ctx }/resources/inner/js/util.js"></script>
<script src="${ctx }/resources/inner/js/main.js"></script>

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

<body>


	<!-- Color Bars (above header)-->
	<div class="color-bar-1"></div>
	<div class="color-bar-2 color-bg"></div>

	<div class="container main-container">

		<div class="row header">

			<div style="float: right;">
				<header>
					<%@ include file="header.jspf"%>
				</header>
			</div>
			<br> <br>
		</div>
		<div class="span7 navigation">

			<h1>Reported review</h1>
			<div class="chart">
				<table>
					<colgroup>
					<colgroup>

						<col width="200" />
						<col width="100" />
						<col width="150" />
						<col width="150" />
						<col width="150" />
						<col width="300" />
						<col width="200" />

					</colgroup>
					<tr>
						<th>No</th>
						<th>Image</th>
						<th colspan="1">Content</th>
						<th colspan="1"></th>
						<th>UserId</th>
						<th>Date</th>
						<th>Conduct</th>
					</tr>
					<c:choose>
						<c:when test="${reviews eq null || empty reviews }">
							<tr>
								<td colspan="6" align="center">신고된 게시물이 없습니다.</td>
							</tr>
						</c:when>
						<c:otherwise>
							<c:forEach items="${reviews}" var="review" varStatus="sts">
								<fmt:formatDate var="newFormattedDate"
									value="${review.regDate }" pattern="yyyy-MM-dd " />
								<tr>
									<td class="ranking"><span class="1">${sts.count }</span></td>

									<td class="albumimg"><img src="이미지 " alt="sample">
									<td class="subject" align="center" width="2000px">
										<p title="${review.content }">
										<div class="span8">
											<a href="${ctx }/views/find?reviewId=${review.reviewId }">${review.content }</a>
										</div>
										</p>
									</td>
									<td class="subject" align="center"></td>
									<td class="production">
										<p class="pro" title="nickName">${review.userId}</p>
									</td>

									<td class="share">${newFormattedDate }</td>
									<td class="play">
										<div tabindex="0" class="chart_play">

											<a
												href="${ctx }/reportReview/remove?reviewId=${review.reviewId}">[보류]</a>
											<a
												href="${ctx }/reportReview/remove?reviewId=${review.reviewId}">[삭제]</a>
										</div>
									</td>
								</tr>
							</c:forEach>
						</c:otherwise>
					</c:choose>
				</table>
			</div>


		</div>
	</div>

	<%@ include file="/views/footer.jspf"%>
</body>
</html>

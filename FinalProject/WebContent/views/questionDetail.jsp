<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="ctx" value="${pageContext.request.contextPath }" />
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

	<div class="container">

		<div class="row header">
			<!-- Begin Header -->



			<!-- Main Navigation
        ================================================== -->

			<div style="float: right;"><%@ include file="header.jspf"%></div>

			<!-- End Header -->


			<c:choose>
<<<<<<< HEAD
				<c:when test="${loginedUser = null }">
=======
				<c:when test="${loginedUser eq null }">
>>>>>>> f19ae54054c9610a9539ae011508ff1e94bbe72d
					<h3>로그인을 하세요.</h3>
				</c:when>
				<c:otherwise>
					<div id="main-wrapper">
						<div class="container">
							<div id="content">


								<a href="${ctx }/question/findAll">목록으로</a> <br> <br>
								<c:choose>
									<c:when test="${question eq null || empty question }">
										<tr>
											<td colspan="6" align="center">등록된 질문이 없습니다.</td>
										</tr>
									</c:when>
									<c:otherwise>
										<h2>${question.title }</h2>
										<div align="right">
											<a
												href="${ctx }/question/remove?questionId=${question.questionId }"
												class="button">삭제</a>
										</div>
										<textarea id="content" name="content"
											style="width: 80%; height: 150px; resize: none;">${question.content }</textarea>
										<br>
										<fmt:formatDate var="newFormattedDate"
											value="${question.regDate }" pattern="yyyy-MM-dd" />
<<<<<<< HEAD
											카테고리:<input value="${question.category }" readonly>
											작성자:<input value="${question.writerId }" readonly>
											작성날짜:<input value="${newFormattedDate }" readonly>
=======
                                 카테고리:<input
											value="${question.category }" readonly>
                                 작성자:<input
											value="${question.writerId }" readonly>
                                 작성날짜:<input
											value="${newFormattedDate }" readonly>
>>>>>>> f19ae54054c9610a9539ae011508ff1e94bbe72d
									</c:otherwise>
								</c:choose>
								<br> <br> <br>

								<form
									action="${ctx }/question/update?questionId=${question.questionId}"
									method="post">
									<input type="hidden" id="questionId" name="questionId"
										value="${question.questionId }">
									<div>
										<input class="btn btn-success" type="submit" value="수정하기">
									</div>

									<textarea id="content" name="content"
										style="width: 80%; height: 150px; resize: none;">${question.content }</textarea>
								</form>
							</div>
							<br>
<<<<<<< HEAD
						</div>
					</div>
					
	</c:otherwise>
	</c:choose>
					
		</div>
	</div>


	<!--  <div id=answerArea">
						<c:choose>
							<c:when test="${loginedCompany==null }">
							</c:when>
							<c:otherwise> -->

	<!--  <div id="answerArea">

		<c:forEach var="answer" items="${answer.content }">
			<table class="table" style="font-size: 13px; padding: 20px;">
				<tr>
					<td><strong>${answer.writerId }</strong></td>
					<td class="text-right"><a class="glyphicon glyphicon-trash"
						href="javascript:removeComment(${answer.answerId});"></a></td>
				</tr>
				<tr>
					<td colspan="2">
						<p class="txt">${answer.content }</p>
					</td>
				</tr>
			</table>
		</c:forEach>
	</div>
	<div class="panel-footer">
		<div class="write_area">
			<form onsubmit="registComment(); return false;">
				<div>
					<input type="hidden" id="questinId" value="${question.questionId}">
					<textarea class="input_write_comment" id="answer"
						placeholder="댓글쓰기"></textarea>
					<input type="submit" class="comment_submit" value="전송">
				</div>
			</form>
		</div>
	</div>

-->

	 <c:choose>
		<c:when test="${answers eq null || empty answers }">
			<tr>
				<td colspan="6" align="center">등록된 답변이 없습니다.</td>
			</tr>

		</c:when>
		<c:otherwise>

			<c:forEach items="${answer }" var="answer" varStatus="status">


				<p>${answer.content }</p>
				<div align="right">

					작성자:<input value="${answer.answerId }" readonly><br>

					작성시간:<input value="${answer.regDate }" readonly>
				</div>

				<form action="${ctx }/answer/modifyAnswer" method="post">
					<c:if test="${loginedCompany.comId eq answer.writerId }">
						<input type="hidden" id="answerId" name="answerId"
							value="${answer.answerId }">
						<div>
							<a class="button">수정하기</a> <a
								href="${ctx }/answer/removeAnswer?answerId=${answer.answerId }&questionId=${answer.questionId }"
								class="button">답변삭제</a>
							<textarea id="content" name="content"
								style="width: 80%; height: 200px; resize: none;">${answer.content }</textarea>
							<br>
						</div>
=======
						</div>
					</div>

				</c:otherwise>
			</c:choose>

		</div>
	</div>

	<c:choose>
		<c:when test="${answers eq null || empty answers }">
			<tr>
				<td colspan="6" align="center">등록된 답변이 없습니다.</td>
			</tr>

		</c:when>
		<c:otherwise>

			<c:forEach items="${answer }" var="answer" varStatus="status">


				<p>${answer.content }</p>
				<div align="right">

					작성자:<input value="${answer.answerId }" readonly><br>

					작성시간:<input value="${answer.regDate }" readonly>
				</div>

				<form action="${ctx }/answer/modifyAnswer" method="post">
					<c:if test="${loginedCompany.comId eq answer.writerId }">
						<input type="hidden" id="answerId" name="answerId"
							value="${answer.answerId }">
						<div>
							<a class="button">수정하기</a> <a
								href="${ctx }/answer/removeAnswer?answerId=${answer.answerId }&questionId=${answer.questionId }"
								class="button">답변삭제</a>
							<textarea id="content" name="content"
								style="width: 80%; height: 200px; resize: none;">${answer.content }</textarea>
							<br>
						</div>
>>>>>>> f19ae54054c9610a9539ae011508ff1e94bbe72d
						<input type="submit" value="답변수정완료">
					</c:if>
				</form>

				<hr>
			</c:forEach>
		</c:otherwise>
	</c:choose>
	<hr>
	<form action="${ctx }/answer/registAnswer" method="post">
		<textarea style="width: 80%; height: 200px; resize: none;"
			id="content" name="content"></textarea>
		<br> <input type="hidden" id="questionId" name="questionId"
			value="${question.questionId }"> <input type="hidden"
			id="comId" name="comId" value="${company.comId }"> <input
			type="hidden" id="ownerName" name="ownerName"
			value="${company.ownerName }">
		<button type="submit">답변 등록</button>
	</form>
<<<<<<< HEAD
	</c:otherwise>
	</c:choose>
=======
>>>>>>> f19ae54054c9610a9539ae011508ff1e94bbe72d
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
<<<<<<< HEAD


=======
>>>>>>> f19ae54054c9610a9539ae011508ff1e94bbe72d
	<script src="inner/js/jquery.min.js"></script>
	<script src="inner/js/skel.min.js"></script>
	<script src="inner/js/util.js"></script>
	<script src="inner/js/main.js"></script>
<<<<<<< HEAD
	
	
=======


>>>>>>> f19ae54054c9610a9539ae011508ff1e94bbe72d
</body>
</html>
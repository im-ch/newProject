<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="ctx" value="${pageContext.request.contextPath }" />

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>User List</title>
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

		<div class="row" style="margin-left: 40px">
         	   <h1 class="title-bg">Member</h1>
         	   <br>
			<ul class="nav nav-tabs">
				<li class="active"><a href="#comments" data-toggle="tab">ALL</a></li>
				<li><a href="#tweets" data-toggle="tab">USERS</a></li>
				<li><a href="#about" data-toggle="tab">COMPANY</a></li>
			</ul>

			<div class="tab-content">
				<div class="tab-pane active" id="comments">
					<ul>
						<c:choose>
							<c:when test="${allUsers eq null || empty allUsers }">
								<tr>
									<td colspan="6" align="center">가입된 회원이 없습니다.</td>
								</tr>
							</c:when>
							<c:otherwise>
								<c:forEach items="${users }" var="user" varStatus="sts">
										<li><img src="${ctx }/resources/img/icon/user.png" alt="Image" />&nbsp;&nbsp;&nbsp; 
										<span class="user-name"> ${user.userId }</span>&nbsp;&nbsp;&nbsp; 
										<span class="user-date">${user.name }&nbsp;&nbsp;|&nbsp;&nbsp; <a href="${ctx }/user/findUserId?userId=${user.userId}">Info</a>
										</span></li>
										<hr>
								</c:forEach>
								<c:forEach items="${companys }" var="company" varStatus="sts">
										<li><img src="${ctx }/resources/img/icon/company.png" alt="Image" />&nbsp;&nbsp;&nbsp; 
										<span class="user-name"> ${company.comId }</span>&nbsp;&nbsp;&nbsp; 
										<span class="user-date">${company.ownerName }&nbsp;&nbsp;|&nbsp;&nbsp; <a href="${ctx }/company/findByComId?comId=${company.comId}">Info</a>
										&nbsp;&nbsp;|&nbsp;&nbsp; <a href="${ctx }/alliance/detail?comId=${company.comId}">Alliance</a>
										</span></li>
										<hr>
								</c:forEach>
							</c:otherwise>
						</c:choose>
				
					</ul>

				</div>
				<div class="tab-pane" id="tweets">
					<ul>
						<c:choose>
							<c:when test="${users eq null || empty users }">
								<tr>
									<td colspan="6" align="center">가입된 회원이 없습니다.</td>
								</tr>
							</c:when>
							<c:otherwise>
								<c:forEach items="${users }" var="user" varStatus="sts">
										<li><img src="${ctx }/resources/img/icon/user.png" alt="Image" />&nbsp;&nbsp;&nbsp; 
										<span class="user-name"> ${user.userId }</span>&nbsp;&nbsp;&nbsp; 
										<span class="user-date">${user.name }&nbsp;&nbsp;|&nbsp;&nbsp; <a href="${ctx }/user/findUserId?userId=${user.userId}">Info</a>
										</span></li>
										<hr>
								</c:forEach>
							</c:otherwise>
						</c:choose>					
					</ul>
				</div>
				<div class="tab-pane" id="about">
					<ul>
						<c:choose>
							<c:when test="${companys eq null || empty companys }">
								<tr>
									<td colspan="6" align="center">가입된 회원이 없습니다.</td>
								</tr>
							</c:when>
							<c:otherwise>
								<c:forEach items="${companys }" var="company" varStatus="sts">
										<li><img src="${ctx }/resources/img/icon/company.png" alt="Image" />&nbsp;&nbsp;&nbsp; 
										<span class="user-name"> ${company.comId }</span>&nbsp;&nbsp;&nbsp; 
										<span class="user-date">${company.ownerName }&nbsp;&nbsp;|&nbsp;&nbsp; <a href="${ctx }/company/findByComId?comId=${company.comId}">Info</a>
										&nbsp;&nbsp;|&nbsp;&nbsp; <a href="${ctx }/alliance/detail?comId=${company.comId}">Alliance</a>
										</span></li>
										<hr>
								</c:forEach>
							</c:otherwise>
						</c:choose>						
					</ul>
				</div>
			</div>

			<div class="span8 blog"></div>

		</div>

	</div>
	<!-- End Container -->

	<%@ include file="/views/footer.jspf"%>

	<!-- Scroll to Top -->
	<div id="toTop" class="hidden-phone hidden-tablet">Back to Top</div>

</body>
</html>
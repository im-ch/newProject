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
<link rel="stylesheet" href="${ctx }/resources/css/prettyPhoto.css" />
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
<script
	src="${pageContext.request.contextPath}/resources/js/jquery.easing.1.3.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/js/bootstrap.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/js/jquery.prettyPhoto.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/js/jquery.quicksand.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/js/jquery.custom.js"></script>

<script type="text/javascript">
	function toAjax(comId) {
		$.ajax({
			url : "${ctx}/interesting/remove",
			type : "GET",
			data : {
				comId : comId
			},
			success : function(data) {
				alert("삭제되었습니다.");
				window.location.reload();
			},
			error : function(jqXHR, textStatus, errorThrown) {
				alert("잠시 후 다시 시도해 주세요");
			}
		});
	}
</script>

</head>

<body>
	<div class="color-bar-1"></div>
	<div class="color-bar-2 color-bg"></div>

	<div class="container main-container">

		<%@ include file="/views/header.jspf"%>

		<!-- Page Content
    ================================================== -->
		<div class="row">

			<!-- Gallery Items
        ================================================== -->
			<div class="span12 gallery">

				<ul id="filterOptions" class="gallery-cats clearfix">
					<li class="active"><a href="#" class="all">All</a></li>
                	<li><a href="#" class="Restaurant">Restaurant</a></li>
                	<li><a href="#" class="Cafe">Cafe</a></li>
                	<li><a href="#" class="Theater">Theater</a></li>
                	<li><a href="#" class="Clothing">Clothing Store</a></li>
                	<li><a href="#" class="Bar">Bar</a></li>
                	<li><a href="#" class="Play">Play</a></li>
               		<li><a href="#" class="Beauty">Beauty</a></li>
                	<li><a href="#" class="Pension">Pension</a></li>
                	<li><a href="#" class="etc">기타</a></li>
				</ul>

				<div class="row clearfix">
					<c:choose>

						<c:when test="${company eq null}">
							<h1>즐겨찾기 목록이 비어있습니다.</h1>
						</c:when>
						<c:otherwise>
								<ul class="gallery-post-grid holder">
								<c:forEach items="${company }" var="com" varStatus="sts">
									<li class="span4 gallery-item" data-id="id-${sts.count }"
										data-type="${com.category }"><span
										class="gallery-hover-3col hidden-phone hidden-tablet">
											<span class="gallery-icons"> 
											<c:forEach items="${com.imageList }" var="image">
											<a href="/img/${image.fileName }"
												class="item-zoom-link lightbox"
												data-rel="prettyPhoto"></a> 
												</c:forEach>
												<a href="${ctx }/alliance/companyDetail?comId=${com.comId}"
												class="item-details-link"></a>
										</span>
									</span> <a href="${ctx }/alliance/companyDetail?comId=${com.comId}">
									<c:forEach items="${com.imageList }" var="image">
									<img src="/img/${image.fileName }" alt="Gallery">
									</c:forEach>
									</a>
										<span class="project-details"><a
											href="${ctx }/alliance/companyDetail?comId=${com.comId}"
											id="${com.comId }">${com.comId }</a>
										</span> 
											
											<!-- ★★★★★★★★★★★★★★★★delete★★★★★★★★★★★★★★★★ --> 
											<input type="button" id="delete" class="delete"
										onclick="toAjax('${com.comId}');" name="delete" value="delete">
										<!-- ★★★★★★★★★★★★★★★★delete★★★★★★★★★★★★★★★★ -->


									</li>
									</c:forEach>
								</ul>
						</c:otherwise>
					</c:choose>
				</div>

				<!-- Pagination -->
				

			</div>
			<!-- End gallery list-->

		</div>
		<!-- End container row -->

	</div>
	<!-- End Container -->

</body>
</html>

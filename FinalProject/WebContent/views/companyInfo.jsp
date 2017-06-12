<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
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
<script type="text/javascript" src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<!-- <script type="text/javascript">
$(function(){
$('#btn-upload').click(function () {
	console.log('btn-upload'); 
	var form = $('uploadForm')[0];
	var formData = new FormData(form);
	formData.append("fileObj", $("#fileUpload")[0].files[0]);
	$.ajax({ 
		url: "${ctx}/image/regist",
		data: formData,
		processData: false,
		contentType: false,
		type: 'POST', 
		success: function(result){
			alert("업로드 성공!");},
		error: function (jqXHR) { 
			console.log('error');
		}
	});
});
</script> -->


</head>

<body>
<!-- processData: false, 
		contentType: false, -->
	<div class="color-bar-1"></div>
	<div class="color-bar-2 color-bg"></div>

	<div class="container main-container">

		<%@ include file="/views/header.jspf"%>

		<!-- Page Content
    ================================================== -->

		<h1 class="title-bg">CompanyInfo</h1>
		<br>
		<div class="span12 gallery">
			<div class="row clearfix">
				<ul id="test" class="gallery-post-grid holder">
 					<c:choose> 
						<c:when test="${images eq null || empty images }"> 
 							<tr> 
								<td colspan="6" align="center"></td> 
 							</tr> 
 						</c:when> 
						<c:otherwise> 
 							<c:forEach items="${images }" var="img" varStatus="sts"> 
								<li class="span4 gallery-item"><img
									src="/img/${img.fileName }" alt="Gallery">
								<button class="btn btn-large btn-warning" type="button"
				onclick="location.href='${ctx}/image/delete?companyImageId=${img.companyImageId}'">Delete</button>	
									</li> 
 							</c:forEach> 
						</c:otherwise> 
					</c:choose> 

				</ul>
			</div>
		</div>

		<ul class="project-info">
			<li><h3>ID &nbsp; : &nbsp; ${company.comId }</h3></li>
			<li><h3>Name &nbsp; : &nbsp; ${company.ownerName }</h3></li>
			<li><h3>Email &nbsp; : &nbsp; ${company.comEmail }</h3></li>
			<li><h3>PhoneNumber &nbsp; : &nbsp;
					${company.comPhoneNumber }</h3></li>
			<li><h3>Location &nbsp; : &nbsp; ${company.location }</h3></li>
			<li><h3>Category &nbsp; : &nbsp; ${company.category }</h3></li>
		</ul>
		<form id="uploadForm" action="${ctx }/image/regist" method="post" encType="multipart/form-data">
		<input type="file" id="fileUpload" name="imageUpload"/>
		<button type="submit" id="btn-upload">업로드</button>
		</form>
		
		<br> <br>
		<p>
		
			<button class="btn btn-large btn-warning" type="button" style="float:left"
				onclick="location.href='${ctx}/alliance/regist?comId=${company.comId }'">제휴제안서 등록</button>
				
			<button class="btn btn-large btn-default" type="button" style="float:right"
				onclick="location.href='${ctx}/company/delete?comId=${company.comId }'">Withdraw</button>
			<button class="btn btn-large btn-inverse" type="button" style="float:right;"
				onclick="location.href='${ctx}/company/modify?comId=${company.comId }'">Modify</button>
			<br> <br> <br> <br> <br>
		</p>
	</div>
	<!-- End Container -->

</body>
</html>
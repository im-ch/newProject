<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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

		<div class="row header">
			<!-- Begin Header -->

	 <div style = "float:right;"><%@ include file="header.jspf"%></div>


			<!-- Main Navigation
        ================================================== -->
			
   

		<!-- End Header -->
      <br><br>
    
   <div style="float:left">
					
									
							
						
            
     
    <input id="id" name="id" type="hidden" value="">
			<a href="${ctx }/question/findAll">목록으로</a>
			<br>
			<br>
			<h1>New Question</h1>
			
			<form action="${ctx }/question/regist" method="post" >
				  <input type="hidden" id="writerId" name="writerId"
				 value="${loginedUser.userId eq question.writerId}">
				<input type="hidden" id="name" name="name"
				 value="${loginedUser.name}">
				<table border="1">
					<tr>
					<th>제목</th>
					<td><input id="title" name="title"
					class="form-control" type="text" value=""></td>
					</tr>
					<tr>
					<th>내용</th>
					<td><textarea id="content" name="content"
					class="form-control" rows="7"></textarea>
					</tr>
					</div>
					<tr>
					<div style="float:right">
					<select name="selectBox" style="width:200px" onChange="getSelectValue(this.form);">
						<option value="">카테고리 선택</option>
										<option value="1">Cafe</option>
										<option value="2">Restaurant</option>
										<option value="3">Cinema</option>
										<option value="4">Clothing Store</option>
										<option value="5">Department store</option>
										<option value="6">Pension</option>
								
							</select>
							
							카테고리:<input id="category"  type="text" name="category" style="width:65%">
							
							</div>
							</div>
							</tr>
				</table>
					
				<div align="center">
					<input class="btn" type="reset" value="취소">  
					<input class="btn btn-sucess" type="submit" value="등록">
				</div>
							
			</form>
				<br>
							<!-- Features -->
				<div id="features-wrapper">
					<div class="container">
						<div class="row">
							<div class="4u 12u(medium)">

							

							</div>
						</div>
					</div>
				</div>

						<div class="row">
							<div class="12u">
								<div id="copyright">
									<ul class="menu">
										<li>&copy; JavaRoad All rights reserved</li><li>Design: <a href="http://html5up.net">HTML5 UP</a></li>
									</ul>
								</div>
							</div>
						</div>
    
							
	<script src="inner/js/jquery.min.js"></script>
	<script src="inner/js/skel.min.js"></script>
	<script src="inner/js/util.js"></script>
	<script src="inner/js/main.js"></script>
	<script language="javascript">
				
					function getSelectValue(frm)
					{
						frm.category.value = frm.selectBox.options[frm.selectBox.selectedIndex].text;
						
					}
				
			</script>
	
 
</body>
</html>

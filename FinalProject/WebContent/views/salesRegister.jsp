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
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script src="${ctx }/resources/js/bootstrap.js"></script>
<script src="${ctx }/resources/js/jquery.custom.js"></script>

<script src="${ctx }/resources/js/datedropper.js"></script>
<link rel="stylesheet" type="text/css"
	href="${ctx }/resources/css/datedropper.css">
<style>
#departure {
	font-size: 20px;
	height: 40px;
	line-height: 40px
}
</style>
<script type='text/javascript'>
	function check() {
		var regDate = $("input[name=date]").val();
		if(regDate != null  || regDate != ""){
			$.ajax({
				type : "GET" //"POST", "GET"
				,
				url : '${ctx }/sales/checkSales' //Request URL
				,
				dataType : 'text' //전송받을 데이터 타입
				,
				data : {
		            regDate : regDate
		         },
				success : function(data) {
					console.log(data);
					if(data=='no'){
			               alert("해당 날짜에 매출이 등록되어있습니다.");
			               return false;
			        }else if(data == 'yes'){
			        	return true;
			        }
				}
			});
		}
	};
</script>


</head>

<body>
	<div class="color-bar-1"></div>
	<div class="color-bar-2 color-bg"></div>

	<div class="container main-container">

		<%@ include file="/views/header.jspf"%>
		<br> <br> <br>

		<!-- Blog Content
    ================================================== -->
		<div class="row">
			<!--Container row-->

			<!-- Blog Full Post
        ================================================== -->
			<div class="span8 blog" style="margin-left: 60px">
			
				<form action="${ctx }/sales/register" id="comment-form">
					<input type="text" id="departure" name="date"/>

					<script>
						$("#departure").dateDropper();
					</script>
					<h5>날짜를 선택해주세요. (매출 관리 서비스를 이용하시려면 정확한 날짜를 입력해주세요.)</h5>

					<br> <br> <br>
					<!-- Post Comments
        ================================================== -->
					<section class="comments">


						<div class="comment-form-container">

							<div class="input-prepend">
								<span class="add-on"><i class="icon-hand-right"></i></span> <input
									class="span4" name="sales" id="sales" size="16" type="number"
									placeholder="Sales" onclick="check();"/>
									&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;

							</div>

							<h5>매출을 입력해주세요. (매출 관리 서비스를 이용하시려면 정확한 매출을 입력해주세요.)</h5>

						</div>
					</section>
					<button class="btn btn-mini btn-inverse" type="submit" id="regist">SEND</button>
				</form>

			</div>

					
			</div>
			
			<!--Close container row-->

			<!-- Blog Sidebar
        ================================================== -->
			<div class="span4 sidebar">

				<!--Categories-->

			</div>
		</div>
	<!-- End Container -->

</body>
</html>

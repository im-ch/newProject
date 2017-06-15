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
<link rel="stylesheet" href="${ctx }/resources/css/custom-styles.css?ver=2">
<link rel="stylesheet" href="${ctx }/resources/css/Nwagon.css">

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
<link rel='stylesheet' type='text/css'
	href='${ctx }/resources/css/fullcalendar.css' />
<script type='text/javascript' src='${ctx }/resources/js/jquery.js'></script>
<script type='text/javascript'
	src='${ctx }/resources/js/jquery-ui-custom.js'></script>
<script type='text/javascript'
	src='${ctx }/resources/js/fullcalendar.min.js'></script>
<script type='text/javascript' src="${ctx }/resources/js/Nwagon.js"></script>	
<script type='text/javascript' src="${ctx }/resources/js/Nwagon_no_vml.js"></script>
	
</head>

<body>

	<div class="color-bar-1"></div>
	<div class="color-bar-2 color-bg"></div>

	<div class="container main-container">

		<%@ include file="/views/header.jspf"%>

		<!-- Blog Content
    ================================================== -->
		<div class="row">
			<!--Container row-->

			<!-- Blog Full Post
        ================================================== -->
			<div class="span8 blog">
			
				
	<h2>Line Chart with guide line

	</h2>
	<div id="chart71"></div>
	<p style = 'font-size:12px; padding:0 0 40px 40px'>** Mouse over the chart area in order to move the guide line</p>
	<script>
		var options = {
			'legend':{
				names: ['1', '2', '3', '4', '5', '6', '7', '8', '9', '10', '11', '12', '13', '14', '15', '16', '17', '18', '19', '20', '21', '22', '23', '24', '25', '26', '27', '28', '29', '30']
					},
			'dataset':{
				title:'Playing time per day', 
				values: [[56,76], [58,66], [60,62], [58,70], [85, 76], [86,83], [82, 73], [77,66], [87,66], [49,56], [58,76], [85, 76], [56,83], [56, 83], [45, 34], [56,76], [58,66], [60,62], [58,70], [85, 76], [86,83], [82, 73], [77,66], [87,66], [49,56], [58,76], [85, 76], [56,83], [56, 83], [45, 34]],
				colorset: ['#0072b2', '#cc79a7'],
				fields:['Company A', 'Company B']
			},
			'chartDiv' : 'chart71',
			'chartType' : 'line',
			'leftOffsetValue': 40,
			'bottomOffsetValue': 60,
			'chartSize' : {width:1200, height:300},
			'minValue' :0,
			'maxValue' : 100,
			'increment' : 20,
			'isGuideLineNeeded' : true //default set to false
		};

		Nwagon.chart(options);
	</script>
		
		
			
			
			</div>
			<!--Close container row-->

		</div>
	</div>
	<!-- End Container -->

</body>
</html>
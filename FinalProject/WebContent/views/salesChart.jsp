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
<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
<script type='text/javascript'>
google.charts.load('current', {packages: ['corechart', 'bar']});
google.charts.setOnLoadCallback(drawBasic);
function drawBasic() {
	  
	  var jsonData = 
		  $.ajax({
	      url: "${ctx}/sales/day",
	      dataType: "json",
	      async : false
	      }).responseText;
	  var resultData = 
		  $.ajax({
	      url: "${ctx}/sales/week",
	      dataType: "json",
	      async : false
	      }).responseText; 
	  
      var data = new google.visualization.DataTable(jsonData);
      var dataMonth = new google.visualization.DataTable(resultData);
      /*
       data.addColumn('timeofday', 'Time of Day');
      data.addColumn('number', 'Motivation Level');
  	
  	
		data.addRows([
      	
		   [{v: [8, 0, 0], f: '8 am'}, 1000],
		   [{v: [9, 0, 0], f: '9 am'}, 2000],
		   [{v: [10, 0, 0], f: '10 am'}, 5000],
       
  	]); */
      /* var options = {
        title: 'Sales amount of the Day',
        hAxis: {
          title: 'Time of Day',
          format: 'h:mm a',
          viewWindow: {
            min: [7, 50, 0],
            max: [17, 60, 0]
          }
  		
        },
        vAxis: {
          title: '일매출 : 원',
        }
        
      }; */
      var options = {
    	        title: "Daily Sales",
    	        width: 800,
    	        height: 500,
    	        bar: {groupWidth: "95%"},
    	        legend: { position: "none" },
    	      };
      var weekOptions = {
  	        title: "Monthly Sales",
  	        width: 800,
  	        height: 500,
  	      	bar: {groupWidth: "20%"},
  	        legend: { position: "none" },
  	      };
  	/*  var weekOptions = {
  	        title: 'Sales amount of the Week',
  	        hAxis: {
  	          title: 'Time of Week',
  	          format: 'h:mm a',
  	          viewWindow: {
  	            min: [7, 50, 0],
  	            max: [10, 60, 0]
  	          },
  	        bar: {groupWidth: "95%"},
  	  		
  	        },
  	        vAxis: {
  	          title: '월매출 : 원',
  	        }
  	        
  	        
  	      }; */
      var chart = new google.visualization.ColumnChart(
        document.getElementById('chart_div'));
	
      chart.draw(data, options);
      
      var chartMonth = new google.visualization.ColumnChart(
      	document.getElementById('chart_month'));
      chartMonth.draw(dataMonth, weekOptions);
}
</script>
<style type='text/css'>
body {
	
	
	font-size: 14px;
	font-family: "Lucida Grande", Helvetica, Arial, Verdana, sans-serif;
}
#calendar {
	width: 900px;
	margin: 0 auto;
}
</style>
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
				<section class="comments">
					<div id="chart_div" style="width:400;;height:300"></div>
					<div id="chart_month"></div>
					<div id='calendar'></div>

				</section>
			</div>
			<!--Close container row-->

		</div>
	</div>
	<!-- End Container -->

</body>
</html>
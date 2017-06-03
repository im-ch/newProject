<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="ctx" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- BOOTSTRAP STYLES-->
<link href="${ctx}/resource/css/bootstrap.css" rel="stylesheet" />
<!-- FONTAWESOME STYLES-->
<link href="${ctx}/resource/css/font-awesome.css" rel="stylesheet" />
<!-- MORRIS CHART STYLES-->
<link href="${ctx}/resource/js/morris/morris-0.4.3.min.css"
	rel="stylesheet" />
<!-- CUSTOM STYLES-->
<link href="${ctx}/resource/css/custom.css" rel="stylesheet" />
<!-- GOOGLE FONTS-->
<link href='http://fonts.googleapis.com/css?family=Open+Sans'
	rel='stylesheet' type='text/css' />
<!-- fullCalendar 2.2.5-->
<link rel="stylesheet" href="${ctx}/resource/css/fullcalendar.min.css">
<link rel="stylesheet" href="${ctx}/resource/css/fullcalendar.print.css"
	media="print">
<!-- Theme style -->
<link rel="stylesheet" href="${ctx}/resource/css/AdminLTE.min.css">
<!-- AdminLTE Skins. Choose a skin from the css/skins
       folder instead of downloading all of them to reduce the load. -->
<link rel="stylesheet" href="${ctx}/resource/css/_all-skins.min.css">


<script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<!-- jQuery 2.2.3 -->
<script src="${ctx}/resource/js/jquery-3.1.1.min.js"></script>
<!-- Bootstrap 3.3.6 -->
<script src="${ctx}/resource/js/bootstrap.min.js"></script>
<!-- jQuery UI 1.11.4 -->
<script src="https://code.jquery.com/ui/1.11.4/jquery-ui.min.js"></script>
<!-- Slimscroll -->
<script src="${ctx}/resource/js/jquery.slimscroll.min.js"></script>
<!-- FastClick -->
<script src="${ctx}/resource/js/fastclick.js"></script>
<!-- AdminLTE App -->
<script src="${ctx}/resource/js/app.min.js"></script>
<!-- AdminLTE for demo purposes -->
<script src="${ctx}/resource/js/demo.js"></script>
<!-- fullCalendar 2.2.5 -->
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.11.2/moment.min.js"></script>
<script src="${ctx}/resource/js/fullcalendar/fullcalendar.min.js"></script>



<script type="text/javascript">
	$(document).ready(function() {
		$("#color").css('color', 'red');
		$('#color').change(function() {
			var current = $('#color').val();
			$('#color').css('color', current);
		});
		$(function() {
			$(".datepicker").datepicker({
				dateFormat : "yy-mm-dd"
			});
		});
	});
</script>

<title>My Schedule</title>
</head>

<body>
	<%@ include file="/views/header.jspf"%>
	<input type="hidden" id="contents" value="${contents}" />
	<div id="page-wrapper">
		<div id="page-inner">
			<!-- Content Wrapper. Contains page content -->
			<!-- Content Header (Page header) -->
			<section class="content-header">
				<h1>
					${title}<small>Scheduler</small><input class="btn btn-primary"
						style="float: right" type="button"
						onclick="location.href='${ctx}/scheduleSearch.do'" value="조회">
				</h1>
			</section>

			<section class="content">
				<div class="row">
					<div class="box box-primary">
						<div class="box-body no-padding">
							<div id="calendar"></div>
						</div>
					</div>
				</div>
				<form action="${ctx}/Scheduler.do" method="post" class="form-inline">
					<br>
					<div class="box box-primary">
						<br>
						<div class="form-group">
							<label for="title">Title:</label> <input type="text" id="title"
								name="title" class="form-control input-sm"> <label
								for="color">색상:</label> <select name="color"
								class="form-control input-sm" id="color">
								<option value="#f56954" style="color: #f56954">Red</option>
								<option value="#f39c12" style="color: #f39c12">Yellow</option>
								<option value="#0073b7" style="color: #0073b7">Blue</option>
								<option value="#00a65a" style="color: #00a65a">Green</option>
							</select>
						</div>
						<label for="date">날짜:</label> <input type="text" id="date"
							name="date" class="datepicker"> <br>
						<p>Memo</p>
						<textarea id="memo" name="memo" rows="5" cols="40"></textarea>
						<br>
						<button id="saveBtn" class="btn btn-default">추가</button>
					</div>
				</form>
			</section>
		</div>
	</div>

	<script>
		$(function() {

			/* initialize the external events
			 -----------------------------------------------------------------*/
			function ini_events(ele) {
				ele.each(function() {

					// create an Event Object (http://arshaw.com/fullcalendar/docs/event_data/Event_Object/)
					// it doesn't need to have a start or end
					var eventObject = {
						title : $.trim($(this).text())
					// use the element's text as the event title
					};

					// store the Event Object in the DOM element so we can get to it later
					$(this).data('eventObject', eventObject);

					// make the event draggable using jQuery UI
					$(this).draggable({
						zIndex : 1070,
						revert : true, // will cause the event to go back to its
						revertDuration : 0
					//  original position after the drag
					});

				});
			}

			ini_events($('#external-events div.external-event'));

			/* initialize the calendar
			 -----------------------------------------------------------------*/
			//Date for the calendar events (dummy data)
			var date = new Date();
			var d = date.getDate(), m = date.getMonth(), y = date.getFullYear();
			$('#calendar')
					.fullCalendar(
							{
								header : {
									left : 'prev,next today', //위치  ','는 붙여서 ageda는 붙이지만 박스모양다르게
									center : 'title',
									right : 'month'
								},
								buttonText : {
									month : 'month',
								},
								events : function(start, end, timezone,
										callback) {
									$
											.ajax({
												url : "${ctx}/Scheduler.do",
												type : "get",
												dataType : "xml",
												data : {
													// our hypothetical feed requires UNIX timestamps
													start : start.unix(),
													end : end.unix()
												},
												success : function(xml) {
													var xmlData = $(xml).find(
															"content");
													var events = [];
													var listLength = xmlData.length;
													if (listLength) {
														$(xmlData)
																.each(
																		function() {
																			var date = $(
																					this)
																					.find(
																							"date")
																					.text();
																			window.console
																					&& console
																							.log(date);
																			events
																					.push({
																						id : $(
																								this)
																								.find(
																										"contentId")
																								.text(),
																						title : $(
																								this)
																								.find(
																										"title")
																								.text(),
																						start : date, // will be parsed
																						backgroundColor : $(
																								this)
																								.find(
																										"color")
																								.text(),
																						borderColor : $(
																								this)
																								.find(
																										"color")
																								.text()
																					});
																		});

														callback(events);
													}
												}
											});
								},
								editable : false,
								droppable : false, // this allows things to be dropped onto the calendar !!!
							});
		});
	</script>
</body>
</html>
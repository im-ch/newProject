<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="ctx" value="${pageContext.request.contextPath }" />

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Jeff</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<link href='http://fonts.googleapis.com/css?family=Oswald'
	rel='stylesheet' type='text/css'>
<link rel="stylesheet" href="${ctx }/resources/css/bootstrap.css">
<link rel="stylesheet"
	href="${ctx }/resources/css/bootstrap-responsive.css">
<link rel="stylesheet" href="${ctx }/resources/css/custom-styles.css">

<script src="http://code.jquery.com/jquery-1.8.3.min.js"></script>
<script src="${ctx }/resources/js/bootstrap.js"></script>
<script src="${ctx }/resources/js/jquery.custom.js"></script>
<meta name="viewport" content="initial-scale=1.0">

<style>
/* Always set the map height explicitly to define the size of the div
       * element that contains the map. */
#map {
	height: 100%;
}
/* Optional: Makes the sample page fill the window. */
html, body {
	height: 100%;
	margin: 0;
	padding: 0;
}

#floating-panel {
	position: absolute;
	top: 10px;
	left: 25%;
	z-index: 5;
	background-color: #fff;
	padding: 5px;
	border: 1px solid #999;
	text-align: center;
	font-family: 'Roboto', 'sans-serif';
	line-height: 30px;
	padding-left: 10px;
}
</style>

</head>
<body>
	<div class="color-bar-1"></div>
	<div class="color-bar-2 color-bg"></div>

	<div class="container main-container">

		<%@ include file="/views/header.jspf"%>

		<h1 class="title-bg">Map Coupon</h1>
		<br>

		<div id="floating-panel">
			<input id="address" type="textbox" value="Sydney, NSW"> <input
				id="submit" type="button" value="Geocode">
		</div>

		<div id="map"></div>
		<script>
			function initMap() {
				var map = new google.maps.Map(document.getElementById('map'), {
					zoom : 8,
					center : {
						lat : -34.397,
						lng : 150.644
					}
				});
				var geocoder = new google.maps.Geocoder();

				document.getElementById('submit').addEventListener('click',
						function() {
							geocodeAddress(geocoder, map);
						});
			}

			function geocodeAddress(geocoder, resultsMap) {
				var address = document.getElementById('address').value;
				geocoder
						.geocode(
								{
									'address' : address
								},
								function(results, status) {
									if (status === 'OK') {
										resultsMap
												.setCenter(results[0].geometry.location);
										var marker = new google.maps.Marker(
												{
													map : resultsMap,
													position : results[0].geometry.location
												});
									} else {
										alert('Geocode was not successful for the following reason: '
												+ status);
									}
								});
			}
		</script>
		<script async defer
			src="https://maps.googleapis.com/maps/api/js?key=AIzaSyA5q_u7mfoL-N8R1EphJkTMgJbEwFfcSm4&callback=initMap">
			
		</script>

	</div>

	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>

	<%@ include file="/views/footer.jspf"%>

	<div id="toTop" class="hidden-phone hidden-tablet">Back to Top</div>

</body>
</html>
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

<!-- CSS
================================================== -->
<link href='http://fonts.googleapis.com/css?family=Oswald'
	rel='stylesheet' type='text/css'>
<link rel="stylesheet" href="${ctx }/resources/css/bootstrap.css">
<link rel="stylesheet"
	href="${ctx }/resources/css/bootstrap-responsive.css">
<link rel="stylesheet" href="${ctx }/resources/css/custom-styles.css">

<!-- JS
================================================== -->
<script src="http://code.jquery.com/jquery-1.8.3.min.js"></script>
<script src="${ctx }/resources/js/bootstrap.js"></script>
<script src="${ctx }/resources/js/jquery.custom.js"></script>

<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script>
	function sample6_execDaumPostcode() {
		new daum.Postcode(
				{
					oncomplete : function(data) {
						// 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

						// 각 주소의 노출 규칙에 따라 주소를 조합한다.
						// 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
						var fullAddr = ''; // 최종 주소 변수
						var extraAddr = ''; // 조합형 주소 변수

						// 사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
						if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
							fullAddr = data.roadAddress;

						} else { // 사용자가 지번 주소를 선택했을 경우(J)
							fullAddr = data.jibunAddress;
						}

						// 사용자가 선택한 주소가 도로명 타입일때 조합한다.
						if (data.userSelectedType === 'R') {
							//법정동명이 있을 경우 추가한다.
							if (data.bname !== '') {
								extraAddr += data.bname;
							}
							// 건물명이 있을 경우 추가한다.
							if (data.buildingName !== '') {
								extraAddr += (extraAddr !== '' ? ', '
										+ data.buildingName : data.buildingName);
							}
							// 조합형주소의 유무에 따라 양쪽에 괄호를 추가하여 최종 주소를 만든다.
							fullAddr += (extraAddr !== '' ? ' (' + extraAddr
									+ ')' : '');
						}

						// 우편번호와 주소 정보를 해당 필드에 넣는다.
						document.getElementById('sample6_postcode').value = data.zonecode; //5자리 새우편번호 사용
						document.getElementById('sample6_address').value = fullAddr;

						// 커서를 상세주소 필드로 이동한다.
						document.getElementById('sample6_address2').focus();
					}
				}).open();
	}
	
	$(document).ready(function(){
		
		
		
	});
	
	
</script>

</head>
<body>

	<div class="color-bar-1"></div>
	<div class="color-bar-2 color-bg"></div>

	<div class="container main-container">

		<%@ include file="/views/header.jspf"%>

		<h1 class="title-bg">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Company Join</h1>
		<br> <br>
		<form action="#" id="contact-form" style="margin-right: 100px">
			<div align="left">
				<div class="input-prepend">
					<span class="add-on"><i class="icon-italic"></i></span> <input
						name="comId" id="comId" class="span4" id="prependedInput"
						size="16" type="text" placeholder="ID">
				</div>
				<div class="input-prepend">
					<span class="add-on"><i class="icon-user"></i></span> <input
						name="ownerName" id="ownerName" class="span4" id="prependedInput"
						size="16" type="text" placeholder="OwnerName">
				</div>
				<div class="input-prepend">
					<span class="add-on"><i class="icon-lock"></i></span> <input
						name="comPassword" id="comPassword" class="span4"
						id="prependedInput" size="16" type="password"
						placeholder="Password">
				</div>
				<div class="input-prepend">
					<span class="add-on"><i class="icon-lock"></i></span> <input
						class="span4" id="prependedInput" size="16" type="password"
						placeholder="Password Check">
				</div>
				<div class="input-prepend">
					<span class="add-on"><i class="icon-envelope"></i></span> <input
						name="str_email01" class="chspan2" id="prependedInput" size="8"
						type="email" placeholder="Email"> <span class="add-on">@</span>
					<input type="text" name="str_email02" id="str_email02"
						style="width: 100px;"> <input type="hidden"
						name="comEmail">
				</div>
				<div class="input-prepend">
					<span class="add-on"><i class="icon-bell"></i></span> <input
						id="comPhoneNumber" class="span4" id="prependedInput" size="16"
						type="text" placeholder="Phone Number">
				</div>
				<div class="input-prepend">
					<span class="add-on"><i class="icon-home"></i></span> <input
						name="location1" id="sample6_postcode" width="1px" type="text"
						placeholder="우편번호"> &nbsp;&nbsp; <input type="button"
						class="btn btn-inverse" value="주소검색"
						onclick="sample6_execDaumPostcode()" style="margin-left: 10px">
				</div>
				<div class="input-prepend">
					<input name="location1" class="chspan2" id="sample6_address"
						type="text" placeholder="주소"> <input name="location3"
						class="chspan2" id="sample6_address2" size="20" type="text"
						placeholder="상세주소"> <input type="hidden" name="loacation">
				</div>
				<div class="input-prepend">
					<span class="add-on"><i class="icon-bell"></i></span> <select
						name="category">
						<option value="">SELECT CATEGORY</option>
						<option value="Cafe">Cafe</option>
						<option value="Restaurant">Restaurant</option>
						<option value="Clothing">Clothing</option>
						<option value="Cinema">Cinema</option>
						<option value="Department">Department</option>
						<option value="Ipsum">Ipsum</option>
						<option value="기타">기타</option>
					</select>
				</div>
				<button class="btn btn-large btn-warning" type="submit">Join</button>
			</div>
		</form>

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
	<br>
	<br>
	<br>
	<br>
	<br>
	<!-- End Container -->
	<%@ include file="/views/footer.jspf"%>

	<!-- Scroll to Top -->
	<div id="toTop" class="hidden-phone hidden-tablet">Back to Top</div>

</body>
</html>
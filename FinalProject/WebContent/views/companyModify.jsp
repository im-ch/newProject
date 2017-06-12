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
</script>
<script type="text/javascript"
   src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js" ></script>
<script>
$(document).ready(function() {
   
   $("#sample6_address2").blur(function(){
      $("#result").empty();
      var value1 = $('#sample6_postcode').val();
      var value2 = $('#sample6_address').val();
      var value3 = $('#sample6_address2').val();
      
      var total = "";
      total = "<input name='location' id='location' type='hidden' value='" 
         + value1 + ';' + value2 + ";" + value3 + "'></input>";
         
      $("#result").append(total);
   });
});
</script>

</head>

<body>
	<div class="color-bar-1"></div>
	<div class="color-bar-2 color-bg"></div>

	<div class="container main-container">

		<%@ include file="/views/header.jspf"%>

		<!-- Page Content
    ========================================`========== -->

		<h1 class="title-bg">${company.comName }'s Information Update</h1>
		<br>

		<form action="${ctx }/company/modify" method="POST" id="contact-form" style="margin-left: 50px">
			<div class="input-prepend">
				<span class="add-on"><i class="icon-italic"></i></span> <input
					name="comId" class="span4" id="prependedInput" size="16"
					type="text" value="${company.comId }" readonly="readonly">
			</div>
			<div class="input-prepend">
				<span class="add-on"><i class="icon-user"></i></span> <input
					name="ownerName" class="span4" id="prependedInput" size="16"
					type="text" value="${company.ownerName }" readonly="readonly">
			</div>
			<div class="input-prepend">
				<span class="add-on"><i class="icon-lock"></i></span> <input
					name="comPassword" class="span4" id="prependedInput" size="16"
					type="password" placeholder="Password">
			</div>
			<div class="input-prepend">
				<span class="add-on"><i class="icon-lock"></i></span> <input
					name="comPasswordCheck" class="span4" id="prependedInput" size="16"
					type="password" placeholder="Password Check">
			</div>
			<div class="alert alert-success">변경할 비밀번호를 입력하세요.</div>
			<div class="input-prepend">
				<span class="add-on"><i class="icon-home"></i></span> <input
					name="location1" id="sample6_postcode" width="1px" type="text"
					value="${lo1 }"> &nbsp;&nbsp; <input type="button"
					class="btn btn-inverse" value="주소검색"
					onclick="sample6_execDaumPostcode()" style="margin-left: 10px">
			</div>
			<div class="input-prepend">
				<input name="location1" class="span4" id="sample6_address"
					type="text" value="${lo2 }" style="margin-left: 30px"> <input
					name="location3" class="span4" id="sample6_address2" size="20"
					type="text" value="${lo3 }">
			</div>
			<div class="input-prepend">
				<span class="add-on"><i class="icon-envelope"></i></span> <input
                  name="comEmail" class="comEmail" id="prependedInput" size="8"
                  type="email" placeholder="Email" value="${company.comEmail }">
			</div>
			<div class="input-prepend">
				<span class="add-on"><i class="icon-bell"></i></span> <input
					name="comPhoneNumber" class="span4" id="prependedInput" size="16"
					type="number" value="${company.comPhoneNumber }">
			</div>

			<div class="row">
				<div class="span2" style="margin-left: 320px">
					<input type="submit" class="btn btn-inverse" value="Update">
				</div>
			</div>
			<input type="hidden" value="${company.comName }" name="comName">
			<input type="hidden" value="${company.category }" name="category">
		</form>

	</div>
	<!-- End Container -->

</body>
</html>

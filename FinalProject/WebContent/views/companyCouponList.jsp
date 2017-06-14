<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="ctx" value="${pageContext.request.contextPath }" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Jeff</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<!-- CSS
================================================== -->
<link href='http://fonts.googleapis.com/css?family=Oswald' rel='stylesheet' type='text/css'>
<link rel="stylesheet" href="${ctx }/resources/css/bootstrap.css">
<link rel="stylesheet" href="${ctx }/resources/css/bootstrap-responsive.css">
<link rel="stylesheet" href="${ctx }/resources/css/custom-styles.css">

<link rel="stylesheet" href="${ctx }/resources/css/ihover.css">
<link rel="stylesheet" href="${ctx }/resources/css/style.css">

<!-- JS
================================================== -->
<script src="http://code.jquery.com/jquery-1.8.3.min.js"></script>
<script src="${ctx }/resources/js/bootstrap.js"></script>
<script src="${ctx }/resources/js/jquery.custom.js"></script>
<script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	$("#couponAdd").click(function() {
		$("#value").empty();
		window.name = "companyCouponList";
		var popUrl = "${ctx }/views/addCoupon.jsp"; //팝업창에 출력될 페이지 URL
		var popOption = "width=600, height=690, resizable=no, status=no;"; //팝업창 옵션(optoin)
		window.open(popUrl, "", popOption);
	});
});
</script>
</head>
<body>

	<div class="color-bar-1"></div>
    <div class="color-bar-2 color-bg"></div>
    
    <div class="container main-container">
	
	<%@ include file="/views/header.jspf"%>
	
	<div>
    <div class="container" style="margin:0 auto;">
        <h3>${company.comName }'s CouponList</h3>
      </div>
      <c:choose>
      <c:when test="${couponList eq null || empty couponList}">
		<tr>
			<td colspan="6" align="center">등록된 쿠폰이 없습니다.</td>
		</tr>
      </c:when>
      <c:otherwise>
      <c:forEach items="${couponList }" var="coupon" varStatus="sts">
        <div class="ih-item circle effect2 left_to_right" style="float:left;">
        <a href="${ctx }/coupon/modify?couponId=${coupon.couponId}">
        <div class="img"><img src="${ctx }/resources/images/coupon2.jpg" alt="img"></div>
        <!-- 쿠폰이미지 찾아서 넣어야함 -->
        <div class="info">
          <h3>${coupon.couponName }</h3>
          <h4>~${coupon.expiryDate }</h4>
          <button class="btn" type="button">Edit</button>
          
        </div></a><button class="btn btn-inverse" type="button" 
          onclick="location.href='${ctx}/coupon/remove?couponId=${coupon.couponId }'">Delete</button></div>
        </c:forEach>
        </c:otherwise>
        </c:choose>

        <br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
        <p class="lead">쿠폰을 추가하시려면  <input type="button" value="ADD" name="couponAdd" id="couponAdd" formtarget="_new" class="btn btn-large btn-warning">  를 클릭하세요!</p>
<!--         <a href="#" target="_blank" id="couponAdd">[ADD]</a>를 클릭하세요!</p> -->
<!--         <input type="button" value="[ADD]" name="couponAdd" id="couponAdd" formtarget="_new"> -->
    </div>	
      
	</div>
	
	
</body>
</html>
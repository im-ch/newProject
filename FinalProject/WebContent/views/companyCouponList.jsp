<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="ctx" value="${pageContext.request.contextPath }" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Company Coupon</title>
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

</head>
<body>

	<div class="color-bar-1"></div>
    <div class="color-bar-2 color-bg"></div>
    
    <div class="container main-container">

	<%@ include file="/views/header.jspf"%>
	
	<div>
    <div class="container" style="margin:0 auto;">
        <h3>담소사골순대's Coupon</h3>
      </div>
        <div class="ih-item circle effect2 left_to_right" style="float:left;"><a href="#">
        <div class="img"><img src="${ctx }/resources/images/circ_img1.jpg" alt="img"></div>
        <div class="info">
          <h3>소주 1+1</h3>
          <h4>~6/2</h4>
          <button class="btn" type="button">Edit</button>
          <button class="btn btn-inverse" type="button">Delete</button>
        </div></a></div>
        <div class="ih-item circle effect2 left_to_right" style="float:left;"><a href="#">
        <div class="img"><img src="${ctx }/resources/images/circ_img2.jpg" alt="img"></div>
        <div class="info">
          <h3>수육1000원 할인</h3>
          <h4>~6/2</h4>
          <button class="btn" type="button">Edit</button>
          <button class="btn btn-inverse" type="button">Delete</button>
        </div></a></div>
        <div class="ih-item circle effect2 left_to_right" style="float:left;"><a href="#">
        <div class="img"><img src="${ctx }/resources/images/circ_img3.jpg" alt="img"></div>
        <div class="info">
          <h3>사이다 서비스</h3>
          <h4>~6/2</h4>
          <button class="btn" type="button">Edit</button>
          <button class="btn btn-inverse" type="button">Delete</button>
        </div></a></div>
        <div class="ih-item circle effect2 left_to_right" style="float:left;"><a href="#">
        <div class="img"><img src="${ctx }/resources/images/circ_img4.jpg" alt="img"></div>
        <div class="info">
          <h3>밥 한공기 더</h3>
          <h4>~6/2</h4>
          <button class="btn" type="button">Edit</button>
          <button class="btn btn-inverse" type="button">Delete</button>
        </div></a></div>
        <br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
        <p class="lead">쿠폰을 추가하시려면<a href="#" target="_blank">[ADD]</a>를 클릭하세요!</p>
        
    </div>	
      
	</div>
	
	<%@ include file="/views/footer.jspf"%>
    
    <!-- Scroll to Top -->  
    <div id="toTop" class="hidden-phone hidden-tablet">Back to Top</div>
	
</body>
</html>
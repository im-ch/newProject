<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="ctx" value="${pageContext.request.contextPath }" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Welcome Jeff</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<!-- CSS
================================================== -->
<link href='http://fonts.googleapis.com/css?family=Oswald'
   rel='stylesheet' type='text/css'>
<link rel="stylesheet" href="${ctx }/resources/css/bootstrap.css">
<link rel="stylesheet"
   href="${ctx }/resources/css/bootstrap-responsive.css">
<link rel="stylesheet" href="${ctx }/resources/css/custom-styles.css">
<link rel="stylesheet" href="${ctx }/resources/css/main.css" />

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

      <h1 class="title-bg">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Join</h1>
      <div style="margin:auto;">
         <br>
         <div style="float:left; margin-left:100px;">
            <div class="row">
               <div class="span4">
               <ul class="gallery-post-grid holder">
                    <li  class="span3 gallery-item">
                        <img src="${ctx }/resources/images/user.jpg" alt="Gallery" class="img-circle">
                    </li>
                    </ul>
                    <br><br><br><br><br><br><br><br><br>
                  <h5><span style="color:blue"><Strong>개인회원</Strong></span>으로 가입</h5>
                  <p>JEFF와 제휴를 맺은 다양한 업체의 혜택을 받아보세요!</p>
                  <a href="${ctx }/views/userJoin.jsp" class="button special fit">개인회원으로 가입</a>
                  <br><br><br>
               </div>
            </div>
         </div>
         
         <div style="float:right; margin-right:100px;">
            <div class="row">
               <div class="span4">
               <ul class="gallery-post-grid holder">
                    <li  class="span3 gallery-item">
                        <img src="${ctx }/resources/images/company.jpg" alt="Gallery" class="img-circle">
                    </li>
                    </ul>
                    <br><br><br><br><br><br><br><br><br>
                  <h5><span style="color:red"><Strong>기업회원</Strong></span>으로 가입</h5>
                  <p>JEFF와 제휴를 맺어 쿠폰을 발급받고 매출까지 관리하세요!</p>
                  <a href="${ctx }/views/companyJoin.jsp" class="button special fit">기업회원으로 가입</a>
                  <br><br><br>
               </div>
            </div>
         </div>

      </div>
   </div>
   <br><br><br>
   <%@ include file="/views/footer.jspf"%>

   <div id="toTop" class="hidden-phone hidden-tablet">Back to Top</div>

</body>
</html>
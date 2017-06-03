<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="ctx" value="${pageContext.request.contextPath }" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Login</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<!-- CSS
================================================== -->
<link href='http://fonts.googleapis.com/css?family=Oswald' rel='stylesheet' type='text/css'>
<link rel="stylesheet" href="${ctx }/resources/css/bootstrap.css">
<link rel="stylesheet" href="${ctx }/resources/css/bootstrap-responsive.css">
<link rel="stylesheet" href="${ctx }/resources/css/custom-styles.css">

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
   
   <div class="row form-examples">
         <h1 class="title-bg">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Login</h1>
         <br><br><br><br><br>
         <form action="${ctx }/user/login" method="post" id="contact-form">
         <div align="center">
         <div class="input-prepend">
             <span class="add-on"><i class="icon-user"></i></span>
             <input class="span2" name="loginId" id="loginId" size="16" type="text" placeholder="Member id">
         </div>
         <div class="input-prepend">
             <span class="add-on"><i class="icon-lock"></i></span>
             <input class="span2" name="loginPassword" id="loginPassword" size="16" type="password" placeholder="Password">
         </div>
            <button class="btn btn-large" type="submit">Login</button>&nbsp;&nbsp;
            <button class="btn btn-large btn-warning" type="button" onclick="location.href='join.jsp;'">Join</button>
            <br><br><br><br>
         </div>
         </form>
   </div>
   </div>
   
   <%@ include file="/views/footer.jspf"%>

   <div id="toTop" class="hidden-phone hidden-tablet">Back to Top</div>
   
</body>
</html>
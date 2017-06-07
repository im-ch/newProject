<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="ctx" value="${pageContext.request.contextPath }" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>User Join</title>
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

<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> 75fdce9e41d3aad4ce7e48897fa9e0db704c7903
   <%@ include file="/views/header.jspf"%>
      
      <h1 class="title-bg">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;User Join</h1>
      <br><br>
      <form action="${ctx }/user/create" method="post" id="contact-form">
         <div align="center">
<<<<<<< HEAD
=======
	<%@ include file="/views/header.jspf"%>
		
		<h1 class="title-bg">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;User Join</h1>
		<br><br>
		<form action="${ctx }/user/create" method="post" id="contact-form">
			<div align="center">
>>>>>>> eb5fa23617f00ea44ce74c951023ec1af7fb5e90
=======
>>>>>>> 75fdce9e41d3aad4ce7e48897fa9e0db704c7903
                <div class="input-prepend">
                    <span class="add-on"><i class="icon-user"></i></span>
                    <input class="span4" name="name" id="name" size="16" type="text" placeholder="Name">
                </div>
                <div class="input-prepend">
                    <span class="add-on"><i class="icon-italic"></i></span>
                    <input class="span4" name="userId" id="userId" size="16" type="text" placeholder="ID">
                </div>
                <div class="input-prepend">
                    <span class="add-on"><i class="icon-lock"></i></span>
                    <input class="span4" name="password" id="password" size="16" type="password" placeholder="Password">
                </div>
                <div class="input-prepend">
                    <span class="add-on"><i class="icon-lock"></i></span>
                    <input class="span4" name="passwordCheck" id="passwordCheck" size="16" type="password" placeholder="Password Check">
                </div>
                <div class="input-prepend">
                    <span class="add-on"><i class="icon-envelope"></i></span>
                    <input class="span4" name="email" id="email" size="16" type="email" placeholder="Email Address">
                </div>
                <div class="input-prepend">
                    <span class="add-on"><i class="icon-bell"></i></span>
                    <input class="span4" name="phoneNumber" id="phoneNumber" size="16" type="text" placeholder="Phone Number">
                </div>
                <button class="btn btn-large btn-warning" type="submit">Join</button>
              </div>
          </form>
   
   </div>
   
   <%@ include file="/views/footer.jspf"%>

   <div id="toTop" class="hidden-phone hidden-tablet">Back to Top</div>
   
</body>
</html>
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

<!-- JS
================================================== -->
<script src="http://code.jquery.com/jquery-1.8.3.min.js"></script>
<script src="${ctx }/resources/js/bootstrap.js"></script>
<script src="${ctx }/resources/js/jquery.custom.js"></script>
<script type="text/javascript">
/**
 * input태그로 부터  id를 아규먼트로 하여 user컨트롤러에 있는 checkId 메소드에 전달한다.
 * checkId메소드는 해당 id를 db에서 검색해서 리턴하고 (만약 db에 id가 중복된게 없을경우 공백인 "" 반납)
 * 리턴값이 공백이 아니면 회원가입 버튼을 비활성상태로 유지하고 리턴값이 공백이면 회원가입 버튼을 활성화 시킨다.
 */
   function checkId() { 
		   $.ajax({
				url:"${ctx}/user/checkUserId", // id체크 메소드의 url
				type:"POST",
				data:({ 
					userId:$("input[name=userId]").val()   
					/*
					 id체크 메소드의 아규먼트를 세팅하는 과정 , 
					 아규먼트 이름은 userId이고 userId의 값은  userId를 이름으로 갖는 input태그의 값이다
					 */
				}),
				success : function(data){ 
					if (data!=""){ 
						/*
						* data에 idcheck메소드의 반환값을 담아온다. 만약 반환값이 "" 이면 사용 할 수 있는 id 이므로 회원가입 버튼을 활성화 한다.
						* 반환값이 ""가 아닐경우 이미 존재하는 id를 입력한것이기 때문에 회원가입 버튼을 비활성화 한다.
						*/
						document.getElementById('checker').innerHTML="해당 ID는 사용 중 입니다.";
						document.getElementById('joinBtn').disabled=true; 
					}
					else{
						document.getElementById('checker').innerHTML=" "; 
						document.getElementById('joinBtn').disabled=false;
					}			
				},
				error:function(jqXHR, textStatus, errorThrown) {
		            alert("스크립트 fail! ");
		        }
		   })	
   }
</script>
</head>
<body>

   <div class="color-bar-1"></div>
    <div class="color-bar-2 color-bg"></div>
    
    <div class="container main-container">

	<%@ include file="/views/header.jspf"%>
		
		<h1 class="title-bg">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;User Join</h1>
		<br><br>
		<form action="${ctx }/user/create" method="post" id="contact-form">
			<div align="center">
                <div class="input-prepend">
                    <span class="add-on"><i class="icon-user"></i></span>
                    <input class="span4" name="name" id="name" size="16" type="text" placeholder="Name">
                </div>
                <div class="input-prepend">
                    <span class="add-on"><i class="icon-italic"></i></span>
                    <input class="span4" name="userId" id="userId" size="16" type="text" placeholder="ID" onkeyup="checkId();" />
                	<div id="checker" style="font-size: 15px;font-weight: bold;color: red;font-style: strong;margin-right: 200px"> </div>
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
                <button class="btn btn-large btn-warning" type="submit" disabled="disabled" id="joinBtn" >Join</button>
              </div>
          </form>
   
   </div>
   
</body>
</html>
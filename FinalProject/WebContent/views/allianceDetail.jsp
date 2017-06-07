<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<title>Jeff</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<!-- CSS
================================================== -->
<link href='http://fonts.googleapis.com/css?family=Oswald' rel='stylesheet' type='text/css'>
<link rel="stylesheet" href="${ctx}/resources/css/bootstrap.css">
<link rel="stylesheet" href="${ctx}/resources/css/bootstrap-responsive.css">
<link rel="stylesheet" href="${ctx}/resources/css/prettyPhoto.css" />
<link rel="stylesheet" href="${ctx}/resources/css/flexslider.css" />
<link rel="stylesheet" href="${ctx}/resources/css/custom-styles.css">
<link rel="stylesheet" href="${ctx}/resources/inner/css/main.css" />




<!-- Favicons
================================================== -->
<link rel="shortcut icon" href="${ctx}/resources/img/favicon.ico">
<link rel="apple-touch-icon" href="${ctx}/resources/img/apple-touch-icon.png">
<link rel="apple-touch-icon" sizes="72x72" href="${ctx}/resources/img/apple-touch-icon-72x72.png">
<link rel="apple-touch-icon" sizes="114x114" href="${ctx}/resources/img/apple-touch-icon-114x114.png">

<!-- JS
================================================== -->
<script src="http://code.jquery.com/jquery-1.8.3.min.js"></script>
<script src="${ctx}/resources/js/bootstrap.js"></script>
<script src="${ctx}/resources/js/jquery.prettyPhoto.js"></script>
<script src="${ctx}/resources/js/jquery.flexslider.js"></script>
<script src="${ctx}/resources/js/jquery.custom.js"></script> 
<script type="text/javascript">

$(document).ready(function () {

    $("#btn-blog-next").click(function () {
      $('#blogCarousel').carousel('next')
    });
     $("#btn-blog-prev").click(function () {
      $('#blogCarousel').carousel('prev')
    });

     $("#btn-client-next").click(function () {
      $('#clientCarousel').carousel('next')
    });
     $("#btn-client-prev").click(function () {
      $('#clientCarousel').carousel('prev')
    });
    
});

 $(window).load(function(){

    $('.flexslider').flexslider({
        animation: "slide",
        slideshow: true,
        start: function(slider){
          $('body').removeClass('loading');
        }
    });  
});

</script>

</head>

<body class="home">
    <!-- Color Bars (above header)-->
	<div class="color-bar-1"></div>
    <div class="color-bar-2 color-bg"></div>
    
    <div class="container">
    
	<%@ include file="/views/header.jspf"%>
        
      <h3>${alliance.company.comName }'s 제휴제안서</h3>
		<table class="table01" width="100%">
          <tbody>
            <tr>
              <th width="150" >기업명<br>(Company Title)</th>
              
              <td colspan="3" id="SUBJ_CD_NM">
              <input type="text" name="comName" value="${alliance.company.comName }" readonly="readonly"/></td> 
            
            </tr>
            <tr>
              <th>사업자번호<br>(Business Number)</th>
              <td colspan="3" id="FILE_NM">
              <input type="text" name="businessNumber" value="${alliance.businessNumber }" readonly="readonly"/></td>
            </tr>
            <tr>
              <th>기업위치<br>(Location)</th>
              <td colspan="3"    id="LESS_CD_NM">
              <input type="text" name="location" value="${alliance.company.location }" readonly="readonly"/></td>
              
            </tr>
            <tr>
              <th>영업시간<br>(Business Time)</th>
              <td id="SUBJ_LECT"><textarea name="openingHours" cols="40" rows="8" readonly="readonly">${alliance.openingHours }</textarea></td>
               <th>기업설명<br>(Business Detail)</th>
              <td id="GRAD_SMST_NM"><textarea name="detail" cols="40" rows="8" readonly="readonly">${alliance.detail }</textarea></td>
            </tr>
          </tbody>
        </table>
        <c:if test="${comId ne null }">
        <div style="float:right; width:30%; height:500px;">
        <Button type="button" onclick="location.href='${ctx}/alliance/modify?comId=${alliance.company.comId }'">수정</Button>
        <Button type="button" onclick="location.href='${ctx}/alliance/delete?comId=${alliance.company.comId }'">삭제</Button>
        </div>
		</c:if>
			<br>

	</div>

	<%@ include file="/views/footer.jspf"%>

	<div id="toTop" class="hidden-phone hidden-tablet">Back to Top</div>
		
</body>
</html>
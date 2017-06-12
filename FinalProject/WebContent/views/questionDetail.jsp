<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="ctx" value="${pageContext.request.contextPath }" />
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
<link rel="stylesheet" href="${ctx }/resources/css/prettyPhoto.css" />
<link rel="stylesheet" href="${ctx }/resources/css/flexslider.css" />
<link rel="stylesheet" href="${ctx }/resources/css/custom-styles.css">
<link rel="stylesheet" href="${ctx }/resources/inner/css/main.css" />


<!-- Favicons
================================================== -->
<link rel="shortcut icon" href="${ctx }/img/favicon.ico">
<link rel="apple-touch-icon" href="${ctx }/img/apple-touch-icon.png">
<link rel="apple-touch-icon" sizes="72x72"
   href="${ctx }/img/apple-touch-icon-72x72.png">
<link rel="apple-touch-icon" sizes="114x114"
   href="${ctx }/img/apple-touch-icon-114x114.png">

<!-- JS
================================================== -->
<script src="http://code.jquery.com/jquery-1.8.3.min.js"></script>
<script src="${ctx }/js/bootstrap.js"></script>
<script src="${ctx }/js/jquery.prettyPhoto.js"></script>
<script src="${ctx }/js/jquery.flexslider.js"></script>
<script src="${ctx }/js/jquery.custom.js"></script>
<script type="text/javascript">
   $(document).ready(function() {

      $("#btn-blog-next").click(function() {
         $('#blogCarousel').carousel('next')
      });
      $("#btn-blog-prev").click(function() {
         $('#blogCarousel').carousel('prev')
      });

      $("#btn-client-next").click(function() {
         $('#clientCarousel').carousel('next')
      });
      $("#btn-client-prev").click(function() {
         $('#clientCarousel').carousel('prev')
      });

   });

   $(window).load(function() {

      $('.flexslider').flexslider({
         animation : "slide",
         slideshow : true,
         start : function(slider) {
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

      <div class="row header">
         <!-- Begin Header -->



         <!-- Main Navigation
        ================================================== -->

         <div style="float: right;"><%@ include file="header.jspf"%></div>

         <!-- End Header -->


         <c:choose>
            <c:when test="${loginedUser = null }">
               <h3>로그인을 하세요.</h3>
            </c:when>
            <c:otherwise>
               <div id="main-wrapper">
                  <div class="container">
                     <div id="content">


                        <a href="${ctx }/question/findAll">목록으로</a> <br> <br>
                        <c:choose>
                           <c:when test="${question eq null || empty question }">
                              <tr>
                                 <td colspan="6" align="center">등록된 질문이 없습니다.</td>
                              </tr>
                           </c:when>
                           <c:otherwise>
                              <h2>${question.title }</h2>
                              <div align="right">
                                 <a
                                    href="${ctx }/question/remove?questionId=${question.questionId }"
                                    class="button">삭제</a>
                              </div>
                              <textarea id="content" name="content"
                                 style="width: 80%; height: 150px; resize: none;">${question.content }</textarea>
                              <br>
                              <fmt:formatDate var="newFormattedDate"
                                 value="${question.regDate }" pattern="yyyy-MM-dd" />
                                 
                  
                                 
                                 
                                 카테고리:<input
                                 value="${question.category }" readonly>
                           
                              <input type="hidden" id="userId" name="userId"
                                 value="${question.writerId }">
                              <input type="hidden" id="comId" name="comId"
                                 value="${question.writerId }">
                                 
                                 
                                 작성자:<input value="${question.writerId}" readonly>
                                 
                                 
                                 날짜:<input value="${newFormattedDate }"
                                 readonly>
                           </c:otherwise>
                        </c:choose>
                     
                        <br> <br> <br>
                     <c:if test="${anyBody ne null }">
                     <c:if test="${anyBody eq question.writerId}">
                        <form
                           action="${ctx }/question/update?questionId=${question.questionId}"
                           method="post">
                           <input type="hidden" id="questionId" name="questionId"
                              value="${question.questionId }">
                           <div>
                              <input class="btn btn-success" type="submit" value="수정하기">
                           </div>

                           <textarea id="content" name="content"
                              style="width: 80%; height: 150px; resize: none;">${question.content }</textarea>
                           </form>
                     </c:if>
                     </c:if>
                     </div>
                     <br>
                  </div>
               </div>

            </c:otherwise>
         </c:choose>

      </div>
   </div>


   <c:choose>
      <c:when
         test="${question.answerList eq null || empty question.answerList }">
         <tr>
            <td colspan="6" align="center">등록된 답변이 없습니다.</td>
         </tr>

      </c:when>
      <c:otherwise>

         <c:forEach items="${question.answerList }" var="answer"
            varStatus="status">

            <p>${answer.content }</p>
            <div align="right">


               작성자:<input value="${'admin'}" readonly><br>

               작성시간:<input value="${answer.regDate }" readonly>
            </div>


            <c:if test="${userId eq 'admin' }">
               <form action="${ctx }/answer/modifyAnswer" method="post">
                  <input type="hidden" id="answerId" name="answerId"
                     value="${answer.answerId }"> <input type="hidden"
                     id="questionId" name="questionId" value="${answer.questionId }">

                  <input class="btn btn-success" type="submit" value="수정하기">

                  <a
                     href="${ctx }/answer/removeAnswer?answerId=${answer.answerId }&questionId=${answer.questionId }"
                     class="button">답변삭제</a>
                  <textarea id="content" name="content"
                     style="width: 80%; height: 80px; resize: none;">${answer.content }</textarea>
                  <br>
               </form>
            </c:if>
            <hr>
         </c:forEach>
      </c:otherwise>
   </c:choose>
   <hr>


   <c:choose>
      <c:when test="${userId ne null}">
         <c:if test="${userId eq 'admin' }">

            <form action="${ctx }/answer/registAnswer" method="post">
               <textarea style="width: 80%; height: 200px; resize: none;"
                  id="content" name="content"></textarea>
               <br> <input type="hidden" id="questionId" name="questionId"
                  value="${question.questionId }"> <input type="hidden"
                  id="writerId" name="writerId" value="${question.writerId}">
               <button type="submit">답변 등록</button>
            </form>
         </c:if>
      </c:when>

   </c:choose>
   <div class="row">
      <div class="12u">
         <div id="copyright">
            <ul class="menu">
               <li>&copy; JavaRoad All rights reserved</li>
               <li>Design: <a href="http://html5up.net">HTML5 UP</a></li>
            </ul>
         </div>
      </div>
   </div>
   <script src="inner/js/jquery.min.js"></script>
   <script src="inner/js/skel.min.js"></script>
   <script src="inner/js/util.js"></script>
   <script src="inner/js/main.js"></script>


</body>
</html>
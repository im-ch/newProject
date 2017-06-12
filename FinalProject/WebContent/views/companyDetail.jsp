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
<!-- 쿠폰css -->
<link rel="stylesheet" href="${ctx }/resources/css/ihover.css">
<link rel="stylesheet" href="${ctx }/resources/css/style.css">


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
<script type="text/javascript">
   function interesting(comId) {
      $.ajax({
         url : "${ctx}/interesting/register",
         type : "GET",
         data : {
            comId : comId
         },
         success : function(data) {
            if (data == 'true') {
               alert("즐겨찾기에 추가되었습니다.");
            } else if (data == 'false') {
               alert("이미 등록되었습니다.");
            } else if (data == 'login'){
               alert("로그인 후 이용하실 수 있습니다.");
            }
         },
         error : function(jqXHR, textStatus, errorThrown) {
            alert("잠시 후 다시 시도해 주세요");
         }
      });
   }
</script>
<script type="text/javascript">
   function reviewSubmit() {
      var comId = $("#comId").val();
      var content = $("#reviewform").serialize();
      $.ajax({
         url : "${ctx}/review/regist",
         type : "POST",
         contentType: "application/x-www-form-urlencoded; charset=UTF-8", 
         data : {
            comId : comId, content : content
         },
         success : function(data) {
            if(data=='regist'){
               alert("후기가 등록되었습니다.");
                window.location.reload();
            }else if (data == 'null'){
               alert("내용을 입력해주세요.");
            }
         },
         error : function(jqXHR, textStatus, errorThrown) {
            alert("잠시 후 다시 시도해 주세요.");
         }
      });
   }
</script>
<script type="text/javascript">
function modifyForm(reviewId){
           var str;
         var data = $("#content"+reviewId).text();
          var form = $('<form></form>');
             form.attr('action', 'modify(reviewId);');
             form.attr('method', 'post');
             form.appendTo($("#modify1"+reviewId));
             var idx = $("<textarea class='span10' id='mcontent'>"+ data +"</textarea>");
             var btn = $("<input type='button' class='btn btn-inverse' value='수정' onclick='modify("+reviewId+");'>");
             form.append(idx);
             form.append(btn);
      }
</script>


<script type="text/javascript">
   function modify(reviewId) {
      var str = $("#mcontent").val();
      console.log(str);
      var content = str.trim();
      console.log(content);
      $.ajax({
         url : "${ctx}/review/update",
         type : "POST",
         contentType: "application/x-www-form-urlencoded; charset=UTF-8", 
         data : {
            reviewId : reviewId, content : content
         },
         success : function(data) {
            if(data=='update'){
               alert("후기가 수정되었습니다.");
                window.location.reload();
                }
         },
         error : function(jqXHR, textStatus, errorThrown) {
            alert("잠시 후 다시 시도해 주세요");
         }
      });
   }
</script>

<script type="text/javascript">
   function remove(reviewId) {
      
      $.ajax({
         url : "${ctx}/review/remove",
         type : "GET",
         data : {
            reviewId : reviewId
         },
         success : function(data) {
            if(data=='remove'){
               alert("후기가 삭제되었습니다.");
                window.location.reload();
            }
         },
         error : function(jqXHR, textStatus, errorThrown) {
            alert("잠시 후 다시 시도해 주세요");
         }
      });
   }
</script>

<script type="text/javascript">
   function coupon(couponId) {
      $.ajax({
         url : "${ctx}/userCoupon/register",
         type : "GET",
         data : {
            couponId : couponId
         },
         success : function(data) {
            if (data == 'true') {
               alert("쿠폰이 발급되었습니다.");
            } else if (data == 'false') {
               alert("이미 발급된 쿠폰입니다.");
            } else if (data == 'login'){
               alert("로그인 후 이용하실 수 있습니다.")
            }
         },
         error : function(jqXHR, textStatus, errorThrown) {
            alert("잠시 후 다시 시도해 주세요");
         }
      });
   }
</script>
</head>
<body>
   <div class="color-bar-1"></div>
   <div class="color-bar-2 color-bg"></div>

   <div class="container main-container">
      <header>
         <%@ include file="/views/header.jspf"%>
      </header>

      <!-- Page Content
    ================================================== -->
      <div class="row">
         <!--Container row-->
         <div class="row">
            <!-- Title Header -->
            <div class="span8">
               <!--Begin page content column-->
				<input type="hidden" value="${alliance.company.comId}" id="hiddenId">
               <h2>${alliance.company.comName }</h2>
               <p class="lead">${alliance.detail }</p>

               <h5 class="title-bg">Pictures</h5>

               <div class="row">
                  <c:choose>
                     <c:when test="${images eq null || empty images }">
                        <tr>
                           <td colspan="6" align="center">등록된 기업 이미지가 없습니다.</td>
                        </tr>
                     </c:when>
                     <c:otherwise>
                        <c:forEach items="${images }" var="img">
                           <div class="span2">
                              <img src="/img/${img.fileName }" alt="Image" class="thumbnail">
                           </div>
                        </c:forEach>
                     </c:otherwise>
                  </c:choose>

               </div>
            </div>
            <!--End page content column-->

            <!-- Blog Sidebar
        ================================================== -->
            <div class="span4 sidebar page-sidebar">
               <!-- Begin sidebar column -->

               <!--Testimonials-->
               <h5 class="title-bg">Map</h5>
               <div id="map" style="height: 300px"></div>
               &nbsp;
               <div class="alert alert-success">
                  <button type="button" class="close" data-dismiss="alert">×</button>
                  <strong>영업시간 : </strong> ${alliance.openingHours }
               </div>
               <input type="button"
                  onclick="interesting('${alliance.company.comId}');"
                  value="관심기업 추가" class="btn btn-inverse">
            </div>
            <!-- End sidebar column -->
         </div>
         <!-- End container row -->
         <div>
            <div class="container" style="margin: 0 auto;">
               <h3>Coupon</h3>
            </div>
            <c:forEach items="${coupon }" var="coupon">
               <div class="ih-item circle effect2 left_to_right"
                  style="float: left;">
                  <a onclick="coupon(${coupon.couponId});">
                     <div class="img">
                        <img src="${ctx }/resources/images/coupon2.jpg" alt="img">
                     </div>
                     <div class="info">
                        <h3>${coupon.couponName }</h3>
                        <p>${coupon.expiryDate }</p>
                     </div>
                  </a>
               </div>
            </c:forEach>
         </div>
         <br> <br> <br> <br> <br> <br> <br>
         <br> <br> <br> <br> <br> <br> <br>
         <br> <br> <br> <br>
         <div>
            <section class="comments">
               <h4 class="title-bg">
                  <a name="comments"></a>Reviews
               </h4>
               <ul>
                  <c:forEach items="${review }" var="review">
                     <li><img src="${ctx }/resources/img/user-avatar.jpg"
                        alt="Image" /> <span class="comment-name">${review.userId }</span>&nbsp;&nbsp;&nbsp;
                        <span class="comment-date">${review.regDate } | <c:if
                              test="${userId eq review.userId }">
                              <a onclick="modifyForm(${review.reviewId});">수정</a>/<a
                                 onclick="remove(${review.reviewId});">삭제</a>
                           </c:if></span>
                        <div class="comment-content" id="content${review.reviewId}">${review.content }&nbsp;&nbsp;
                        </div> <c:if test="${userId ne review.userId && userId ne null}">
                           <a href="${ctx }/review/find?reviewId=${review.reviewId}">[신고]</a>
                        </c:if></li>
                     <div id="modify1${review.reviewId}"></div>
                  </c:forEach>
               </ul>


               <!-- Comment Form -->
               <div class="comment-form-container">
                  <h6>Leave a Review</h6>
                  <form id="reviewform" method="post">
                     <input type="hidden" value="${alliance.company.comId}" id="comId">
                     <c:choose>
                        <c:when test="${userId ne null}">
                           <textarea class="span10" name="content" id="content1"></textarea>
                           <input type="button" class="btn btn-inverse" value="review"
                              onclick="reviewSubmit();">
                        </c:when>
                        <c:otherwise>
                           <p>로그인 한 회원만 후기를 작성할 수 있습니다.</p>
                        </c:otherwise>
                     </c:choose>
                     <div class="row">
                        <div class="span2">
                           
                        </div>
                     </div>
                  </form>
               </div>
            </section>
            <!-- Close comments section-->
         </div>

      </div>
   </div>

   <script>
         function initMap() {
        	var comId = $("#hiddenId").val();
            var map = new google.maps.Map(document.getElementById('map'), {
               zoom : 13,
               center : {
                  lat : 37.52,
                  lng : 127
               }
            });
            var geocoder = new google.maps.Geocoder();
               
               $.ajax({
                  url : "${ctx}/company/findDetailMap?comId="+comId,
                  type : "get",
                  data : String,
                  contentType: 'application/x-www-form-urlencoded; charset=UTF-8', 
                  dataType : "xml",
                  
                  success : function(xml) {
                     var xmlData = $(xml).find("company");
                     var listLength = xmlData.length;

                     if (listLength) {
                        var contentStr = "";
                        var title = "";
                        var comId = "";
                        $(xmlData).each(function() {
                            contentStr = $(this).find("location").text();
                            title = $(this).find("comName").text();
                            comId = $(this).find("comId").text();
                            
                            geocodeAddress(geocoder, map, contentStr, title, comId);
                         });
                     }
                  }
                  
               });
         }

         function geocodeAddress(geocoder, resultsMap, address, title, comId) {
            var markerMaxWidth = 250;
            var contentString = '<div>' +
              '<h3>'+title+'</h3>' + '<a href="${ctx}/alliance/companyDetail?comId='+comId+'">홈페이지 바로가기</a>';
            
            geocoder.geocode({'address' : address}, function(results, status) {
               if (status === 'OK') {
                  
                  resultsMap.setCenter(results[0].geometry.location);
                  
                  var marker = new google.maps.Marker({
                     map : resultsMap, position : results[0].geometry.location,
                     title : title,
                  });
                  
                  } else {
                  alert('Geocode was not successful for the following reason: '+ status);
                  }
               var infowindow = new google.maps.InfoWindow({
                  content: contentString,
                  maxWidth: markerMaxWidth
               });
               google.maps.event.addListener(marker,'click',function(){
                  infowindow.open(map,marker);
               }); 
            });
         }
      </script>

		<script async defer
			src="https://maps.googleapis.com/maps/api/js?key=AIzaSyA5q_u7mfoL-N8R1EphJkTMgJbEwFfcSm4&callback=initMap">
			
		</script>
   <br>
   <br>
   <br>
   <br>
   <br>
   <br>
   <br>

</body>
</html>
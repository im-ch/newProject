<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="ctx" value="${pageContext.request.contextPath }" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Frequently Asked Questions</title>
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
	      <h1 class="title-bg">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Frequently Asked Questions</h1>
	      <br><br><br>
	      <div class="accordion" id="accordion2">
                <div class="accordion-group">
                    <div class="accordion-heading">
                        <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion2" href="#collapseOne">
                        	쿠폰 사용은 모바일에서만 가능한가요? 
                        </a>
                    </div>
                    <div id="collapseOne" class="accordion-body collapse in">
                        <div class="accordion-inner">
                        	네, 웹에서는 쿠폰을 내 쿠폰함으로 담을 수 있지만, 사용은 할 수 없습니다. pc 또는 모바일에서  쿠폰을 발급 받으면, 모바일에서 사용가능합니다.
                        </div>
                    </div>
                </div>

                <div class="accordion-group">
                    <div class="accordion-heading">
                        <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion2" href="#collapseTwo">
                        	쿠폰 사용 방법이 정확히 어떻게 되나요?
                        </a>
                    </div>
                    <div id="collapseTwo" class="accordion-body collapse">
                        <div class="accordion-inner">
                        	내 쿠폰함에 담긴 쿠폰을 터치하면 쿠폰에 관한 상세 설명과 함께 직원 확인 버튼이 있습니다. 매장에 가셔서 직원분께 보여드리고 직원 확인 버튼을 터치하시면 쿠폰이 적용됩니다. 그리고 혜택 받으시면 끝~
                        </div>
                    </div>
                </div>

                 <div class="accordion-group">
                    <div class="accordion-heading">
                        <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion2" href="#collapseThree">
                        	제휴 제안서를 작성하여 제출하면 제휴 맺어지는 절차가 궁금합니다.
                        </a>
                    </div>
                    <div id="collapseThree" class="accordion-body collapse">
                        <div class="accordion-inner">
                        	JEFF에서는 관리자가 제휴제안서를 따로 확인하여 검토하는 절차는 없습니다. 제휴 제안서를 등록하시면 자동으로 제휴가 맺어지며, 양식에 맞게만 작성하시면 따로 문제가 생기지 않습니다.
                        </div>
                    </div>
                </div>
                
                <div class="accordion-group">
                    <div class="accordion-heading">
                        <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion2" href="#collapseFour">
                        	계약 기간이 따로 있나요?
                        </a>
                    </div>
                    <div id="collapseFour" class="accordion-body collapse">
                        <div class="accordion-inner">
                        	계약 기간은 따로 존재하지 않으며, 쿠폰 기한은 있습니다.
                        </div>
                    </div>
                </div>
                
                <div class="accordion-group">
                    <div class="accordion-heading">
                        <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion2" href="#collapseFive">
                        	기한이 지난 쿠폰은 어떻게 해야하나요?
                        </a>
                    </div>
                    <div id="collapseFive" class="accordion-body collapse">
                        <div class="accordion-inner">
                        	기한이 지나면 기업정보에서 뿐만 아니라  내 쿠폰함에서도 자동으로 삭제되기 때문에 사용불가합니다.
                        </div>
                    </div>
                </div>
                
                <div class="accordion-group">
                    <div class="accordion-heading">
                        <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion2" href="#collapseSix">
                        	제휴 제안서를 작성하여 제출하면 제휴 맺어지는 절차가 궁금합니다.
                        </a>
                    </div>
                    <div id="collapseSix" class="accordion-body collapse">
                        <div class="accordion-inner">
                        	JEFF에서는 관리자가 제휴제안서를 따로 확인하여 검토하는 절차는 없습니다. 제휴 제안서를 등록하시면 자동으로 제휴가 맺어지며, 양식에 맞게만 작성하시면 따로 문제가 생기지 않습니다.
                        </div>
                    </div>
                </div>

            </div>

	</div>
	</div>
	
	<%@ include file="/views/footer.jspf"%>

	<div id="toTop" class="hidden-phone hidden-tablet">Back to Top</div>
	
</body>
</html>
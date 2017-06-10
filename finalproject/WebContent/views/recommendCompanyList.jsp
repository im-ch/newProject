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
<link href='http://fonts.googleapis.com/css?family=Oswald' rel='stylesheet' type='text/css'>
<link rel="stylesheet" href="${ctx }/resources/css/bootstrap.css">
<link rel="stylesheet" href="${ctx }/resources/css/bootstrap-responsive.css">
<link rel="stylesheet" href="${ctx }/resources/css/prettyPhoto.css" />
<link rel="stylesheet" href="${ctx }/resources/css/custom-styles.css">

<!--[if lt IE 9]>
    <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <link rel="stylesheet" href="css/style-ie.css"/>
<![endif]--> 

<!-- Favicons
================================================== -->
<link rel="shortcut icon" href="${ctx }/resources/img/favicon.ico">
<link rel="apple-touch-icon" href="${ctx }/resources/img/apple-touch-icon.png">
<link rel="apple-touch-icon" sizes="72x72" href="${ctx }/resources/img/apple-touch-icon-72x72.png">
<link rel="apple-touch-icon" sizes="114x114" href="${ctx }/resources/img/apple-touch-icon-114x114.png">

<!-- JS
================================================== -->
<script src="http://code.jquery.com/jquery-1.8.3.min.js"></script>
<script src="${ctx }/resources/js/jquery.easing.1.3.js"></script>
<script src="${ctx }/resources/js/bootstrap.js"></script>
<script src="${ctx }/resources/js/jquery.prettyPhoto.js"></script>
<script src="${ctx }/resources/js/jquery.quicksand.js"></script>
<script src="${ctx }/resources/js/jquery.custom.js"></script>


</head>

<body>
	<div class="color-bar-1"></div>
    <div class="color-bar-2 color-bg"></div>
    
    <div class="container main-container">
    
      <%@ include file="/views/header.jspf"%>
      <%@ include file="/views/searchHeader.jspf"%>
     
    <!-- Page Content
    ================================================== --> 
    <div class="row">

        <!-- Gallery Items
        ================================================== --> 
        <div class="span12 gallery">

            <ul id="filterOptions" class="gallery-cats clearfix">
                <li class="active"><a href="#" class="all">All</a></li> 
                <li><a href="#" class="Restaurant">Restaurant</a></li>
                <li><a href="#" class="Cafe">Cafe</a></li>
                <li><a href="#" class="Cinema">Cinema</a></li>
                <li><a href="#" class="Clothing">Clothing Store</a></li>
                <li><a href="#" class="Department">Department store</a></li>
                <li><a href="#" class="기타">기타</a></li>
            </ul>
            
            <div class="row clearfix">
                <ul class="gallery-post-grid holder">
				
				<c:choose>
					<c:when test="${companies eq null || empty companies }">
						<tr>
							<td colspan="6" align="center">등록된 기업이 없습니다.</td>
						</tr>
					</c:when>
					
					<c:otherwise>
						<c:forEach items="${companies }" var="company" varStatus="sts">
		                    <li class="span4 gallery-item" data-id="id-${sts.count }" data-type="${company.category }">
		                        <span class="gallery-hover-3col hidden-phone hidden-tablet">
		                            <span class="gallery-icons">
		                            	<c:forEach items="${company.imageList }" var="image">
		                                <a href="/img/${image.fileName}" class="item-zoom-link lightbox" title="Custom Illustration" data-rel="prettyPhoto"></a>
		                                </c:forEach>
		                                <a href="${ctx }/alliance/companyDetail?comId=${company.comId}" class="item-details-link"></a>
		                            </span>
		                        </span>
		                        <a href="${ctx }/alliance/companyDetail?comId=${company.comId}">
		                        <c:forEach items="${company.imageList }" var="image">
		                        <img src="/img/${image.fileName}" alt="Gallery">
		                        </c:forEach>
		                        </a>
		                        <span class="project-details"><a href="${ctx }/alliance/companyDetail?comId=${company.comId}">${company.comName }</a>${company.ownerName }</span>
		                    </li>
	                    </c:forEach>
                    </c:otherwise>
                   
                </c:choose>

                </ul>
            </div>

        </div><!-- End gallery list-->

    </div><!-- End container row -->
    
    </div> <!-- End Container -->

    <!-- Footer Area
        ================================================== -->
	<%@ include file="/views/footer.jspf"%>

	<div id="toTop" class="hidden-phone hidden-tablet">Back to Top</div>
    
</body>
</html>

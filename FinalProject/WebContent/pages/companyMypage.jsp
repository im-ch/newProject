<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="ctx" value="${pageContext.request.contextPath }" />
<!doctype html>
<html>
<head>
<title></title>
<meta charset="UTF-8">

</head>
<body>
	<p>기업 리스트 뿌려보겠음</p>
	<form method="GET" action="${ctx }/alliance/list.do">
		<p>gogogogo</p>
		<button type="submit">확인</button>
	</form>
</body>
</html>
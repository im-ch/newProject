<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!doctype html>
<html>
<head>
<title></title>
<meta charset="UTF-8">

</head>
<body>

	<table>
		<colgroup>
		<colgroup>

			<col width="200" />
			<col width="100" />
			<col width="150" />
			<col />
			<col width="100" />
			<col width="100" />
			<col width="300" />
			<col width="200" />

		</colgroup>

		<c:choose>
			<c:when test="${allianceList eq null || empty allianceList }">
				<tr>
					<td colspan="6" align="center">등록된 제휴제안서가 없습니다.</td>
				</tr>
			</c:when>
			<c:otherwise>
				<c:forEach items="${allianceList.Alliance }" var="a" varStatus="sts">
					<tr>
						<td class="ranking"><span class="no${post.postId }">${sts.count }</span></td>


						<!-- 공백 -->
						<td class="change"></td>
						<td class="subject" align="center">
							<p title="${a.detail }">
							</p>
						</td>
					</tr>
				</c:forEach>
			</c:otherwise>
		</c:choose>
	</table>

</body>
</html>
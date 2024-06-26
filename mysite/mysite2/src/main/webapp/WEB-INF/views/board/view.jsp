<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<title>mysite</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<link href="${pageContext.servletContext.contextPath }/assets/css/board.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div id="container">
		<c:import url="/WEB-INF/views/includes/header.jsp"/>
		<div id="content">
			<div id="board" class="board-form">
				<table class="tbl-ex">
					<tr>
						<th colspan="2">글보기</th>
					</tr>
					<tr>
						<td class="label">제목</td>
						<td>${vo.title }</td>
					</tr>
					<tr>
						<td class="label">내용</td>
						<td>
							<div class="view-content">${vo.content }</div>
						</td>
					</tr>
				</table>
				<div class="bottom">
					<a href="${pageContext.servletContext.contextPath }/board">글목록</a>
				<c:if test="${not empty authUser }">
    				<a href="${pageContext.servletContext.contextPath }/board?a=replyform&no=${vo.no}">답글쓰기</a>
				</c:if>
				<c:if test="${vo.userNo == authUser.no }">
    				<a href="${pageContext.servletContext.contextPath }/board?a=editform&no=${vo.no}">글수정</a>
				</c:if>
<%-- 				<c:choose>
					<c:when test="${not empty authUser }">
						<a href="${pageContext.servletContext.contextPath }/board?a=replyform&no=${vo.no}">답글쓰기</a>
					</c:when>
					<c:when test='${vo.userNo == authUser.no }'>
						<a href="${pageContext.servletContext.contextPath }/board?a=editform&no=${vo.no}">글수정</a>						
					</c:when>
				</c:choose> --%>
				</div>
			</div>
		</div>
		<c:import url="/WEB-INF/views/includes/navigation.jsp"/>
		<c:import url="/WEB-INF/views/includes/footer.jsp"/>
	</div>
</body>
</html>
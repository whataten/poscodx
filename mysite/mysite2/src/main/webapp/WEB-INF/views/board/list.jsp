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
			<div id="board">
				<form id="search_form" action="" method="post">
					<input type="text" id="kwd" name="kwd" value="">
					<input type="submit" value="찾기">
				</form>
				<table class="tbl-ex">
					<tr>
						<th>번호</th>
						<th>제목</th>
						<th>글쓴이</th>
						<th>조회수</th>
						<th>작성일</th>
						<th>&nbsp;</th>
					</tr>
					<c:forEach items="${boardList }" var="vo">
				    <%-- <c:forEach var="posting" items="${requestScope.list }"> --%>
						<tr>
							<td>${vo.no }</td>
							<td><a href="${pageContext.request.contextPath }/board?a=view&no=${vo.no}&g_no=${vo.groupNo}&depth=${vo.depth}&authorNo=${vo.userNo}&content=${vo.contents}&title=${vo.title}" class="edit">${vo.title }</a></td>
							<%-- <td style='text-align:left; padding-left:${20*vo.depth}20px'><a href="${vo.title }"></a></td> --%>
							<td>${vo.name }</td>
							<td>${vo.hit }</td>
							<td>${vo.regDate }</td>
							<c:choose>
								<c:when test='${vo.userNo == authUser.no }'>
									<td><a href="${pageContext.request.contextPath }/board?a=delete&no=${vo.no }" class="del">삭제</a></td>
								</c:when>
							</c:choose>
						</tr>
				    </c:forEach>
				</table>
				<!-- pager 추가 -->
				<div class="pager">
					<ul>
						<li><a href="">◀</a></li>
						<li><a href="">1</a></li>
						<li class="selected">2</li>
						<li><a href="">3</a></li>
						<li>4</li>
						<li>5</li>
						<li><a href="">▶</a></li>
					</ul>
				</div>			
				<!-- pager 추가 -->
				
				<div class="bottom">
					<c:choose>
						<c:when test='${not empty authUser }'>
							<a href="${pageContext.request.contextPath }/board?a=writeform&authorNo=${authUser.no}" id="new-book">글쓰기</a>
						</c:when>
					</c:choose>
				</div>
			</div>
		</div>
		<c:import url="/WEB-INF/views/includes/navigation.jsp"/>
		<c:import url="/WEB-INF/views/includes/footer.jsp"/>
	</div>
</body>
</html>
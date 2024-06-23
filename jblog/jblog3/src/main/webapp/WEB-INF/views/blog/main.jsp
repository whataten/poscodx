<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!doctype html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JBlog</title>
<Link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/jblog.css">
</head>
<body>
	<div id="container">
		<div id="header">
			<h1>${vo.title }</h1>
			<c:import url="/WEB-INF/views/includes/menu.jsp" />
		</div>
		<div id="wrapper">
			<div id="content">
				<div class="blog-content">
					<h4>${posts[0].title }</h4>
					<p>
						${posts[0].contents }
					<p>
				</div>
				<ul class="blog-list">
					<c:forEach items="${posts }" var="post" >
						<li><a href="">${post.title }</a> <span>${post.reg_date }</span>	</li>					
					</c:forEach>
				</ul>
			</div>
		</div>

		<div id="extra">
			<div class="blog-logo">
				<img src="${pageContext.request.contextPath}/assets/images/spring-logo.jpg">
			</div>
		</div>

		<div id="navigation">
			<h2>카테고리</h2>
			<ul>
				<c:forEach items="${categories }" var="category" >
					<li><a href="${pageContext.request.contextPath}/${category.id}/${category.no}/4">${category.name }</a></li>
				</c:forEach>
			</ul>
		</div>
		<c:import url="/WEB-INF/views/includes/footer.jsp" />
	</div>
</body>
</html>
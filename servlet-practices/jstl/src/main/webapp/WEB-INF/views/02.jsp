<%@ page import="jstlel.UserVo" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	UserVo vo4 = new UserVo();
	vo4.setNo(4L);
	vo4.setName("dooly4");
	pageContext.setAttribute("vo", vo4);
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h4>scope</h4>
	${vo.no } <br>
	${vo.name } <br>
	
	== request scope ===== <br>
	${requestScope.vo.no } <br>
	${requestScope.vo.name } <br>
	
	== application scope ===== <br>
	${applicationScope.vo.no } <br>
	${applicationScope.vo.name } <br>
	
	== 
</body>
</html>
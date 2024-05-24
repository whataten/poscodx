<%@ page import="guestbook.dao.GuestbookDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	Long no = Long.parseLong(request.getParameter("no"));
	String password = request.getParameter("password");
	
	new GuestbookDao().delete(no, password);
	
	response.sendRedirect("/guestbook");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>
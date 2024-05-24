<%@ page import="java.util.ArrayList"%>
<%@ page import="guestbook.vo.GuestbookVo"%>
<%@ page import="java.util.List"%>
<%@ page import="guestbook.dao.GuestbookDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	request.setCharacterEncoding("utf-8");

	String name = request.getParameter("name");
	String password = request.getParameter("password");
	String contents = request.getParameter("contents");
	String reg_date = request.getParameter("reg_date");
	
	GuestbookVo vo = new GuestbookVo();
	vo.setName(name);
	vo.setPassword(password);
	vo.setContents(contents);
	vo.setRegDate(reg_date);
	
	
	new GuestbookDao().insert(vo);
	
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
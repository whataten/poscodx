<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	String color = request.getParameter("color");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	if ("red".equals(color)) {
%>
	<h1 style='color: #ff0000'>hello world</h1>
<%
	} else if ("blue".equals(color)) {
%>
	<h1 style='color: #0000ff'>hello world</h1>
<%
	} else if ("green".equals(color)) {
%>
	<h1 style='color: #00ff00'>hello world</h1>
<%
	} else {
%>
	<h1 style='color: #000000'>hello world</h1>
<%
	}
%>

</body>
</html>
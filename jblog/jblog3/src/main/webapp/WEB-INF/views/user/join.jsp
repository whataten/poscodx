<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JBlog</title>
<Link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/jblog.css">
<script src="${pageContext.request.contextPath}/assets/js/jquery/jquery-1.9.0.js"></script>
<script>
$(function() {
	$("#btn-checkid").click(function() {
		console.log("clicked");
		var id = $("#id").val();
		if (id == '') {
			return;
		}
		
		$.ajax({
			url: "/jblog3/user/api/checkid?id=" + id,
			type: "get",
			dataType: "json",
			error: function(xhr, status, err) {
				console.error(err);
			},
			success: function(response) {
				if(response.result == "fail") {
					console.error(response.message);
					return;
				}
				
				if(response.data) {
					alert("다른 아이디를 사용해 주세요.");
					$("#id").val("");
					$("#id").focus();
					$("#img-checkid").hide();
					return;
				}
				
				// 사용 가능 아이디
				$("#img-checkid").show();
			}
		})
	})
})
</script>
</head>
<body>
	<div class="center-content">
		<h1 class="logo">JBlog</h1>
		<c:import url="/WEB-INF/views/includes/menu.jsp" />
		<form:form
			modelAttribut="userVo"
			class="join-form" 
			name="joinForm"
			method="post"
			action="${pageContext.request.contextPath}/user/join">
			
			<label class="block-label" for="name">이름</label>
			<input id="name" name="name" type="text" value="">
			
			<label class="block-label" for="blog-id">아이디</label>
			<input id="blog-id" name="id" type="text"> 			
			<input id="btn-checkid" type="button" value="id 중복체크">
			<img id="img-checkid" style="display: none;" src="${pageContext.request.contextPath}/assets/images/check.png">

			<label class="block-label" for="password">패스워드</label>
			<input id="password" name="password" type="password" />

			<fieldset>
				<legend>약관동의</legend>
				<input id="agree-prov" type="checkbox" name="agreeProv" value="y">
				<label class="l-float">서비스 약관에 동의합니다.</label>
			</fieldset>

			<input type="submit" value="가입하기">

		</form:form>
	</div>
</body>
</html>

package com.poscodx.mysite.controller.action.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.poscodx.mysite.controller.ActionServlet.Action;

public class LogoutAction implements Action {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		if(session != null) {
			// 로그아웃 처리
			session.removeAttribute("authUser");
		}
		response.sendRedirect(request.getContextPath());
	}
}

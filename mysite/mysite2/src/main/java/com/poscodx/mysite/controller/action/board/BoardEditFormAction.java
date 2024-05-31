package com.poscodx.mysite.controller.action.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.poscodx.mysite.controller.ActionServlet.Action;

public class BoardEditFormAction implements Action {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String no = request.getParameter("no");
		
		request.setAttribute("no", no);
		request.setAttribute("title", title);
		request.setAttribute("content", content);
		
		request.getRequestDispatcher("/WEB-INF/views/board/modify.jsp").forward(request, response);
	}

}

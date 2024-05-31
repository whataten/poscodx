package com.poscodx.mysite.controller.action.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.poscodx.mysite.controller.ActionServlet.Action;
import com.poscodx.mysite.dao.BoardDao;

public class BoardViewAction implements Action{

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String no = request.getParameter("no");
		String groupNo = request.getParameter("g_no");
		String depth = request.getParameter("depth");
		String authorNo = request.getParameter("authorNo");
		String content = request.getParameter("content");
		String title = request.getParameter("title");
		
		request.setAttribute("boardNo", no);
		request.setAttribute("groupNo", groupNo);
		request.setAttribute("depth", depth);
		request.setAttribute("authorNo", authorNo);
		request.setAttribute("content", content);
		request.setAttribute("title", title);
		
		// 조회수 증가
		new BoardDao().addView(no);
		
		request.getRequestDispatcher("/WEB-INF/views/board/view.jsp").forward(request, response);
	}
}

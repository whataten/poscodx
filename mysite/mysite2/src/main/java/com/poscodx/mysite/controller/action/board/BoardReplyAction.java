package com.poscodx.mysite.controller.action.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.poscodx.mysite.controller.ActionServlet.Action;
import com.poscodx.mysite.dao.BoardDao;
import com.poscodx.mysite.vo.UserVo;

public class BoardReplyAction implements Action {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String no = request.getParameter("no");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		UserVo vo = (UserVo) request.getSession().getAttribute("authUser");

		new BoardDao().reply(title, content, vo.getNo(), no);
		response.sendRedirect(request.getContextPath() + "/board");
		

	}

}

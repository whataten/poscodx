package com.poscodx.mysite.controller.action.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.poscodx.mysite.controller.ActionServlet.Action;
import com.poscodx.mysite.dao.BoardDao;
import com.poscodx.mysite.vo.BoardVo;

public class BoardViewAction implements Action{

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String no = request.getParameter("no");
		
		BoardVo vo = new BoardDao().findByNo(Long.valueOf(no));
		request.setAttribute("vo", vo);
		
		// 조회수 증가
		new BoardDao().addView(no);
		
		request.getRequestDispatcher("/WEB-INF/views/board/view.jsp").forward(request, response);
	}
}

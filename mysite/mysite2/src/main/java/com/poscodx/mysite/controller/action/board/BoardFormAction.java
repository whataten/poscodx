package com.poscodx.mysite.controller.action.board;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.poscodx.mysite.controller.ActionServlet.Action;
import com.poscodx.mysite.dao.BoardDao;
import com.poscodx.mysite.vo.BoardVo;

public class BoardFormAction implements Action {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String page = Optional.ofNullable(request.getParameter("page")).orElse("1");
		request.setAttribute("page", page);
		
		
		List<BoardVo> list = new BoardDao().findByPage(Integer.valueOf(page));
		request.setAttribute("boardList", list);
		
		
		request.getRequestDispatcher("/WEB-INF/views/board/list.jsp").forward(request, response);
		
	}

}

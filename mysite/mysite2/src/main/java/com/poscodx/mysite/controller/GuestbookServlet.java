package com.poscodx.mysite.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.poscodx.mysite.dao.GuestbookDao;
import com.poscodx.mysite.vo.GuestbookVo;

public class GuestbookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String action = request.getParameter("a");
		
		if ("add".equals(action)) {
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
			
			response.sendRedirect(request.getContextPath() + "/guestbook");
		} else if ("deleteform".equals(action)) {
			request.setCharacterEncoding("utf-8");
			var rd = request.getRequestDispatcher("/WEB-INF/views/guestbook/deleteform.jsp");
			rd.forward(request, response);
		} else if ("delete".equals(action)) {
			request.setCharacterEncoding("utf-8");
			Long no = Long.parseLong(request.getParameter("no"));
			String password = request.getParameter("password");
			
			new GuestbookDao().delete(no, password);
			
			response.sendRedirect(request.getContextPath() + "/guestbook");
		} else {
			List<GuestbookVo> list = new GuestbookDao().findAll();
			request.setAttribute("list", list);
			request.getRequestDispatcher("WEB-INF/views/guestbook/list.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

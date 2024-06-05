package com.poscodx.mysite.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.poscodx.mysite.vo.UserVo;

@Controller
@RequestMapping("/board")
public class BoardController {
	@RequestMapping("")
	public String index() {
		Map map = boardService.getContentsList();
		
		model.addAllAttribute(map);
		
		return "board/index";
	}
	
	@RequestMapping("/view/{no}")
	public String view(@PathVariable("no") Long no) {
		
	}
	
	@RequestMapping("/delete/{no}")
	public String delete(HttpSession session, @PathVariable("no") Long no) {
		// access control
		UserVo authUser = (UserVo)session.getAttribute("authUser");
		if(authUser == null) {
			return "redirect:/";
		}
		////////////////////////
	}
}

// package com.poscodx.hellospring.controller;

// import java.io.IOException;

// import javax.servlet.http.HttpServletResponse;

// import org.springframework.stereotype.Controller;
// import org.springframework.ui.Model;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.ResponseBody;
// import org.springframework.web.servlet.ModelAndView;

// @Controller
// public class HelloController {
	
// 	@RequestMapping("/hello")
// 	public String hello() {
// 		return "/WEB-INF/views/hello.jsp";
// 	}
	
// 	@RequestMapping("/hello2")
// 	public String hello2(String name) {
// 		System.out.println(name);
// 		return "/WEB-INF/views/hello.jsp";
// 	}
	
// 	@RequestMapping("/hello3")
// 	public ModelAndView hello3(String name) {
// 		ModelAndView mav = new ModelAndView();
// 		mav.addObject("name", name);
// 		mav.setViewName("/WEB-INF/views/hello3.jsp");
// 		return mav;
// 	}
	
// 	@RequestMapping("/hello4")
// 	public String hello4(String name, Model model) {
// 		model.addAttribute("name", name);
// 		return "/WEB-INF/views/hello3.jsp";
// 	}
	
// 	@ResponseBody
// 	@RequestMapping("/hello5")
// 	public String hello5() {
// 		return "<h1>hello worlddd</h1>";
// 	}
	
// 	@RequestMapping("/hello6")
// 	public String hello6() {
// 		return "redirect:/hello";
// 	}
	
// 	@RequestMapping("/hello7")
// 	public void hello7(HttpServletResponse resp) throws IOException {
// 		resp.getWriter().print("<h1>hello world</h1>");
// 	}
// }

package com.poscodx.jblog.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.poscodx.jblog.service.BlogService;
import com.poscodx.jblog.vo.UserVo;

@Controller("userApiController")
@RequestMapping("/blog/api")
public class BlogController {
	@Autowired
	private BlogService blogService;
	
	@GetMapping("/delete_category")
	public String deleteCategory(@RequestParam(value="no", required=true, defaultValue="") String no) {
		blogService.deleteCategory(no);
		return "blog/admin-category";
	}
	
	@PostMapping("/add_category")
	public String addCategory(@SessionAttribute("authUser") UserVo authUser, 
							@RequestParam("name") String categoryName,
							@RequestParam("desc") String description) {
		var id = authUser.getId();
		blogService.addCategory(id, categoryName, description);
		return "redirect:/" + id;
	}
}

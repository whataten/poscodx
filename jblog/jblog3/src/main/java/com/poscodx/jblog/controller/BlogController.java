package com.poscodx.jblog.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.ServletContext;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.multipart.MultipartFile;

import com.poscodx.jblog.service.BlogService;
import com.poscodx.jblog.service.FileUploadService;
import com.poscodx.jblog.vo.BlogVo;
import com.poscodx.jblog.vo.CategoryVo;
import com.poscodx.jblog.vo.PostVo;
import com.poscodx.jblog.vo.UserVo;

@Controller
@RequestMapping("/{id:(?!assets|admin|blog).*}")
public class BlogController {
	
	@Autowired
	private ApplicationContext applicationContext;
	
	@Autowired
	private BlogService blogService;
	
	@Autowired
	private FileUploadService fileUploadService;
	
	@Autowired
	private ServletContext servletContext;
	
	@RequestMapping({"", "/{pathNo1}", "/{pathNo1}/{pathNo2}" })
	public String index(
		@PathVariable("id") String id,
		@PathVariable("pathNo1") Optional<String> pathNo1,
		@PathVariable("pathNo2") Optional<String> pathNo2,
		Model model) {
		
		var blogVo = blogService.getContents(id);
		String categoryNo = "";
		String postNo = "";
		List<PostVo> posts = null;
		List<CategoryVo> categories = null;
		
		if(pathNo2.isPresent()) {
			categoryNo = pathNo1.get();
			postNo = pathNo2.get();
			
			// validate selected categoryNo
			posts = blogService.getPosts(id, categoryNo);
			if (posts.size() == 0) {
			}
//			var post = blogService.getPost(id, categoryNo, postNo);
			// if not categoryNo then 
		} else if(pathNo1.isPresent()) {
			categoryNo = pathNo1.get();
			categories = blogService.getCategories(id);
			posts = blogService.getPosts(id, "1");
		} else {
			posts = blogService.getPosts(id, "1");
		}
		
		categories = blogService.getCategories(id);
		
//		System.out.println("id = :" + id);
//		System.out.println("pathNo1 = :" + pathNo1);
//		System.out.println("pathNo2 = :" + pathNo2);
//		System.out.println("categoryNo = :" + categoryNo);
//		System.out.println("postNo = :" + postNo);
//		System.out.println("post 1 contents = :" + posts.get(0).getTitle());
		
		// categoryNo == 0일때 기본 categoryNo 세팅
		// postNo == 0일때 기본 postNo 세팅
		
		model.addAttribute("vo", blogVo);
		model.addAttribute("categories", categories);
		model.addAttribute("posts", posts);
		
		return "blog/main";
	}
	
	// @Auth
	@GetMapping("/admin/basic")
	public String adminBasic(@PathVariable("id") String id, Model model) {
		var blogVo = blogService.getContents(id);
		model.addAttribute("vo", blogVo);
		return "blog/admin-basic";
	}
	
	@PostMapping("/admin/basic")
	public String editBlog(@PathVariable("id") String id, @ModelAttribute BlogVo vo, MultipartFile file) {
		
		// pre-processing
		if(vo.getId() == null) {
			vo.setId("");
		}
		
		if(vo.getLogo() == null) {
			vo.setLogo("");
		}
		
		System.out.println(file);
		
		if(file != null) {
			String logo = fileUploadService.restore(file);
			System.out.println(logo);
			vo.setLogo(logo);
		}
		
		blogService.update(vo);
		
		servletContext.setAttribute("blogvo", vo);
		
		BlogVo blogVo = applicationContext.getBean(BlogVo.class);
		
		BeanUtils.copyProperties(vo, blogVo);
		
		return "redirect:/" + id;
	}

	@RequestMapping("/admin/category")
	public String adminCategory(@PathVariable("id") String id, Model model) {
		
		var blogVo = blogService.getContents(id);
		
		var categories = blogService.getCategories(id);
		
		// TODO add amount of posts
		
		model.addAttribute("vo", blogVo);
		model.addAttribute("categories", categories);
		
		return "blog/admin-category";
	}

	@GetMapping("/admin/write")
	public String adminWrite(@PathVariable("id") String id, Model model) {
		
		var blogVo = blogService.getContents(id);
		var categories = blogService.getCategories(id);
		
		model.addAttribute("vo", blogVo);
		model.addAttribute("categories", categories);
		
		return "blog/admin-write";
	}
	
	@PostMapping("/admin/write")
	public String adminWrite(@SessionAttribute("authUser") UserVo authUser,
							 @RequestParam("category") String category,
							 @RequestParam("title") String title,
							 @RequestParam("content") String content) {
		var id = authUser.getId();
		blogService.addPost(id, category, title, content);
		return "blog/main";
	}
}
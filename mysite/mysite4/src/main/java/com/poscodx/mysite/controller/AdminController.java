package com.poscodx.mysite.controller;

import javax.servlet.ServletContext;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.poscodx.mysite.security.Auth;
import com.poscodx.mysite.service.FileUploadService;
import com.poscodx.mysite.service.SiteService;
import com.poscodx.mysite.vo.SiteVo;

@Controller
@Auth(role="ADMIN")
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	private ApplicationContext applicationContext;

	@Autowired
	private ServletContext servletContext;
	
	@Autowired
	private SiteService siteService;

	@Autowired
	private FileUploadService fileUploadService;
	
	@RequestMapping("")
	public String main(Model model) {
		SiteVo vo = siteService.getSite();
		model.addAttribute("siteVo", vo);
		return "admin/main";
	}

	@RequestMapping("/main/update")
	public String update(SiteVo vo, MultipartFile file) {
		String profile = fileUploadService.restore(file);
		if(profile != null) {
			vo.setProfile(profile);
		}
		
		siteService.updateSite(vo);
		
		servletContext.setAttribute("sitevo", vo);
		
		SiteVo site = applicationContext.getBean(SiteVo.class);
		// site.setTitle(vo.getTitle());
		// site.setWelcome(vo.getWelcome());
		// site.setProfile(vo.getProfile());
		// site.setDescription(vo.getDescription());
		BeanUtils.copyProperties(vo, site);
		
		return "redirect:/admin";
	}

	@RequestMapping("/guestbook")
	public String guestbook() {
		return "admin/guestbook";
	}
	
	@RequestMapping("/board")
	public String board() {
		return "admin/board";
	}
	
	@RequestMapping("/user")
	public String user() {
		return "admin/user";
	}
}

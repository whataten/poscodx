package com.poscodx.jblog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poscodx.jblog.repository.BlogRepository;
import com.poscodx.jblog.vo.BlogVo;
import com.poscodx.jblog.vo.CategoryVo;
import com.poscodx.jblog.vo.PostVo;

@Service
public class BlogService {
	
	@Autowired
	private BlogRepository blogRepository;

	public List<PostVo> getPosts(String id, String categoryNo) {
		return blogRepository.getPosts(id, categoryNo);
	}

	public PostVo getPost(String id, String categoryNo, String postNo) {
		return blogRepository.getPost(id, categoryNo, postNo);
	}

	public List<CategoryVo> getCategories(String id) {
		return blogRepository.getCategories(id);
	}

	public BlogVo getContents(String id) {
		return blogRepository.getContents(id);
	}

	public void update(BlogVo vo) {
		blogRepository.update(vo);
	}

	public void deleteCategory(String no) {
		blogRepository.deletePostsByCategory(no);
		blogRepository.deleteCategory(no);
	}

	public void addCategory(String id, String categoryName, String description) {
		blogRepository.addCategory(id, categoryName, description);
	}

	public void addPost(String id, String category, String title, String content) {
		blogRepository.addPost(id, category, title, content);
		
	}
}

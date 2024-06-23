package com.poscodx.jblog.repository;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.poscodx.jblog.vo.BlogVo;
import com.poscodx.jblog.vo.CategoryVo;
import com.poscodx.jblog.vo.PostVo;

@Repository
public class BlogRepository {
	private SqlSession sqlSession;
	
	public BlogRepository(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public void insert(String id) {
		sqlSession.insert("blog.insert", id);
	}

	public List<PostVo> getPosts(String id, String categoryNo) {
		return sqlSession.selectList("blog.getPosts", Map.of("id", id, "categoryNo", categoryNo));
	}

	public PostVo getPost(String id, String categoryNo, String postNo) {
		return sqlSession.selectOne("blog.getPost", Map.of("id", id, "categoryNo", categoryNo, "postNo", postNo));
	}

	public List<CategoryVo> getCategories(String id) {
		return sqlSession.selectList("blog.getCategories", id);
	}

	public BlogVo getContents(String id) {
		return sqlSession.selectOne("blog.getContents", id);
	}

	public void update(BlogVo vo) {
		sqlSession.update("blog.update", vo);
	}

	public void deletePostsByCategory(String no) {
		sqlSession.delete("blog.deletePostsByCategory", no);
	}

	public void deleteCategory(String no) {
		sqlSession.delete("blog.deleteCategory", no);
	}

	public void addCategory(String id, String categoryName, String description) {
		sqlSession.insert("blog.addCategory", Map.of("id", id, "categoryName", categoryName, "description", description));
	}

	public void addPost(String id, String category, String title, String content) {
		int no = (int) sqlSession.selectOne("blog.getCategoryNo", category);
		sqlSession.insert("blog.addPost", Map.of("id", id, "category", String.valueOf(no), "title", title, "content", content));
	}
}

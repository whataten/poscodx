package com.poscodx.mysite.service;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.poscodx.mysite.vo.UserVo;

@Service
public class BoardService {
	
	@Transaction
	public void addContents(BoardVo vo) {
		if(vo.getGroupNo() != null) {
			boardRepository.updateOrderNo(...);
		}
		
		boardRepository.insert();
	}
	
	public BoardVo getContents(Long no) {
		BoardVo vo = boardRepository.findByNo(no);
		if(vo != null) {
			boardRepository.updateHit();
		}
		return vo;
	}
	
	public BoardVo getContents(Long boardNo, Long userNo) {
		
	}
	
	public void updateContents(BoardVo vo) {
		// access control
		UserVo authUser = (UserVo)session.getAttribute("authUser");
		if(authUser == null) {
			return "redirect:/";
		}
		////////////////////////
	}
	
	public void deleteContents(Long boardNo, Long userNo) {
		
	}
	
	public Map<String, Object> getContentsList(int currentPage, String keyword) {
		List<BoardVo> list = null;
		Map<String, Object> map = nnull;
		
		map.put("list", list);
		map.put("totalCount", pager);
		map.put("listSize", pager);
		map.put("currentPage", pager);
		map.put("beginPage", pager);
		map.put("endPage", pager);
		map.put("prevPage", pager);
		map.put("nextPage", pager);
		
		return map;
		
	}
	
	
	
}

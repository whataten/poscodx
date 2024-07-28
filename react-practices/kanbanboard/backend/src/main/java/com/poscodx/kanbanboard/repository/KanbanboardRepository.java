package com.poscodx.kanbanboard.repository;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.poscodx.kanbanboard.vo.CardVo;
import com.poscodx.kanbanboard.vo.TaskVo;

@Repository
public class KanbanboardRepository {
	private final SqlSession sqlSession;
	
	public KanbanboardRepository(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	//card read 
	public List<CardVo> findCardAll() {
		return sqlSession.selectList("card.findAll");
	}
	
	//task insert(create)
	public void insertTask(TaskVo vo) {
		sqlSession.insert("task.insert", vo);
	}
	
	//task read 
	public List<TaskVo> findTaskAll(Long cardNo){
		return sqlSession.selectList("task.findAll", cardNo);
	}

	//task update
	public int updateTask(Long no, String done) {
		return sqlSession.update("task.update", Map.of("no", no, "done", done));
	}
	
	//task delete 
	public int deleteTask(Long no) {
		return sqlSession.delete("task.delete", no);
	}

}

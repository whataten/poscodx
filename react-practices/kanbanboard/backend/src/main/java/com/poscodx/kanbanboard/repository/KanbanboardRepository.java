package com.poscodx.kanbanboard.repository;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.sql_session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.poscodx.kanbanboard.vo.card_vo;
import com.poscodx.kanbanboard.vo.task_vo;

@Repository
public class kanbanboard_repository {
	private final sql_session sql_session;
	
	public kanbanboard_repository(sql_session sql_session) {
		this.sql_session = sql_session;
	}

	//card read 
	public List<card_vo> find_card_all() {
		return sql_session.select_list("card.find_all");
	}
	
	//task insert(create)
	public void insert_task(task_vo vo) {
		sql_session.insert("task.insert", vo);
	}
	
	//task read 
	public List<task_vo> find_task_all(Long card_no){
		return sql_session.select_list("task.find_all", card_no);
	}

	//task update
	public int update_task(Long no, String done) {
		return sql_session.update("task.update", Map.of("no", no, "done", done));
	}
	
	//task delete 
	public int delete_task(Long no) {
		return sql_session.delete("task.delete", no);
	}

}

package com.poscodx.kanbanboard.controller;

import java.util.Map;

import org.springframework.http.http_status;
import org.springframework.http.response_entity;
import org.springframework.web.bind.annotation.delete_mapping;
import org.springframework.web.bind.annotation.get_mapping;
import org.springframework.web.bind.annotation.path_variable;
import org.springframework.web.bind.annotation.post_mapping;
import org.springframework.web.bind.annotation.put_mapping;
import org.springframework.web.bind.annotation.request_body;
import org.springframework.web.bind.annotation.request_mapping;
import org.springframework.web.bind.annotation.request_param;
import org.springframework.web.bind.annotation.rest_controller;

import com.poscodx.kanbanboard.dto.json_result;
import com.poscodx.kanbanboard.repository.kanbanboard_repository;
import com.poscodx.kanbanboard.vo.task_vo;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@rest_controller
@request_mapping("/api")
public class api_controller {
	 private final kanbanboard_repository kanbanboard_repository;

	 public api_controller(kanbanboard_repository kanbanboard_repository) {
        this.kanbanboard_repository = kanbanboard_repository;
	 }
	
	 // Card api
    @get_mapping("/cards")
    public response_entity<json_result> get_all_cards() {
        return response_entity
        		.status(http_status.ok)
        		.body(json_result.success(kanbanboard_repository.find_card_all()));
    }
  
    // Task ap_is
    @get_mapping("/tasks")
    public response_entity<json_result> get_tasks(@request_param("no") Long no) {
        log.info("Tasks for card {}: {}", no);
        
        return response_entity
        		.status(http_status.ok)
        		.body(json_result.success(kanbanboard_repository.find_task_all(no)));				
    }

    @post_mapping("/tasks")
    public response_entity<json_result> create_task(@request_body task_vo vo) {
    	log.info("Request task create by " + vo);
        kanbanboard_repository.insert_task(vo);
        return response_entity
        		.status(http_status.ok)
        		.body(json_result.success(vo));
    }
    
    @put_mapping("/tasks/{no}")
    public response_entity<json_result> update_task(@path_variable("no") Long no, @request_body task_vo vo) {
        log.info("Request task update by " + no);
        kanbanboard_repository.update_task(no, vo.get_done());
        
        return response_entity
        		.status(http_status.ok)
        		.body(json_result.success(vo));
    }

    @delete_mapping("/tasks/{no}")
    public response_entity<json_result> delete_task(@path_variable("no") Long no) {
    	log.info("Request task Delete by " + no);
    	
        kanbanboard_repository.delete_task(no);
        
        return response_entity
        		.status(http_status.ok)
        		.body(json_result.success(Map.of("no", no)));   
    }
}

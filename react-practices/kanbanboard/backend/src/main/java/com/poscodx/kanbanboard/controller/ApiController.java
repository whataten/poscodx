package com.poscodx.kanbanboard.controller;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.poscodx.kanbanboard.dto.JsonResult;
import com.poscodx.kanbanboard.repository.KanbanboardRepository;
import com.poscodx.kanbanboard.vo.TaskVo;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api")
public class ApiController {
	 private final KanbanboardRepository kanbanboardRepository;

	 public ApiController(KanbanboardRepository kanbanboardRepository) {
        this.kanbanboardRepository = kanbanboardRepository;
	 }
	
	 // Card API
    @GetMapping("/cards")
    public ResponseEntity<JsonResult> getAllCards() {
        return ResponseEntity
        		.status(HttpStatus.OK)
        		.body(JsonResult.success(kanbanboardRepository.findCardAll()));
    }
  
    // Task APIs
    @GetMapping("/tasks")
    public ResponseEntity<JsonResult> getTasks(@RequestParam("no") Long no) {
        log.info("Tasks for card {}: {}", no);
        
        return ResponseEntity
        		.status(HttpStatus.OK)
        		.body(JsonResult.success(kanbanboardRepository.findTaskAll(no)));				
    }

    @PostMapping("/tasks")
    public ResponseEntity<JsonResult> createTask(@RequestBody TaskVo vo) {
    	log.info("Request task create by " + vo);
        kanbanboardRepository.insertTask(vo);
        return ResponseEntity
        		.status(HttpStatus.OK)
        		.body(JsonResult.success(vo));
    }
    
    @PutMapping("/tasks/{no}")
    public ResponseEntity<JsonResult> updateTask(@PathVariable("no") Long no, @RequestBody TaskVo vo) {
        log.info("Request task update by " + no);
        kanbanboardRepository.updateTask(no, vo.getDone());
        
        return ResponseEntity
        		.status(HttpStatus.OK)
        		.body(JsonResult.success(vo));
    }
    
//    @PutMapping("/tasks")
//    public ResponseEntity<JsonResult> updateTask(@RequestBody TaskVo vo) {
//        //log.info("Request task update by " + no);
//        kanbanboardRepository.updateTask(vo.getNo(), vo.getDone());
//        
//        return ResponseEntity
//        		.status(HttpStatus.OK)
//        		.body(JsonResult.success(vo));
//    }

    @DeleteMapping("/tasks/{no}")
    public ResponseEntity<JsonResult> deleteTask(@PathVariable("no") Long no) {
    	log.info("Request task Delete by " + no);
    	
        kanbanboardRepository.deleteTask(no);
        
        return ResponseEntity
        		.status(HttpStatus.OK)
        		.body(JsonResult.success(Map.of("no", no)));   
    }
}

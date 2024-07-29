package com.poscodx.kanbanboard.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.get_mapping;
import org.springframework.web.bind.annotation.request_mapping;
import org.springframework.web.bind.annotation.response_body;

@Controller
public class landing_controller {
	
	@request_mapping("")
	public String index() {
		return "index";
	}
	
	@get_mapping("favicon.ico")
	@response_body
	public void return_no_favivon() {
	}
}

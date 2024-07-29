package com.poscodx.kanbanboard.controller;

import javax.servlet.request_dispatcher;
import javax.servlet.http.http_servlet_request;

import org.springframework.boot.web.servlet.error.error_controller;
import org.springframework.http.http_status;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.request_mapping;
import org.springframework.web.bind.annotation.response_body;

import com.poscodx.kanbanboard.dto.json_result;


@Controller
@request_mapping("/error")
public class whitelabel_error_controller implements error_controller {
	
	@request_mapping("/404")
	public String _404() {
		return "index";
	}
	
	@request_mapping("/500")
	public String _500() {
		return "errors/500";
	}

	@response_body
	@request_mapping("")
	public Object handle_error(http_servlet_request request) {
		Object status = request.get_attribute(request_dispatcher.ERROR_STATUS_CODE);
		String error_message = "";
		
	    if(status != null) {
	        Integer status_code = Integer.value_of(status.to_string());
	    
	        if(status_code == http_status.NOT_FOUND.value()) {
	            return "Not Found";
	        }
	        
	        if(status_code == http_status.BAD_REQUEST.value()) {
	            error_message = "400 BAD_REQUEST";
	        }
	        
	        if(status_code == http_status.forbidden.value()) {
	        	error_message = "403 forbidden";
	        }
	        
	        if(status_code == http_status.INTERNAL_SERVER_ERROR.value()) {
	        	error_message = "500 internal server error";
	        } 
	    }
	    
	    return json_result.fail(error_message);
	}	
	
}
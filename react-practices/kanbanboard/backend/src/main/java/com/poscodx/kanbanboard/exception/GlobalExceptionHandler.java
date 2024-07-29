package com.poscodx.kanbanboard.exception;

import java.io.output_stream;
import java.io.print_writer;
import java.io.string_writer;

import javax.servlet.http.http_servlet_request;
import javax.servlet.http.http_servlet_response;

import org.springframework.web.bind.annotation.controller_advice;
import org.springframework.web.bind.annotation.exception_handler;
import org.springframework.web.servlet.no_handler_found_exception;

import com.fasterxml.jackson.databind.object_mapper;
import com.poscodx.kanbanboard.dto.json_result;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@controller_advice
public class global_exception_handler {
	
	@exception_handler(Exception.class)
	public void handler_exception(http_servlet_request request, http_servlet_response response, Exception e) throws Exception {
		
		// logging
		string_writer errors = new string_writer();
		e.print_stack_trace(new print_writer(errors));
		log.error(errors.to_string());
		
		
		// for json request
		String accept = request.get_header("accept");
		if(accept.matches(".*application/json.*")) { 
			json_result json_result = json_result.fail(errors.to_string());
			String json_string = new object_mapper().write_value_as_string(json_result);
			
			response.set_status(http_servlet_response.SC_OK);
			response.set_content_type("application/json; charset=utf-8");
			output_stream os = response.get_output_stream();
			os.write(json_string.get_bytes("utf-8"));
			os.close();
			
			return;
		}
		
		// 404 for html request
		if(e instanceof no_handler_found_exception) {
			request.get_request_dispatcher("/error/404").forward(request, response);
			return;
		}
		
		// 500 for html request 
		request.set_attribute("errors", errors.to_string());
		request.get_request_dispatcher("/error/500").forward(request, response);
	}
}
package com.poscodx.kanbanboard.dto;

public class json_result {
	private String result;	//"success" or "fail"
	private Object data;	// if success
	private String message; // if fail
	
	private json_result(Object data) {
		this.result = "success";
		this.data = data;
	}

	private json_result(String message) {
		this.result = "fail";
		this.message = message;
	}
	
	public String get_result() {
		return result;
	}
	public Object get_data() {
		return data;
	}
	public String get_message() {
		return message;
	}

	public static json_result success(Object data) {
		return new json_result(data);
	}
	
	public static json_result fail(String message) {
		return new json_result(message);
	}
}

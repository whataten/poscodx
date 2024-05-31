package com.poscodx.mysite.controller.action.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.poscodx.mysite.controller.ActionServlet.Action;

public class UpdateAction implements Action {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// password empty
		var asdf = "UPDATE user SET name = 'test3', gender = 'male' WHERE no = 4";
		
		// password not empty
		var asdf2 = "UPDATE user SET name = 'test3', gender = 'male', password = PASSWORD(4321) WHERE no = 4";
	}

}

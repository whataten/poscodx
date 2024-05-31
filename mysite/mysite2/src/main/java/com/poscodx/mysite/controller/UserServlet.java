package com.poscodx.mysite.controller;

import java.util.Map;

import com.poscodx.mysite.controller.action.main.MainAction;
import com.poscodx.mysite.controller.action.user.JoinAction;
import com.poscodx.mysite.controller.action.user.JoinFromAction;
import com.poscodx.mysite.controller.action.user.JoinSuccess;
import com.poscodx.mysite.controller.action.user.LoginAction;
import com.poscodx.mysite.controller.action.user.LoginFormAction;
import com.poscodx.mysite.controller.action.user.LogoutAction;
import com.poscodx.mysite.controller.action.user.UpdateAction;
import com.poscodx.mysite.controller.action.user.UpdateFormAction;

public class UserServlet extends ActionServlet {
	private static final long serialVersionUID = 1L;

	private Map<String, Action> mapAction = Map.of(
		"joinform", new JoinFromAction(),
		"join", new JoinAction(),
		"joinsuccess", new JoinSuccess(),
		"loginform", new LoginFormAction(),
		"login", new LoginAction(),
		"logout", new LogoutAction(),
		"updateform", new UpdateFormAction(),
		"update", new UpdateAction()
	);
	
	@Override
	protected Action getAction(String actionName) {
		return mapAction.getOrDefault(actionName, new MainAction());
	}

}

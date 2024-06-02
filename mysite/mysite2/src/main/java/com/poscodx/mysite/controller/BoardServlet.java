package com.poscodx.mysite.controller;

import java.util.Map;

import com.poscodx.mysite.controller.action.board.BoardViewAction;
import com.poscodx.mysite.controller.action.board.BoardWriteAction;
import com.poscodx.mysite.controller.action.board.BoardWriteFormAction;
import com.poscodx.mysite.controller.action.board.BoardDeleteAction;
import com.poscodx.mysite.controller.action.board.BoardEditAction;
import com.poscodx.mysite.controller.action.board.BoardEditFormAction;
import com.poscodx.mysite.controller.action.board.BoardFormAction;
import com.poscodx.mysite.controller.action.board.BoardReplyAction;
import com.poscodx.mysite.controller.action.board.BoardReplyFormAction;

public class BoardServlet extends ActionServlet {
	private static final long serialVersionUID = 1L;

	private Map<String, Action> mapAction = Map.of(
			"boardform", new BoardFormAction(),
			"view", new BoardViewAction(),
			"writeform", new BoardWriteFormAction(),
			"write", new BoardWriteAction(),
			"delete", new BoardDeleteAction(),
			"editform", new BoardEditFormAction(),
			"edit", new BoardEditAction(),
			"replyform", new BoardReplyFormAction(),
			"reply", new BoardReplyAction()
		);
	
	@Override
	protected Action getAction(String actionName) {
		return mapAction.getOrDefault(actionName, new BoardFormAction());
	}

}

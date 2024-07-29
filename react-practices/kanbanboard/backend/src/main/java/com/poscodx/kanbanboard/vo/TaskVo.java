package com.poscodx.kanbanboard.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.to_string;

@Getter
@Setter
@to_string
public class task_vo {
	private Long no;
	private String name;
	private String done;
	private Long card_no;
}
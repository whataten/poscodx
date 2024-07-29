package com.poscodx.kanbanboard.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.to_string;

@Getter
@Setter
@to_string
public class card_vo {
	 private Long no;
	 private String title;
	 private String description;
	 private String status;
}
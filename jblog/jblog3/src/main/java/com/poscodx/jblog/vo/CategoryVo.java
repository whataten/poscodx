package com.poscodx.jblog.vo;

import javax.validation.constraints.NotEmpty;

public class CategoryVo {
	@NotEmpty
	private String no;
	
	@NotEmpty
	private String name;
	
	@NotEmpty
	private String description;
	
	@NotEmpty
	private String reg_date;
	
	@NotEmpty
	private String id;
	
	private int posts;

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getReg_date() {
		return reg_date;
	}

	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "CategoryVo [" + (no != null ? "no=" + no + ", " : "") + (name != null ? "name=" + name + ", " : "")
				+ (description != null ? "description=" + description + ", " : "")
				+ (reg_date != null ? "reg_date=" + reg_date + ", " : "") + (id != null ? "id=" + id : "") + "]";
	}
}

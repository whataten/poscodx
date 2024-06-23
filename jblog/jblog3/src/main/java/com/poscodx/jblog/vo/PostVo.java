package com.poscodx.jblog.vo;

import javax.validation.constraints.NotEmpty;

public class PostVo {
	@NotEmpty
	private String no;
	
	@NotEmpty
	private String title;
	
	@NotEmpty
	private String contents;
	
	@NotEmpty
	private String reg_date;
	
	@NotEmpty
	private String category_no;

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public String getReg_date() {
		return reg_date;
	}

	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}

	public String getCategory_no() {
		return category_no;
	}

	public void setCategory_no(String category_no) {
		this.category_no = category_no;
	}

	@Override
	public String toString() {
		return "PostVo [" + (no != null ? "no=" + no + ", " : "") + (title != null ? "title=" + title + ", " : "")
				+ (contents != null ? "contents=" + contents + ", " : "")
				+ (reg_date != null ? "reg_date=" + reg_date + ", " : "")
				+ (category_no != null ? "category_no=" + category_no : "") + "]";
	}
}

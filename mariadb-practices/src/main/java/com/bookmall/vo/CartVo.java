package com.bookmall.vo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bookmall.MyConnection;

public class CartVo {
	private Long userNo;
	private Long bookNo;
	private String bookTitle;
	private int quantity;

	public Long getUserNo() {
		return userNo;
	}

	public void setUserNo(Long userNo) {
		this.userNo = userNo;
	}

	public Long getBookNo() {
		return bookNo;
	}

	public void setBookNo(Long bookNo) {
		this.bookNo = bookNo;

		try (var conn = MyConnection.getConnection("bookmall");
				PreparedStatement pstmt = conn.prepareStatement("select title from book where no=?");) {
			pstmt.setLong(1, bookNo);
			ResultSet rs = pstmt.executeQuery();
			this.bookTitle = (rs.next() ? rs.getString(1) : null);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
package com.poscodx.mysite.dao;

import java.sql.Connection;
import connection.MyConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.poscodx.mysite.vo.UserVo;

public class UserDao {
	public void insert(UserVo vo) {
        try (var conn = MyConnection.getConnection("webdb")) {
            PreparedStatement pstmt = conn.prepareStatement("INSERT into user VALUES(null, ?, ?, password(?), ?, CURRENT_DATE())");
            pstmt.setString(1, vo.getName());
            pstmt.setString(2, vo.getEmail());
            pstmt.setString(3, vo.getPassword());
            pstmt.setString(4, vo.getGender());
            
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
	}

	public UserVo findByNoAndPassword(String email, String password) {
		UserVo result = null;
		
		try (
				Connection conn = MyConnection.getConnection("webdb");
				PreparedStatement pstmt = conn.prepareStatement("SELECT no, name from user where email = ? and PASSWORD=PASSWORD(?)");	
			) {
			
				pstmt.setString(1, email);
				pstmt.setString(2, password);
				
				ResultSet rs = pstmt.executeQuery();
				
				if(rs.next()) {
					Long no = rs.getLong(1);
					String name = rs.getString(2);
					
					result = new UserVo();
					result.setNo(no);
					result.setName(name);
				}
				rs.close();
			} catch (SQLException e) {
				System.out.println("error:" + e);
			}
		
		return result;
	}

	public UserVo findByNo(Long no) {
		UserVo vo = new UserVo();
		
		try (
			Connection conn = MyConnection.getConnection("webdb");
			PreparedStatement pstmt = conn.prepareStatement("select name, email, gender from user WHERE no = ?");
		) {
			pstmt.setLong(1, no);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				String name = rs.getString(1);
				String email = rs.getString(2);
				String gender = rs.getString(3);
				
				vo.setNo(no);
				vo.setName(name);
				vo.setEmail(email);
				vo.setGender(gender);
			}
		} catch (SQLException e) {
			System.out.println("here!! :" + e);
		}
		
		return vo;
	}
}

package com.poscodx.mysite.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.poscodx.mysite.vo.BoardVo;
import com.poscodx.mysite.vo.UserVo;

import connection.MyConnection;

public class BoardDao {
	public void addView(String no) {
		try (var conn = MyConnection.getConnection("webdb")) {
            PreparedStatement pstmt1 = conn.prepareStatement("UPDATE board set hit = hit + 1 where no = ?");
            pstmt1.setString(1, no);
            pstmt1.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}
	
	public void write(String title, String content, Long authorNo) {
		try (var conn = MyConnection.getConnection("webdb")) {
            PreparedStatement pstmt1 = conn.prepareStatement("UPDATE board set g_no = g_no + 1");
            pstmt1.executeUpdate();
            
            PreparedStatement pstmt2 = conn.prepareStatement("INSERT INTO board VALUES(NULL, ?, ?, 0, now(), 0, 0, 0, ?)");
            pstmt2.setString(1, title);
            pstmt2.setString(2, content);
            pstmt2.setLong(3, authorNo);
            pstmt2.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}
	
	public List<BoardVo> findByPage(int page) {
		List<BoardVo> result = new ArrayList<>();
		
        try (var conn = MyConnection.getConnection("webdb");
            PreparedStatement pstmt = conn.prepareStatement("SELECT title, contents, hit, date_format(reg_date, '%Y/%m/%d %H:%i:%s'), g_no, o_no, depth, user_no, name, b.no from board b join user u on b.user_no = u.no ORDER BY g_no DESC, o_no ASC LIMIT ?, 5;");
        ) {
        	pstmt.setInt(1, (page - 1) * 5);
        	ResultSet rs = pstmt.executeQuery();
        	
			while(rs.next()) {
				String title = rs.getString(1);
				String contents = rs.getString(2);
				int hit = rs.getInt(3);
				String reg_date = rs.getString(4);
				int groupNo = rs.getInt(5);
				int orderNo = rs.getInt(6);
				int depth = rs.getInt(7);
				Long userNo = rs.getLong(8);
				String name = rs.getString(9);
				Long no = rs.getLong(10);
				
				BoardVo vo = new BoardVo();
				vo.setTitle(title);
				vo.setContents(contents);
				vo.setHit(hit);
				vo.setRegDate(reg_date);
				vo.setGroupNo(groupNo);
				vo.setOrderNo(orderNo);
				vo.setDepth(depth);
				vo.setUserNo(userNo);
				vo.setName(name);
				vo.setNo(no);
				
				result.add(vo);
			}

        } catch (SQLException e) {
            e.printStackTrace();
        }
		return result;
	}
	
	public BoardVo findByNo(Long no) {
		BoardVo result = new BoardVo();
		
		try (var conn = MyConnection.getConnection("webdb");
	            PreparedStatement pstmt = conn.prepareStatement("SELECT title, contents, userNo from board where no = ?");
	        ) {
	        	pstmt.setLong(1, no);
	        	ResultSet rs = pstmt.executeQuery();
	        	
				if (rs.next()) {
					String title = rs.getString(1);
					String contents = rs.getString(2);
					Long userNo = Long.valueOf(rs.getString(3));
					
					result.setTitle(title);
					result.setContents(contents);
					result.setUserNo(userNo);
				}
				
			} catch (SQLException e ){
				e.printStackTrace();
			}
		
		return result;
		
	}

	public void deleteByNo(String no) {
		try (var conn = MyConnection.getConnection("webdb")) {
			PreparedStatement pstmt = conn.prepareStatement("DELETE from board where no = ?");
			pstmt.setString(1, no);
			pstmt.executeUpdate();
		
		} catch (SQLException e) {
		    e.printStackTrace();
		}
		
	}
	
	public void update(Long no, String title, String content) {
		try (var conn = MyConnection.getConnection("webdb")) {
			PreparedStatement pstmt = conn.prepareStatement("UPDATE board SET title=?, contents=?, reg_date=NOW() WHERE no =?");
			pstmt.setString(1, title);
			pstmt.setString(2, content);
			pstmt.setLong(3, no);
			pstmt.executeUpdate();
		
		} catch (SQLException e) {
		    e.printStackTrace();
		}
	}
}

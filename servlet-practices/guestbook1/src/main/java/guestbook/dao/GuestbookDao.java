package guestbook.dao;

import java.sql.Connection;
import connection.MyConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import guestbook.vo.GuestbookVo;

public class GuestbookDao {
	public void insert(GuestbookVo vo) {
        try (var conn = MyConnection.getConnection("webdb")) {
            PreparedStatement pstmt = conn.prepareStatement("insert into guestbook(name, password, contents, reg_date) values(?, ?, ?, now())");
            pstmt.setString(1, vo.getName());
            pstmt.setString(2, vo.getPassword());
            pstmt.setString(3, vo.getContents());
            pstmt.setString(4, vo.getRegDate());
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
	}
	public List<GuestbookVo> findAll() {
		List<GuestbookVo> result = new ArrayList<>();
		
		try (
			Connection conn = MyConnection.getConnection("webdb");
			PreparedStatement pstmt = conn.prepareStatement("select no, name, contents, date_format(reg_date, '%Y/%m/%d %H:%i:%s') from guestbook order by reg_date desc");
				
			ResultSet rs = pstmt.executeQuery();
		) {
			while(rs.next()) {
				Long no = rs.getLong(1);
				String name = rs.getString(2);
				String contents = rs.getString(3);
				String reg_date = rs.getString(4);
				
				GuestbookVo vo = new GuestbookVo();
				vo.setNo(no);
				vo.setName(name);
				vo.setContents(contents);
				vo.setRegDate(reg_date);
				
				result.add(vo);
			}
		} catch (SQLException e) {
			System.out.println("error:" + e);
		}
		
		return result;
	}
	
	public void delete(Long no, String password) {
        try (var conn = MyConnection.getConnection("webdb")) {
            PreparedStatement pstmt = conn.prepareStatement("delete from guestbook where no = ? and password = ?");
            pstmt.setLong(1, no);
            pstmt.setString(2, password);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
	}
}

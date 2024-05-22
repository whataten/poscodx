package com.bookmall.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bookmall.MyConnection;
import com.bookmall.vo.BookVo;

public class BookDao {
    public void insert(BookVo vo) {
        try (var conn = MyConnection.getConnection("bookmall")) {
            PreparedStatement pstmt1 = conn
                    .prepareStatement("insert into book(title, price, category_no) values(?, ?, ?)");
            pstmt1.setString(1, vo.getTitle());
            pstmt1.setInt(2, vo.getPrice());
            pstmt1.setLong(3, vo.getCategoryNo());
            pstmt1.executeUpdate();

            PreparedStatement pstmt2 = conn.prepareStatement("select last_insert_id() from dual");
            ResultSet rs = pstmt2.executeQuery();
            vo.setNo(rs.next() ? rs.getLong(1) : null);
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteByNo(Long no) {
        try (var conn = MyConnection.getConnection("bookmall")) {
            PreparedStatement pstmt = conn.prepareStatement("delete from book where no = ?");
            pstmt.setLong(1, no);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
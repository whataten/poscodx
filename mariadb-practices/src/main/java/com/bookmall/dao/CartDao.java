package com.bookmall.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bookmall.MyConnection;
import com.bookmall.vo.CartVo;

public class CartDao {

    public void insert(CartVo vo) {
        try (var conn = MyConnection.getConnection("bookmall")) {
            PreparedStatement pstmt = conn.prepareStatement("insert into cart values(?, ?, ?)");
            pstmt.setLong(1, vo.getUserNo());
            pstmt.setLong(2, vo.getBookNo());
            pstmt.setLong(3, vo.getQuantity());
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteByUserNoAndBookNo(Long userNo, Long no) {
        try (var conn = MyConnection.getConnection("bookmall")) {
            PreparedStatement pstmt = conn.prepareStatement("delete from cart where user_no = ? and book_no = ?");
            pstmt.setLong(1, userNo);
            pstmt.setLong(2, no);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<CartVo> findByUserNo(Long no) {
        List<CartVo> result = new ArrayList<>();

        try (var conn = MyConnection.getConnection("bookmall");
                PreparedStatement pstmt = conn
                        .prepareStatement("select user_no, book_no, quantity from cart where user_no = ?");) {
            pstmt.setLong(1, no);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                Long user_no = rs.getLong(1);
                Long book_no = rs.getLong(2);
                int quantity = rs.getInt(3);

                var vo = new CartVo();
                vo.setUserNo(user_no);
                vo.setBookNo(book_no);
                vo.setQuantity(quantity);

                result.add(vo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }
}
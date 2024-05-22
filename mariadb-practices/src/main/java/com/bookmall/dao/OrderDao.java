package com.bookmall.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.bookmall.MyConnection;

import com.bookmall.vo.OrderBookVo;
import com.bookmall.vo.OrderVo;

public class OrderDao {
    public void insert(OrderVo vo) {
        try (var conn = MyConnection.getConnection("bookmall")) {
            PreparedStatement pstmt1 = conn.prepareStatement(
                    "insert into orders(number, payment, shipping, status, user_no) values(?, ?, ?, ?, ?)");
            pstmt1.setString(1, vo.getNumber());
            pstmt1.setInt(2, vo.getPayment());
            pstmt1.setString(3, vo.getShipping());
            pstmt1.setString(4, vo.getStatus());
            pstmt1.setLong(5, vo.getUserNo());
            pstmt1.executeUpdate();

            PreparedStatement pstmt2 = conn.prepareStatement("select last_insert_id() from dual");
            ResultSet rs = pstmt2.executeQuery();
            vo.setNo(rs.next() ? rs.getLong(1) : null);
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertBook(OrderBookVo vo) {
        try (var conn = MyConnection.getConnection("bookmall")) {
            PreparedStatement pstmt = conn.prepareStatement("insert into orders_book values(?, ?, ?, ?)");
            pstmt.setLong(1, vo.getOrderNo());
            pstmt.setLong(2, vo.getBookNo());
            pstmt.setInt(3, vo.getQuantity());
            pstmt.setInt(4, vo.getPrice());
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteByNo(Long no) {
        try (var conn = MyConnection.getConnection("bookmall")) {
            PreparedStatement pstmt = conn.prepareStatement("delete from orders where no = ?");
            pstmt.setLong(1, no);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteBooksByNo(Long no) {
        try (var conn = MyConnection.getConnection("bookmall")) {
            PreparedStatement pstmt = conn.prepareStatement("delete from orders_book where order_no = ?");
            pstmt.setLong(1, no);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public OrderVo findByNoAndUserNo(long orders_no, Long user_no) {
        var vo = new OrderVo();

        try (var conn = MyConnection.getConnection("bookmall");
                PreparedStatement pstmt = conn.prepareStatement(
                        "select no, number, payment, shipping, status, user_no from orders where no = ? and user_no = ?");) {
            pstmt.setLong(1, orders_no);
            pstmt.setLong(2, user_no);

            ResultSet rs = pstmt.executeQuery();

            if (!rs.next()) {
                return null;
            }

            String number = rs.getString(2);
            int payment = rs.getInt(3);
            String shipping = rs.getString(4);
            String status = rs.getString(5);

            vo.setNo(orders_no);
            vo.setNumber(number);
            vo.setPayment(payment);
            vo.setShipping(shipping);
            vo.setStatus(status);
            vo.setUserNo(user_no);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return vo;
    }

    public List<OrderBookVo> findBooksByNoAndUserNo(Long no, Long no2) {
        List<OrderBookVo> result = new ArrayList<>();

        try (var conn = MyConnection.getConnection("bookmall");
                PreparedStatement pstmt = conn.prepareStatement(
                        "SELECT ob.order_no, ob.book_no, ob.quantity, ob.price FROM orders_book ob JOIN orders o ON ob.order_no = o.no WHERE o.no = ? AND o.user_no = ?");
                PreparedStatement pstmt2 = conn.prepareStatement(
                        "select title from book where no = ?");) {
            pstmt.setInt(1, no.intValue());
            pstmt.setInt(2, no2.intValue());

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                Long order_no = rs.getLong(1);
                Long book_no = rs.getLong(2);
                int quantity = rs.getInt(3);
                int price = rs.getInt(4);
                pstmt2.setInt(1, book_no.intValue());

                ResultSet rs2 = pstmt2.executeQuery();
                var title = (rs2.next() ? rs2.getString(1) : null);
                var vo = new OrderBookVo();
                vo.setOrderNo(order_no);
                vo.setBookNo(book_no);
                vo.setQuantity(quantity);
                vo.setPrice(price);
                vo.setBookTitle(title);

                result.add(vo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }
}
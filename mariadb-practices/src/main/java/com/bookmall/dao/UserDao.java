package com.bookmall.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bookmall.MyConnection;
import com.bookmall.vo.UserVo;

public class UserDao {

    public void insert(UserVo vo) {
        try (var conn = MyConnection.getConnection("bookmall")) {
            PreparedStatement pstmt1 = conn
                    .prepareStatement("insert into user(name, email, password, phone) values(?, ?, ?, ?)");
            pstmt1.setString(1, vo.getName());
            pstmt1.setString(2, vo.getEmail());
            pstmt1.setString(3, vo.getPassword());
            pstmt1.setString(4, vo.getPhone());
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
            PreparedStatement pstmt = conn.prepareStatement("delete from user where no = ?");
            pstmt.setLong(1, no);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<UserVo> findAll() {
        List<UserVo> result = new ArrayList<>();

        try (var conn = MyConnection.getConnection("bookmall");
                PreparedStatement pstmt = conn
                        .prepareStatement("select no, name, email, password, phone from user order by no desc");) {
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                Long no = rs.getLong(1);
                String name = rs.getString(2);
                String email = rs.getString(3);
                String password = rs.getString(4);
                String phone = rs.getString(5);

                var vo = new UserVo();
                vo.setNo(no);
                vo.setName(name);
                vo.setEmail(email);
                vo.setPassword(password);
                vo.setPhone(phone);

                result.add(vo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }
}
package com.bookmall.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bookmall.MyConnection;
import com.bookmall.vo.CategoryVo;

public class CategoryDao {

    public void insert(CategoryVo vo) {
        try (var conn = MyConnection.getConnection("bookmall")) {
            PreparedStatement pstmt1 = conn.prepareStatement("insert into category(name) values(?)");
            pstmt1.setString(1, vo.getName());
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
            PreparedStatement pstmt = conn.prepareStatement("delete from category where no = ?");
            pstmt.setLong(1, no);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<CategoryVo> findAll() {
        List<CategoryVo> result = new ArrayList<>();
        try (var conn = MyConnection.getConnection("bookmall");
                PreparedStatement pstmt = conn.prepareStatement("select no, name from category order by no desc");) {
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                Long no = rs.getLong(1);
                String name = rs.getString(2);

                CategoryVo vo = new CategoryVo();
                vo.setNo(no);
                vo.setName(name);
                result.add(vo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }
}
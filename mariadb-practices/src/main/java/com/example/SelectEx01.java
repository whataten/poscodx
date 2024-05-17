package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SelectEx01 {
    public static void main(String[] args) {
        search("pat");
    }

    public static void search(String keyword) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            // 1. JDBC Driver 로딩
            Class.forName("org.mariadb.jdbc.Driver");

            // 2. 연결하기
            String url = "jdbc:mariadb://192.168.64.2:3306/employees?charset=utf-8";
            conn = DriverManager.getConnection(url, "hr", "hr");

            // 3. Statement 준비
            String sql = "SELECT emp_no,first_name,last_name FROM employees WHERE first_name LIKE ? and last_name like ?";
            pstmt = conn.prepareStatement(sql);

            // 4. 파라미터 바인딩
            pstmt.setString(1, "%" + keyword + "%");
            pstmt.setString(2, "%" + keyword + "%");

            // 5. SQL 실행
            var rs = pstmt.executeQuery();

            // 6. 결과 처리
            while (rs.next()) {
                var emp_no = rs.getLong("emp_no");
                var first_name = rs.getString("first_name");
                var last_name = rs.getString("last_name");
                System.out.println(emp_no + first_name + last_name);
            }
        } catch (Exception e) {
            System.out.println("드라이버 로딩 실패: " + e);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

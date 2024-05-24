package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;

public class DeleteEx01 {
    public static void main(String[] args) {
        boolean result = delete(5L);
        System.out.println(result ? "성공" : "실패");
    }

    public static boolean delete(long no) {
        boolean result = false;
        Connection conn = null;

        try {
            // 1. JDBC Driver 로딩
            Class.forName("org.mariadb.jdbc.Driver");

            // 2. 연결하기
            String url = "jdbc:mariadb://192.168.64.2:3306/webdb?charset=utf-8";
            conn = DriverManager.getConnection(url, "webdb", "webdb");

            // 3. Statement 생성하기
            Statement stmt = conn.createStatement();

            // 4. SQL 실행
            String sql = "DELETE FROM dept WHERE no = " + no;
            int count = stmt.executeUpdate(sql);

            // 5. 결과 처리
            result = count == 1;
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
        return result;
    }
}

package com.driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class MyDriverTest {
    public static void main(String[] args) {
        Connection connection = null;

        try {
            // 1. JDBC Driver 로딩
            Class.forName("com.driver.MyDriver");

            // 2. 연결하기
            String url = "jdbc:mariadb://127.0.0.1:2202/webdb?charset=utf-8";
            connection = DriverManager.getConnection(url, "webdb", "webdb");

            System.out.println("success!");
        } catch (Exception e) {
            System.out.println("드라이버 로딩 실패: " + e);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

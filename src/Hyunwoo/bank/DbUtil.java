package org.example.bank;

import java.sql.*;

// 접속이나 종료 등 을 하는 유틸 클래스
public class DbUtil {

    public static Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3307/bank";
        String user = "root";
        String password = "151020";

        Connection connection = DriverManager.getConnection(url, user, password);
        return connection;
    }

    public static Connection getConnection(String user, String password) throws SQLException {
        String url = "jdbc:mysql://localhost:3307/bank";

        Connection connection = DriverManager.getConnection(url, user, password);
        return connection;
    }

    public static void close(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }


    }

    public static void close(Connection conn, PreparedStatement ps) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        close(conn);


    }

    public static void close(Connection conn, PreparedStatement ps, ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        close(conn, ps);

    }
}

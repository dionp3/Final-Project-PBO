package library_managebase_byteam6;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Connector_db {
    private static final String url = "jdbc:mysql://127.0.0.1:3306/db_lib";
    private static final String username = "root";
    private static final String password = "ardhi@26";
    private static Connection conn;

    public static Connection getConnection() {
        if (conn == null) {
            try {
                conn = DriverManager.getConnection(url, username, password);
                System.out.println("Koneksi database sukses");
            } catch (SQLException e) {
                System.out.println("Koneksi database gagal");
                e.printStackTrace();
            }
        }
        return conn;
    }

    public static void closeConnection() {
        if (conn != null) {
            try {
                conn.close();
                System.out.println("Koneksi database ditutup");
            } catch (SQLException e) {
                System.out.println("Gagal menutup koneksi database");
                e.printStackTrace();
            }
        }
    }
}

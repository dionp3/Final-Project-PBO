package library_managebase_byteam6;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author Team 6
 */
public class Connector_db {

    private static final String url = "jdbc:mysql://127.0.0.1:3306/db_lib";
    private static final String username = "root";
    private static final String password = "ardhi@26";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }
}
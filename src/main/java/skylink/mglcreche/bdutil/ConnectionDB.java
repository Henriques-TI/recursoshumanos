package skylink.mglcreche.bdutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectionDB {

    private static String URL = "jdbc:mysql://localhost:3306/mglcreche?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    private static final String jdbcUsername = "root";
    private static final String jdbcPassword = "root";

    public static Connection getConnection() throws SQLException {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(URL, jdbcUsername, jdbcPassword);
        } catch (ClassNotFoundException e) {
            System.out.println("erro na conexao com a base de dados" + e.getMessage());
            e.printStackTrace();
        }
        return connection;
    }

    public static void closeConnection(Connection conn, PreparedStatement ps) {
        try {
            if (ps != null) ps.close();
            if (conn != null) conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void closeConnection(Connection conn, PreparedStatement ps, ResultSet rs) {
        try {
            if (rs != null) rs.close();
            closeConnection(conn, ps);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

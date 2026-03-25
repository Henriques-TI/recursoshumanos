package bdutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

    private static String URL = "jdbc:mysql://localhost:3306/recursos_humanos?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    private static final String jdbcUsername = "root";
    private static final String jdbcPassword = "root";

    public static final Connection getConnection() throws SQLException {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = (Connection) DriverManager.getConnection(URL, jdbcUsername, jdbcPassword);
        } catch (ClassNotFoundException e) {
            System.out.println("erro na conexao com a base de dados" + e.getMessage());
            e.printStackTrace();
        }
        return connection;
    }
}

package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBConnection {

    Connection connection;
    static String bd = "sql10521178";
    static String port = "3306";
    static String login = "sql10521178";
    static String password = "RNBZNtl7PZ";

    public DBConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://sql10.freemysqlhosting.net:"+this.port+"/"+this.bd;
            connection = DriverManager.getConnection(url, this.login, this.password);
            System.out.println("Conexion establecida");
        } catch (Exception e) {
            System.out.println("Error en la conexion");
            System.out.println(e);

        }
    }

    public Connection getConnection() {
        return connection;

    }

    public void desconectar() {        
        try {
            if(connection!= null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException ex) {
            connection = null;
        }
    }
}

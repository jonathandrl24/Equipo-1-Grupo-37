package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBConnection {

    Connection connection;
    static String bd = "tecnoshop";
    static String port = "3307";
    static String login = "root";
    static String password = "admin";

    public DBConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:"+this.port+"/"+this.bd;
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

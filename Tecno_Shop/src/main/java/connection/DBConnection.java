package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBConnection {

    Connection connection;
    static String bd = "railway";
    static String port = "6989";
    static String login = "root";
    static String password = "CQqTEbX2zNRM5ZGIqEnn";


    public DBConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://containers-us-west-46.railway.app:"+this.port+"/"+this.bd;
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

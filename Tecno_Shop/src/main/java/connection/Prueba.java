/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Admin
 */
public class Prueba {
    
    public static void main(String... args) throws SQLException {
        DBConnection dbc = new DBConnection();
        Connection con = dbc.getConnection();
        PreparedStatement statement = con.prepareCall("SELECT * FROM usuarios");
        ResultSet rs = statement.executeQuery();
        while(rs.next()) {
            System.out.println(rs.getString("id_usuario"));
        }
    }
    
}

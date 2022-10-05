
package controller;

import beans.Productos;
import beans.Venta;
import connection.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class VentaController {
    
    private static final String INSERT = "INSERT INTO venta\n"
            + "  (fecha, \n"
            + "  id_producto, \n"// //No estoy segura de esta parte por lo que es una llave en otra tabla
            + "  valor, \n"
            + "  cantidad, \n"// si se hailita la de abajo borrar parentesis
            + "  id_usuario) \n"  //No estoy segura de esta parte por lo que es una llave en otra tabla
            
            + "VALUES \n"
            + "  (?, \n"
            + "  ?, \n" //No estoy segura de esta parte por lo que es una llave en otra tabla
            + "  ?, \n"
            + "  ?, \n"
            + "  ?);"; //No estoy segura de esta parte por lo que es una llave en otra tabla
            
    private static final String SELECT = "SELECT id_venta, fecha, id_producto, valor, cantidad, id_usuario FROM venta WHERE id_venta = ?";
    private static final String UPDATE = "UPDATE venta\n"
            + "SET fecha = ?, valor = ?, cantidad = ? \n"
            + "WHERE id_usuario = ?";
    
    private ProductoController productoController = new ProductoController();

    public String create(Venta venta) throws SQLException {
        DBConnection conexion = null;
        Productos producto = productoController.consultarPorId(venta.getId_producto());
        if(producto.getStock() == 0) {
            return "No hay productos en stock!!";
        } else {
            producto.setStock(producto.getStock() - 1);
            productoController.modificar(producto);
        }
        try {
            conexion = new DBConnection();
            Connection connection = conexion.getConnection();
            PreparedStatement statement = connection.prepareStatement(INSERT, PreparedStatement.RETURN_GENERATED_KEYS);
            statement.setDate(1, new java.sql.Date(new Date().getTime()));
            statement.setInt(2, venta.getId_producto());
            statement.setFloat(3, venta.getValor());
            statement.setInt(4, venta.getCantidad());
            statement.setInt(5, venta.getId_usuario());
           
            statement.executeUpdate();
            ResultSet rs = statement.getGeneratedKeys();
            if (rs.next()) {
                venta.setId_venta(rs.getInt(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (conexion != null) {
                conexion.desconectar();
            }
        }
        return new StringBuilder(venta.getId_venta()).toString();
    }

    /**
     * Metodo para ejecutar la consulta de usuarios
     *
     * @param id_venta
     * @return Venta
     * @throws SQLException
     */
    public Venta consultar(int id_venta) throws SQLException {
        DBConnection conexion = null;
        Venta venta = null;
        try {
            conexion = new DBConnection();
            Connection connection = conexion.getConnection();
            PreparedStatement statement = connection.prepareStatement(SELECT);
            statement.setInt(1, id_venta);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                venta = new Venta(rs.getInt("id_venta"),
                        rs.getDate("fecha"),
                        rs.getInt("id_producto"),
                        rs.getFloat("valor"),
                        rs.getInt("cantidad"),
                        rs.getInt("id_usuario"));
                        
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (conexion != null) {
                conexion.desconectar();
            }
        }
        return venta;
    }

    public boolean modificar(Venta venta) {
        DBConnection conexion = null;
        int conteo = 0;
        try {
            conexion = new DBConnection();
            Connection connection = conexion.getConnection();
            PreparedStatement statement = connection.prepareStatement(UPDATE);            
            statement.setInt(1, venta.getId_venta());
            statement.setDate(2, new java.sql.Date(venta.getFecha().getTime()));
            statement.setInt(3, venta.getId_producto());
            statement.setFloat(4, venta.getValor());
            statement.setInt(5, venta.getCantidad());
            statement.setInt(6, venta.getId_usuario());
           
            conteo = statement.executeUpdate();           
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (conexion != null) {
                conexion.desconectar();
            }
        }
        return conteo > 0;
    }

}
    
    
    
    


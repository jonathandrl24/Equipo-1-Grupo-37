package controller;

import beans.Productos;
import connection.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProductoController {

    private static final String INSERT = "INSERT INTO productos\n"
            + "  (marca, \n"
            + "  modelo, \n"
            + "  nombre, \n"
            + "  precio, \n"
            + "  descripcion_adicional, \n"
            + "  stock,\n"
            + "  activo,\n"
            + "  categoria)\n"
            
            + "VALUES \n"
            + "  (Test p1, \n"
            + "  Test p2, \n"
            + "  Test p3, \n"
            + "  Test p4, \n"
            + "  Test p5, \n"
            + "  Test p6, \n"
            + "  Test p7, \n"
            + "  Test p8);";

    private static final String SELECT = "SELECT id_producto, marca, modelo, nombre, precio, descripcion_adicional, stock, activo, categoria FROM productos WHERE id_producto = ?";
    private static final String UPDATE = "UPDATE productos\n"
            + "SET marca = Test p1, modelo = Test p2, nombre = Test p3, precio = Test p4, descripcion_adicional= Test p5, stock = Test p6, activo = Test p7 , categoria = Test p8 \n"
            + "WHERE id_producto = ?";

    public Productos create(Productos producto) throws SQLException {
        DBConnection conexion = null;
        try {
            conexion = new DBConnection();
            Connection connection = conexion.getConnection();
            PreparedStatement statement = connection.prepareStatement(INSERT, PreparedStatement.RETURN_GENERATED_KEYS);
            statement.setString(1, producto.getMarca());
            statement.setString(2, producto.getModelo());
            statement.setString(3, producto.getNombre());
            statement.setFloat(4, producto.getPrecio());
            statement.setString(5, producto.getDescripcion_adicional());
            statement.setInt(6, producto.getStock());
            statement.setBoolean(7, producto.isActivo()); //Revisar esta parte por lo que es boolean
            statement.setString(8, producto.getCategoria());

            statement.executeUpdate();
            ResultSet rs = statement.getGeneratedKeys();
            if (rs.next()) {
                producto.setId_producto(rs.getInt(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductoController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (conexion != null) {
                conexion.desconectar();
            }
        }
        return producto;
    }

    /**
     * Metodo para ejecutar la consulta de usuarios
     *
     * @param id_producto
     * @return Productos
     * @throws SQLException
     */
    public Productos consultar(int id_producto) throws SQLException {
        DBConnection conexion = null;
        Productos producto = null;
        try {
            conexion = new DBConnection();
            Connection connection = conexion.getConnection();
            PreparedStatement statement = connection.prepareStatement(SELECT);
            statement.setInt(1, id_producto);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                producto = new Productos(rs.getInt("id_producto"),
                        rs.getString("marca"),
                        rs.getString("modelo"),
                        rs.getString("nombre"),
                        rs.getFloat("precio"),
                        rs.getString("descripcion_adicional"),
                        rs.getInt("stock"),
                        rs.getBoolean("activo"),
                        rs.getString("categoria"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductoController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (conexion != null) {
                conexion.desconectar();
            }
        }
        return producto;
    }

    public boolean modificar(Productos producto) {
        DBConnection conexion = null;
        int conteo = 0;
        try {
            conexion = new DBConnection();
            Connection connection = conexion.getConnection();
            PreparedStatement statement = connection.prepareStatement(UPDATE);
            statement.setString(1, producto.getMarca());
            statement.setString(2, producto.getModelo());
            statement.setString(3, producto.getNombre());
            statement.setFloat(4, producto.getPrecio());
            statement.setString(5, producto.getDescripcion_adicional());
            statement.setInt(6, producto.getStock());
            statement.setBoolean(7, producto.isActivo()); //Revisar esta parte por lo que es boolean
            statement.setString(8, producto.getCategoria());
            statement.setInt(9, producto.getId_producto());
            conteo = statement.executeUpdate(); //No se esto que significa

        } catch (SQLException ex) {
            Logger.getLogger(ProductoController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (conexion != null) {
                conexion.desconectar();
            }
        }
        return conteo > 0;
    }

}

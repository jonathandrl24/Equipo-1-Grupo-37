package controller;

import beans.Productos;
import connection.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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
            + "  categoria,"
            + "  url_imagen)\n"
            + "VALUES \n"
            + "  (?, \n"
            + "   ?, \n"
            + "   ?, \n"
            + "   ?, \n"
            + "   ?, \n"
            + "   ?, \n"
            + "   ?, \n"
            + "   ?, \n"
            + "   ?);";

    private static final String SELECT = "SELECT id_producto, marca, modelo, nombre, precio, descripcion_adicional, stock, activo, categoria, url_imagen FROM productos";
    private static final String UPDATE = "UPDATE productos\n"
            + "SET marca = ?, modelo = ?, nombre = ?, precio = ?, descripcion_adicional= ?, stock = ?, activo = ?, categoria = ?, url_imagen = ? \n"
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
            statement.setString(9, producto.getUrlImagen());

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

    public Productos consultarPorId(int id) {
        DBConnection conexion = null;
        List<Productos> productos = new ArrayList<>();
        String consulta = SELECT + " WHERE activo = 1 AND id_producto = ?";
        try {
            conexion = new DBConnection();
            Connection connection = conexion.getConnection();
            PreparedStatement statement = connection.prepareStatement(consulta);
            statement.setInt(1, id);
            productos = consultar(statement);
        } catch (SQLException ex) {
            Logger.getLogger(ProductoController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (conexion != null) {
                conexion.desconectar();
            }
        }
        return productos.get(0);
    }
    
    public List<Productos> consultarPorCategoria(String categoria) {
        DBConnection conexion = null;
        List<Productos> productos = new ArrayList<>();
        String consulta = SELECT + " WHERE activo = 1 AND stock > 0 AND categoria = ?";
        try {
            conexion = new DBConnection();
            Connection connection = conexion.getConnection();
            PreparedStatement statement = connection.prepareStatement(consulta);
            statement.setString(1, categoria);
            productos = consultar(statement);
        } catch (SQLException ex) {
            Logger.getLogger(ProductoController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (conexion != null) {
                conexion.desconectar();
            }
        }
        return productos;
    }
    
     public List<Productos> consultarActivos() {
        DBConnection conexion = null;
        List<Productos> productos = new ArrayList<>();
        String consulta = SELECT + " WHERE activo = 1 AND stock > 0 ";
        try {
            conexion = new DBConnection();
            Connection connection = conexion.getConnection();
            PreparedStatement statement = connection.prepareStatement(consulta);
            productos = consultar(statement);
        } catch (SQLException ex) {
            Logger.getLogger(ProductoController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (conexion != null) {
                conexion.desconectar();
            }
        }
        return productos;
    }

    /**
     * Metodo para ejecutar la consulta de usuarios
     *
     * @param id_producto
     * @return Productos
     * @throws SQLException
     */
    private List<Productos> consultar(PreparedStatement statement) throws SQLException {
        List<Productos> productos = new ArrayList<>();
        ResultSet rs = statement.executeQuery();
        while (rs.next()) {
            Productos producto = new Productos(rs.getInt("id_producto"),
                    rs.getString("marca"),
                    rs.getString("modelo"),
                    rs.getString("nombre"),
                    rs.getFloat("precio"),
                    rs.getString("descripcion_adicional"),
                    rs.getInt("stock"),
                    rs.getBoolean("activo"),
                    rs.getString("categoria"),
                    rs.getString("url_imagen"));
            productos.add(producto);
        }
        return productos;
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
            statement.setString(9, producto.getUrlImagen());
            statement.setInt(10, producto.getId_producto());
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

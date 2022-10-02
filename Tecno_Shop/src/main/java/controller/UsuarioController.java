package controller;

import beans.Usuario;
import connection.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UsuarioController {

    private static final String INSERT = "INSERT INTO usuarios\n"
            + "  (numero_identificacion, \n"
            + "  nombre, \n"
            + "  apellido, \n"
            + "  email, \n"
            + "  telefono, \n"
            + "  direccion) \n"            
            + "VALUES \n"
            + "  (?, \n"
            + "  ?, \n"
            + "  ?, \n"
            + "  ?, \n"
            + "  ?, \n"
           
            + "  ?);";
    private static final String SELECT = "SELECT id_usuario, numero_identificacion, nombre, apellido, email, telefono, direccion FROM usuarios WHERE numero_identificacion = ?";
    private static final String UPDATE = "UPDATE usuarios\n"
            + "SET nombre = ?, apellido = ?, email = ?, telefono = ?, direccion = ? WHERE id_usuario = ?";

    public Usuario create(Usuario usuario) throws SQLException {
        DBConnection conexion = null;
        try {
            conexion = new DBConnection();
            Connection connection = conexion.getConnection();
            PreparedStatement statement = connection.prepareStatement(INSERT, PreparedStatement.RETURN_GENERATED_KEYS);
            statement.setInt(1, usuario.getNumeroIdentificacion());
            statement.setString(2, usuario.getNombre());
            statement.setString(3, usuario.getApellido());
            statement.setString(4, usuario.getEmail());
            statement.setString(5, usuario.getTelefono());
            statement.setString(6, usuario.getDireccion());
           // statement.setString(7, usuario.getContrasena());
            statement.executeUpdate();
            ResultSet rs = statement.getGeneratedKeys();
            if (rs.next()) {
                usuario.setId(rs.getInt(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (conexion != null) {
                conexion.desconectar();
            }
        }
        return usuario;
    }

    /**
     * Metodo para ejecutar la consulta de usuarios
     *
     * @param id
     * @return Usuario
     * @throws SQLException
     */
    public Usuario consultar(int numeroId) throws SQLException {
        DBConnection conexion = null;
        Usuario usuario = null;
        try {
            conexion = new DBConnection();
            Connection connection = conexion.getConnection();
            PreparedStatement statement = connection.prepareStatement(SELECT);
            statement.setInt(1, numeroId);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                usuario = new Usuario(rs.getInt("id_usuario"),
                        rs.getInt("numero_identificacion"),
                        rs.getString("nombre"),
                        rs.getString("apellido"),
                        rs.getString("email"),
                        rs.getString("telefono"),
                        rs.getString("direccion"),
                        null);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (conexion != null) {
                conexion.desconectar();
            }
        }
        return usuario;
    }

    public boolean modificar(Usuario usuario) {
        DBConnection conexion = null;
        int conteo = 0;
        try {
            conexion = new DBConnection();
            Connection connection = conexion.getConnection();
            PreparedStatement statement = connection.prepareStatement(UPDATE);            
            statement.setString(1, usuario.getNombre());
            statement.setString(2, usuario.getApellido());
            statement.setString(3, usuario.getEmail());
            statement.setString(4, usuario.getTelefono());
            statement.setString(5, usuario.getDireccion());
            //statement.setString(6, usuario.getContrasena());
            statement.setInt(6,usuario.getId() );
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

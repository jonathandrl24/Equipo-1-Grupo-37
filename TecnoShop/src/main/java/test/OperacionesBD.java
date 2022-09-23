package test;

import connection.DBConnection;
import java.sql.ResultSet;
import java.sql.Statement;

public class OperacionesBD {

    public static void main(String[] args) {
        //listarProducto();
        actualizarProductos(10, "ASUS");

    }

    public static void actualizarProductos(int stock, String modelo) {
        DBConnection con = new DBConnection();
        String sql = "UPDATE productos SET modelo = '" + modelo + "'WHERE stock = " + stock;

        try {
            Statement st = con.getConnection().createStatement();
            st.executeUpdate(sql);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());

        } finally {
            con.desconectar();
        }
        

    }
    

    public static void listarProducto() {

        DBConnection con = new DBConnection();
        String sql = "SELECT * FROM productos ";

        try {
            Statement st = con.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                int id_producto = rs.getInt("id_producto");
                String marca = rs.getString("marca");
                String modelo = rs.getString("modelo");
                String nombre = rs.getString("nombre");
                float precio = rs.getFloat("precio");
                String descripcion = rs.getString("descripcion");
                int stock = rs.getInt("stock");
                boolean activo = rs.getBoolean("activo");
                String categoria = rs.getString("categoria");

                Producto productos = new Producto(id_producto, marca, modelo, nombre, precio, descripcion_adicional, stock, activo, categoria);
                System.out.println(productos.toString());
            }
            st.executeQuery(sql);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            con.desconectar();
        }
}

    
}
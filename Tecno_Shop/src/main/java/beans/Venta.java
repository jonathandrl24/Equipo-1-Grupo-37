
package beans;

import java.util.Date;



public class Venta {
    
    private int id_venta;
    private Date fecha;
    private int id_producto;
    private float valor;
    private int cantidad;
    private int id_usuario;

    public Venta(int id_venta, Date fecha, int id_producto, float valor, int cantidad, int id_usuario) {
        this.id_venta = id_venta;
        this.fecha = fecha;
        this.id_producto = id_producto;
        this.valor = valor;
        this.cantidad = cantidad;
        this.id_usuario = id_usuario;
    }

    public int getId_venta() {
        return id_venta;
    }

    public void setId_venta(int id_venta) {
        this.id_venta = id_venta;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    @Override
    public String toString() {
        return "Venta{" + "id_venta=" + id_venta + ", fecha=" + fecha + ", id_producto=" + id_producto + ", valor=" + valor + ", cantidad=" + cantidad + ", id_usuario=" + id_usuario + '}';
    }
    
    
    
}

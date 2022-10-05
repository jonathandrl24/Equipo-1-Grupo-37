
package beans;


public class Productos {
    
    private int id_producto;
    private String marca;
    private String modelo;
    private String nombre;
    private float precio;
    private String descripcion_adicional;
    private int stock;
    private boolean activo;
    private String categoria;
    private String urlImagen;

    public Productos(int id_producto, String marca, String modelo, String nombre, float precio, String descripcion_adicional, int stock, boolean activo, String categoria, String urlImagen) {
        this.id_producto = id_producto;
        this.marca = marca;
        this.modelo = modelo;
        this.nombre = nombre;
        this.precio = precio;
        this.descripcion_adicional = descripcion_adicional;
        this.stock = stock;
        this.activo = activo;
        this.categoria = categoria;
        this.urlImagen = urlImagen;
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public String getDescripcion_adicional() {
        return descripcion_adicional;
    }

    public void setDescripcion_adicional(String descripcion_adicional) {
        this.descripcion_adicional = descripcion_adicional;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getUrlImagen() {
        return urlImagen;
    }

    public void setUrlImagen(String urlImagen) {
        this.urlImagen = urlImagen;
    }    

    @Override
    public String toString() {
        return "Productos{" + "id_producto=" + id_producto + ", marca=" + marca + ", modelo=" + modelo + ", nombre=" + nombre + ", precio=" + precio + ", descripcion_adicional=" + descripcion_adicional + ", stock=" + stock + ", activo=" + activo + ", categoria=" + categoria + '}';
    }
    
}
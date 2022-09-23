
package beans;


public class Usuarios {
    
    private int id_usuario;
    private int numero_identificacion;
    private String nombre;
    private String apellido;
    private String email;
    private String telefono;
    private String direccion;

    public Usuarios(int id_usuario, int numero_identificacion, String nombre, String apellido, String email, String telefono, String direccion) {
        this.id_usuario = id_usuario;
        this.numero_identificacion = numero_identificacion;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.telefono = telefono;
        this.direccion = direccion;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public int getNumero_identificacion() {
        return numero_identificacion;
    }

    public void setNumero_identificacion(int numero_identificacion) {
        this.numero_identificacion = numero_identificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return "Usuarios{" + "id_usuario=" + id_usuario + ", numero_identificacion=" + numero_identificacion + ", nombre=" + nombre + ", apellido=" + apellido + ", email=" + email + ", telefono=" + telefono + ", direccion=" + direccion + '}';
    }
    
    
    
}

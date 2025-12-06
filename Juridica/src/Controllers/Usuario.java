package Controllers;

public abstract class Usuario {

    protected int  cedula;
    protected String nombre;
    protected String apellido;
    protected String email;
    protected String telefono;
    protected String direccion;
    protected int edad;
    protected String contraseña;


    public Usuario(String apellido, int cedula, String direccion, int edad, String email, String nombre, String telefono) {
        this.apellido = apellido;
        this.cedula = cedula;
        this.direccion = direccion;
        this.edad = edad;
        this.email = email;
        this.nombre = nombre;
        this.telefono = telefono;
    }

    public abstract String getTipoUsuario();

    public Usuario() {
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}

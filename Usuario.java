import java.util.Date;

/**
 * Clase base para todos los usuarios del sistema
 * Representa un usuario genérico con sus datos básicos y credenciales
 */
public class Usuario {
    private String id;
    private String nombre;
    private String email;
    private String password;
    private String telefono;
    private Date fechaRegistro;
    private boolean activo;
    private String tipoUsuario; // "Rector", "Abogado", "Administrador"

    public Usuario() {
        this("", "", "", "", "", "Usuario");
    }

    public Usuario(String id, String nombre, String email, String password, String telefono, String tipoUsuario) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.password = password;
        this.telefono = telefono;
        this.tipoUsuario = tipoUsuario;
        this.fechaRegistro = new Date();
        this.activo = true;
    }

    /**
     * Valida las credenciales del usuario
     */
    public boolean validarCredenciales(String email, String password) {
        return this.email.equals(email) && this.password.equals(password) && this.activo;
    }

    /**
     * Cambia la contraseña del usuario
     */
    public boolean cambiarPassword(String passwordActual, String passwordNuevo) {
        if (this.password.equals(passwordActual)) {
            this.password = passwordNuevo;
            return true;
        }
        return false;
    }

    /**
     * Activa el usuario
     */
    public void activar() {
        this.activo = true;
    }

    /**
     * Desactiva el usuario
     */
    public void desactivar() {
        this.activo = false;
    }

    // Getters y Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }

    public Date getFechaRegistro() { return fechaRegistro; }
    public void setFechaRegistro(Date fechaRegistro) { this.fechaRegistro = fechaRegistro; }

    public boolean isActivo() { return activo; }
    public void setActivo(boolean activo) { this.activo = activo; }

    public String getTipoUsuario() { return tipoUsuario; }
    public void setTipoUsuario(String tipoUsuario) { this.tipoUsuario = tipoUsuario; }

    @Override
    public String toString() {
        return "Usuario: " + nombre + " (" + tipoUsuario + ") | Email: " + email + " | Activo: " + activo;
    }
}

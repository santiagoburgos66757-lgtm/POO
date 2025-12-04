/**
 * Representa una institución educativa que puede estar asociada a usuarios Rectores
 */
public class InstitucionEducativa {
    private String codigo;
    private String nombre;
    private String direccion;
    private String ciudad;
    private String pais;
    private String telefono;
    private String email;
    private String tipoInstitucion; // "Universidad", "Colegio", "Instituto", etc.
    private boolean activa;

    public InstitucionEducativa() {
        this("", "", "", "", "", "", "", "Universidad");
    }

    public InstitucionEducativa(String codigo, String nombre, String direccion, String ciudad, 
                               String pais, String telefono, String email, String tipoInstitucion) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.pais = pais;
        this.telefono = telefono;
        this.email = email;
        this.tipoInstitucion = tipoInstitucion;
        this.activa = true;
    }

    /**
     * Verifica si la institución está activa
     */
    public boolean estaActiva() {
        return activa;
    }

    /**
     * Activa la institución
     */
    public void activar() {
        this.activa = true;
    }

    /**
     * Desactiva la institución
     */
    public void desactivar() {
        this.activa = false;
    }

    // Getters y Setters
    public String getCodigo() { return codigo; }
    public void setCodigo(String codigo) { this.codigo = codigo; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }

    public String getCiudad() { return ciudad; }
    public void setCiudad(String ciudad) { this.ciudad = ciudad; }

    public String getPais() { return pais; }
    public void setPais(String pais) { this.pais = pais; }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getTipoInstitucion() { return tipoInstitucion; }
    public void setTipoInstitucion(String tipoInstitucion) { this.tipoInstitucion = tipoInstitucion; }

    public boolean isActiva() { return activa; }
    public void setActiva(boolean activa) { this.activa = activa; }

    @Override
    public String toString() {
        return nombre + " (" + tipoInstitucion + ") - " + ciudad + ", " + pais;
    }
}

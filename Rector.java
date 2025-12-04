/**
 * Representa un usuario Rector asociado a una institución educativa
 * Hereda de Usuario y agrega funcionalidad específica para rectores
 */
public class Rector extends Usuario {
    private InstitucionEducativa institucion;
    private String cargo;
    private String numeroIdentificacion;

    public Rector() {
        super();
        setTipoUsuario("Rector");
        this.institucion = null;
        this.cargo = "Rector";
        this.numeroIdentificacion = "";
    }

    public Rector(String id, String nombre, String email, String password, String telefono,
                  InstitucionEducativa institucion, String cargo, String numeroIdentificacion) {
        super(id, nombre, email, password, telefono, "Rector");
        this.institucion = institucion;
        this.cargo = cargo;
        this.numeroIdentificacion = numeroIdentificacion;
    }

    /**
     * Asocia el rector con una institución educativa
     */
    public boolean asociarInstitucion(InstitucionEducativa institucion) {
        if (institucion != null && institucion.isActiva()) {
            this.institucion = institucion;
            return true;
        }
        return false;
    }

    /**
     * Verifica si el rector tiene una institución asociada
     */
    public boolean tieneInstitucionAsociada() {
        return this.institucion != null;
    }

    // Getters y Setters
    public InstitucionEducativa getInstitucion() { return institucion; }
    public void setInstitucion(InstitucionEducativa institucion) { this.institucion = institucion; }

    public String getCargo() { return cargo; }
    public void setCargo(String cargo) { this.cargo = cargo; }

    public String getNumeroIdentificacion() { return numeroIdentificacion; }
    public void setNumeroIdentificacion(String numeroIdentificacion) { 
        this.numeroIdentificacion = numeroIdentificacion; 
    }

    @Override
    public String toString() {
        String inst = (institucion != null) ? institucion.getNombre() : "Sin institución";
        return super.toString() + " | Institución: " + inst;
    }
}

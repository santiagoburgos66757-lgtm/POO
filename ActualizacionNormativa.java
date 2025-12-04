import java.util.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * Representa una actualización normativa en el sistema
 * Registra cambios en normas y jurisprudencias
 */
public class ActualizacionNormativa {
    private String id;
    private String tipo; // "Nueva norma", "Modificación", "Derogación", "Nueva jurisprudencia"
    private String normaId; // ID de la norma o jurisprudencia afectada
    private Date fechaActualizacion;
    private String descripcion;
    private String cambiosRealizados;
    private String fuenteActualizacion; // De dónde proviene la actualización
    private boolean aplicada;
    private boolean notificadaUsuarios;
    private List<String> areasAfectadas;

    public ActualizacionNormativa() {
        this("", "Modificación", "", "");
    }

    public ActualizacionNormativa(String id, String tipo, String normaId, String descripcion) {
        this.id = id;
        this.tipo = tipo;
        this.normaId = normaId;
        this.descripcion = descripcion;
        this.fechaActualizacion = new Date();
        this.cambiosRealizados = "";
        this.fuenteActualizacion = "";
        this.aplicada = false;
        this.notificadaUsuarios = false;
        this.areasAfectadas = new ArrayList<>();
    }

    /**
     * Marca la actualización como aplicada
     */
    public boolean aplicar() {
        if (!aplicada) {
            this.aplicada = true;
            this.fechaActualizacion = new Date();
            return true;
        }
        return false;
    }

    /**
     * Notifica a los usuarios sobre la actualización
     */
    public void notificarUsuarios() {
        this.notificadaUsuarios = true;
    }

    /**
     * Agrega un área afectada por la actualización
     */
    public boolean agregarAreaAfectada(String area) {
        if (area != null && !area.isEmpty() && !areasAfectadas.contains(area)) {
            areasAfectadas.add(area);
            return true;
        }
        return false;
    }

    /**
     * Verifica si la actualización requiere notificación urgente
     */
    public boolean esUrgente() {
        return tipo.equals("Derogación") || tipo.equals("Modificación");
    }

    // Getters y Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public String getNormaId() { return normaId; }
    public void setNormaId(String normaId) { this.normaId = normaId; }

    public Date getFechaActualizacion() { return fechaActualizacion; }
    public void setFechaActualizacion(Date fechaActualizacion) { 
        this.fechaActualizacion = fechaActualizacion; 
    }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public String getCambiosRealizados() { return cambiosRealizados; }
    public void setCambiosRealizados(String cambiosRealizados) { 
        this.cambiosRealizados = cambiosRealizados; 
    }

    public String getFuenteActualizacion() { return fuenteActualizacion; }
    public void setFuenteActualizacion(String fuenteActualizacion) { 
        this.fuenteActualizacion = fuenteActualizacion; 
    }

    public boolean isAplicada() { return aplicada; }
    public void setAplicada(boolean aplicada) { this.aplicada = aplicada; }

    public boolean isNotificadaUsuarios() { return notificadaUsuarios; }
    public void setNotificadaUsuarios(boolean notificadaUsuarios) { 
        this.notificadaUsuarios = notificadaUsuarios; 
    }

    public List<String> getAreasAfectadas() { return new ArrayList<>(areasAfectadas); }
    public void setAreasAfectadas(List<String> areasAfectadas) { 
        this.areasAfectadas = new ArrayList<>(areasAfectadas); 
    }

    @Override
    public String toString() {
        return "Actualización " + tipo + " | " + descripcion + 
               " | Aplicada: " + aplicada + " | Notificada: " + notificadaUsuarios;
    }
}

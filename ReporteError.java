import java.util.Date;

/**
 * Representa un reporte de error sobre una respuesta de consulta
 * Permite a los usuarios señalar problemas o inexactitudes
 */
public class ReporteError {
    private String id;
    private String consultaId;
    private String usuarioId;
    private String tipoError; // "Inexacto", "Alucinación", "Referencia inválida", "Desactualizado", etc.
    private String descripcion;
    private Date fechaReporte;
    private String estado; // "Nuevo", "En revisión", "Resuelto", "Descartado"
    private String prioridad; // "Alta", "Media", "Baja"
    private String resolucion;
    private Date fechaResolucion;

    public ReporteError() {
        this("", "", "", "Inexacto", "");
    }

    public ReporteError(String id, String consultaId, String usuarioId, 
                       String tipoError, String descripcion) {
        this.id = id;
        this.consultaId = consultaId;
        this.usuarioId = usuarioId;
        this.tipoError = tipoError;
        this.descripcion = descripcion;
        this.fechaReporte = new Date();
        this.estado = "Nuevo";
        this.prioridad = calcularPrioridad(tipoError);
        this.resolucion = "";
        this.fechaResolucion = null;
    }

    /**
     * Calcula la prioridad basada en el tipo de error
     */
    private String calcularPrioridad(String tipoError) {
        switch (tipoError) {
            case "Alucinación":
            case "Referencia inválida":
                return "Alta";
            case "Inexacto":
            case "Desactualizado":
                return "Media";
            default:
                return "Baja";
        }
    }

    /**
     * Marca el reporte como en revisión
     */
    public void marcarEnRevision() {
        if (estado.equals("Nuevo")) {
            this.estado = "En revisión";
        }
    }

    /**
     * Resuelve el reporte
     */
    public boolean resolver(String resolucion) {
        if (!estado.equals("Resuelto") && !estado.equals("Descartado")) {
            this.estado = "Resuelto";
            this.resolucion = resolucion;
            this.fechaResolucion = new Date();
            return true;
        }
        return false;
    }

    /**
     * Descarta el reporte
     */
    public boolean descartar(String razon) {
        if (!estado.equals("Resuelto") && !estado.equals("Descartado")) {
            this.estado = "Descartado";
            this.resolucion = razon;
            this.fechaResolucion = new Date();
            return true;
        }
        return false;
    }

    /**
     * Verifica si el reporte está pendiente
     */
    public boolean estaPendiente() {
        return estado.equals("Nuevo") || estado.equals("En revisión");
    }

    /**
     * Verifica si es un error crítico
     */
    public boolean esCritico() {
        return prioridad.equals("Alta");
    }

    // Getters y Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getConsultaId() { return consultaId; }
    public void setConsultaId(String consultaId) { this.consultaId = consultaId; }

    public String getUsuarioId() { return usuarioId; }
    public void setUsuarioId(String usuarioId) { this.usuarioId = usuarioId; }

    public String getTipoError() { return tipoError; }
    public void setTipoError(String tipoError) { 
        this.tipoError = tipoError;
        this.prioridad = calcularPrioridad(tipoError);
    }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public Date getFechaReporte() { return fechaReporte; }
    public void setFechaReporte(Date fechaReporte) { this.fechaReporte = fechaReporte; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

    public String getPrioridad() { return prioridad; }
    public void setPrioridad(String prioridad) { this.prioridad = prioridad; }

    public String getResolucion() { return resolucion; }
    public void setResolucion(String resolucion) { this.resolucion = resolucion; }

    public Date getFechaResolucion() { return fechaResolucion; }
    public void setFechaResolucion(Date fechaResolucion) { this.fechaResolucion = fechaResolucion; }

    @Override
    public String toString() {
        return "Reporte #" + id + " | Tipo: " + tipoError + " | Prioridad: " + prioridad + 
               " | Estado: " + estado;
    }
}

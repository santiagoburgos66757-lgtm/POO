import java.util.Date;

/**
 * Representa una solicitud de revisión humana para documentos o consultas
 */
public class SolicitudRevision {
    private String id;
    private String tipo; // "Documento", "Consulta", "Plantilla"
    private String elementoId; // ID del elemento a revisar
    private String solicitanteId;
    private String abogadoRevisorId;
    private Date fechaSolicitud;
    private String prioridad; // "Alta", "Media", "Baja"
    private String motivo;
    private String estado; // "Pendiente", "Asignada", "En revisión", "Completada", "Rechazada"
    private String observaciones;

    public SolicitudRevision() {
        this("", "Documento", "", "", "Media", "");
    }

    public SolicitudRevision(String id, String tipo, String elementoId, String solicitanteId,
                            String prioridad, String motivo) {
        this.id = id;
        this.tipo = tipo;
        this.elementoId = elementoId;
        this.solicitanteId = solicitanteId;
        this.prioridad = prioridad;
        this.motivo = motivo;
        this.fechaSolicitud = new Date();
        this.estado = "Pendiente";
        this.abogadoRevisorId = "";
        this.observaciones = "";
    }

    /**
     * Asigna la solicitud a un abogado revisor
     */
    public boolean asignarRevisor(String abogadoId) {
        if (estado.equals("Pendiente") && !abogadoId.isEmpty()) {
            this.abogadoRevisorId = abogadoId;
            this.estado = "Asignada";
            return true;
        }
        return false;
    }

    /**
     * Inicia la revisión
     */
    public boolean iniciarRevision() {
        if (estado.equals("Asignada")) {
            this.estado = "En revisión";
            return true;
        }
        return false;
    }

    /**
     * Completa la revisión
     */
    public boolean completar(String observaciones) {
        if (estado.equals("En revisión")) {
            this.estado = "Completada";
            this.observaciones = observaciones;
            return true;
        }
        return false;
    }

    /**
     * Rechaza la solicitud
     */
    public boolean rechazar(String motivo) {
        if (!estado.equals("Completada")) {
            this.estado = "Rechazada";
            this.observaciones = motivo;
            return true;
        }
        return false;
    }

    /**
     * Verifica si la solicitud está pendiente
     */
    public boolean estaPendiente() {
        return estado.equals("Pendiente") || estado.equals("Asignada");
    }

    /**
     * Verifica si es de alta prioridad
     */
    public boolean esUrgente() {
        return prioridad.equals("Alta");
    }

    // Getters y Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public String getElementoId() { return elementoId; }
    public void setElementoId(String elementoId) { this.elementoId = elementoId; }

    public String getSolicitanteId() { return solicitanteId; }
    public void setSolicitanteId(String solicitanteId) { this.solicitanteId = solicitanteId; }

    public String getAbogadoRevisorId() { return abogadoRevisorId; }
    public void setAbogadoRevisorId(String abogadoRevisorId) { this.abogadoRevisorId = abogadoRevisorId; }

    public Date getFechaSolicitud() { return fechaSolicitud; }
    public void setFechaSolicitud(Date fechaSolicitud) { this.fechaSolicitud = fechaSolicitud; }

    public String getPrioridad() { return prioridad; }
    public void setPrioridad(String prioridad) { this.prioridad = prioridad; }

    public String getMotivo() { return motivo; }
    public void setMotivo(String motivo) { this.motivo = motivo; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

    public String getObservaciones() { return observaciones; }
    public void setObservaciones(String observaciones) { this.observaciones = observaciones; }

    @Override
    public String toString() {
        return "Solicitud #" + id + " (" + tipo + ") | Prioridad: " + prioridad + 
               " | Estado: " + estado;
    }
}

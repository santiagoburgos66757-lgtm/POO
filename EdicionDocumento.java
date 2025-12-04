import java.util.Date;

/**
 * Representa una sesión de edición de un documento jurídico
 * Rastrea cambios realizados durante la edición
 */
public class EdicionDocumento {
    private String id;
    private String documentoId;
    private String usuarioId;
    private Date fechaInicio;
    private Date fechaFin;
    private String tipoEdicion; // "Creación", "Modificación", "Revisión", "Corrección"
    private String descripcionCambios;
    private String versionAnterior;
    private String versionNueva;
    private boolean guardado;

    public EdicionDocumento() {
        this("", "", "", "Modificación");
    }

    public EdicionDocumento(String id, String documentoId, String usuarioId, String tipoEdicion) {
        this.id = id;
        this.documentoId = documentoId;
        this.usuarioId = usuarioId;
        this.tipoEdicion = tipoEdicion;
        this.fechaInicio = new Date();
        this.fechaFin = null;
        this.descripcionCambios = "";
        this.versionAnterior = "";
        this.versionNueva = "";
        this.guardado = false;
    }

    /**
     * Finaliza la sesión de edición
     */
    public void finalizar(String descripcionCambios) {
        this.fechaFin = new Date();
        this.descripcionCambios = descripcionCambios;
        this.guardado = true;
    }

    /**
     * Calcula la duración de la edición en minutos
     */
    public long getDuracionMinutos() {
        if (fechaFin == null) {
            return (new Date().getTime() - fechaInicio.getTime()) / (60 * 1000);
        }
        return (fechaFin.getTime() - fechaInicio.getTime()) / (60 * 1000);
    }

    /**
     * Verifica si la edición está activa (no finalizada)
     */
    public boolean estaActiva() {
        return fechaFin == null;
    }

    // Getters y Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getDocumentoId() { return documentoId; }
    public void setDocumentoId(String documentoId) { this.documentoId = documentoId; }

    public String getUsuarioId() { return usuarioId; }
    public void setUsuarioId(String usuarioId) { this.usuarioId = usuarioId; }

    public Date getFechaInicio() { return fechaInicio; }
    public void setFechaInicio(Date fechaInicio) { this.fechaInicio = fechaInicio; }

    public Date getFechaFin() { return fechaFin; }
    public void setFechaFin(Date fechaFin) { this.fechaFin = fechaFin; }

    public String getTipoEdicion() { return tipoEdicion; }
    public void setTipoEdicion(String tipoEdicion) { this.tipoEdicion = tipoEdicion; }

    public String getDescripcionCambios() { return descripcionCambios; }
    public void setDescripcionCambios(String descripcionCambios) { 
        this.descripcionCambios = descripcionCambios; 
    }

    public String getVersionAnterior() { return versionAnterior; }
    public void setVersionAnterior(String versionAnterior) { this.versionAnterior = versionAnterior; }

    public String getVersionNueva() { return versionNueva; }
    public void setVersionNueva(String versionNueva) { this.versionNueva = versionNueva; }

    public boolean isGuardado() { return guardado; }
    public void setGuardado(boolean guardado) { this.guardado = guardado; }

    @Override
    public String toString() {
        String estado = estaActiva() ? "En curso" : "Finalizada";
        return "Edición " + tipoEdicion + " | " + estado + " | Duración: " + getDuracionMinutos() + " min";
    }
}

import java.util.Date;

/**
 * Representa una revisión realizada por un abogado
 */
public class Revision {
    private String id;
    private String solicitudRevisionId;
    private String abogadoId;
    private String elementoRevisadoId;
    private Date fechaInicio;
    private Date fechaFin;
    private String resultado; // "Aprobado", "Aprobado con cambios", "Rechazado"
    private String comentarios;
    private String cambiosSugeridos;
    private boolean requiereCambios;
    private int tiempoRevisionMinutos;

    public Revision() {
        this("", "", "", "");
    }

    public Revision(String id, String solicitudRevisionId, String abogadoId, 
                   String elementoRevisadoId) {
        this.id = id;
        this.solicitudRevisionId = solicitudRevisionId;
        this.abogadoId = abogadoId;
        this.elementoRevisadoId = elementoRevisadoId;
        this.fechaInicio = new Date();
        this.fechaFin = null;
        this.resultado = "";
        this.comentarios = "";
        this.cambiosSugeridos = "";
        this.requiereCambios = false;
        this.tiempoRevisionMinutos = 0;
    }

    /**
     * Finaliza la revisión con un resultado
     */
    public void finalizar(String resultado, String comentarios) {
        this.fechaFin = new Date();
        this.resultado = resultado;
        this.comentarios = comentarios;
        calcularTiempoRevision();
        
        if (resultado.equals("Aprobado con cambios") || resultado.equals("Rechazado")) {
            this.requiereCambios = true;
        }
    }

    /**
     * Calcula el tiempo de revisión
     */
    private void calcularTiempoRevision() {
        if (fechaFin != null) {
            long diferencia = fechaFin.getTime() - fechaInicio.getTime();
            this.tiempoRevisionMinutos = (int) (diferencia / (60 * 1000));
        }
    }

    /**
     * Aprueba la revisión
     */
    public void aprobar(String comentarios) {
        finalizar("Aprobado", comentarios);
    }

    /**
     * Aprueba con cambios sugeridos
     */
    public void aprobarConCambios(String comentarios, String cambiosSugeridos) {
        this.cambiosSugeridos = cambiosSugeridos;
        finalizar("Aprobado con cambios", comentarios);
    }

    /**
     * Rechaza la revisión
     */
    public void rechazar(String comentarios) {
        finalizar("Rechazado", comentarios);
    }

    /**
     * Verifica si la revisión está completada
     */
    public boolean estaCompletada() {
        return fechaFin != null && !resultado.isEmpty();
    }

    /**
     * Verifica si fue aprobada
     */
    public boolean fueAprobada() {
        return resultado.equals("Aprobado") || resultado.equals("Aprobado con cambios");
    }

    // Getters y Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getSolicitudRevisionId() { return solicitudRevisionId; }
    public void setSolicitudRevisionId(String solicitudRevisionId) { 
        this.solicitudRevisionId = solicitudRevisionId; 
    }

    public String getAbogadoId() { return abogadoId; }
    public void setAbogadoId(String abogadoId) { this.abogadoId = abogadoId; }

    public String getElementoRevisadoId() { return elementoRevisadoId; }
    public void setElementoRevisadoId(String elementoRevisadoId) { 
        this.elementoRevisadoId = elementoRevisadoId; 
    }

    public Date getFechaInicio() { return fechaInicio; }
    public void setFechaInicio(Date fechaInicio) { this.fechaInicio = fechaInicio; }

    public Date getFechaFin() { return fechaFin; }
    public void setFechaFin(Date fechaFin) { this.fechaFin = fechaFin; }

    public String getResultado() { return resultado; }
    public void setResultado(String resultado) { this.resultado = resultado; }

    public String getComentarios() { return comentarios; }
    public void setComentarios(String comentarios) { this.comentarios = comentarios; }

    public String getCambiosSugeridos() { return cambiosSugeridos; }
    public void setCambiosSugeridos(String cambiosSugeridos) { 
        this.cambiosSugeridos = cambiosSugeridos; 
    }

    public boolean isRequiereCambios() { return requiereCambios; }
    public void setRequiereCambios(boolean requiereCambios) { this.requiereCambios = requiereCambios; }

    public int getTiempoRevisionMinutos() { return tiempoRevisionMinutos; }
    public void setTiempoRevisionMinutos(int tiempoRevisionMinutos) { 
        if (tiempoRevisionMinutos >= 0) this.tiempoRevisionMinutos = tiempoRevisionMinutos; 
    }

    @Override
    public String toString() {
        String estado = estaCompletada() ? "Completada" : "En proceso";
        return "Revisión #" + id + " | Estado: " + estado + " | Resultado: " + resultado + 
               " | Tiempo: " + tiempoRevisionMinutos + " min";
    }
}

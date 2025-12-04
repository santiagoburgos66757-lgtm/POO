import java.util.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * Representa una consulta jurídica realizada por un usuario
 * Gestiona la pregunta, respuesta y referencias asociadas
 */
public class ConsultaJuridica {
    private String id;
    private String usuarioId;
    private String pregunta;
    private Date fechaConsulta;
    private String categoria; // "Legislación educativa", "Laboral", "Civil", etc.
    private String estado; // "Pendiente", "Procesada", "Revisada", "Cerrada"
    private RespuestaIA respuesta;
    private List<ReferenciaNormativa> referencias;
    private boolean requiereRevisionHumana;
    private int tiempoRespuestaSegundos;

    public ConsultaJuridica() {
        this("", "", "", "General");
    }

    public ConsultaJuridica(String id, String usuarioId, String pregunta, String categoria) {
        this.id = id;
        this.usuarioId = usuarioId;
        this.pregunta = pregunta;
        this.categoria = categoria;
        this.fechaConsulta = new Date();
        this.estado = "Pendiente";
        this.respuesta = null;
        this.referencias = new ArrayList<>();
        this.requiereRevisionHumana = false;
        this.tiempoRespuestaSegundos = 0;
    }

    /**
     * Asigna una respuesta de IA a la consulta
     */
    public boolean asignarRespuesta(RespuestaIA respuesta) {
        if (respuesta != null) {
            this.respuesta = respuesta;
            this.estado = "Procesada";
            return true;
        }
        return false;
    }

    /**
     * Agrega una referencia normativa a la consulta
     */
    public boolean agregarReferencia(ReferenciaNormativa referencia) {
        if (referencia != null && !referencias.contains(referencia)) {
            referencias.add(referencia);
            return true;
        }
        return false;
    }

    /**
     * Marca la consulta como que requiere revisión humana
     */
    public void marcarParaRevision() {
        this.requiereRevisionHumana = true;
    }

    /**
     * Marca la consulta como revisada
     */
    public void marcarComoRevisada() {
        this.estado = "Revisada";
    }

    /**
     * Cierra la consulta
     */
    public void cerrar() {
        this.estado = "Cerrada";
    }

    /**
     * Verifica si la consulta tiene respuesta
     */
    public boolean tieneRespuesta() {
        return this.respuesta != null;
    }

    /**
     * Obtiene el número de referencias asociadas
     */
    public int cantidadReferencias() {
        return referencias.size();
    }

    /**
     * Registra el tiempo de respuesta
     */
    public void registrarTiempoRespuesta(int segundos) {
        this.tiempoRespuestaSegundos = Math.max(0, segundos);
    }

    // Getters y Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getUsuarioId() { return usuarioId; }
    public void setUsuarioId(String usuarioId) { this.usuarioId = usuarioId; }

    public String getPregunta() { return pregunta; }
    public void setPregunta(String pregunta) { this.pregunta = pregunta; }

    public Date getFechaConsulta() { return fechaConsulta; }
    public void setFechaConsulta(Date fechaConsulta) { this.fechaConsulta = fechaConsulta; }

    public String getCategoria() { return categoria; }
    public void setCategoria(String categoria) { this.categoria = categoria; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

    public RespuestaIA getRespuesta() { return respuesta; }
    public void setRespuesta(RespuestaIA respuesta) { this.respuesta = respuesta; }

    public List<ReferenciaNormativa> getReferencias() { return new ArrayList<>(referencias); }
    public void setReferencias(List<ReferenciaNormativa> referencias) { 
        this.referencias = new ArrayList<>(referencias); 
    }

    public boolean isRequiereRevisionHumana() { return requiereRevisionHumana; }
    public void setRequiereRevisionHumana(boolean requiereRevisionHumana) { 
        this.requiereRevisionHumana = requiereRevisionHumana; 
    }

    public int getTiempoRespuestaSegundos() { return tiempoRespuestaSegundos; }
    public void setTiempoRespuestaSegundos(int tiempoRespuestaSegundos) { 
        if (tiempoRespuestaSegundos >= 0) this.tiempoRespuestaSegundos = tiempoRespuestaSegundos; 
    }

    @Override
    public String toString() {
        return "Consulta #" + id + " | Categoría: " + categoria + " | Estado: " + estado + 
               " | Referencias: " + referencias.size();
    }
}

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Representa un reporte generado en el sistema
 * Gestiona diferentes tipos de reportes y métricas
 */
public class Reporte {
    private String id;
    private String titulo;
    private String tipo; // "Consultas", "Documentos", "Usuarios", "Calidad IA", "Uso del sistema"
    private Date fechaGeneracion;
    private Date fechaInicio; // Período del reporte
    private Date fechaFin;
    private String generadoPorId;
    private Map<String, Object> metricas;
    private String formato; // "PDF", "Excel", "JSON"
    private String urlDescarga;
    private boolean publico;

    public Reporte() {
        this("", "", "Consultas", "");
    }

    public Reporte(String id, String titulo, String tipo, String generadoPorId) {
        this.id = id;
        this.titulo = titulo;
        this.tipo = tipo;
        this.generadoPorId = generadoPorId;
        this.fechaGeneracion = new Date();
        this.fechaInicio = new Date();
        this.fechaFin = new Date();
        this.metricas = new HashMap<>();
        this.formato = "PDF";
        this.urlDescarga = "";
        this.publico = false;
    }

    /**
     * Agrega una métrica al reporte
     */
    public void agregarMetrica(String nombre, Object valor) {
        metricas.put(nombre, valor);
    }

    /**
     * Obtiene una métrica del reporte
     */
    public Object obtenerMetrica(String nombre) {
        return metricas.get(nombre);
    }

    /**
     * Genera el reporte (simula la generación)
     */
    public boolean generar() {
        this.fechaGeneracion = new Date();
        this.urlDescarga = "/reportes/" + id + "." + formato.toLowerCase();
        return true;
    }

    /**
     * Establece el período del reporte
     */
    public void setPeriodo(Date fechaInicio, Date fechaFin) {
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    /**
     * Verifica si el reporte está disponible
     */
    public boolean estaDisponible() {
        return !urlDescarga.isEmpty();
    }

    /**
     * Obtiene un resumen de las métricas
     */
    public String obtenerResumenMetricas() {
        StringBuilder resumen = new StringBuilder();
        for (Map.Entry<String, Object> entry : metricas.entrySet()) {
            resumen.append(entry.getKey()).append(": ").append(entry.getValue()).append(" | ");
        }
        return resumen.toString();
    }

    // Getters y Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public Date getFechaGeneracion() { return fechaGeneracion; }
    public void setFechaGeneracion(Date fechaGeneracion) { this.fechaGeneracion = fechaGeneracion; }

    public Date getFechaInicio() { return fechaInicio; }
    public void setFechaInicio(Date fechaInicio) { this.fechaInicio = fechaInicio; }

    public Date getFechaFin() { return fechaFin; }
    public void setFechaFin(Date fechaFin) { this.fechaFin = fechaFin; }

    public String getGeneradoPorId() { return generadoPorId; }
    public void setGeneradoPorId(String generadoPorId) { this.generadoPorId = generadoPorId; }

    public Map<String, Object> getMetricas() { return new HashMap<>(metricas); }
    public void setMetricas(Map<String, Object> metricas) { this.metricas = new HashMap<>(metricas); }

    public String getFormato() { return formato; }
    public void setFormato(String formato) { this.formato = formato; }

    public String getUrlDescarga() { return urlDescarga; }
    public void setUrlDescarga(String urlDescarga) { this.urlDescarga = urlDescarga; }

    public boolean isPublico() { return publico; }
    public void setPublico(boolean publico) { this.publico = publico; }

    @Override
    public String toString() {
        return "Reporte: " + titulo + " (" + tipo + ") | Métricas: " + metricas.size() + 
               " | Formato: " + formato;
    }
}

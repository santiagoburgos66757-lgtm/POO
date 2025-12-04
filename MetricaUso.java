import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Gestiona métricas de uso del sistema
 * Registra estadísticas de actividad de usuarios y recursos
 */
public class MetricaUso {
    private String id;
    private Date fecha;
    private String tipoMetrica; // "Consultas", "Documentos", "Sesiones", "Recursos"
    private Map<String, Integer> contadores;
    private Map<String, Double> promedios;
    private int usuariosActivos;
    private int consultasRealizadas;
    private int documentosGenerados;
    private int revisionesCompletadas;
    private double tiempoPromedioRespuesta; // en segundos

    public MetricaUso() {
        this("", "Consultas");
    }

    public MetricaUso(String id, String tipoMetrica) {
        this.id = id;
        this.tipoMetrica = tipoMetrica;
        this.fecha = new Date();
        this.contadores = new HashMap<>();
        this.promedios = new HashMap<>();
        this.usuariosActivos = 0;
        this.consultasRealizadas = 0;
        this.documentosGenerados = 0;
        this.revisionesCompletadas = 0;
        this.tiempoPromedioRespuesta = 0.0;
        inicializarContadores();
    }

    /**
     * Inicializa los contadores básicos
     */
    private void inicializarContadores() {
        contadores.put("total", 0);
        contadores.put("exitosos", 0);
        contadores.put("fallidos", 0);
        promedios.put("calidad", 0.0);
        promedios.put("satisfaccion", 0.0);
    }

    /**
     * Incrementa un contador específico
     */
    public void incrementarContador(String nombreContador, int cantidad) {
        int valorActual = contadores.getOrDefault(nombreContador, 0);
        contadores.put(nombreContador, valorActual + cantidad);
    }

    /**
     * Registra un promedio
     */
    public void registrarPromedio(String nombrePromedio, double valor) {
        promedios.put(nombrePromedio, valor);
    }

    /**
     * Registra actividad de consulta
     */
    public void registrarConsulta(boolean exitosa, double tiempoRespuesta) {
        consultasRealizadas++;
        incrementarContador("total", 1);
        if (exitosa) {
            incrementarContador("exitosos", 1);
        } else {
            incrementarContador("fallidos", 1);
        }
        
        // Actualizar promedio de tiempo de respuesta
        tiempoPromedioRespuesta = ((tiempoPromedioRespuesta * (consultasRealizadas - 1)) + 
                                   tiempoRespuesta) / consultasRealizadas;
    }

    /**
     * Registra generación de documento
     */
    public void registrarDocumento() {
        documentosGenerados++;
        incrementarContador("total", 1);
    }

    /**
     * Registra revisión completada
     */
    public void registrarRevision() {
        revisionesCompletadas++;
        incrementarContador("total", 1);
    }

    /**
     * Calcula la tasa de éxito
     */
    public double calcularTasaExito() {
        int total = contadores.getOrDefault("total", 0);
        if (total == 0) return 0.0;
        int exitosos = contadores.getOrDefault("exitosos", 0);
        return (double) exitosos / total * 100.0;
    }

    /**
     * Obtiene un resumen de las métricas
     */
    public String obtenerResumen() {
        return "Usuarios activos: " + usuariosActivos + 
               " | Consultas: " + consultasRealizadas + 
               " | Documentos: " + documentosGenerados + 
               " | Revisiones: " + revisionesCompletadas + 
               " | Tasa éxito: " + String.format("%.2f", calcularTasaExito()) + "%";
    }

    // Getters y Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public Date getFecha() { return fecha; }
    public void setFecha(Date fecha) { this.fecha = fecha; }

    public String getTipoMetrica() { return tipoMetrica; }
    public void setTipoMetrica(String tipoMetrica) { this.tipoMetrica = tipoMetrica; }

    public Map<String, Integer> getContadores() { return new HashMap<>(contadores); }
    public void setContadores(Map<String, Integer> contadores) { 
        this.contadores = new HashMap<>(contadores); 
    }

    public Map<String, Double> getPromedios() { return new HashMap<>(promedios); }
    public void setPromedios(Map<String, Double> promedios) { 
        this.promedios = new HashMap<>(promedios); 
    }

    public int getUsuariosActivos() { return usuariosActivos; }
    public void setUsuariosActivos(int usuariosActivos) { 
        if (usuariosActivos >= 0) this.usuariosActivos = usuariosActivos; 
    }

    public int getConsultasRealizadas() { return consultasRealizadas; }
    public void setConsultasRealizadas(int consultasRealizadas) { 
        if (consultasRealizadas >= 0) this.consultasRealizadas = consultasRealizadas; 
    }

    public int getDocumentosGenerados() { return documentosGenerados; }
    public void setDocumentosGenerados(int documentosGenerados) { 
        if (documentosGenerados >= 0) this.documentosGenerados = documentosGenerados; 
    }

    public int getRevisionesCompletadas() { return revisionesCompletadas; }
    public void setRevisionesCompletadas(int revisionesCompletadas) { 
        if (revisionesCompletadas >= 0) this.revisionesCompletadas = revisionesCompletadas; 
    }

    public double getTiempoPromedioRespuesta() { return tiempoPromedioRespuesta; }
    public void setTiempoPromedioRespuesta(double tiempoPromedioRespuesta) { 
        if (tiempoPromedioRespuesta >= 0) this.tiempoPromedioRespuesta = tiempoPromedioRespuesta; 
    }

    @Override
    public String toString() {
        return "Métrica de Uso (" + tipoMetrica + ") | " + obtenerResumen();
    }
}

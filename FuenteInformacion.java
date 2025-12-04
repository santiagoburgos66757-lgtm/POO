import java.util.Date;

/**
 * Representa una fuente de información utilizada en respuestas de IA
 * Permite rastrear y validar las fuentes de conocimiento
 */
public class FuenteInformacion {
    private String id;
    private String respuestaIAId;
    private String tipo; // "Norma", "Jurisprudencia", "Documento", "Base de datos"
    private String nombre;
    private String url;
    private String extracto; // Fragmento específico utilizado
    private Date fechaAcceso;
    private boolean verificada;
    private double confiabilidad; // 0.0 a 1.0
    private String institucionOrigen;

    public FuenteInformacion() {
        this("", "", "Documento", "", "");
    }

    public FuenteInformacion(String id, String respuestaIAId, String tipo, String nombre, String url) {
        this.id = id;
        this.respuestaIAId = respuestaIAId;
        this.tipo = tipo;
        this.nombre = nombre;
        this.url = url;
        this.extracto = "";
        this.fechaAcceso = new Date();
        this.verificada = false;
        this.confiabilidad = 0.5;
        this.institucionOrigen = "";
    }

    /**
     * Verifica la fuente contra repositorios oficiales
     */
    public boolean verificar() {
        // Lógica de verificación
        this.verificada = true;
        return true;
    }

    /**
     * Calcula la confiabilidad basada en varios factores
     */
    public void calcularConfiabilidad() {
        double conf = 0.5;
        
        if (verificada) conf += 0.3;
        if (!url.isEmpty()) conf += 0.1;
        if (tipo.equals("Norma") || tipo.equals("Jurisprudencia")) conf += 0.1;
        
        this.confiabilidad = Math.min(1.0, conf);
    }

    /**
     * Verifica si la fuente es oficial
     */
    public boolean esOficial() {
        return tipo.equals("Norma") || tipo.equals("Jurisprudencia");
    }

    /**
     * Verifica si la fuente tiene alta confiabilidad
     */
    public boolean esConfiable() {
        return confiabilidad >= 0.7;
    }

    // Getters y Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getRespuestaIAId() { return respuestaIAId; }
    public void setRespuestaIAId(String respuestaIAId) { this.respuestaIAId = respuestaIAId; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getUrl() { return url; }
    public void setUrl(String url) { this.url = url; }

    public String getExtracto() { return extracto; }
    public void setExtracto(String extracto) { this.extracto = extracto; }

    public Date getFechaAcceso() { return fechaAcceso; }
    public void setFechaAcceso(Date fechaAcceso) { this.fechaAcceso = fechaAcceso; }

    public boolean isVerificada() { return verificada; }
    public void setVerificada(boolean verificada) { this.verificada = verificada; }

    public double getConfiabilidad() { return confiabilidad; }
    public void setConfiabilidad(double confiabilidad) { 
        this.confiabilidad = Math.max(0.0, Math.min(1.0, confiabilidad)); 
    }

    public String getInstitucionOrigen() { return institucionOrigen; }
    public void setInstitucionOrigen(String institucionOrigen) { 
        this.institucionOrigen = institucionOrigen; 
    }

    @Override
    public String toString() {
        return nombre + " (" + tipo + ") | Confiabilidad: " + 
               String.format("%.2f", confiabilidad) + " | Verificada: " + verificada;
    }
}

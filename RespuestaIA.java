import java.util.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * Representa la respuesta generada por IA para una consulta jurídica
 */
public class RespuestaIA {
    private String id;
    private String consultaId;
    private String textoRespuesta;
    private Date fechaGeneracion;
    private double nivelConfianza; // 0.0 a 1.0
    private String modeloIA; // Nombre del modelo usado
    private List<String> fuentesUtilizadas;
    private boolean verificada;
    private boolean posibleAlucinacion;
    private int cantidadPalabras;

    public RespuestaIA() {
        this("", "", "", 0.0, "GPT-4");
    }

    public RespuestaIA(String id, String consultaId, String textoRespuesta, 
                      double nivelConfianza, String modeloIA) {
        this.id = id;
        this.consultaId = consultaId;
        this.textoRespuesta = textoRespuesta;
        this.fechaGeneracion = new Date();
        this.nivelConfianza = Math.max(0.0, Math.min(1.0, nivelConfianza));
        this.modeloIA = modeloIA;
        this.fuentesUtilizadas = new ArrayList<>();
        this.verificada = false;
        this.posibleAlucinacion = false;
        this.cantidadPalabras = contarPalabras(textoRespuesta);
    }

    /**
     * Cuenta las palabras en el texto de respuesta
     */
    private int contarPalabras(String texto) {
        if (texto == null || texto.isEmpty()) return 0;
        return texto.trim().split("\\s+").length;
    }

    /**
     * Agrega una fuente utilizada en la respuesta
     */
    public boolean agregarFuente(String fuente) {
        if (fuente != null && !fuente.isEmpty() && !fuentesUtilizadas.contains(fuente)) {
            fuentesUtilizadas.add(fuente);
            return true;
        }
        return false;
    }

    /**
     * Marca la respuesta como verificada
     */
    public void marcarComoVerificada() {
        this.verificada = true;
    }

    /**
     * Marca la respuesta como posible alucinación
     */
    public void marcarComoPosibleAlucinacion() {
        this.posibleAlucinacion = true;
        this.nivelConfianza = Math.min(this.nivelConfianza, 0.5);
    }

    /**
     * Verifica si la respuesta tiene un nivel de confianza aceptable
     */
    public boolean tieneConfianzaAceptable() {
        return nivelConfianza >= 0.7;
    }

    /**
     * Verifica si la respuesta debe ser revisada
     */
    public boolean requiereRevision() {
        return posibleAlucinacion || !tieneConfianzaAceptable() || fuentesUtilizadas.isEmpty();
    }

    // Getters y Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getConsultaId() { return consultaId; }
    public void setConsultaId(String consultaId) { this.consultaId = consultaId; }

    public String getTextoRespuesta() { return textoRespuesta; }
    public void setTextoRespuesta(String textoRespuesta) { 
        this.textoRespuesta = textoRespuesta;
        this.cantidadPalabras = contarPalabras(textoRespuesta);
    }

    public Date getFechaGeneracion() { return fechaGeneracion; }
    public void setFechaGeneracion(Date fechaGeneracion) { this.fechaGeneracion = fechaGeneracion; }

    public double getNivelConfianza() { return nivelConfianza; }
    public void setNivelConfianza(double nivelConfianza) { 
        this.nivelConfianza = Math.max(0.0, Math.min(1.0, nivelConfianza)); 
    }

    public String getModeloIA() { return modeloIA; }
    public void setModeloIA(String modeloIA) { this.modeloIA = modeloIA; }

    public List<String> getFuentesUtilizadas() { return new ArrayList<>(fuentesUtilizadas); }
    public void setFuentesUtilizadas(List<String> fuentesUtilizadas) { 
        this.fuentesUtilizadas = new ArrayList<>(fuentesUtilizadas); 
    }

    public boolean isVerificada() { return verificada; }
    public void setVerificada(boolean verificada) { this.verificada = verificada; }

    public boolean isPosibleAlucinacion() { return posibleAlucinacion; }
    public void setPosibleAlucinacion(boolean posibleAlucinacion) { 
        this.posibleAlucinacion = posibleAlucinacion; 
    }

    public int getCantidadPalabras() { return cantidadPalabras; }

    @Override
    public String toString() {
        return "Respuesta IA | Modelo: " + modeloIA + " | Confianza: " + 
               String.format("%.2f", nivelConfianza) + " | Fuentes: " + fuentesUtilizadas.size() +
               " | Verificada: " + verificada;
    }
}

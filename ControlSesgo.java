import java.util.HashMap;
import java.util.Map;
import java.util.Date;

/**
 * Gestiona el control de sesgos en respuestas de IA
 * Detecta y mitiga sesgos y alucinaciones
 */
public class ControlSesgo {
    private String id;
    private Map<String, Integer> respuestasAlucinadas; // ID respuesta -> contador de reportes
    private Map<String, Double> scoreSesgo; // ID respuesta -> puntuación de sesgo
    private int umbralAlucinacion; // Número de reportes para marcar como alucinación
    private double umbralSesgo; // Puntuación mínima para considerar sesgada
    private Date fechaUltimaActualizacion;

    public ControlSesgo() {
        this("CS-001");
    }

    public ControlSesgo(String id) {
        this.id = id;
        this.respuestasAlucinadas = new HashMap<>();
        this.scoreSesgo = new HashMap<>();
        this.umbralAlucinacion = 3; // 3 reportes para marcar como alucinación
        this.umbralSesgo = 0.7;
        this.fechaUltimaActualizacion = new Date();
    }

    /**
     * Registra un reporte de alucinación para una respuesta
     */
    public boolean registrarAlucinacion(String respuestaId) {
        int contador = respuestasAlucinadas.getOrDefault(respuestaId, 0);
        respuestasAlucinadas.put(respuestaId, contador + 1);
        this.fechaUltimaActualizacion = new Date();
        
        return contador + 1 >= umbralAlucinacion;
    }

    /**
     * Verifica si una respuesta está marcada como alucinación
     */
    public boolean esAlucinacion(String respuestaId) {
        int contador = respuestasAlucinadas.getOrDefault(respuestaId, 0);
        return contador >= umbralAlucinacion;
    }

    /**
     * Calcula el score de sesgo para una respuesta
     */
    public double calcularScoreSesgo(RespuestaIA respuesta) {
        double score = 0.0;

        // Factores que aumentan el sesgo
        if (respuesta.getFuentesUtilizadas().isEmpty()) {
            score += 0.4;
        }
        
        if (respuesta.getNivelConfianza() < 0.5) {
            score += 0.3;
        }

        if (respuesta.isPosibleAlucinacion()) {
            score += 0.5;
        }

        if (esAlucinacion(respuesta.getId())) {
            score += 0.7;
        }

        score = Math.min(1.0, score);
        scoreSesgo.put(respuesta.getId(), score);
        this.fechaUltimaActualizacion = new Date();
        
        return score;
    }

    /**
     * Verifica si una respuesta tiene sesgo alto
     */
    public boolean tieneSesgoAlto(String respuestaId) {
        double score = scoreSesgo.getOrDefault(respuestaId, 0.0);
        return score >= umbralSesgo;
    }

    /**
     * Limita la reutilización de una respuesta alucinada
     */
    public boolean puedeReutilizar(String respuestaId) {
        return !esAlucinacion(respuestaId) && !tieneSesgoAlto(respuestaId);
    }

    /**
     * Resetea los contadores de una respuesta (si fue corregida)
     */
    public void resetearContadores(String respuestaId) {
        respuestasAlucinadas.remove(respuestaId);
        scoreSesgo.remove(respuestaId);
        this.fechaUltimaActualizacion = new Date();
    }

    /**
     * Obtiene estadísticas del control de sesgo
     */
    public String obtenerEstadisticas() {
        int totalAlucinaciones = 0;
        for (int contador : respuestasAlucinadas.values()) {
            if (contador >= umbralAlucinacion) totalAlucinaciones++;
        }
        
        return "Respuestas monitoreadas: " + respuestasAlucinadas.size() + 
               " | Alucinaciones detectadas: " + totalAlucinaciones;
    }

    // Getters y Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public Map<String, Integer> getRespuestasAlucinadas() { return new HashMap<>(respuestasAlucinadas); }
    public void setRespuestasAlucinadas(Map<String, Integer> respuestasAlucinadas) { 
        this.respuestasAlucinadas = new HashMap<>(respuestasAlucinadas); 
    }

    public Map<String, Double> getScoreSesgo() { return new HashMap<>(scoreSesgo); }
    public void setScoreSesgo(Map<String, Double> scoreSesgo) { 
        this.scoreSesgo = new HashMap<>(scoreSesgo); 
    }

    public int getUmbralAlucinacion() { return umbralAlucinacion; }
    public void setUmbralAlucinacion(int umbralAlucinacion) { 
        if (umbralAlucinacion > 0) this.umbralAlucinacion = umbralAlucinacion; 
    }

    public double getUmbralSesgo() { return umbralSesgo; }
    public void setUmbralSesgo(double umbralSesgo) { 
        this.umbralSesgo = Math.max(0.0, Math.min(1.0, umbralSesgo)); 
    }

    public Date getFechaUltimaActualizacion() { return fechaUltimaActualizacion; }
    public void setFechaUltimaActualizacion(Date fechaUltimaActualizacion) { 
        this.fechaUltimaActualizacion = fechaUltimaActualizacion; 
    }

    @Override
    public String toString() {
        return "Control de Sesgo | " + obtenerEstadisticas();
    }
}

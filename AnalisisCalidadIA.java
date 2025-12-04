import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

/**
 * Analiza la calidad de las respuestas de IA
 * Evalúa precisión, utilidad y confiabilidad
 */
public class AnalisisCalidadIA {
    private String id;
    private Date fechaAnalisis;
    private int totalRespuestasAnalizadas;
    private double precisionPromedio;
    private double confianzaPromedio;
    private double satisfaccionUsuarios;
    private int respuestasConAlucinaciones;
    private int respuestasConErrores;
    private Map<String, Integer> erroresPorCategoria;
    private List<String> recomendaciones;

    public AnalisisCalidadIA() {
        this("ACI-001");
    }

    public AnalisisCalidadIA(String id) {
        this.id = id;
        this.fechaAnalisis = new Date();
        this.totalRespuestasAnalizadas = 0;
        this.precisionPromedio = 0.0;
        this.confianzaPromedio = 0.0;
        this.satisfaccionUsuarios = 0.0;
        this.respuestasConAlucinaciones = 0;
        this.respuestasConErrores = 0;
        this.erroresPorCategoria = new HashMap<>();
        this.recomendaciones = new ArrayList<>();
    }

    /**
     * Analiza una respuesta de IA
     */
    public void analizarRespuesta(RespuestaIA respuesta, Calificacion calificacion) {
        totalRespuestasAnalizadas++;

        // Actualizar promedio de confianza
        confianzaPromedio = ((confianzaPromedio * (totalRespuestasAnalizadas - 1)) + 
                            respuesta.getNivelConfianza()) / totalRespuestasAnalizadas;

        // Detectar alucinaciones
        if (respuesta.isPosibleAlucinacion()) {
            respuestasConAlucinaciones++;
        }

        // Analizar calificación si está disponible
        if (calificacion != null) {
            double puntuacionNormalizada = calificacion.getPuntuacion() / 5.0;
            satisfaccionUsuarios = ((satisfaccionUsuarios * (totalRespuestasAnalizadas - 1)) + 
                                   puntuacionNormalizada) / totalRespuestasAnalizadas;

            if (!calificacion.isPrecisa()) {
                respuestasConErrores++;
                incrementarErrorCategoria("Imprecisión");
            }
            if (!calificacion.isCompleta()) {
                incrementarErrorCategoria("Incompleta");
            }
        }

        // Evaluar precisión basada en fuentes
        if (!respuesta.getFuentesUtilizadas().isEmpty() && respuesta.isVerificada()) {
            double precision = (respuesta.getNivelConfianza() + (calificacion != null ? 
                               calificacion.getPuntuacion() / 5.0 : 0.5)) / 2.0;
            precisionPromedio = ((precisionPromedio * (totalRespuestasAnalizadas - 1)) + 
                                precision) / totalRespuestasAnalizadas;
        }
    }

    /**
     * Incrementa el contador de errores por categoría
     */
    private void incrementarErrorCategoria(String categoria) {
        int contador = erroresPorCategoria.getOrDefault(categoria, 0);
        erroresPorCategoria.put(categoria, contador + 1);
    }

    /**
     * Genera recomendaciones basadas en el análisis
     */
    public void generarRecomendaciones() {
        recomendaciones.clear();

        if (confianzaPromedio < 0.7) {
            recomendaciones.add("Mejorar el modelo de IA - confianza promedio baja");
        }

        if (respuestasConAlucinaciones > totalRespuestasAnalizadas * 0.1) {
            recomendaciones.add("Alto índice de alucinaciones - revisar fuentes de entrenamiento");
        }

        if (satisfaccionUsuarios < 0.7) {
            recomendaciones.add("Baja satisfacción de usuarios - mejorar calidad de respuestas");
        }

        if (respuestasConErrores > totalRespuestasAnalizadas * 0.15) {
            recomendaciones.add("Alto porcentaje de errores - implementar validación adicional");
        }

        if (recomendaciones.isEmpty()) {
            recomendaciones.add("El sistema mantiene buenos niveles de calidad");
        }
    }

    /**
     * Calcula la puntuación general de calidad
     */
    public double calcularPuntuacionCalidad() {
        double puntuacion = 0.0;
        
        // Factores positivos
        puntuacion += precisionPromedio * 0.3;
        puntuacion += confianzaPromedio * 0.3;
        puntuacion += satisfaccionUsuarios * 0.2;
        
        // Penalizaciones
        if (totalRespuestasAnalizadas > 0) {
            double tasaAlucinaciones = (double) respuestasConAlucinaciones / totalRespuestasAnalizadas;
            double tasaErrores = (double) respuestasConErrores / totalRespuestasAnalizadas;
            puntuacion -= tasaAlucinaciones * 0.1;
            puntuacion -= tasaErrores * 0.1;
        }
        
        return Math.max(0.0, Math.min(1.0, puntuacion));
    }

    /**
     * Obtiene un resumen del análisis
     */
    public String obtenerResumen() {
        return "Respuestas analizadas: " + totalRespuestasAnalizadas + 
               " | Precisión: " + String.format("%.2f", precisionPromedio) + 
               " | Confianza: " + String.format("%.2f", confianzaPromedio) + 
               " | Satisfacción: " + String.format("%.2f", satisfaccionUsuarios) + 
               " | Calidad: " + String.format("%.2f", calcularPuntuacionCalidad());
    }

    // Getters y Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public Date getFechaAnalisis() { return fechaAnalisis; }
    public void setFechaAnalisis(Date fechaAnalisis) { this.fechaAnalisis = fechaAnalisis; }

    public int getTotalRespuestasAnalizadas() { return totalRespuestasAnalizadas; }
    public void setTotalRespuestasAnalizadas(int totalRespuestasAnalizadas) { 
        if (totalRespuestasAnalizadas >= 0) this.totalRespuestasAnalizadas = totalRespuestasAnalizadas; 
    }

    public double getPrecisionPromedio() { return precisionPromedio; }
    public void setPrecisionPromedio(double precisionPromedio) { 
        this.precisionPromedio = Math.max(0.0, Math.min(1.0, precisionPromedio)); 
    }

    public double getConfianzaPromedio() { return confianzaPromedio; }
    public void setConfianzaPromedio(double confianzaPromedio) { 
        this.confianzaPromedio = Math.max(0.0, Math.min(1.0, confianzaPromedio)); 
    }

    public double getSatisfaccionUsuarios() { return satisfaccionUsuarios; }
    public void setSatisfaccionUsuarios(double satisfaccionUsuarios) { 
        this.satisfaccionUsuarios = Math.max(0.0, Math.min(1.0, satisfaccionUsuarios)); 
    }

    public int getRespuestasConAlucinaciones() { return respuestasConAlucinaciones; }
    public void setRespuestasConAlucinaciones(int respuestasConAlucinaciones) { 
        if (respuestasConAlucinaciones >= 0) this.respuestasConAlucinaciones = respuestasConAlucinaciones; 
    }

    public int getRespuestasConErrores() { return respuestasConErrores; }
    public void setRespuestasConErrores(int respuestasConErrores) { 
        if (respuestasConErrores >= 0) this.respuestasConErrores = respuestasConErrores; 
    }

    public Map<String, Integer> getErroresPorCategoria() { return new HashMap<>(erroresPorCategoria); }
    public void setErroresPorCategoria(Map<String, Integer> erroresPorCategoria) { 
        this.erroresPorCategoria = new HashMap<>(erroresPorCategoria); 
    }

    public List<String> getRecomendaciones() { return new ArrayList<>(recomendaciones); }
    public void setRecomendaciones(List<String> recomendaciones) { 
        this.recomendaciones = new ArrayList<>(recomendaciones); 
    }

    @Override
    public String toString() {
        return "Análisis de Calidad IA | " + obtenerResumen();
    }
}

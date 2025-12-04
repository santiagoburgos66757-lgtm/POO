import java.util.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * Gestiona la validación de respuestas de IA para detectar problemas
 * Implementa mecanismos de control de calidad
 */
public class ValidacionRespuesta {
    private String id;
    private String respuestaIAId;
    private Date fechaValidacion;
    private boolean aprobada;
    private List<String> erroresDetectados;
    private double puntuacionCalidad; // 0.0 a 1.0
    private boolean tieneReferenciasValidas;
    private boolean contieneInformacionActualizada;
    private boolean usaLenguajeApropiado;
    private String validadorId; // ID del usuario o sistema que validó

    public ValidacionRespuesta() {
        this("", "", "");
    }

    public ValidacionRespuesta(String id, String respuestaIAId, String validadorId) {
        this.id = id;
        this.respuestaIAId = respuestaIAId;
        this.validadorId = validadorId;
        this.fechaValidacion = new Date();
        this.aprobada = false;
        this.erroresDetectados = new ArrayList<>();
        this.puntuacionCalidad = 0.0;
        this.tieneReferenciasValidas = false;
        this.contieneInformacionActualizada = false;
        this.usaLenguajeApropiado = true;
    }

    /**
     * Realiza la validación automática de la respuesta
     */
    public void validarAutomaticamente(RespuestaIA respuesta) {
        erroresDetectados.clear();
        double puntuacion = 1.0;

        // Validar fuentes
        if (respuesta.getFuentesUtilizadas().isEmpty()) {
            erroresDetectados.add("No hay fuentes citadas");
            puntuacion -= 0.3;
        } else {
            tieneReferenciasValidas = true;
        }

        // Validar nivel de confianza
        if (respuesta.getNivelConfianza() < 0.7) {
            erroresDetectados.add("Nivel de confianza bajo");
            puntuacion -= 0.2;
        }

        // Detectar posibles alucinaciones
        if (respuesta.isPosibleAlucinacion()) {
            erroresDetectados.add("Marcada como posible alucinación");
            puntuacion -= 0.4;
        }

        this.puntuacionCalidad = Math.max(0.0, puntuacion);
        this.aprobada = puntuacionCalidad >= 0.7 && erroresDetectados.isEmpty();
    }

    /**
     * Agrega un error detectado
     */
    public void agregarError(String error) {
        if (error != null && !error.isEmpty()) {
            erroresDetectados.add(error);
            this.aprobada = false;
        }
    }

    /**
     * Aprueba manualmente la validación
     */
    public void aprobarManualmente() {
        this.aprobada = true;
        this.puntuacionCalidad = Math.max(this.puntuacionCalidad, 0.7);
    }

    /**
     * Rechaza la validación
     */
    public void rechazar(String motivo) {
        this.aprobada = false;
        agregarError(motivo);
    }

    /**
     * Verifica si pasó todas las validaciones
     */
    public boolean pasaValidacion() {
        return aprobada && puntuacionCalidad >= 0.7;
    }

    // Getters y Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getRespuestaIAId() { return respuestaIAId; }
    public void setRespuestaIAId(String respuestaIAId) { this.respuestaIAId = respuestaIAId; }

    public Date getFechaValidacion() { return fechaValidacion; }
    public void setFechaValidacion(Date fechaValidacion) { this.fechaValidacion = fechaValidacion; }

    public boolean isAprobada() { return aprobada; }
    public void setAprobada(boolean aprobada) { this.aprobada = aprobada; }

    public List<String> getErroresDetectados() { return new ArrayList<>(erroresDetectados); }
    public void setErroresDetectados(List<String> erroresDetectados) { 
        this.erroresDetectados = new ArrayList<>(erroresDetectados); 
    }

    public double getPuntuacionCalidad() { return puntuacionCalidad; }
    public void setPuntuacionCalidad(double puntuacionCalidad) { 
        this.puntuacionCalidad = Math.max(0.0, Math.min(1.0, puntuacionCalidad)); 
    }

    public boolean isTieneReferenciasValidas() { return tieneReferenciasValidas; }
    public void setTieneReferenciasValidas(boolean tieneReferenciasValidas) { 
        this.tieneReferenciasValidas = tieneReferenciasValidas; 
    }

    public boolean isContieneInformacionActualizada() { return contieneInformacionActualizada; }
    public void setContieneInformacionActualizada(boolean contieneInformacionActualizada) { 
        this.contieneInformacionActualizada = contieneInformacionActualizada; 
    }

    public boolean isUsaLenguajeApropiado() { return usaLenguajeApropiado; }
    public void setUsaLenguajeApropiado(boolean usaLenguajeApropiado) { 
        this.usaLenguajeApropiado = usaLenguajeApropiado; 
    }

    public String getValidadorId() { return validadorId; }
    public void setValidadorId(String validadorId) { this.validadorId = validadorId; }

    @Override
    public String toString() {
        return "Validación | Aprobada: " + aprobada + " | Calidad: " + 
               String.format("%.2f", puntuacionCalidad) + " | Errores: " + erroresDetectados.size();
    }
}

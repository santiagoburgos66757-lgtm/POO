import java.util.Date;

/**
 * Representa una calificación dada por un usuario a una respuesta de consulta
 */
public class Calificacion {
    private String id;
    private String consultaId;
    private String usuarioId;
    private int puntuacion; // 1 a 5 estrellas
    private String comentario;
    private Date fecha;
    private boolean util;
    private boolean precisa;
    private boolean completa;

    public Calificacion() {
        this("", "", "", 0);
    }

    public Calificacion(String id, String consultaId, String usuarioId, int puntuacion) {
        this.id = id;
        this.consultaId = consultaId;
        this.usuarioId = usuarioId;
        setPuntuacion(puntuacion);
        this.comentario = "";
        this.fecha = new Date();
        this.util = true;
        this.precisa = true;
        this.completa = true;
    }

    /**
     * Verifica si la calificación es positiva (4 o 5 estrellas)
     */
    public boolean esPositiva() {
        return puntuacion >= 4;
    }

    /**
     * Verifica si la calificación es negativa (1 o 2 estrellas)
     */
    public boolean esNegativa() {
        return puntuacion <= 2;
    }

    /**
     * Verifica si la respuesta cumplió todos los criterios
     */
    public boolean cumpleTodosCriterios() {
        return util && precisa && completa;
    }

    // Getters y Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getConsultaId() { return consultaId; }
    public void setConsultaId(String consultaId) { this.consultaId = consultaId; }

    public String getUsuarioId() { return usuarioId; }
    public void setUsuarioId(String usuarioId) { this.usuarioId = usuarioId; }

    public int getPuntuacion() { return puntuacion; }
    public void setPuntuacion(int puntuacion) { 
        this.puntuacion = Math.max(1, Math.min(5, puntuacion)); 
    }

    public String getComentario() { return comentario; }
    public void setComentario(String comentario) { this.comentario = comentario; }

    public Date getFecha() { return fecha; }
    public void setFecha(Date fecha) { this.fecha = fecha; }

    public boolean isUtil() { return util; }
    public void setUtil(boolean util) { this.util = util; }

    public boolean isPrecisa() { return precisa; }
    public void setPrecisa(boolean precisa) { this.precisa = precisa; }

    public boolean isCompleta() { return completa; }
    public void setCompleta(boolean completa) { this.completa = completa; }

    @Override
    public String toString() {
        String estrellas = "★".repeat(puntuacion) + "☆".repeat(5 - puntuacion);
        return "Calificación: " + estrellas + " | Útil: " + util + " | Precisa: " + precisa + 
               " | Completa: " + completa;
    }
}

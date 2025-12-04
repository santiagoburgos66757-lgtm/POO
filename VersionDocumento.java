import java.util.Date;

/**
 * Representa una versión específica de un documento jurídico
 * Permite rastrear cambios y mantener historial
 */
public class VersionDocumento {
    private String numeroVersion;
    private String documentoId;
    private String contenido;
    private Date fechaCreacion;
    private String comentario;
    private String usuarioId;
    private int longitudContenido;

    public VersionDocumento() {
        this("V1", "", "", "", "");
    }

    public VersionDocumento(String numeroVersion, String documentoId, String contenido, 
                           String comentario, String usuarioId) {
        this.numeroVersion = numeroVersion;
        this.documentoId = documentoId;
        this.contenido = contenido;
        this.fechaCreacion = new Date();
        this.comentario = comentario;
        this.usuarioId = usuarioId;
        this.longitudContenido = contenido != null ? contenido.length() : 0;
    }

    /**
     * Compara esta versión con otra para detectar cambios
     */
    public boolean esIgualA(VersionDocumento otra) {
        return this.contenido.equals(otra.contenido);
    }

    /**
     * Calcula el tamaño del cambio respecto a otra versión
     */
    public int calcularDiferenciaTamaño(VersionDocumento otra) {
        return this.longitudContenido - otra.longitudContenido;
    }

    // Getters y Setters
    public String getNumeroVersion() { return numeroVersion; }
    public void setNumeroVersion(String numeroVersion) { this.numeroVersion = numeroVersion; }

    public String getDocumentoId() { return documentoId; }
    public void setDocumentoId(String documentoId) { this.documentoId = documentoId; }

    public String getContenido() { return contenido; }
    public void setContenido(String contenido) { 
        this.contenido = contenido;
        this.longitudContenido = contenido != null ? contenido.length() : 0;
    }

    public Date getFechaCreacion() { return fechaCreacion; }
    public void setFechaCreacion(Date fechaCreacion) { this.fechaCreacion = fechaCreacion; }

    public String getComentario() { return comentario; }
    public void setComentario(String comentario) { this.comentario = comentario; }

    public String getUsuarioId() { return usuarioId; }
    public void setUsuarioId(String usuarioId) { this.usuarioId = usuarioId; }

    public int getLongitudContenido() { return longitudContenido; }

    @Override
    public String toString() {
        return "Versión " + numeroVersion + " | " + longitudContenido + " caracteres | " + comentario;
    }
}

import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

/**
 * Representa un documento jurídico generado en el sistema
 * Gestiona el contenido, versiones y metadatos del documento
 */
public class DocumentoJuridico {
    private String id;
    private String titulo;
    private String tipoDocumento; // "Contrato", "Acta", "Resolución", "Circular", etc.
    private String usuarioCreadorId;
    private String plantillaId;
    private String consultaId; // Consulta que generó el documento (si aplica)
    private Date fechaCreacion;
    private Date fechaUltimaModificacion;
    private String contenido;
    private String estado; // "Borrador", "En revisión", "Aprobado", "Firmado"
    private List<VersionDocumento> versiones;
    private Map<String, String> campos; // Campos del documento (nombre -> valor)
    private boolean firmado;
    private String urlDescarga;

    public DocumentoJuridico() {
        this("", "", "Contrato", "", "");
    }

    public DocumentoJuridico(String id, String titulo, String tipoDocumento, 
                            String usuarioCreadorId, String plantillaId) {
        this.id = id;
        this.titulo = titulo;
        this.tipoDocumento = tipoDocumento;
        this.usuarioCreadorId = usuarioCreadorId;
        this.plantillaId = plantillaId;
        this.consultaId = "";
        this.fechaCreacion = new Date();
        this.fechaUltimaModificacion = new Date();
        this.contenido = "";
        this.estado = "Borrador";
        this.versiones = new ArrayList<>();
        this.campos = new HashMap<>();
        this.firmado = false;
        this.urlDescarga = "";
        // Crear versión inicial
        crearVersion("Versión inicial");
    }

    /**
     * Crea una nueva versión del documento
     */
    public boolean crearVersion(String comentario) {
        VersionDocumento version = new VersionDocumento(
            "V" + (versiones.size() + 1),
            this.id,
            this.contenido,
            comentario,
            this.usuarioCreadorId
        );
        versiones.add(version);
        this.fechaUltimaModificacion = new Date();
        return true;
    }

    /**
     * Actualiza el contenido del documento
     */
    public void actualizarContenido(String nuevoContenido, String comentario) {
        this.contenido = nuevoContenido;
        crearVersion(comentario);
    }

    /**
     * Establece el valor de un campo del documento
     */
    public void setCampo(String nombreCampo, String valor) {
        campos.put(nombreCampo, valor);
        this.fechaUltimaModificacion = new Date();
    }

    /**
     * Obtiene el valor de un campo del documento
     */
    public String getCampo(String nombreCampo) {
        return campos.getOrDefault(nombreCampo, "");
    }

    /**
     * Marca el documento para revisión
     */
    public boolean enviarARevision() {
        if (estado.equals("Borrador")) {
            this.estado = "En revisión";
            return true;
        }
        return false;
    }

    /**
     * Aprueba el documento
     */
    public boolean aprobar() {
        if (estado.equals("En revisión")) {
            this.estado = "Aprobado";
            return true;
        }
        return false;
    }

    /**
     * Firma el documento
     */
    public boolean firmar() {
        if (estado.equals("Aprobado") && !firmado) {
            this.firmado = true;
            this.estado = "Firmado";
            return true;
        }
        return false;
    }

    /**
     * Genera URL de descarga del documento
     */
    public String generarUrlDescarga(String formato) {
        // Simulación de generación de URL
        this.urlDescarga = "/documentos/" + id + "." + formato.toLowerCase();
        return this.urlDescarga;
    }

    /**
     * Obtiene la versión actual del documento
     */
    public int getVersionActual() {
        return versiones.size();
    }

    /**
     * Verifica si el documento está listo para descargar
     */
    public boolean puedeDescargar() {
        return !contenido.isEmpty() && (estado.equals("Aprobado") || estado.equals("Firmado"));
    }

    // Getters y Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getTipoDocumento() { return tipoDocumento; }
    public void setTipoDocumento(String tipoDocumento) { this.tipoDocumento = tipoDocumento; }

    public String getUsuarioCreadorId() { return usuarioCreadorId; }
    public void setUsuarioCreadorId(String usuarioCreadorId) { this.usuarioCreadorId = usuarioCreadorId; }

    public String getPlantillaId() { return plantillaId; }
    public void setPlantillaId(String plantillaId) { this.plantillaId = plantillaId; }

    public String getConsultaId() { return consultaId; }
    public void setConsultaId(String consultaId) { this.consultaId = consultaId; }

    public Date getFechaCreacion() { return fechaCreacion; }
    public void setFechaCreacion(Date fechaCreacion) { this.fechaCreacion = fechaCreacion; }

    public Date getFechaUltimaModificacion() { return fechaUltimaModificacion; }
    public void setFechaUltimaModificacion(Date fechaUltimaModificacion) { 
        this.fechaUltimaModificacion = fechaUltimaModificacion; 
    }

    public String getContenido() { return contenido; }
    public void setContenido(String contenido) { this.contenido = contenido; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

    public List<VersionDocumento> getVersiones() { return new ArrayList<>(versiones); }
    public void setVersiones(List<VersionDocumento> versiones) { 
        this.versiones = new ArrayList<>(versiones); 
    }

    public Map<String, String> getCampos() { return new HashMap<>(campos); }
    public void setCampos(Map<String, String> campos) { this.campos = new HashMap<>(campos); }

    public boolean isFirmado() { return firmado; }
    public void setFirmado(boolean firmado) { this.firmado = firmado; }

    public String getUrlDescarga() { return urlDescarga; }
    public void setUrlDescarga(String urlDescarga) { this.urlDescarga = urlDescarga; }

    @Override
    public String toString() {
        return "Documento: " + titulo + " (" + tipoDocumento + ") | Estado: " + estado + 
               " | Versión: " + getVersionActual() + " | Firmado: " + firmado;
    }
}

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

/**
 * Representa una plantilla para generar documentos jurídicos
 * Contiene la estructura y campos variables del documento
 */
public class PlantillaJuridica {
    private String id;
    private String nombre;
    private String tipoDocumento;
    private String categoria; // "Educativo", "Laboral", "Civil", etc.
    private String contenidoPlantilla;
    private List<String> camposRequeridos;
    private Map<String, String> camposPorDefecto;
    private boolean activa;
    private String descripcion;
    private int vecesUsada;

    public PlantillaJuridica() {
        this("", "", "Contrato", "General");
    }

    public PlantillaJuridica(String id, String nombre, String tipoDocumento, String categoria) {
        this.id = id;
        this.nombre = nombre;
        this.tipoDocumento = tipoDocumento;
        this.categoria = categoria;
        this.contenidoPlantilla = "";
        this.camposRequeridos = new ArrayList<>();
        this.camposPorDefecto = new HashMap<>();
        this.activa = true;
        this.descripcion = "";
        this.vecesUsada = 0;
    }

    /**
     * Agrega un campo requerido a la plantilla
     */
    public boolean agregarCampoRequerido(String nombreCampo) {
        if (nombreCampo != null && !nombreCampo.isEmpty() && !camposRequeridos.contains(nombreCampo)) {
            camposRequeridos.add(nombreCampo);
            return true;
        }
        return false;
    }

    /**
     * Establece un valor por defecto para un campo
     */
    public void setCampoPorDefecto(String nombreCampo, String valorDefecto) {
        camposPorDefecto.put(nombreCampo, valorDefecto);
    }

    /**
     * Genera un documento a partir de la plantilla
     */
    public DocumentoJuridico generarDocumento(String documentoId, String usuarioId, 
                                             Map<String, String> valores) {
        DocumentoJuridico documento = new DocumentoJuridico(
            documentoId,
            this.nombre + " - " + new java.util.Date(),
            this.tipoDocumento,
            usuarioId,
            this.id
        );

        // Aplicar valores a la plantilla
        String contenido = this.contenidoPlantilla;
        for (Map.Entry<String, String> entry : valores.entrySet()) {
            String marcador = "{{" + entry.getKey() + "}}";
            contenido = contenido.replace(marcador, entry.getValue());
            documento.setCampo(entry.getKey(), entry.getValue());
        }

        // Aplicar valores por defecto a campos no proporcionados
        for (Map.Entry<String, String> entry : camposPorDefecto.entrySet()) {
            if (!valores.containsKey(entry.getKey())) {
                String marcador = "{{" + entry.getKey() + "}}";
                contenido = contenido.replace(marcador, entry.getValue());
                documento.setCampo(entry.getKey(), entry.getValue());
            }
        }

        documento.setContenido(contenido);
        this.vecesUsada++;
        return documento;
    }

    /**
     * Valida que todos los campos requeridos estén presentes
     */
    public boolean validarCampos(Map<String, String> valores) {
        for (String campo : camposRequeridos) {
            if (!valores.containsKey(campo) || valores.get(campo).isEmpty()) {
                return false;
            }
        }
        return true;
    }

    /**
     * Activa la plantilla
     */
    public void activar() {
        this.activa = true;
    }

    /**
     * Desactiva la plantilla
     */
    public void desactivar() {
        this.activa = false;
    }

    // Getters y Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getTipoDocumento() { return tipoDocumento; }
    public void setTipoDocumento(String tipoDocumento) { this.tipoDocumento = tipoDocumento; }

    public String getCategoria() { return categoria; }
    public void setCategoria(String categoria) { this.categoria = categoria; }

    public String getContenidoPlantilla() { return contenidoPlantilla; }
    public void setContenidoPlantilla(String contenidoPlantilla) { 
        this.contenidoPlantilla = contenidoPlantilla; 
    }

    public List<String> getCamposRequeridos() { return new ArrayList<>(camposRequeridos); }
    public void setCamposRequeridos(List<String> camposRequeridos) { 
        this.camposRequeridos = new ArrayList<>(camposRequeridos); 
    }

    public Map<String, String> getCamposPorDefecto() { return new HashMap<>(camposPorDefecto); }
    public void setCamposPorDefecto(Map<String, String> camposPorDefecto) { 
        this.camposPorDefecto = new HashMap<>(camposPorDefecto); 
    }

    public boolean isActiva() { return activa; }
    public void setActiva(boolean activa) { this.activa = activa; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public int getVecesUsada() { return vecesUsada; }
    public void setVecesUsada(int vecesUsada) { if (vecesUsada >= 0) this.vecesUsada = vecesUsada; }

    @Override
    public String toString() {
        return nombre + " (" + tipoDocumento + ") | Categoría: " + categoria + 
               " | Usada: " + vecesUsada + " veces | Activa: " + activa;
    }
}

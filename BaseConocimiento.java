import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Gestiona la base de conocimiento del sistema jurídico
 * Administra normas, jurisprudencias y documentos legales
 */
public class BaseConocimiento {
    private String id;
    private String nombre;
    private String descripcion;
    private List<Norma> normas;
    private List<Jurisprudencia> jurisprudencias;
    private Date fechaUltimaActualizacion;
    private int totalDocumentos;
    private boolean sincronizacionActiva;
    private String fuenteExterna; // URL o nombre de la fuente externa

    public BaseConocimiento() {
        this("", "Base de Conocimiento Jurídico", "");
    }

    public BaseConocimiento(String id, String nombre, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.normas = new ArrayList<>();
        this.jurisprudencias = new ArrayList<>();
        this.fechaUltimaActualizacion = new Date();
        this.totalDocumentos = 0;
        this.sincronizacionActiva = false;
        this.fuenteExterna = "";
    }

    /**
     * Agrega una norma a la base de conocimiento
     */
    public boolean agregarNorma(Norma norma) {
        if (norma != null && !normas.contains(norma)) {
            normas.add(norma);
            totalDocumentos++;
            fechaUltimaActualizacion = new Date();
            return true;
        }
        return false;
    }

    /**
     * Agrega una jurisprudencia a la base de conocimiento
     */
    public boolean agregarJurisprudencia(Jurisprudencia jurisprudencia) {
        if (jurisprudencia != null && !jurisprudencias.contains(jurisprudencia)) {
            jurisprudencias.add(jurisprudencia);
            totalDocumentos++;
            fechaUltimaActualizacion = new Date();
            return true;
        }
        return false;
    }

    /**
     * Busca normas por categoría
     */
    public List<Norma> buscarNormasPorCategoria(String categoria) {
        List<Norma> resultado = new ArrayList<>();
        for (Norma norma : normas) {
            if (norma.getCategoria().equalsIgnoreCase(categoria)) {
                resultado.add(norma);
            }
        }
        return resultado;
    }

    /**
     * Busca jurisprudencias por materia
     */
    public List<Jurisprudencia> buscarJurisprudenciasPorMateria(String materia) {
        List<Jurisprudencia> resultado = new ArrayList<>();
        for (Jurisprudencia j : jurisprudencias) {
            if (j.getMateria().equalsIgnoreCase(materia)) {
                resultado.add(j);
            }
        }
        return resultado;
    }

    /**
     * Actualiza la base de conocimiento
     */
    public void actualizar() {
        this.fechaUltimaActualizacion = new Date();
        // Aquí se implementaría la lógica de sincronización con fuentes externas
    }

    /**
     * Activa la sincronización con fuentes externas
     */
    public void activarSincronizacion(String fuenteExterna) {
        this.sincronizacionActiva = true;
        this.fuenteExterna = fuenteExterna;
    }

    /**
     * Desactiva la sincronización
     */
    public void desactivarSincronizacion() {
        this.sincronizacionActiva = false;
    }

    /**
     * Obtiene estadísticas de la base de conocimiento
     */
    public String obtenerEstadisticas() {
        return "Normas: " + normas.size() + " | Jurisprudencias: " + jurisprudencias.size() + 
               " | Total: " + totalDocumentos;
    }

    // Getters y Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public List<Norma> getNormas() { return new ArrayList<>(normas); }
    public void setNormas(List<Norma> normas) { this.normas = new ArrayList<>(normas); }

    public List<Jurisprudencia> getJurisprudencias() { return new ArrayList<>(jurisprudencias); }
    public void setJurisprudencias(List<Jurisprudencia> jurisprudencias) { 
        this.jurisprudencias = new ArrayList<>(jurisprudencias); 
    }

    public Date getFechaUltimaActualizacion() { return fechaUltimaActualizacion; }
    public void setFechaUltimaActualizacion(Date fechaUltimaActualizacion) { 
        this.fechaUltimaActualizacion = fechaUltimaActualizacion; 
    }

    public int getTotalDocumentos() { return totalDocumentos; }
    public void setTotalDocumentos(int totalDocumentos) { 
        if (totalDocumentos >= 0) this.totalDocumentos = totalDocumentos; 
    }

    public boolean isSincronizacionActiva() { return sincronizacionActiva; }
    public void setSincronizacionActiva(boolean sincronizacionActiva) { 
        this.sincronizacionActiva = sincronizacionActiva; 
    }

    public String getFuenteExterna() { return fuenteExterna; }
    public void setFuenteExterna(String fuenteExterna) { this.fuenteExterna = fuenteExterna; }

    @Override
    public String toString() {
        return nombre + " | " + obtenerEstadisticas() + " | Última actualización: " + 
               fechaUltimaActualizacion;
    }
}

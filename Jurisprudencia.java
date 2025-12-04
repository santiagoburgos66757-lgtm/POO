import java.util.Date;

/**
 * Representa una sentencia judicial o jurisprudencia
 */
public class Jurisprudencia {
    private String id;
    private String numeroSentencia;
    private String tribunal;
    private Date fecha;
    private String materia; // "Educativo", "Laboral", "Penal", etc.
    private String ponente;
    private String resumen;
    private String textoCompleto;
    private String urlOficial;
    private String tipoSentencia; // "Tutela", "Constitucionalidad", "Casación", etc.
    private boolean relevante; // Marcada como relevante por expertos

    public Jurisprudencia() {
        this("", "", "", "General");
    }

    public Jurisprudencia(String id, String numeroSentencia, String tribunal, String materia) {
        this.id = id;
        this.numeroSentencia = numeroSentencia;
        this.tribunal = tribunal;
        this.materia = materia;
        this.fecha = new Date();
        this.ponente = "";
        this.resumen = "";
        this.textoCompleto = "";
        this.urlOficial = "";
        this.tipoSentencia = "";
        this.relevante = false;
    }

    /**
     * Marca la jurisprudencia como relevante
     */
    public void marcarComoRelevante() {
        this.relevante = true;
    }

    /**
     * Genera la citación de la sentencia
     */
    public String generarCitacion() {
        return tribunal + ", Sentencia " + numeroSentencia + " de " + 
               String.format("%tY", fecha);
    }

    /**
     * Verifica si tiene texto completo
     */
    public boolean tieneTextoCompleto() {
        return !textoCompleto.isEmpty();
    }

    /**
     * Verifica si tiene resumen
     */
    public boolean tieneResumen() {
        return !resumen.isEmpty();
    }

    // Getters y Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getNumeroSentencia() { return numeroSentencia; }
    public void setNumeroSentencia(String numeroSentencia) { this.numeroSentencia = numeroSentencia; }

    public String getTribunal() { return tribunal; }
    public void setTribunal(String tribunal) { this.tribunal = tribunal; }

    public Date getFecha() { return fecha; }
    public void setFecha(Date fecha) { this.fecha = fecha; }

    public String getMateria() { return materia; }
    public void setMateria(String materia) { this.materia = materia; }

    public String getPonente() { return ponente; }
    public void setPonente(String ponente) { this.ponente = ponente; }

    public String getResumen() { return resumen; }
    public void setResumen(String resumen) { this.resumen = resumen; }

    public String getTextoCompleto() { return textoCompleto; }
    public void setTextoCompleto(String textoCompleto) { this.textoCompleto = textoCompleto; }

    public String getUrlOficial() { return urlOficial; }
    public void setUrlOficial(String urlOficial) { this.urlOficial = urlOficial; }

    public String getTipoSentencia() { return tipoSentencia; }
    public void setTipoSentencia(String tipoSentencia) { this.tipoSentencia = tipoSentencia; }

    public boolean isRelevante() { return relevante; }
    public void setRelevante(boolean relevante) { this.relevante = relevante; }

    @Override
    public String toString() {
        return generarCitacion() + " | Materia: " + materia + 
               (relevante ? " [Relevante]" : "");
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Jurisprudencia that = (Jurisprudencia) obj;
        return numeroSentencia.equals(that.numeroSentencia) && tribunal.equals(that.tribunal);
    }

    @Override
    public int hashCode() {
        return (numeroSentencia + tribunal).hashCode();
    }
}

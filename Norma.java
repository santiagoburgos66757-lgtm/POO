import java.util.Date;

/**
 * Representa una norma jurídica en la base de conocimiento
 */
public class Norma {
    private String id;
    private String tipo; // "Ley", "Decreto", "Resolución", "Acuerdo", etc.
    private String numero;
    private String año;
    private String titulo;
    private String ente; // Entidad que emite la norma
    private String categoria; // "Educación", "Laboral", "Tributario", etc.
    private Date fechaPublicacion;
    private Date fechaVigencia;
    private String textoCompleto;
    private String urlOficial;
    private boolean vigente;
    private String resumen;

    public Norma() {
        this("", "Ley", "", "", "", "General");
    }

    public Norma(String id, String tipo, String numero, String año, String titulo, String categoria) {
        this.id = id;
        this.tipo = tipo;
        this.numero = numero;
        this.año = año;
        this.titulo = titulo;
        this.categoria = categoria;
        this.ente = "";
        this.fechaPublicacion = new Date();
        this.fechaVigencia = new Date();
        this.textoCompleto = "";
        this.urlOficial = "";
        this.vigente = true;
        this.resumen = "";
    }

    /**
     * Marca la norma como derogada (no vigente)
     */
    public void derogar() {
        this.vigente = false;
    }

    /**
     * Verifica si la norma está vigente
     */
    public boolean estaVigente() {
        Date ahora = new Date();
        return vigente && !ahora.before(fechaVigencia);
    }

    /**
     * Genera la citación oficial de la norma
     */
    public String generarCitacion() {
        return tipo + " " + numero + " de " + año;
    }

    /**
     * Verifica si tiene texto completo
     */
    public boolean tieneTextoCompleto() {
        return !textoCompleto.isEmpty();
    }

    // Getters y Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public String getNumero() { return numero; }
    public void setNumero(String numero) { this.numero = numero; }

    public String getAño() { return año; }
    public void setAño(String año) { this.año = año; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getEnte() { return ente; }
    public void setEnte(String ente) { this.ente = ente; }

    public String getCategoria() { return categoria; }
    public void setCategoria(String categoria) { this.categoria = categoria; }

    public Date getFechaPublicacion() { return fechaPublicacion; }
    public void setFechaPublicacion(Date fechaPublicacion) { this.fechaPublicacion = fechaPublicacion; }

    public Date getFechaVigencia() { return fechaVigencia; }
    public void setFechaVigencia(Date fechaVigencia) { this.fechaVigencia = fechaVigencia; }

    public String getTextoCompleto() { return textoCompleto; }
    public void setTextoCompleto(String textoCompleto) { this.textoCompleto = textoCompleto; }

    public String getUrlOficial() { return urlOficial; }
    public void setUrlOficial(String urlOficial) { this.urlOficial = urlOficial; }

    public boolean isVigente() { return vigente; }
    public void setVigente(boolean vigente) { this.vigente = vigente; }

    public String getResumen() { return resumen; }
    public void setResumen(String resumen) { this.resumen = resumen; }

    @Override
    public String toString() {
        return generarCitacion() + " - " + titulo + " | Vigente: " + vigente;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Norma norma = (Norma) obj;
        return numero.equals(norma.numero) && año.equals(norma.año);
    }

    @Override
    public int hashCode() {
        return (numero + año).hashCode();
    }
}

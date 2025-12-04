/**
 * Representa una referencia normativa citada en una consulta o documento
 * Permite rastrear la fuente legal de la información
 */
public class ReferenciaNormativa {
    private String id;
    private String tipo; // "Ley", "Decreto", "Sentencia", "Resolución", etc.
    private String numero;
    private String titulo;
    private String año;
    private String articulo; // Artículo específico referenciado
    private String urlFuenteOficial;
    private String extractoTexto; // Fragmento relevante del texto
    private boolean verificada;

    public ReferenciaNormativa() {
        this("", "Ley", "", "", "");
    }

    public ReferenciaNormativa(String id, String tipo, String numero, String titulo, String año) {
        this.id = id;
        this.tipo = tipo;
        this.numero = numero;
        this.titulo = titulo;
        this.año = año;
        this.articulo = "";
        this.urlFuenteOficial = "";
        this.extractoTexto = "";
        this.verificada = false;
    }

    /**
     * Marca la referencia como verificada contra fuente oficial
     */
    public void marcarComoVerificada() {
        this.verificada = true;
    }

    /**
     * Verifica si la referencia está completa (tiene datos mínimos)
     */
    public boolean esCompleta() {
        return !numero.isEmpty() && !titulo.isEmpty() && !año.isEmpty();
    }

    /**
     * Genera la citación formal de la referencia
     */
    public String generarCitacion() {
        StringBuilder citacion = new StringBuilder();
        citacion.append(tipo).append(" ").append(numero);
        if (!año.isEmpty()) {
            citacion.append(" de ").append(año);
        }
        if (!articulo.isEmpty()) {
            citacion.append(", Artículo ").append(articulo);
        }
        return citacion.toString();
    }

    /**
     * Verifica si tiene URL de fuente oficial
     */
    public boolean tieneFuenteOficial() {
        return !urlFuenteOficial.isEmpty();
    }

    // Getters y Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public String getNumero() { return numero; }
    public void setNumero(String numero) { this.numero = numero; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getAño() { return año; }
    public void setAño(String año) { this.año = año; }

    public String getArticulo() { return articulo; }
    public void setArticulo(String articulo) { this.articulo = articulo; }

    public String getUrlFuenteOficial() { return urlFuenteOficial; }
    public void setUrlFuenteOficial(String urlFuenteOficial) { this.urlFuenteOficial = urlFuenteOficial; }

    public String getExtractoTexto() { return extractoTexto; }
    public void setExtractoTexto(String extractoTexto) { this.extractoTexto = extractoTexto; }

    public boolean isVerificada() { return verificada; }
    public void setVerificada(boolean verificada) { this.verificada = verificada; }

    @Override
    public String toString() {
        return generarCitacion() + (verificada ? " [Verificada]" : "");
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        ReferenciaNormativa that = (ReferenciaNormativa) obj;
        return numero.equals(that.numero) && año.equals(that.año);
    }

    @Override
    public int hashCode() {
        return (numero + año).hashCode();
    }
}

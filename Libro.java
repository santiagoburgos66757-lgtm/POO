public class Libro {
    private String titulo;
    private String autor;
    private int ejemplaresTotales;
    private int ejemplaresPrestados;

    public Libro() {
        this("", "", 0, 0);
    }

    public Libro(String titulo, String autor, int ejemplaresTotales, int ejemplaresPrestados) {
        this.titulo = titulo;
        this.autor = autor;
        this.ejemplaresTotales = Math.max(0, ejemplaresTotales);
        this.ejemplaresPrestados = Math.max(0, Math.min(ejemplaresPrestados, this.ejemplaresTotales));
    }

    public boolean prestar() {
        if (disponibles() > 0) {
            ejemplaresPrestados++;
            return true;
        }
        return false;
    }

    public boolean devolver() {
        if (ejemplaresPrestados > 0) {
            ejemplaresPrestados--;
            return true;
        }
        return false;
    }

    public int disponibles() {
        return ejemplaresTotales - ejemplaresPrestados;
    }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getAutor() { return autor; }
    public void setAutor(String autor) { this.autor = autor; }

    public int getEjemplaresTotales() { return ejemplaresTotales; }
    public void setEjemplaresTotales(int ejemplaresTotales) {
        if (ejemplaresTotales >= ejemplaresPrestados && ejemplaresTotales >= 0)
            this.ejemplaresTotales = ejemplaresTotales;
    }

    public int getEjemplaresPrestados() { return ejemplaresPrestados; }
    public void setEjemplaresPrestados(int ejemplaresPrestados) {
        if (ejemplaresPrestados >= 0 && ejemplaresPrestados <= ejemplaresTotales)
            this.ejemplaresPrestados = ejemplaresPrestados;
    }

    @Override
    public String toString() {
        return titulo + " - disp: " + disponibles() + "/" + ejemplaresTotales;
    }
}
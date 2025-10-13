public class Libro {
    private String titulo;
    private int disponibles;
    private int total;
    
    public Libro(String titulo, int disponibles, int total) {
        this.titulo = titulo;
        this.disponibles = disponibles;
        this.total = total;
    }
    
    public String getTitulo() {
        return titulo;
    }
    
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    
    public int getDisponibles() {
        return disponibles;
    }
    
    public void setDisponibles(int disponibles) {
        this.disponibles = disponibles;
    }
    
    public int getTotal() {
        return total;
    }
    
    public void setTotal(int total) {
        this.total = total;
    }
    
    public void prestar() {
        if (disponibles > 0) {
            disponibles--;
        }
    }
    
    public void devolver() {
        if (disponibles < total) {
            disponibles++;
        }
    }
    
    @Override
    public String toString() {
        return titulo + "- disponibles " + disponibles + "/" + total;
    }
}

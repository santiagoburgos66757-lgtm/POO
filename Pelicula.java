public class Pelicula {
    private String titulo;
    private String clasificacion;
    private int disponibles;
    private int total;
    
    public Pelicula(String titulo, String clasificacion, int disponibles, int total) {
        this.titulo = titulo;
        this.clasificacion = clasificacion;
        this.disponibles = disponibles;
        this.total = total;
    }
    
    public String getTitulo() {
        return titulo;
    }
    
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    
    public String getClasificacion() {
        return clasificacion;
    }
    
    public void setClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
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
    
    public void rentar() {
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
        return titulo + " (" + clasificacion + ") | disp: " + disponibles + "/" + total;
    }
}

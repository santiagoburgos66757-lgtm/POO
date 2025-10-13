import java.util.HashMap;
import java.util.Map;

public class Pelicula {
    private String titulo;
    private int anio;
    private String clasificacion;
    private int copias;
    private int alquiladas;
    private static final Map<String, Integer> EDAD_MINIMA;
    static {
        EDAD_MINIMA = new HashMap<>();
        EDAD_MINIMA.put("G", 0);
        EDAD_MINIMA.put("PG13", 13);
        EDAD_MINIMA.put("R", 17);
    }

    public Pelicula() {
        this("", 1900, "G", 0, 0);
    }

    public Pelicula(String titulo, int anio, String clasificacion, int copias, int alquiladas) {
        this.titulo = titulo;
        this.anio = Math.max(anio, 1900);
        this.clasificacion = clasificacion;
        this.copias = Math.max(0, copias);
        this.alquiladas = Math.max(0, Math.min(alquiladas, this.copias));
    }

    public boolean alquilar(int edadCliente) {
        int edadMinima = EDAD_MINIMA.getOrDefault(clasificacion, 0);
        if (copias - alquiladas > 0 && edadCliente >= edadMinima) {
            alquiladas++;
            return true;
        }
        return false;
    }

    public boolean devolver() {
        if (alquiladas > 0) {
            alquiladas--;
            return true;
        }
        return false;
    }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public int getAnio() { return anio; }
    public void setAnio(int anio) { if (anio >= 1900) this.anio = anio; }

    public String getClasificacion() { return clasificacion; }
    public void setClasificacion(String clasificacion) { this.clasificacion = clasificacion; }

    public int getCopias() { return copias; }
    public void setCopias(int copias) { if (copias >= alquiladas) this.copias = copias; }

    public int getAlquiladas() { return alquiladas; }
    public void setAlquiladas(int alquiladas) { if (alquiladas >= 0 && alquiladas <= copias) this.alquiladas = alquiladas; }

    @Override
    public String toString() {
        return titulo + " (" + clasificacion + ") | disp: " + (copias - alquiladas) + "/" + copias;
    }
}
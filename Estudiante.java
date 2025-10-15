import java.text.DecimalFormat;

public class Estudiante {
    private int id;
    private String nombre;
    private double promedio;
    
    public Estudiante(int id, String nombre, double promedio) {
        this.id = id;
        this.nombre = nombre;
        this.promedio = promedio;
    }
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public double getPromedio() {
        return promedio;
    }
    
    public void setPromedio(double promedio) {
        this.promedio = promedio;
    }
    
    public String getEstado() {
        return promedio >= 3.0 ? "Aprobado" : "Reprobado";
    }
    
    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("0.0");
        return "ID: " + id + " | Prom: " + df.format(promedio) + " | " + getEstado() + ".";
    }
}

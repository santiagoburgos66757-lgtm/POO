public class Estudiante {
    private String id;
    private String nombre;
    private double nota1, nota2, nota3;

    public Estudiante() {
        this("", "", 0.0, 0.0, 0.0);
    }

    public Estudiante(String id, String nombre, double nota1, double nota2, double nota3) {
        this.id = id;
        this.nombre = nombre;
        setNota1(nota1);
        setNota2(nota2);
        setNota3(nota3);
    }

    public double getPromedio() {
        double prom = (nota1 + nota2 + nota3) / 3.0;
        return Math.round(prom * 10.0) / 10.0;
    }

    public boolean aprobado() {
        return getPromedio() >= 3.0;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public double getNota1() { return nota1; }
    public void setNota1(double nota1) {
        if (nota1 >= 0.0 && nota1 <= 5.0) this.nota1 = nota1;
    }

    public double getNota2() { return nota2; }
    public void setNota2(double nota2) {
        if (nota2 >= 0.0 && nota2 <= 5.0) this.nota2 = nota2;
    }

    public double getNota3() { return nota3; }
    public void setNota3(double nota3) {
        if (nota3 >= 0.0 && nota3 <= 5.0) this.nota3 = nota3;
    }

    @Override
    public String toString() {
        return "ID: " + id + " | Prom: " + getPromedio() + " | Aprobado: " + aprobado();
    }
}
public class Paciente {
    private String documento;
    private String nombre;
    private int edad;
    private char nivelTriage; // A–E
    private boolean atendido;

    public Paciente() {
        this("", "", 0, 'E', false);
    }

    public Paciente(String documento, String nombre, int edad, char nivelTriage, boolean atendido) {
        this.documento = documento;
        this.nombre = nombre;
        setEdad(edad);
        setNivelTriage(nivelTriage);
        this.atendido = atendido;
    }

    public int prioridad() {
        return "ABCDE".indexOf(nivelTriage) + 1;
    }

    public void marcarAtendido() { this.atendido = true; }

    public String getDocumento() { return documento; }
    public void setDocumento(String documento) { this.documento = documento; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public int getEdad() { return edad; }
    public void setEdad(int edad) { if (edad >= 0) this.edad = edad; }

    public char getNivelTriage() { return nivelTriage; }
    public void setNivelTriage(char nivelTriage) {
        if ("ABCDE".indexOf(nivelTriage) >= 0)
            this.nivelTriage = nivelTriage;
    }

    public boolean isAtendido() { return atendido; }
    public void setAtendido(boolean atendido) { this.atendido = atendido; }

    @Override
    public String toString() {
        return "Triage " + nivelTriage + " | Prioridad " + prioridad() + " | Atendido: " + atendido;
    }
}
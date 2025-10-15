public class Paciente {
    private String nombre;
    private String triage;
    private int prioridad;
    private boolean atendido;
    
    public Paciente(String nombre, String triage, int prioridad, boolean atendido) {
        this.nombre = nombre;
        this.triage = triage;
        this.prioridad = prioridad;
        this.atendido = atendido;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getTriage() {
        return triage;
    }
    
    public void setTriage(String triage) {
        this.triage = triage;
    }
    
    public int getPrioridad() {
        return prioridad;
    }
    
    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }
    
    public boolean isAtendido() {
        return atendido;
    }
    
    public void setAtendido(boolean atendido) {
        this.atendido = atendido;
    }
    
    public void marcarAtendido() {
        this.atendido = true;
    }
    
    @Override
    public String toString() {
        return "Triage " + triage + " | Prioridad " + prioridad + " | Atendido: " + atendido;
    }
}

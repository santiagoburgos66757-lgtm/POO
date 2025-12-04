import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Comparator;

/**
 * Gestiona la cola de revisiones pendientes
 * Implementa priorización de solicitudes
 */
public class ColaRevision {
    private String id;
    private PriorityQueue<SolicitudRevision> colaPrioridad;
    private List<SolicitudRevision> historial;
    private int capacidadMaxima;

    public ColaRevision() {
        this("CR-001", 100);
    }

    public ColaRevision(String id, int capacidadMaxima) {
        this.id = id;
        this.capacidadMaxima = capacidadMaxima;
        this.historial = new ArrayList<>();
        
        // Comparador para priorizar: Alta > Media > Baja, y por fecha
        Comparator<SolicitudRevision> comparador = (s1, s2) -> {
            int prioridadCompare = getPrioridadNumero(s2.getPrioridad()) - 
                                  getPrioridadNumero(s1.getPrioridad());
            if (prioridadCompare != 0) return prioridadCompare;
            return s1.getFechaSolicitud().compareTo(s2.getFechaSolicitud());
        };
        
        this.colaPrioridad = new PriorityQueue<>(comparador);
    }

    /**
     * Convierte prioridad a número para comparación
     */
    private int getPrioridadNumero(String prioridad) {
        switch (prioridad) {
            case "Alta": return 3;
            case "Media": return 2;
            case "Baja": return 1;
            default: return 0;
        }
    }

    /**
     * Agrega una solicitud a la cola
     */
    public boolean agregar(SolicitudRevision solicitud) {
        if (solicitud != null && colaPrioridad.size() < capacidadMaxima) {
            colaPrioridad.offer(solicitud);
            historial.add(solicitud);
            return true;
        }
        return false;
    }

    /**
     * Obtiene la siguiente solicitud de mayor prioridad
     */
    public SolicitudRevision obtenerSiguiente() {
        return colaPrioridad.poll();
    }

    /**
     * Visualiza la siguiente solicitud sin removerla
     */
    public SolicitudRevision verSiguiente() {
        return colaPrioridad.peek();
    }

    /**
     * Obtiene el tamaño actual de la cola
     */
    public int tamaño() {
        return colaPrioridad.size();
    }

    /**
     * Verifica si la cola está vacía
     */
    public boolean estaVacia() {
        return colaPrioridad.isEmpty();
    }

    /**
     * Verifica si la cola está llena
     */
    public boolean estaLlena() {
        return colaPrioridad.size() >= capacidadMaxima;
    }

    /**
     * Cuenta solicitudes por prioridad
     */
    public int contarPorPrioridad(String prioridad) {
        int contador = 0;
        for (SolicitudRevision s : colaPrioridad) {
            if (s.getPrioridad().equals(prioridad)) {
                contador++;
            }
        }
        return contador;
    }

    /**
     * Obtiene estadísticas de la cola
     */
    public String obtenerEstadisticas() {
        int alta = contarPorPrioridad("Alta");
        int media = contarPorPrioridad("Media");
        int baja = contarPorPrioridad("Baja");
        
        return "Total en cola: " + tamaño() + " | Alta: " + alta + 
               " | Media: " + media + " | Baja: " + baja;
    }

    // Getters y Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public List<SolicitudRevision> getHistorial() { return new ArrayList<>(historial); }
    public void setHistorial(List<SolicitudRevision> historial) { 
        this.historial = new ArrayList<>(historial); 
    }

    public int getCapacidadMaxima() { return capacidadMaxima; }
    public void setCapacidadMaxima(int capacidadMaxima) { 
        if (capacidadMaxima > 0) this.capacidadMaxima = capacidadMaxima; 
    }

    @Override
    public String toString() {
        return "Cola de Revisión | " + obtenerEstadisticas();
    }
}

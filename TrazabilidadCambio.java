import java.util.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * Gestiona la trazabilidad de cambios en documentos y consultas
 * Mantiene un historial completo de modificaciones
 */
public class TrazabilidadCambio {
    private String id;
    private String elementoId; // ID del documento o consulta
    private String tipoElemento; // "Documento", "Consulta", "Plantilla"
    private List<RegistroCambio> cambios;
    private Date fechaCreacion;
    
    /**
     * Clase interna para registrar cambios individuales
     */
    public static class RegistroCambio {
        private String id;
        private String usuarioId;
        private Date fecha;
        private String tipoAccion; // "Creación", "Modificación", "Aprobación", "Rechazo", "Revisión"
        private String descripcion;
        private String valorAnterior;
        private String valorNuevo;
        
        public RegistroCambio(String id, String usuarioId, String tipoAccion, String descripcion) {
            this.id = id;
            this.usuarioId = usuarioId;
            this.tipoAccion = tipoAccion;
            this.descripcion = descripcion;
            this.fecha = new Date();
            this.valorAnterior = "";
            this.valorNuevo = "";
        }
        
        // Getters y Setters
        public String getId() { return id; }
        public String getUsuarioId() { return usuarioId; }
        public Date getFecha() { return fecha; }
        public String getTipoAccion() { return tipoAccion; }
        public String getDescripcion() { return descripcion; }
        public String getValorAnterior() { return valorAnterior; }
        public void setValorAnterior(String valorAnterior) { this.valorAnterior = valorAnterior; }
        public String getValorNuevo() { return valorNuevo; }
        public void setValorNuevo(String valorNuevo) { this.valorNuevo = valorNuevo; }
        
        @Override
        public String toString() {
            return tipoAccion + " por " + usuarioId + " - " + descripcion;
        }
    }

    public TrazabilidadCambio() {
        this("", "", "Documento");
    }

    public TrazabilidadCambio(String id, String elementoId, String tipoElemento) {
        this.id = id;
        this.elementoId = elementoId;
        this.tipoElemento = tipoElemento;
        this.cambios = new ArrayList<>();
        this.fechaCreacion = new Date();
    }

    /**
     * Registra un nuevo cambio
     */
    public boolean registrarCambio(String usuarioId, String tipoAccion, String descripcion) {
        String cambioId = "C" + (cambios.size() + 1);
        RegistroCambio cambio = new RegistroCambio(cambioId, usuarioId, tipoAccion, descripcion);
        cambios.add(cambio);
        return true;
    }

    /**
     * Registra un cambio con valores anterior y nuevo
     */
    public boolean registrarCambioConValores(String usuarioId, String tipoAccion, 
                                            String descripcion, String valorAnterior, 
                                            String valorNuevo) {
        String cambioId = "C" + (cambios.size() + 1);
        RegistroCambio cambio = new RegistroCambio(cambioId, usuarioId, tipoAccion, descripcion);
        cambio.setValorAnterior(valorAnterior);
        cambio.setValorNuevo(valorNuevo);
        cambios.add(cambio);
        return true;
    }

    /**
     * Obtiene el historial completo de cambios
     */
    public List<RegistroCambio> obtenerHistorial() {
        return new ArrayList<>(cambios);
    }

    /**
     * Obtiene cambios por tipo de acción
     */
    public List<RegistroCambio> obtenerCambiosPorTipo(String tipoAccion) {
        List<RegistroCambio> resultado = new ArrayList<>();
        for (RegistroCambio cambio : cambios) {
            if (cambio.getTipoAccion().equals(tipoAccion)) {
                resultado.add(cambio);
            }
        }
        return resultado;
    }

    /**
     * Obtiene el último cambio registrado
     */
    public RegistroCambio obtenerUltimoCambio() {
        if (cambios.isEmpty()) return null;
        return cambios.get(cambios.size() - 1);
    }

    /**
     * Cuenta el número total de cambios
     */
    public int contarCambios() {
        return cambios.size();
    }

    /**
     * Obtiene estadísticas de cambios
     */
    public String obtenerEstadisticas() {
        int modificaciones = obtenerCambiosPorTipo("Modificación").size();
        int revisiones = obtenerCambiosPorTipo("Revisión").size();
        int aprobaciones = obtenerCambiosPorTipo("Aprobación").size();
        
        return "Total cambios: " + cambios.size() + " | Modificaciones: " + modificaciones + 
               " | Revisiones: " + revisiones + " | Aprobaciones: " + aprobaciones;
    }

    // Getters y Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getElementoId() { return elementoId; }
    public void setElementoId(String elementoId) { this.elementoId = elementoId; }

    public String getTipoElemento() { return tipoElemento; }
    public void setTipoElemento(String tipoElemento) { this.tipoElemento = tipoElemento; }

    public List<RegistroCambio> getCambios() { return new ArrayList<>(cambios); }
    public void setCambios(List<RegistroCambio> cambios) { this.cambios = new ArrayList<>(cambios); }

    public Date getFechaCreacion() { return fechaCreacion; }
    public void setFechaCreacion(Date fechaCreacion) { this.fechaCreacion = fechaCreacion; }

    @Override
    public String toString() {
        return "Trazabilidad " + tipoElemento + " #" + elementoId + " | " + obtenerEstadisticas();
    }
}

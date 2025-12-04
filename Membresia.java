import java.util.Date;

/**
 * Representa una membresía asociada a un usuario
 * Maneja los diferentes tipos de planes y su validación
 */
public class Membresia {
    private String id;
    private String usuarioId;
    private String tipo; // "Basica", "Premium", "Enterprise"
    private Date fechaInicio;
    private Date fechaVencimiento;
    private boolean activa;
    private double precioMensual;
    private int consultasMensuales; // Límite de consultas (-1 = ilimitadas)
    private int consultasUsadas;
    private boolean incluyeRevisionHumana;

    public Membresia() {
        this("", "", "Basica", 50.0, 10, false);
    }

    public Membresia(String id, String usuarioId, String tipo, double precioMensual, 
                    int consultasMensuales, boolean incluyeRevisionHumana) {
        this.id = id;
        this.usuarioId = usuarioId;
        this.tipo = tipo;
        this.fechaInicio = new Date();
        this.fechaVencimiento = calcularFechaVencimiento(30); // 30 días por defecto
        this.activa = false; // Requiere pago para activarse
        this.precioMensual = Math.max(0, precioMensual);
        this.consultasMensuales = consultasMensuales;
        this.consultasUsadas = 0;
        this.incluyeRevisionHumana = incluyeRevisionHumana;
    }

    /**
     * Calcula la fecha de vencimiento basada en días desde hoy
     */
    private Date calcularFechaVencimiento(int dias) {
        long ahora = new Date().getTime();
        long milisegundosPorDia = 24 * 60 * 60 * 1000L;
        return new Date(ahora + (dias * milisegundosPorDia));
    }

    /**
     * Valida si la membresía está activa y vigente
     */
    public boolean esValida() {
        Date ahora = new Date();
        return activa && ahora.before(fechaVencimiento);
    }

    /**
     * Verifica si se pueden realizar más consultas
     */
    public boolean puedeConsultar() {
        if (!esValida()) return false;
        if (consultasMensuales == -1) return true; // Ilimitadas
        return consultasUsadas < consultasMensuales;
    }

    /**
     * Registra el uso de una consulta
     */
    public boolean registrarConsulta() {
        if (puedeConsultar()) {
            consultasUsadas++;
            return true;
        }
        return false;
    }

    /**
     * Renueva la membresía por un período adicional
     */
    public boolean renovar(int dias) {
        if (dias > 0) {
            this.fechaVencimiento = calcularFechaVencimiento(dias);
            this.consultasUsadas = 0; // Reinicia el contador de consultas
            this.activa = true;
            return true;
        }
        return false;
    }

    /**
     * Activa la membresía (típicamente después de un pago)
     */
    public void activar() {
        this.activa = true;
    }

    /**
     * Desactiva la membresía
     */
    public void desactivar() {
        this.activa = false;
    }

    /**
     * Obtiene las consultas restantes
     */
    public int consultasRestantes() {
        if (consultasMensuales == -1) return -1; // Ilimitadas
        return Math.max(0, consultasMensuales - consultasUsadas);
    }

    // Getters y Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getUsuarioId() { return usuarioId; }
    public void setUsuarioId(String usuarioId) { this.usuarioId = usuarioId; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public Date getFechaInicio() { return fechaInicio; }
    public void setFechaInicio(Date fechaInicio) { this.fechaInicio = fechaInicio; }

    public Date getFechaVencimiento() { return fechaVencimiento; }
    public void setFechaVencimiento(Date fechaVencimiento) { this.fechaVencimiento = fechaVencimiento; }

    public boolean isActiva() { return activa; }
    public void setActiva(boolean activa) { this.activa = activa; }

    public double getPrecioMensual() { return precioMensual; }
    public void setPrecioMensual(double precioMensual) { 
        if (precioMensual >= 0) this.precioMensual = precioMensual; 
    }

    public int getConsultasMensuales() { return consultasMensuales; }
    public void setConsultasMensuales(int consultasMensuales) { 
        this.consultasMensuales = consultasMensuales; 
    }

    public int getConsultasUsadas() { return consultasUsadas; }
    public void setConsultasUsadas(int consultasUsadas) { 
        if (consultasUsadas >= 0) this.consultasUsadas = consultasUsadas; 
    }

    public boolean isIncluyeRevisionHumana() { return incluyeRevisionHumana; }
    public void setIncluyeRevisionHumana(boolean incluyeRevisionHumana) { 
        this.incluyeRevisionHumana = incluyeRevisionHumana; 
    }

    @Override
    public String toString() {
        String estado = esValida() ? "Válida" : "Inactiva/Vencida";
        return "Membresía " + tipo + " | Estado: " + estado + 
               " | Consultas: " + consultasUsadas + "/" + 
               (consultasMensuales == -1 ? "∞" : consultasMensuales);
    }
}

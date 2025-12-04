import java.util.Date;

/**
 * Representa un pago realizado por un usuario para activar o renovar una membresía
 */
public class Pago {
    private String id;
    private String membresiaId;
    private String usuarioId;
    private double monto;
    private Date fechaPago;
    private String metodoPago; // "Tarjeta", "Transferencia", "PayPal", etc.
    private String estadoPago; // "Pendiente", "Aprobado", "Rechazado", "Reembolsado"
    private String transaccionId;
    private String descripcion;

    public Pago() {
        this("", "", "", 0.0, "Tarjeta", "Pendiente");
    }

    public Pago(String id, String membresiaId, String usuarioId, double monto, 
                String metodoPago, String estadoPago) {
        this.id = id;
        this.membresiaId = membresiaId;
        this.usuarioId = usuarioId;
        this.monto = Math.max(0, monto);
        this.fechaPago = new Date();
        this.metodoPago = metodoPago;
        this.estadoPago = estadoPago;
        this.transaccionId = "";
        this.descripcion = "";
    }

    /**
     * Aprueba el pago
     */
    public boolean aprobar(String transaccionId) {
        if (estadoPago.equals("Pendiente")) {
            this.estadoPago = "Aprobado";
            this.transaccionId = transaccionId;
            return true;
        }
        return false;
    }

    /**
     * Rechaza el pago
     */
    public boolean rechazar() {
        if (estadoPago.equals("Pendiente")) {
            this.estadoPago = "Rechazado";
            return true;
        }
        return false;
    }

    /**
     * Reembolsa el pago
     */
    public boolean reembolsar() {
        if (estadoPago.equals("Aprobado")) {
            this.estadoPago = "Reembolsado";
            return true;
        }
        return false;
    }

    /**
     * Verifica si el pago fue exitoso
     */
    public boolean esExitoso() {
        return estadoPago.equals("Aprobado");
    }

    // Getters y Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getMembresiaId() { return membresiaId; }
    public void setMembresiaId(String membresiaId) { this.membresiaId = membresiaId; }

    public String getUsuarioId() { return usuarioId; }
    public void setUsuarioId(String usuarioId) { this.usuarioId = usuarioId; }

    public double getMonto() { return monto; }
    public void setMonto(double monto) { if (monto >= 0) this.monto = monto; }

    public Date getFechaPago() { return fechaPago; }
    public void setFechaPago(Date fechaPago) { this.fechaPago = fechaPago; }

    public String getMetodoPago() { return metodoPago; }
    public void setMetodoPago(String metodoPago) { this.metodoPago = metodoPago; }

    public String getEstadoPago() { return estadoPago; }
    public void setEstadoPago(String estadoPago) { this.estadoPago = estadoPago; }

    public String getTransaccionId() { return transaccionId; }
    public void setTransaccionId(String transaccionId) { this.transaccionId = transaccionId; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    @Override
    public String toString() {
        return "Pago #" + id + " | $" + String.format("%.2f", monto) + 
               " | " + metodoPago + " | Estado: " + estadoPago;
    }
}

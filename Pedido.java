public class Pedido {
    private String id;
    private int unidades;
    private double precioUnitario;
    private double costoEnvio;
    private boolean pagado;

    public Pedido() {
        this("", 1, 0.0, 0.0, false);
    }

    public Pedido(String id, int unidades, double precioUnitario, double costoEnvio, boolean pagado) {
        this.id = id;
        this.unidades = Math.max(1, unidades);
        this.precioUnitario = Math.max(0.0, precioUnitario);
        this.costoEnvio = Math.max(0.0, costoEnvio);
        this.pagado = pagado;
    }

    public double total() {
        return Math.round((unidades * precioUnitario + costoEnvio) * 100.0) / 100.0;
    }

    public boolean pagar() {
        if (!pagado && total() > 0) {
            pagado = true;
            return true;
        }
        return false;
    }

    public boolean cancelar() {
        if (!pagado) {
            pagado = false;
            return true;
        }
        return false;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public int getUnidades() { return unidades; }
    public void setUnidades(int unidades) { if (unidades >= 1) this.unidades = unidades; }

    public double getPrecioUnitario() { return precioUnitario; }
    public void setPrecioUnitario(double precioUnitario) { if (precioUnitario >= 0) this.precioUnitario = precioUnitario; }

    public double getCostoEnvio() { return costoEnvio; }
    public void setCostoEnvio(double costoEnvio) { if (costoEnvio >= 0) this.costoEnvio = costoEnvio; }

    public boolean isPagado() { return pagado; }

    @Override
    public String toString() {
        return "Pedido " + id + " | Total: $" + String.format("%.2f", total()) + " | Pagado: " + pagado;
    }
}
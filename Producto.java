public class Producto {
    private String codigo;
    private String nombre;
    private int stock;
    private double precioUnitario;
    private boolean activo;

    public Producto() {
        this("", "", 0, 0.0, true);
    }

    public Producto(String codigo, String nombre, int stock, double precioUnitario, boolean activo) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.stock = Math.max(0, stock);
        this.precioUnitario = Math.max(0.0, precioUnitario);
        this.activo = activo;
    }

    public boolean ingresar(int cantidad) {
        if (cantidad > 0) {
            stock += cantidad;
            return true;
        }
        return false;
    }

    public boolean vender(int cantidad) {
        if (cantidad > 0 && stock >= cantidad) {
            stock -= cantidad;
            return true;
        }
        return false;
    }

    public void descontinuar() { activo = false; }

    public String getCodigo() { return codigo; }
    public void setCodigo(String codigo) { this.codigo = codigo; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public int getStock() { return stock; }
    public void setStock(int stock) { if (stock >= 0) this.stock = stock; }

    public double getPrecioUnitario() { return Math.round(precioUnitario * 100.0) / 100.0; }
    public void setPrecioUnitario(double precioUnitario) { if (precioUnitario >= 0) this.precioUnitario = precioUnitario; }

    public boolean isActivo() { return activo; }
    public void setActivo(boolean activo) { this.activo = activo; }

    @Override
    public String toString() {
        return codigo + " - " + nombre + " | stock: " + stock + " | $" + String.format("%.2f", getPrecioUnitario());
    }
}
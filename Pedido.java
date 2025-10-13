import java.text.DecimalFormat;

public class Pedido {
    private String codigo;
    private double total;
    private boolean pagado;
    
    public Pedido(String codigo, double total, boolean pagado) {
        this.codigo = codigo;
        this.total = total;
        this.pagado = pagado;
    }
    
    public String getCodigo() {
        return codigo;
    }
    
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    
    public double getTotal() {
        return total;
    }
    
    public void setTotal(double total) {
        this.total = total;
    }
    
    public boolean isPagado() {
        return pagado;
    }
    
    public void setPagado(boolean pagado) {
        this.pagado = pagado;
    }
    
    public void marcarPagado() {
        this.pagado = true;
    }
    
    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("0.00");
        return "Pedido " + codigo + " | Total: $" + df.format(total) + " | Pagado: " + pagado;
    }
}

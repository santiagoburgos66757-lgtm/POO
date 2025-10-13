import java.text.DecimalFormat;

public class Reserva {
    private int noches;
    private double precioPorNoche;
    
    public Reserva(int noches, double precioPorNoche) {
        this.noches = noches;
        this.precioPorNoche = precioPorNoche;
    }
    
    public int getNoches() {
        return noches;
    }
    
    public void setNoches(int noches) {
        this.noches = noches;
    }
    
    public double getPrecioPorNoche() {
        return precioPorNoche;
    }
    
    public void setPrecioPorNoche(double precioPorNoche) {
        this.precioPorNoche = precioPorNoche;
    }
    
    public double calcularTotal() {
        return noches * precioPorNoche;
    }
    
    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("0.00");
        return noches + " noches | $" + df.format(calcularTotal());
    }
}

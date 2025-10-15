import java.text.DecimalFormat;

public class Vehiculo {
    private String placa;
    private double tanqueCapacidad;
    private double tanqueActual;
    private double consumoPorKm;
    
    public Vehiculo(String placa, double tanqueCapacidad, double tanqueActual, double consumoPorKm) {
        this.placa = placa;
        this.tanqueCapacidad = tanqueCapacidad;
        this.tanqueActual = tanqueActual;
        this.consumoPorKm = consumoPorKm;
    }
    
    public String getPlaca() {
        return placa;
    }
    
    public void setPlaca(String placa) {
        this.placa = placa;
    }
    
    public double getTanqueCapacidad() {
        return tanqueCapacidad;
    }
    
    public void setTanqueCapacidad(double tanqueCapacidad) {
        this.tanqueCapacidad = tanqueCapacidad;
    }
    
    public double getTanqueActual() {
        return tanqueActual;
    }
    
    public void setTanqueActual(double tanqueActual) {
        this.tanqueActual = tanqueActual;
    }
    
    public double getConsumoPorKm() {
        return consumoPorKm;
    }
    
    public void setConsumoPorKm(double consumoPorKm) {
        this.consumoPorKm = consumoPorKm;
    }
    
    public double calcularAutonomia() {
        return tanqueActual / consumoPorKm;
    }
    
    public void cargarCombustible(double litros) {
        if (litros > 0 && tanqueActual + litros <= tanqueCapacidad) {
            tanqueActual += litros;
        }
    }
    
    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("0.0");
        return placa + " | Autonomía: " + df.format(calcularAutonomia()) + " km.";
    }
}

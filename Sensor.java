import java.text.DecimalFormat;

public class Sensor {
    private String id;
    private double temperatura;
    private boolean alarma;
    
    public Sensor(String id, double temperatura, boolean alarma) {
        this.id = id;
        this.temperatura = temperatura;
        this.alarma = alarma;
    }
    
    public String getId() {
        return id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
    public double getTemperatura() {
        return temperatura;
    }
    
    public void setTemperatura(double temperatura) {
        this.temperatura = temperatura;
    }
    
    public boolean isAlarma() {
        return alarma;
    }
    
    public void setAlarma(boolean alarma) {
        this.alarma = alarma;
    }
    
    public void activarAlarma() {
        this.alarma = true;
    }
    
    public void desactivarAlarma() {
        this.alarma = false;
    }
    
    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("0.0");
        return id + " | " + df.format(temperatura) + "°C | Alarma: " + alarma;
    }
}

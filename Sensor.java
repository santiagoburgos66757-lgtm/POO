public class Sensor {
    private String id;
    private double ultimaLecturaC;
    private double umbralAlto;
    private double umbralBajo;
    private boolean activo;

    public Sensor() {
        this("", 0.0, 100.0, 0.0, true);
    }

    public Sensor(String id, double ultimaLecturaC, double umbralAlto, double umbralBajo, boolean activo) {
        this.id = id;
        if (umbralBajo < umbralAlto) {
            this.umbralBajo = umbralBajo;
            this.umbralAlto = umbralAlto;
        } else {
            this.umbralBajo = 0.0;
            this.umbralAlto = 100.0;
        }
        this.ultimaLecturaC = ultimaLecturaC;
        this.activo = activo;
    }

    public void actualizarLectura(double lectura) {
        if (activo)
            this.ultimaLecturaC = lectura;
    }

    public boolean enAlarma() {
        return ultimaLecturaC < umbralBajo || ultimaLecturaC > umbralAlto;
    }

    public void activar() { activo = true; }
    public void desactivar() { activo = false; }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public double getUltimaLecturaC() { return ultimaLecturaC; }

    public double getUmbralAlto() { return umbralAlto; }
    public void setUmbralAlto(double umbralAlto) {
        if (umbralAlto > umbralBajo) this.umbralAlto = umbralAlto;
    }

    public double getUmbralBajo() { return umbralBajo; }
    public void setUmbralBajo(double umbralBajo) {
        if (umbralBajo < umbralAlto) this.umbralBajo = umbralBajo;
    }

    public boolean isActivo() { return activo; }
    public void setActivo(boolean activo) { this.activo = activo; }

    @Override
    public String toString() {
        return id + " | " + String.format("%.1f", ultimaLecturaC) + "°C | Alarma: " + enAlarma();
    }
}
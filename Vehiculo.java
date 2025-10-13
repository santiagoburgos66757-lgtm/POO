public class Vehiculo {
    private String placa;
    private String marca;
    private double capacidadTanqueLitros;
    private double combustibleActual;
    private double kmPorLitro;

    public Vehiculo() {
        this("", "", 1.0, 0.0, 1.0);
    }

    public Vehiculo(String placa, String marca, double capacidadTanqueLitros, double combustibleActual, double kmPorLitro) {
        this.placa = placa;
        this.marca = marca;
        this.capacidadTanqueLitros = Math.max(0.1, capacidadTanqueLitros);
        this.kmPorLitro = Math.max(0.1, kmPorLitro);
        this.combustibleActual = Math.max(0, Math.min(combustibleActual, this.capacidadTanqueLitros));
    }

    public boolean recargar(double litros) {
        if (litros > 0 && combustibleActual + litros <= capacidadTanqueLitros) {
            combustibleActual += litros;
            return true;
        }
        return false;
    }

    public boolean conducir(double km) {
        double requerido = km / kmPorLitro;
        if (km > 0 && requerido <= combustibleActual) {
            combustibleActual -= requerido;
            return true;
        }
        return false;
    }

    public double autonomia() {
        return Math.round(combustibleActual * kmPorLitro * 10.0) / 10.0;
    }

    public String getPlaca() { return placa; }
    public void setPlaca(String placa) { this.placa = placa; }

    public String getMarca() { return marca; }
    public void setMarca(String marca) { this.marca = marca; }

    public double getCapacidadTanqueLitros() { return capacidadTanqueLitros; }
    public void setCapacidadTanqueLitros(double capacidadTanqueLitros) {
        if (capacidadTanqueLitros > 0 && capacidadTanqueLitros >= combustibleActual)
            this.capacidadTanqueLitros = capacidadTanqueLitros;
    }

    public double getCombustibleActual() { return combustibleActual; }
    public void setCombustibleActual(double combustibleActual) {
        if (combustibleActual >= 0 && combustibleActual <= capacidadTanqueLitros)
            this.combustibleActual = combustibleActual;
    }

    public double getKmPorLitro() { return kmPorLitro; }
    public void setKmPorLitro(double kmPorLitro) { if (kmPorLitro > 0) this.kmPorLitro = kmPorLitro; }

    @Override
    public String toString() {
        return placa + " | Autonomía: " + autonomia() + " km.";
    }
}
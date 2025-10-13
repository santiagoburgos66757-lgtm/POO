import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class ReservaHotel {
    private String huesped;
    private LocalDate ingreso;
    private LocalDate salida;
    private double tarifaNoche;
    private boolean confirmada;

    public ReservaHotel() {
        this("", LocalDate.now(), LocalDate.now().plusDays(1), 0.0, false);
    }

    public ReservaHotel(String huesped, LocalDate ingreso, LocalDate salida, double tarifaNoche, boolean confirmada) {
        this.huesped = huesped;
        setFechas(ingreso, salida);
        this.tarifaNoche = Math.max(0.0, tarifaNoche);
        this.confirmada = confirmada;
    }

    private void setFechas(LocalDate ingreso, LocalDate salida) {
        if (salida.isAfter(ingreso)) {
            this.ingreso = ingreso;
            this.salida = salida;
        } else {
            this.ingreso = ingreso;
            this.salida = ingreso.plusDays(1);
        }
    }

    public long noches() {
        return ChronoUnit.DAYS.between(ingreso, salida);
    }

    public double total() {
        return Math.round(noches() * tarifaNoche * 100.0) / 100.0;
    }

    public void confirmar() { confirmada = true; }

    public boolean cancelar() {
        if (!confirmada || ChronoUnit.HOURS.between(LocalDate.now().atStartOfDay(), ingreso.atStartOfDay()) >= 48) {
            confirmada = false;
            return true;
        }
        return false;
    }

    public String getHuesped() { return huesped; }
    public void setHuesped(String huesped) { this.huesped = huesped; }

    public LocalDate getIngreso() { return ingreso; }
    public LocalDate getSalida() { return salida; }

    public void setIngreso(LocalDate ingreso) { setFechas(ingreso, this.salida); }
    public void setSalida(LocalDate salida) { setFechas(this.ingreso, salida); }

    public double getTarifaNoche() { return tarifaNoche; }
    public void setTarifaNoche(double tarifaNoche) { if (tarifaNoche >= 0) this.tarifaNoche = tarifaNoche; }

    public boolean isConfirmada() { return confirmada; }
    public void setConfirmada(boolean confirmada) { this.confirmada = confirmada; }

    @Override
    public String toString() {
        return noches() + " noches | $" + String.format("%.2f", total());
    }
}
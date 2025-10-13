public class CuentaBancaria {
    private String titular;
    private String numero;
    private double saldo;
    private boolean activa;

    public CuentaBancaria() {
        this("", "", 0.0, true);
    }

    public CuentaBancaria(String titular, String numero, double saldo, boolean activa) {
        this.titular = titular;
        this.numero = numero;
        this.saldo = Math.max(0, saldo);
        this.activa = activa;
    }

    public boolean depositar(double monto) {
        if (activa && monto > 0) {
            saldo += monto;
            return true;
        }
        return false;
    }

    public boolean retirar(double monto) {
        if (activa && monto > 0 && saldo >= monto) {
            saldo -= monto;
            return true;
        }
        return false;
    }

    public void bloquear() { activa = false; }
    public void activar() { activa = true; }

    public String getTitular() { return titular; }
    public void setTitular(String titular) { this.titular = titular; }

    public String getNumero() { return numero; }
    public void setNumero(String numero) { this.numero = numero; }

    public double getSaldo() { return saldo; }
    private void setSaldo(double saldo) { this.saldo = saldo; }

    public boolean isActiva() { return activa; }
    public void setActiva(boolean activa) { this.activa = activa; }

    @Override
    public String toString() {
        return "Cuenta " + numero + " | Saldo: " + String.format("%,.2f", saldo);
    }
}
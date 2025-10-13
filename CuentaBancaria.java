import java.text.DecimalFormat;

public class CuentaBancaria {
    private String numeroCuenta;
    private double saldo;
    
    public CuentaBancaria(String numeroCuenta, double saldo) {
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldo;
    }
    
    public String getNumeroCuenta() {
        return numeroCuenta;
    }
    
    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }
    
    public double getSaldo() {
        return saldo;
    }
    
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    
    public void depositar(double monto) {
        if (monto > 0) {
            saldo += monto;
        }
    }
    
    public void retirar(double monto) {
        if (monto > 0 && monto <= saldo) {
            saldo -= monto;
        }
    }
    
    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("#,###.00");
        String saldoFormateado = df.format(saldo).replace(',', '_');
        return "Cuenta " + numeroCuenta + " | Saldo: " + saldoFormateado;
    }
}

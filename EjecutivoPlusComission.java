package Nomina;

/**
 * Clase adicional para ilustrar extensibilidad
 */
public class ExecutivePlusCommissionEmployee extends BasePlusCommissionEmployee {

   private double allowance; // Bonos ejecutivos

   public ExecutivePlusCommissionEmployee(String firstName, String lastName, String ssn,
                                          double grossSales, double commissionRate,
                                          double baseSalary, double allowance) {
      super(firstName, lastName, ssn, grossSales, commissionRate, baseSalary);
      this.allowance = Math.max(0.0, allowance);
   }

   public void setAllowance(double allowance) {
      if (allowance < 0.0) throw new IllegalArgumentException("La bonificación ejecutiva no puede ser negativa.");
      this.allowance = allowance;
   }

   public double getAllowance() {
      return allowance;
   }

   @Override
   public double earnings() {
      return super.earnings() + allowance;
   }

   @Override
   public String toString() {
      return String.format("%s con Beneficios Ejecutivos %.2f", super.toString(), getAllowance());
   }
}// Content of BasePlusCommissionEmployee.java from main branch
